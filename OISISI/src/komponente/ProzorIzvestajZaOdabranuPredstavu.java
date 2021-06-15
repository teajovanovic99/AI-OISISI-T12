package komponente;

import model.Karta;
import model.Predstava;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProzorIzvestajZaOdabranuPredstavu extends JPanel {

    private JTable tblIzvestaj;
    private JLabel lblNazivIzvestaja;
    private JLabel lblZarada;

    public ProzorIzvestajZaOdabranuPredstavu() {
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

    public void popuniTabelu(Predstava predstava) {
        List<Karta> prodateKarte = predstava.getSedista().values().stream().filter(s -> s != null)
                .collect(Collectors.toList());

        Float zarada = new Float(0);
        DefaultTableModel tableModel = (DefaultTableModel) tblIzvestaj.getModel();

        String[] kolone = {"Šifra", "Cena"};

        Object[][] podaci = new Object[prodateKarte.size()][2];
        for (int i = 0; i < prodateKarte.size(); i++) {
            Karta karta = prodateKarte.get(i);
            Object[] o = new Object[] {karta.getSifra(), karta.getCena()};
            podaci[i] = o;
            zarada += karta.getCena();
        }

        tableModel.setDataVector(podaci, kolone);
        tblIzvestaj.setRowHeight(30);

        lblNazivIzvestaja.setText("Prodate karte za predstavu \""+predstava.getNaziv()+"\"");
        lblZarada.setText("Ukupna zarada: "+ zarada);
    }
}
