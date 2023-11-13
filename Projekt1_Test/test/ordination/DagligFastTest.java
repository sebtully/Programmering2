package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DagligFastTest {

    @Test
    void TC1_testSamletDosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        Dosis dosis1 = new Dosis(LocalTime.of(8, 0), 1.0);
        Dosis dosis2 = new Dosis(LocalTime.of(12, 0), 2.0);
        Dosis dosis3 = new Dosis(LocalTime.of(18, 0), 3.0);
        dagligFast.setDoser(new Dosis[]{dosis1, dosis2, dosis3});

        double forventetSamletDosis = 6.0;

        assertEquals(forventetSamletDosis, dagligFast.samletDosis());
    }

    @Test
    void TC2_testSamletDosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        Dosis dosis1 = new Dosis(LocalTime.of(8, 0), 5.0);
        Dosis dosis2 = new Dosis(LocalTime.of(12, 0), 8.0);
        Dosis dosis3 = new Dosis(LocalTime.of(18, 0), 10.0);
        dagligFast.setDoser(new Dosis[]{dosis1, dosis2, dosis3});

        double forventetSamletDosis = 23.0;

        assertEquals(forventetSamletDosis, dagligFast.samletDosis());
    }

    @Test
    void TC3_testSamletDosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        Dosis dosis1 = new Dosis(LocalTime.of(8, 0), 0.0);
        Dosis dosis2 = new Dosis(LocalTime.of(12, 0), 0.0);
        Dosis dosis3 = new Dosis(LocalTime.of(18, 0), 0.0);
        dagligFast.setDoser(new Dosis[]{dosis1, dosis2, dosis3});

        double forventetSamletDosis = 0.0;

        assertEquals(forventetSamletDosis, dagligFast.samletDosis());
    }


    @Test
    void TC1_testDoegnDosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        Dosis dosis1 = new Dosis(LocalTime.of(8, 0), 1.0);
        Dosis dosis2 = new Dosis(LocalTime.of(12, 0), 2.0);
        Dosis dosis3 = new Dosis(LocalTime.of(18, 0), 3.0);
        dagligFast.setDoser(new Dosis[]{dosis1, dosis2, dosis3});

        double forventetDoegnDosis = 2.0;

        assertEquals(forventetDoegnDosis, dagligFast.doegnDosis());
    }

    @Test
    void TC2_testDoegnDosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        Dosis dosis1 = new Dosis(LocalTime.of(8, 0), 5.0);
        Dosis dosis2 = new Dosis(LocalTime.of(12, 0), 8.0);
        Dosis dosis3 = new Dosis(LocalTime.of(18, 0), 10.0);
        dagligFast.setDoser(new Dosis[]{dosis1, dosis2, dosis3});

        double forventetDoegnDosis = 7.6;

        assertEquals(forventetDoegnDosis, dagligFast.doegnDosis());
    }

    @Test
    void TC3_testDoegnDosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligFast dagligFast = new DagligFast(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        Dosis dosis1 = new Dosis(LocalTime.of(8, 0), 0.0);
        Dosis dosis2 = new Dosis(LocalTime.of(12, 0), 0.0);
        Dosis dosis3 = new Dosis(LocalTime.of(18, 0), 0.0);
        dagligFast.setDoser(new Dosis[]{dosis1, dosis2, dosis3});

        double forventetDoegnDosis = 0.0;

        assertEquals(forventetDoegnDosis, dagligFast.doegnDosis());
    }

}