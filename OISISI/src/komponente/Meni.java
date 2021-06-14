package komponente;

import akcije.*;
import model.TipKorisnika;

import javax.swing.*;

public class Meni extends JMenuBar {

    private JMenu meni;
    private JMenuItem miExit;
    private JMenuItem miIzlogujSe;
    private JMenu predstaveMeni;
    private JMenuItem miPrikaziPredstave;
    private JMenuItem miKreirajPredstavu;
    private JMenu izvestajMeni;
    private JMenuItem miIzvestajUkupneZarade;

    public Meni() {
        meni = new JMenu("Opcije");
        miIzlogujSe = new JMenuItem(new IzlogujSeAkcija());
        miIzlogujSe.setText("Odjavi se");
        meni.add(miIzlogujSe);
        meni.addSeparator();
        miExit = new JMenuItem(new ExitAkcija());
        miExit.setText("Izađi");
        meni.add(miExit);

        predstaveMeni = new JMenu("Predstave");
        miPrikaziPredstave = new JMenuItem(new PrikaziSvePredstaveAkcija());
        miPrikaziPredstave.setText("Pregledaj predstave");
        predstaveMeni.add(miPrikaziPredstave);
        miKreirajPredstavu = new JMenuItem(new KreirajPredstavuAkcija());
        miKreirajPredstavu.setText("Kreiraj predstavu");
        predstaveMeni.add(miKreirajPredstavu);

        izvestajMeni = new JMenu("Izveštaji");
        miIzvestajUkupneZarade = new JMenuItem(new GenerisiIzvestajAkcija());
        miIzvestajUkupneZarade.setText("Izveštaj ukupne zarade");
        izvestajMeni.add(miIzvestajUkupneZarade);

        add(meni);
        add(izvestajMeni);
        add(predstaveMeni);
        add(Box.createGlue());
    }

    public void podesiVidljivost(TipKorisnika tipKorisnika) {
        switch (tipKorisnika) {
            case KORISNIK:
                this.miExit.setVisible(true);
                this.miIzlogujSe.setVisible(true);
                this.miPrikaziPredstave.setVisible(true);
                this.miKreirajPredstavu.setVisible(false);
                this.izvestajMeni.setVisible(false);
                this.miIzvestajUkupneZarade.setVisible(false);
                break;
            case ADMINISTRATOR:
                this.miExit.setVisible(true);
                this.miIzlogujSe.setVisible(true);
                this.miPrikaziPredstave.setVisible(true);
                this.miKreirajPredstavu.setVisible(true);
                this.izvestajMeni.setVisible(true);
                this.miIzvestajUkupneZarade.setVisible(true);
                break;
        }

    }
}
