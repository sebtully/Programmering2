package Opgave2.Map;

import Opgave2.List.Studerende;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class SkoleMap {

    private String navn;
    private Set<StuderendeMap> studerende = (Set<StuderendeMap>) new HashMap<>();

    public SkoleMap(String navn,
                    Set<StuderendeMap> studerende) {
        this.navn = navn;
        this.studerende = (Set<StuderendeMap>) studerende;
    }

    public Collection<StuderendeMap> getStuderende() {
        return studerende;
    }

    public String getNavn() {
        return navn;
    }

    public void addStuderende(StuderendeMap studerende) {
       if(this.studerende.add(studerende));
       this.studerende.add(studerende);


    }

    public void removeStuderende(StuderendeMap studerende) {
        if(this.studerende.add(studerende));
        this.studerende.remove(studerende);

    }

    //Metoden gennemsnit skal beregne det samlede gennemsnit af alle karakter, for de studerende på skolen
    public double gennemsnit() {
        //beregne det samlede gennemsnit af alle karakter, for de studerende på skolen
        double sum = 0;
        for (StuderendeMap s : studerende) {
            for (int i = 0; i < s.getKarakterer().size(); i++) {
                sum += (int) s.getKarakterer().get(i);
            }
        }
        return sum / studerende.size();
    }

    public StuderendeMap findStuderende(int studieNr) {
      //returnerer en studerende med det angivne studieNr, hvis en sådan studerende ikke findes, skal der returneres null.
        for (StuderendeMap s : studerende) {
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
