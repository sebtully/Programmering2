package Opgave2.Set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SkoleSet {

    private String navn;
    private Set<StuderendeSet> studerende = new HashSet<>();

    public SkoleSet(String navn, HashSet<StuderendeSet> studerende) {
        this.navn = navn;
        this.studerende = studerende;
    }

    public Collection<StuderendeSet> getStuderende() {
        return studerende;
    }

    public String getNavn() {
        return navn;
    }

    public void addStuderende(StuderendeSet studerende) {
       if(this.studerende.add(studerende));
       this.studerende.add(studerende);


    }

    public void removeStuderende(StuderendeSet studerende) {
        if(this.studerende.add(studerende));
        this.studerende.remove(studerende);

    }

    //Metoden gennemsnit skal beregne det samlede gennemsnit af alle karakter, for de studerende på skolen
    public double gennemsnit() {
        //beregne det samlede gennemsnit af alle karakter, for de studerende på skolen
        double sum = 0;
        for (StuderendeSet s : studerende) {
            for (int i = 0; i < s.getKarakterer().size(); i++) {
                sum += (int) s.getKarakterer().get(i);
            }
        }
        return sum / studerende.size();
    }

    public StuderendeSet findStuderende(int studieNr) {
      //returnerer en studerende med det angivne studieNr, hvis en sådan studerende ikke findes, skal der returneres null.
        for (StuderendeSet s : studerende) {
            if (s.getNr() == studieNr) {
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Skole{" +
                "navn='" + navn + '\'' +
                '}';
    }

}
