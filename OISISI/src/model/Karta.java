package model;

import java.io.Serializable;

public class Karta implements Serializable {

    private static final long serialVersionUID = -555590659442080922L;

    private Long sifra;
    private Long sifraPredstave;
    private String korisnickoIme;
    private Integer sediste;
    private Float cena;

    public Karta() {

    }

    public Karta(Long sifraPredstave, String korisnickoIme, Integer sediste, Float cena) {
        this.sifraPredstave = sifraPredstave;
        this.korisnickoIme = korisnickoIme;
        this.sediste = sediste;
        this.cena = cena;
    }

    public Long getSifra() {
        return sifra;
    }

    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }

    public Long getSifraPredstave() {
        return sifraPredstave;
    }

    public void setSifraPredstave(Long sifraPredstave) {
        this.sifraPredstave = sifraPredstave;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Integer getSediste() {
        return sediste;
    }

    public void setSediste(Integer sediste) {
        this.sediste = sediste;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "\nSifra: "+this.sifra+"\nSifra predstave: "+this.sifraPredstave+"\nKorisnicko ime: "+this.korisnickoIme+
                "\nSediste: "+this.sediste+"\nCena: "+this.cena;
    }
}
