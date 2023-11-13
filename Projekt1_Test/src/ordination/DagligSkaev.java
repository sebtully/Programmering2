package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    // TODO
    private LocalTime Tid;
    private double antal;
    private ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Patient patient) {
        super(startDen, slutDen, laegemiddel, patient);
    }


    @Override
    public double samletDosis() {
        double samletDosis = 0;
        for (Dosis d : doser) {
            samletDosis += d.getAntal();
        }
        return samletDosis;
    }


    @Override
    public double doegnDosis() {
        double sum = 0;
        for (Dosis d : doser) {
            sum += d.getAntal();
        }
        return sum / antalDage();

    }

    @Override
    public String getType() {
        return "Daglig skæv";
    }

    public void opretDosis(LocalTime tid, double antal) {
        this.Tid = tid;
        this.antal = antal;
    }
    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }
    public Dosis createDosis (LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        doser.add(dosis);
        return dosis;
    }

    public LocalTime getTid() {
        return Tid;
    }

    public double getAntal() {
        return antal;
    }
}
