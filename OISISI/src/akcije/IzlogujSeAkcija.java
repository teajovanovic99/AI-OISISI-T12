package akcije;

import aplikacija.Singleton;
import komponente.ProzorPrijava;
import komponente.Ruter;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class IzlogujSeAkcija extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        Singleton.getInstance().setUlogovanKorisnik(null);
        Singleton.getInstance().setPrikazanePredstave(null);
        Singleton.getInstance().setDetaljnoPrikazanaPredstava(null);
        Singleton.getInstance().setPredstavaZaIzmenu(null);
        Singleton.getInstance().setPredstavaIzvestaj(null);
        Singleton.getInstance().setRezervisanaSedista(null);

        Ruter ruter = Singleton.getInstance().getRuter();
        ruter.getMeni().setVisible(false);
        ruter.osveziProzor(ProzorPrijava.class);
        ruter.promeniProzor(ProzorPrijava.class);
    }
}
