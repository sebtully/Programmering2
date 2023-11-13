package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DagligSkaevTest {

    @Test
    void TC1_testOpretdosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        LocalTime tid = LocalTime.of(8, 0);
        double antal = 2.5;

        dagligSkaev.opretDosis(tid, antal);

        assertEquals(tid, dagligSkaev.getTid());
        assertEquals(antal, dagligSkaev.getAntal());
    }

    @Test
    void TC2_testOpretdosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        LocalTime tid = LocalTime.of(14, 30);
        double antal = 1.0;

        dagligSkaev.opretDosis(tid, antal);

        assertEquals(tid, dagligSkaev.getTid());
        assertEquals(antal, dagligSkaev.getAntal());
    }
    @Test
    void TC3_testOpretdosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        LocalTime tid = LocalTime.of(10, 0);
        double antal = 0.0;

        dagligSkaev.opretDosis(tid, antal);

        assertEquals(tid, dagligSkaev.getTid());
        assertEquals(antal, dagligSkaev.getAntal());
    }
    @Test
    void TC4_testOpretdosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        LocalTime tid = LocalTime.of(20, 45);
        double antal = -1;

        dagligSkaev.createDosis(tid, antal);

        assertEquals(tid, dagligSkaev.getTid());
        assertEquals(antal, dagligSkaev.getAntal());
    }

    @Test
    void TC5_testOpretdosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        LocalTime tid = LocalTime.of(25, 30);
        double antal = 2.0;

        dagligSkaev.createDosis(tid, antal);

        assertEquals(tid, dagligSkaev.getTid());
        assertEquals(antal, dagligSkaev.getAntal());
    }
    @Test
    void TC1_testSamletDosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        dagligSkaev.createDosis(LocalTime.of(12, 0), 1.0);
        dagligSkaev.createDosis(LocalTime.of(12, 10), 2.0);
        dagligSkaev.createDosis(LocalTime.of(18, 20), 3.0);

        double forventetSamletDosis = 6.0;

        assertEquals(forventetSamletDosis, dagligSkaev.samletDosis());
    }


    @Test
    void TC2_testSamletDosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        dagligSkaev.createDosis(LocalTime.of(12, 0), 5.0);
        dagligSkaev.createDosis(LocalTime.of(12, 10), 8.0);
        dagligSkaev.createDosis(LocalTime.of(12, 20), 10.0);

        double forventetSamletDosis = 23.0;

        assertEquals(forventetSamletDosis, dagligSkaev.samletDosis());
    }

    @Test
    void TC3_testSamletDosis() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient);
        dagligSkaev.createDosis(LocalTime.of(12, 0), 0.0);
        dagligSkaev.createDosis(LocalTime.of(12, 10), 0.0);
        dagligSkaev.createDosis(LocalTime.of(18, 20), 0.0);

        double forventetSamletDosis = 0.0;

        assertEquals(forventetSamletDosis, dagligSkaev.samletDosis());
    }

    @Test
    void TC1_testDoegnDosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 02), laegemiddel, patient);
        dagligSkaev.createDosis(LocalTime.of(12, 0), 1.0);
        dagligSkaev.createDosis(LocalTime.of(12, 10), 2.0);
        dagligSkaev.createDosis(LocalTime.of(18, 20), 3.0);

        double forventetDoegnDosis = 3.0;

        assertEquals(forventetDoegnDosis, dagligSkaev.doegnDosis());
    }

    @Test
    void TC2_testDoegnDosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 02), laegemiddel, patient);
        dagligSkaev.createDosis(LocalTime.of(12, 0), 5.0);
        dagligSkaev.createDosis(LocalTime.of(12, 10), 8.0);
        dagligSkaev.createDosis(LocalTime.of(18, 20), 10.0);

        double forventetDoegnDosis = 11.5;

        assertEquals(forventetDoegnDosis, dagligSkaev.doegnDosis());
    }

    @Test
    void TC3_testDoegnDosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 02), laegemiddel, patient);
        dagligSkaev.createDosis(LocalTime.of(12, 0), 0.0);
        dagligSkaev.createDosis(LocalTime.of(12, 10), 0.0);
        dagligSkaev.createDosis(LocalTime.of(18, 20), 0.0);

        double forventetDoegnDosis = 0.0;

        assertEquals(forventetDoegnDosis, dagligSkaev.doegnDosis());
    }

}