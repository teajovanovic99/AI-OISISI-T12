package aplikacija;

import kontroler.KartaKontoler;
import kontroler.KorisnikKontroler;
import kontroler.PredstavaKontroler;
import model.Karta;
import model.Korisnik;
import model.Predstava;
import komponente.Ruter;

import java.util.Map;
import java.util.Set;

public class Singleton {

    public static final String APP_NAME = "Theatr";
    private static Singleton instance = new Singleton();

    private Ruter ruter;
    private KorisnikKontroler korisnikKontroler;
    private PredstavaKontroler predstavaKontroler;
    private KartaKontoler kartaKontoler;


    private Map<String, Korisnik> korisnici;
    private Map<Long, Predstava> predstave;
    private Map<Long, Karta> karte;
    private Map<Long, Predstava> prikazanePredstave;


    private Korisnik ulogovanKorisnik;
    private Predstava detaljnoPrikazanaPredstava;
    private Predstava predstavaZaIzmenu;
    private Set<Integer> rezervisanaSedista;
    private Predstava predstavaIzvestaj;

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

    public Ruter getRuter() {
        return ruter;
    }

    public void setRuter(Ruter ruter) {
        this.ruter = ruter;
    }

    public Korisnik getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    public void setUlogovanKorisnik(Korisnik ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }

    public Map<String, Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Map<String, Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public KorisnikKontroler getKorisnikKontroler() {
        return korisnikKontroler;
    }

    public void setKorisnikKontroler(KorisnikKontroler korisnikKontroler) {
        this.korisnikKontroler = korisnikKontroler;
    }

    public Map<Long, Predstava> getPredstave() {
        return predstave;
    }

    public void setPredstave(Map<Long, Predstava> predstave) {
        this.predstave = predstave;
    }

    public PredstavaKontroler getPredstavaKontroler() {
        return predstavaKontroler;
    }

    public void setPredstavaKontroler(PredstavaKontroler predstavaKontroler) {
        this.predstavaKontroler = predstavaKontroler;
    }
    public Map<Long, Predstava> getPrikazanePredstave() {
        return prikazanePredstave;
    }

    public void setPrikazanePredstave(Map<Long, Predstava> prikazanePredstave) {
        this.prikazanePredstave = prikazanePredstave;
    }

    public Predstava getDetaljnoPrikazanaPredstava() {
        return detaljnoPrikazanaPredstava;
    }

    public void setDetaljnoPrikazanaPredstava(Predstava detaljnoPrikazanaPredstava) {
        this.detaljnoPrikazanaPredstava = detaljnoPrikazanaPredstava;
    }

    public Predstava getPredstavaZaIzmenu() {
        return predstavaZaIzmenu;
    }

    public void setPredstavaZaIzmenu(Predstava predstavaZaIzmenu) {
        this.predstavaZaIzmenu = predstavaZaIzmenu;
    }

    public Map<Long, Karta> getKarte() {
        return karte;
    }

    public void setKarte(Map<Long, Karta> karte) {
        this.karte = karte;
    }

    public Set<Integer> getRezervisanaSedista() {
        return rezervisanaSedista;
    }

    public void setRezervisanaSedista(Set<Integer> rezervisanaSedista) {
        this.rezervisanaSedista = rezervisanaSedista;
    }

    public KartaKontoler getKartaKontoler() {
        return kartaKontoler;
    }

    public void setKartaKontoler(KartaKontoler kartaKontoler) {
        this.kartaKontoler = kartaKontoler;
    }

    public Predstava getPredstavaIzvestaj() {
        return predstavaIzvestaj;
    }

    public void setPredstavaIzvestaj(Predstava predstavaIzvestaj) {
        this.predstavaIzvestaj = predstavaIzvestaj;
    }

}
