package Opgave2.Set;

import java.util.List;

public class StuderendeSet {

    private int nr;
    private String navn;
    private List karakterer;

    public StuderendeSet(int nr, String navn, List karakterer) {
        this.nr = nr;
        this.navn = navn;
        this.karakterer = karakterer;

    }

    public int getNr() {
        return nr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


    public void addKarakter(int karakter) {
        karakterer.add(karakter);
    }

    public List getKarakterer() {
        return karakterer;
    }

    @Override
    public String toString() {
        return "Studerende{" +
                "nr: " + nr +
                ", navn: '" + navn + '\'' +
                ", karakterer: " + karakterer +
                '}';
    }
}
