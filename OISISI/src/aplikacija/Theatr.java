package aplikacija;

import kontroler.KartaKontoler;
import kontroler.KorisnikKontroler;
import kontroler.PredstavaKontroler;
import model.Karta;
import model.Korisnik;
import komponente.Ruter;
import model.Predstava;
import model.TipKorisnika;
import utils.ReadWriteFile;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Theatr {

    public static void main(String[] args) {

        /*Korisnik korisnik1 = new Korisnik("teodora", "1234", "Teodora", "Jovanović");
        Korisnik korisnik2 = new Korisnik("mogli", "1234", "Katarina", "Radetić");
        Korisnik korisnik3 = new Korisnik("mend", "1234", "Miloš", "Nestorović");
        Korisnik korisnik4 = new Korisnik("strajabaja", "1234", "Strahinja", "Bogunović");
        korisnik2.setTipKorisnika(TipKorisnika.ADMINISTRATOR);

        Map<String, Korisnik> korisnici = new HashMap<>();
        korisnici.put(korisnik1.getKorisnickoIme(), korisnik1);
        korisnici.put(korisnik2.getKorisnickoIme(), korisnik2);
        korisnici.put(korisnik3.getKorisnickoIme(), korisnik3);
        korisnici.put(korisnik4.getKorisnickoIme(), korisnik4);


        Predstava predstava1 = new Predstava("Mali princ", "Predstava „Mali princ“ rađena je po motivima čuvenog romana A. Egziperija.", new Date(), new Float(322));
        predstava1.setSifra(new Long(0));
        Predstava predstava2 = new Predstava("Pokondirana tikva", "\"Pokondirena tikva\" je komedija koju je Jovan Sterije Popović napisao 1830. godine", new Date(1622908800000l),
                new Float(420));
        predstava2.setSifra(new Long(1));

        Karta karta1 = new Karta(new Long(1), "mogli", 1, new Float(322));
        karta1.setSifra(new Long(1));
        Karta karta2 = new Karta(new Long(1), "mogli", 14, new Float(322));
        karta2.setSifra(new Long(2));
        Karta karta3 = new Karta(new Long(1), "mogli", 23, new Float(322));
        karta3.setSifra(new Long(3));
        Karta karta4 = new Karta(new Long(1), "mogli", 27, new Float(322));
        karta4.setSifra(new Long(4));

        Map<Long, Karta> karte = new HashMap<>();
        karte.put(karta1.getSifra(), karta1);
        karte.put(karta2.getSifra(), karta2);
        karte.put(karta3.getSifra(), karta3);
        karte.put(karta4.getSifra(), karta4);

        predstava1.getSedista().put(karta1.getSediste(), karta1);
        predstava1.getSedista().put(karta2.getSediste(), karta2);
        predstava1.getSedista().put(karta3.getSediste(), karta3);
        predstava1.getSedista().put(karta4.getSediste(), karta4);


        Map<Long, Predstava> predstave = new HashMap<>();
        predstave.put(predstava1.getSifra(), predstava1);
        predstave.put(predstava2.getSifra(), predstava2);

         */

        ReadWriteFile rw = new ReadWriteFile();
        Map<String, Korisnik> korisnici = (Map<String, Korisnik>) rw.readFile("src/podaci/korisnici.txt");
        Map<Long, Predstava> predstave = (Map<Long, Predstava>) rw.readFile("src/podaci/predstave.txt");
        Map<Long, Karta> karte = (Map<Long, Karta>) rw.readFile("src/podaci/karte.txt");

        Singleton.getInstance().setKorisnici(korisnici);
        Singleton.getInstance().setPredstave(predstave);
        Singleton.getInstance().setKarte(karte);

        Ruter ruter = new Ruter();
        Singleton.getInstance().setRuter(ruter);

        KorisnikKontroler korisnikKontroler = new KorisnikKontroler();
        Singleton.getInstance().setKorisnikKontroler(korisnikKontroler);
        PredstavaKontroler predstavaKontroler = new PredstavaKontroler();
        Singleton.getInstance().setPredstavaKontroler(predstavaKontroler);
        KartaKontoler kartaKontoler = new KartaKontoler();
        Singleton.getInstance().setKartaKontoler(kartaKontoler);

        ruter.setVisible(true);

    }
}
