package kontroler;

import aplikacija.Singleton;
import komponente.ProzorPredstave;
import komponente.Ruter;
import model.Karta;

import java.util.Map;
import java.util.Set;

public class KartaKontoler {

    private Map<Long, Karta> karte;

    public KartaKontoler() {
        karte = Singleton.getInstance().getKarte();
    }

    public Karta kreirajKartu(Karta karta) {
        Set<Long> kljucevi = this.karte.keySet();
        Long sifra = new Long(kljucevi.size()+1);
        karta.setSifra(sifra);
        this.karte.put(sifra, karta);
        System.out.println("\nKreirana karta: " + karta);

        return karta;
    }
}
