package akcije;

import aplikacija.Singleton;
import komponente.ProzorIzvestajZaSvePredstave;
import komponente.Ruter;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GenerisiIzvestajAkcija extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        Ruter ruter = Singleton.getInstance().getRuter();
        ruter.osveziProzor(ProzorIzvestajZaSvePredstave.class);
        ruter.promeniProzor(ProzorIzvestajZaSvePredstave.class);
    }
}
