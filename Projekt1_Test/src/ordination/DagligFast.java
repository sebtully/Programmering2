package ordination;

import java.time.LocalDate;

public class DagligFast extends Ordination {
    // TODO

    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Patient patient) {
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
        return "Daglig fast";
    }

    public Dosis[] getDoser() {
        return doser;
    }


    public void setDoser(Dosis[] doser) {
        this.doser = doser;
    }

}
