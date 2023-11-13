package opgave3;

import java.util.List;

public class Studerende implements Comparable<Studerende> {
    private int studieNr;

    private String navn;

    private List<Integer> karakterer;


    public Studerende(int studieNr, String navn, List<Integer> karakterer) {
        this.studieNr = studieNr;
        this.navn = navn;
        this.karakterer = karakterer;
    }

    public int getStudieNr() {
        return studieNr;
    }

    public String getNavn() {
        return navn;
    }

    public List<Integer> getKarakterer() {
        return karakterer;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void addKarakter(int karakter) {
        karakterer.add(karakter);
    }

    @Override
    public String toString() {
        return "StudieNr: " + studieNr + ", navn: " + navn + ", karakterer: " + karakterer + "\n";
    }


    @Override
    public int compareTo(Studerende o) {
        return this.getNavn().compareTo(o.getNavn());
    }
}