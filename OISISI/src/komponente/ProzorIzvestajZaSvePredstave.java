package komponente;

import aplikacija.Singleton;
import model.Karta;
import model.Predstava;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ProzorIzvestajZaSvePredstave extends JPanel {

    private JTable tblIzvestaj;
    private JLabel lblNazivIzvestaja;
    private JLabel lblZarada;

    public ProzorIzvestajZaSvePredstave() {
        lblNazivIzvestaja = new JLabel();
        lblZarada = new JLabel();

        DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[]{"Šifra", "Cena"}, 0);
        tblIzvestaj = new JTable(defaultTableModel);
        tblIzvestaj.setRowHeight(30);
        tblIzvestaj.getTableHeader().setReorderingAllowed(false);

        setLayout(new GridBagLayout());
        add(lblNazivIzvestaja, new GridBagConstraints(0, 0, 3, 1, 0,
                0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(40, 5, 5,5 ), 0, 0));
        add(tblIzvestaj.getTableHeader(), new GridBagConstraints(0, 1, 3, 1, 0,
                0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 0,5 ), 0, 0));
        add(tblIzvestaj, new GridBagConstraints(0, 2, 3, 1, 0,
                0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 5, 5,5 ), 0, 0));
        add(lblZarada, new GridBagConstraints(0, 3, 3, 1, 0,
                0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5,5 ), 0, 0));
    }

    public void popuniTabelu() {
        List<Predstava> predstave = Singleton.getInstance().getPredstave().values()
                .stream().collect(Collectors.toList());

        Float ukupnaZarada = new Float(0);
        DefaultTableModel tableModel = (DefaultTableModel) tblIzvestaj.getModel();

        String[] kolone = {"Šifra", "Naziv", "Zarada"};

        Object[][] podaci = new Object[predstave.size()][3];
        for (int i = 0; i < predstave.size(); i++) {
            Predstava predstava = predstave.get(i);
            Float zarada = sumirajZaraduPredstave(predstava);
            Object[] o = new Object[] {predstava.getSifra(), predstava.getNaziv(), zarada};
            podaci[i] = o;

            ukupnaZarada += zarada;
        }

        tableModel.setDataVector(podaci, kolone);
        tblIzvestaj.setRowHeight(30);
        TableColumnModel columnModel = tblIzvestaj.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(200);

        lblNazivIzvestaja.setText("Ukupne zarade za sve predstave");
        lblZarada.setText("Ukupna zarada: "+ ukupnaZarada);
    }

    private Float sumirajZaraduPredstave(Predstava predstava) {
        List<Karta> prodateKarte = predstava.getSedista().values().stream().filter(s -> s != null)
                .collect(Collectors.toList());

        Double zarada = prodateKarte.stream().mapToDouble(karta -> karta.getCena()).sum();

        return zarada.floatValue();
    }
}
