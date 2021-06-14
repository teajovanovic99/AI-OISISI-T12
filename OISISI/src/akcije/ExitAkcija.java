package akcije;

import aplikacija.Singleton;
import komponente.Ruter;
import utils.ReadWriteFile;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExitAkcija extends AbstractAction {

    public ExitAkcija() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ruter ruter = Singleton.getInstance().getRuter();

        int code = JOptionPane.showConfirmDialog(ruter,
                "Da li ste sigurni da želite da zatvorite aplikaciju?",
                "Zatvaranje Aplikacije",
                JOptionPane.YES_NO_OPTION);

        if (code != JOptionPane.YES_OPTION) {
            ruter.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        } else {
            ReadWriteFile rw = new ReadWriteFile();
            rw.writeFile("src/podaci/korisnici.txt", Singleton.getInstance().getKorisnici());
            rw.writeFile("src/podaci/predstave.txt", Singleton.getInstance().getPredstave());
            rw.writeFile("src/podaci/karte.txt", Singleton.getInstance().getKarte());

            System.exit(0);
        }
    }
}
