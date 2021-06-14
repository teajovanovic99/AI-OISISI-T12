package komponente;

import aplikacija.Singleton;
import kontroler.PredstavaKontroler;
import model.Predstava;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import utils.DateLabelFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class ProzorIzmeniPredstavu extends JPanel {

    private JLabel lblNaziv;
    private JTextField tfNaziv;
    private JLabel lblOpis;
    private JTextArea taOpis;
    private JLabel lblDatum;
    private JDatePickerImpl dpDatum;
    private JLabel lblVreme;
    private JSpinner jsSati;
    private JSpinner jsMinuti;
    private JLabel lblCena;
    private JSpinner jsCenaKarte;
    private JButton btnIzmeni;
    private JButton btnOdustani;

    public ProzorIzmeniPredstavu() {
        lblNaziv = new JLabel("Naziv: ");
        tfNaziv = new JTextField(30);

        lblOpis = new JLabel("Opis: ");
        taOpis = new JTextArea(5, 30);

        lblDatum = new JLabel("Datum: ");
        UtilDateModel model = new UtilDateModel();
        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        model.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        model.setSelected(true);
        Properties p = new Properties();
        p.put("text.today", "Danas");
        p.put("text.month", "Mesec");
        p.put("text.year", "Godina");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        dpDatum = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        lblVreme = new JLabel("Vreme: ");
        SpinnerModel sati = new SpinnerNumberModel(0, 0, 23, 1);
        jsSati = new JSpinner(sati);
        SpinnerModel minuti = new SpinnerNumberModel(0, 0, 59, 1);
        jsMinuti = new JSpinner(minuti);

        lblCena = new JLabel("Cena: ");
        SpinnerModel cena = new SpinnerNumberModel(0.00f, 0.00f, 1000000000f, 0.01f);
        jsCenaKarte = new JSpinner(cena);

        btnIzmeni = new JButton("Sačuvaj");
        btnOdustani = new JButton("Odustani");

        btnIzmeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ruter ruter = Singleton.getInstance().getRuter();
                Predstava predstava = validacija();
                if (predstava != null) {
                    int code = JOptionPane.showConfirmDialog(ruter,
                            "Da li ste sigurni da želite da izmenite podatke o predstavi?",
                            "Izmena Predstave", JOptionPane.YES_NO_OPTION);

                    if (code != JOptionPane.YES_OPTION) {
                        ruter.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    } else {
                        PredstavaKontroler predstavaKontroler = Singleton.getInstance().getPredstavaKontroler();
                        predstavaKontroler.izmeniPredstavu(predstava);
                    }
                }
            }
        });

        btnOdustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PredstavaKontroler predstavaKontroler = Singleton.getInstance().getPredstavaKontroler();
                predstavaKontroler.prikaziDetaljno(Singleton.getInstance().getDetaljnoPrikazanaPredstava());
            }
        });

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridBagLayout());
        optionsPanel.add(btnOdustani, new GridBagConstraints(0, 0, 1, 1, 0,
                0, GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(20, 5, 5,5 ), 0, 0));
        optionsPanel.add(btnIzmeni, new GridBagConstraints(1, 0, 1, 1, 0,
                0, GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(20, 5, 5,5 ), 0, 0));

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
        add(lblDatum, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5,5 ),
                0, 0));
        add(dpDatum, new GridBagConstraints(1, 2, 2, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5,5 ), 0, 0));
        add(lblVreme, new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5,5 ),
                0, 0));
        add(jsSati, new GridBagConstraints(1, 3, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(5, 5, 5,5 ), 0, 0));
        add(jsMinuti, new GridBagConstraints(2, 3, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(5, 5, 5,5 ), 0, 0));
        add(lblCena, new GridBagConstraints(0, 4, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5,5 ),
                0, 0));
        add(jsCenaKarte, new GridBagConstraints(1, 4, 2, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5,5 ), 0, 0));
        add(optionsPanel, new GridBagConstraints(1, 5, 2, 1, 0,
                0, GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(20, 0, 0, 0 ), 0, 0));
    }

    private Predstava validacija() {
        String naziv = this.tfNaziv.getText();
        String opis = this.taOpis.getText();
        Float cenaKarte = (float)((double) this.jsCenaKarte.getValue());
        Integer sati = (Integer) this.jsSati.getValue();
        Integer minuti = (Integer) this.jsMinuti.getValue();
        Calendar datum = Calendar.getInstance();
        Date d = (Date) this.dpDatum.getModel().getValue();
        datum.setTime(d);
        Calendar datumVreme = Calendar.getInstance();
        datumVreme.set(datum.get(Calendar.YEAR), datum.get(Calendar.MONTH), datum.get(Calendar.DAY_OF_MONTH), sati, minuti);
        Date danasnjiDatumVreme = new Date();
        Date dat = datumVreme.getTime();

        if (naziv.equals("")) {
            JOptionPane.showMessageDialog(null, "Naziv predstave je obavezan!",
                    Singleton.APP_NAME, JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (opis.equals("")) {
            JOptionPane.showMessageDialog(null, "Opis predstave je obavezan!",
                    Singleton.APP_NAME, JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (!dat.after(danasnjiDatumVreme)) {
            JOptionPane.showMessageDialog(null,
                    "Datum prikazivanja predstave mora biti najkasnije tekući datum!",
                    Singleton.APP_NAME, JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return new Predstava(naziv, opis, dat, cenaKarte);
    }

    public void popuniPolja(Predstava predstava) {
        tfNaziv.setText(predstava.getNaziv());
        taOpis.setText(predstava.getOpis());
        Date d = predstava.getDatumVreme();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        dpDatum.getModel().setYear(calendar.get(Calendar.YEAR));
        dpDatum.getModel().setMonth(calendar.get(Calendar.MONTH));
        dpDatum.getModel().setDay(calendar.get(Calendar.DAY_OF_MONTH));
        jsSati.setValue(calendar.get(Calendar.HOUR_OF_DAY));
        jsMinuti.setValue(calendar.get(Calendar.MINUTE));
        jsCenaKarte.setValue(predstava.getCena().doubleValue());
    }
}
