package komponente;

import aplikacija.Singleton;
import kontroler.PredstavaKontroler;
import model.Predstava;
import model.TipKorisnika;
import utils.SedistaTableModel;
import utils.SedistaTableModelListener;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProzorPredstavaDetaljanPrikaz extends JPanel {

    private JLabel lblNaziv;
    private JTextField tfNaziv;
    private JLabel lblOpis;
    private JTextArea taOpis;
    private JLabel lblDatumVreme;
    private JTextField tfDatumVreme;
    private JLabel lblCena;
    private JTextField tfCena;
    private JTable tblSedista;
    private JButton btnRezervisi;
    private JButton btnIzmeni;
    private JButton btnIzvestaj;


    public ProzorPredstavaDetaljanPrikaz() {
        lblNaziv = new JLabel("Naziv: ");
        tfNaziv = new JTextField(30);
        tfNaziv.setEditable(false);

        lblOpis = new JLabel("Opis: ");
        taOpis = new JTextArea(5, 30);
        taOpis.setEditable(false);

        lblDatumVreme = new JLabel("Datum i vreme: ");
        tfDatumVreme = new JTextField(30);
        tfDatumVreme.setEditable(false);

        lblCena = new JLabel("Cena: ");
        tfCena = new JTextField(30);
        tfCena.setEditable(false);

        SedistaTableModel model = new SedistaTableModel(new Object[]{"Sedište", "Sedište 1", "Sedište 2", "Sedište 3",
                "Sedište 4", "Sedište 5", "Sedište 6"}, 0);
        tblSedista = new JTable(model);
        tblSedista.getTableHeader().setReorderingAllowed(false);
        tblSedista.getModel().addTableModelListener(new SedistaTableModelListener());

        btnIzmeni = new JButton("Izmeni");
        btnIzmeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PredstavaKontroler predstavaKontroler = Singleton.getInstance().getPredstavaKontroler();
                predstavaKontroler.prikaziDetaljnoZaIzmenu(Singleton.getInstance().getDetaljnoPrikazanaPredstava());
            }
        });

        btnRezervisi = new JButton("Rezerviši");
        btnRezervisi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Singleton.getInstance().getRezervisanaSedista().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Potrebno je da izaberete bar 1 sedište!",
                            Singleton.APP_NAME, JOptionPane.WARNING_MESSAGE);
                } else {
                    PredstavaKontroler predstavaKontroler = Singleton.getInstance().getPredstavaKontroler();
                    predstavaKontroler.rezervisiKartu(Singleton.getInstance().getRezervisanaSedista());
                    JOptionPane.showMessageDialog(null,
                            "Uspešno rezervisane karte!",
                            Singleton.APP_NAME, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnIzvestaj = new JButton("Izveštaj");
        btnIzvestaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Singleton.getInstance().setPredstavaIzvestaj(Singleton.getInstance().getDetaljnoPrikazanaPredstava());
                Ruter ruter = Singleton.getInstance().getRuter();
                ruter.osveziProzor(ProzorIzvestajZaOdabranuPredstavu.class);
                ruter.promeniProzor(ProzorIzvestajZaOdabranuPredstavu.class);
            }
        });

        JPanel pnlOpcije = new JPanel();
        pnlOpcije.setLayout(new GridBagLayout());
        pnlOpcije.add(btnRezervisi, new GridBagConstraints(0, 0, 1, 1, 0,
                0, GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(20, 5, 0,5 ), 0, 0));
        pnlOpcije.add(btnIzvestaj, new GridBagConstraints(1, 0, 1, 1, 0,
                0, GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(20, 5, 0,5 ), 0, 0));
        pnlOpcije.add(btnIzmeni, new GridBagConstraints(2, 0, 1, 1, 0,
                0, GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(20, 5, 0,5 ), 0, 0));

        setLayout(new GridBagLayout());
        add(lblNaziv, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(50, 5, 5,5 ),
                0, 0));
        add(tfNaziv, new GridBagConstraints(1, 0, 2, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(50, 5, 5,5 ), 0, 0));
        add(lblOpis, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5,5 ),
                0, 0));
        add(taOpis, new GridBagConstraints(1, 1, 2, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5,5 ), 0, 0));
        add(lblDatumVreme, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5,5 ),
                0, 0));
        add(tfDatumVreme, new GridBagConstraints(1, 2, 2, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5,5 ), 0, 0));
        add(lblCena, new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5,5 ),
                0, 0));
        add(tfCena, new GridBagConstraints(1, 3, 2, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5,5 ), 0, 0));
        add(tblSedista.getTableHeader(), new GridBagConstraints(0, 4, 3, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 0,5 ), 0, 0));
        add(tblSedista, new GridBagConstraints(0, 5, 3, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 5, 5,5 ), 0, 0));
        add(pnlOpcije, new GridBagConstraints(2, 6, 1, 1, 0,
                0, GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(5, 5, 5,0 ), 0, 0));
    }
    public void inicijalizujPrikazSedista() {
        SedistaTableModel model = (SedistaTableModel) tblSedista.getModel();
        String[] kolone = {"Sedište", "Sedište 1", "Sedište 2", "Sedište 3", "Sedište 4", "Sedište 5", "Sedište 6"};
        Object[][] podaci = new Object[5][7];
        int cnt = 0;
        Predstava predstava = Singleton.getInstance().getDetaljnoPrikazanaPredstava();
        List<Integer> sedista = predstava.getSedista().keySet().stream().collect(Collectors.toList());

        Object[] red = new Object[7];
        for (int i = 0; i < sedista.size(); i++) {
            Boolean rezervisano = predstava.getSedista().get(sedista.get(i)) == null ? false : true;
            red[1+i%6] = rezervisano;
            model.setCellEditable(cnt, 1+i%6, !rezervisano);
            if (i%6 == 5) {
                int r = cnt+1;
                red[0] = "Red "+r;
                podaci[cnt] = red;
                cnt++;
                red = new Object[7];
            }
        }

        model.setDataVector(podaci, kolone);
        tblSedista.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                boolean selected = table.getSelectionModel().isSelectedIndex(row);
                Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, false, false, -1, -2);
                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
                if (selected) {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                    component.setForeground(table.getSelectionForeground());
                } else {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                }
                return component;
            }
        });
    }

    public void popuniPolja(Predstava predstava) {
        tfNaziv.setText(predstava.getNaziv());
        taOpis.setText(predstava.getOpis());
        tfDatumVreme.setText(formatirajDatum(predstava.getDatumVreme()));
        tfCena.setText(predstava.getCena().toString());
        Set<Integer> rezKarte = new HashSet<>();
        Singleton.getInstance().setRezervisanaSedista(rezKarte);
        inicijalizujPrikazSedista();

        if (predstava.getKarteRasprodate())
            btnRezervisi.setEnabled(false);
        else
            btnRezervisi.setEnabled(true);

        if (Singleton.getInstance().getUlogovanKorisnik().getTipKorisnika().equals(TipKorisnika.KORISNIK)) {
            btnIzmeni.setVisible(false);
            btnIzvestaj.setVisible(false);
        } else if (Singleton.getInstance().getUlogovanKorisnik().getTipKorisnika().equals(TipKorisnika.ADMINISTRATOR)) {
            btnIzmeni.setVisible(true);
            btnIzmeni.setVisible(true);
        }

    }
    public String formatirajDatum(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. hh:mm");
        String stringDatum = sdf.format(date);
        return stringDatum;
    }
}