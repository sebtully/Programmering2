package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination {

    private ArrayList<LocalDate> givneDatoer = new ArrayList<>();
    private double antalEnheder;
    private Laegemiddel laegemiddel;

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Patient patient, double antalEnheder) {
        super(startDen, slutDen, laegemiddel, patient);
        this.laegemiddel = laegemiddel;
        this.antalEnheder = antalEnheder;

    }


    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Returner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        boolean gyldig = false;
        if (givesDen.isEqual(getStartDen())
                || givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen())
                || givesDen.isEqual(getSlutDen())) {
            gyldig = true;
            givneDatoer.add(givesDen);
        } else {
            throw new IllegalArgumentException("Datoen er uden for ordinationens gyldighedsperiode");
        }
        return gyldig;
    }

    public double doegnDosis() {
        long antalDage = ChronoUnit.DAYS.between(givneDatoer.get(0), givneDatoer.get(givneDatoer.size() - 1)) + 1;
        return samletDosis() / antalDage;
    }


    public double samletDosis() {
        return antalEnheder * getAntalGangeGivet();
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return givneDatoer.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }


    @Override
    public Laegemiddel getLaegemiddel() {
        return laegemiddel;
    }

    public List<LocalDate> getGivneDatoer() {
        return givneDatoer;
    }

    @Override
    public String getType() {
        return "PN";
    }
}
