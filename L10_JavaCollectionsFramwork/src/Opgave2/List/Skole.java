package Opgave2.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Skole {

    private String navn;
    private List<Studerende> studerende = new ArrayList<>();

    public Skole(String navn, ArrayList<Studerende> studerende) {
        this.navn = navn;
        this.studerende = studerende;
    }

    public Collection<Studerende> getStuderende() {
        return studerende;
    }

    public String getNavn() {
        return navn;
    }

    public void addStuderende(Studerende studerende) {
       if(this.studerende.add(studerende));
       this.studerende.add(studerende);


    }

    public void removeStuderende(Studerende studerende) {
        if(this.studerende.add(studerende));
        this.studerende.remove(studerende);

    }

    //Metoden gennemsnit skal beregne det samlede gennemsnit af alle karakter, for de studerende på skolen
    public double gennemsnit() {
        //beregne det samlede gennemsnit af alle karakter, for de studerende på skolen
        double sum = 0;
        for (Studerende s : studerende) {
            for (int i = 0; i < s.getKarakterer().size(); i++) {
                sum += (int) s.getKarakterer().get(i);
            }
        }
        return sum / studerende.size();
    }

    public Studerende findStuderende(int studieNr) {
      //returnerer en studerende med det angivne studieNr, hvis en sådan studerende ikke findes, skal der returneres null.
        for (Studerende s : studerende) {
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
