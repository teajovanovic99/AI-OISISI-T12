package komponente;

import aplikacija.Singleton;
import utils.ExitConfirm;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ruter extends JFrame {

    private Meni meni;

    private JPanel displayPanel;

    private Map<Class<?>, Object> prozori;

    public Ruter() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new ExitConfirm());
        inicijalizujProzore();
        inicijalizujGUI();
    }

    public void inicijalizujGUI() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screensize = toolkit.getScreenSize();
        int screenWidth = screensize.width;
        int screenHeight = screensize.height;
        setSize(screenWidth/2, screenHeight/2);
        setTitle("Theatr");

        setLocationRelativeTo(null);

        displayPanel = new JPanel();
        add(displayPanel);
        promeniProzor(ProzorPrijava.class);

        meni = new Meni();
        this.setJMenuBar(meni);
        this.meni.setVisible(false);
    }

    public void inicijalizujProzore() {
        ProzorPrijava prozorPrijava = new ProzorPrijava();
        ProzorRegistracija prozorRegistracija = new ProzorRegistracija();
        ProzorPredstave prozorPredstave = new ProzorPredstave();
        ProzorKreirajPredstavu prozorKreirajPredstavu = new ProzorKreirajPredstavu();
        ProzorPredstavaDetaljanPrikaz prozorPredstavaDetaljanPrikaz = new ProzorPredstavaDetaljanPrikaz();
        ProzorIzmeniPredstavu prozorIzmeniPredstavu = new ProzorIzmeniPredstavu();
        ProzorIzvestajZaOdabranuPredstavu prozorIzvestajZaOdabranuPredstavu = new ProzorIzvestajZaOdabranuPredstavu();
        ProzorIzvestajZaSvePredstave prozorIzvestajZaSvePredstave = new ProzorIzvestajZaSvePredstave();

        this.prozori = new HashMap<>();
        this.prozori.put(ProzorPrijava.class, prozorPrijava);
        this.prozori.put(ProzorRegistracija.class, prozorRegistracija);
        this.prozori.put(ProzorPredstave.class, prozorPredstave);
        this.prozori.put(ProzorKreirajPredstavu.class, prozorKreirajPredstavu);
        this.prozori.put(ProzorPredstavaDetaljanPrikaz.class, prozorPredstavaDetaljanPrikaz);
        this.prozori.put(ProzorIzmeniPredstavu.class, prozorIzmeniPredstavu);
        this.prozori.put(ProzorIzvestajZaOdabranuPredstavu.class, prozorIzvestajZaOdabranuPredstavu);
        this.prozori.put(ProzorIzvestajZaSvePredstave.class, prozorIzvestajZaSvePredstave);
    }

    public void promeniProzor(Class<?> prozor) {
        this.displayPanel.removeAll();
        this.displayPanel.add((JPanel) this.prozori.get(prozor));
        this.displayPanel.revalidate();
        this.displayPanel.repaint();
    }

    public void osveziProzor(Class<?> prozor) {
        if (prozor.getName().equals(ProzorPredstavaDetaljanPrikaz.class.getName())) {
            ProzorPredstavaDetaljanPrikaz prozorPDP = (ProzorPredstavaDetaljanPrikaz) prozori.get(prozor);
            prozorPDP.popuniPolja(Singleton.getInstance().getDetaljnoPrikazanaPredstava());
        } else if (prozor.getName().equals(ProzorPredstave.class.getName())) {
            ProzorPredstave prozorPredstave = (ProzorPredstave) prozori.get(prozor);
            prozorPredstave.ocistiPretragu();
            prozorPredstave.popuniTabelu(Singleton.getInstance().getPredstave().values()
                    .stream().collect(Collectors.toList()));
        }
        else if (prozor.getName().equals(ProzorIzmeniPredstavu.class.getName())) {
            ProzorIzmeniPredstavu prozorIzmeniPredstavu = (ProzorIzmeniPredstavu) prozori.get(prozor);
            prozorIzmeniPredstavu.popuniPolja(Singleton.getInstance().getPredstavaZaIzmenu());
        } else if (prozor.getName().equals(ProzorIzvestajZaOdabranuPredstavu.class.getName())) {
            ProzorIzvestajZaOdabranuPredstavu piop = (ProzorIzvestajZaOdabranuPredstavu) prozori.get(prozor);
            piop.popuniTabelu(Singleton.getInstance().getPredstavaIzvestaj());
        } else if (prozor.getName().equals(ProzorIzvestajZaSvePredstave.class.getName())) {
            ProzorIzvestajZaSvePredstave pisp = (ProzorIzvestajZaSvePredstave) prozori.get(prozor);
            pisp.popuniTabelu();
        } else if (prozor.getName().equals(ProzorPrijava.class.getName())) {
            ProzorPrijava prozorPrijava = (ProzorPrijava) prozori.get(prozor);
            prozorPrijava.ocistiPolja();
        }
    }

    public Meni getMeni() {
        return meni;
    }
}
