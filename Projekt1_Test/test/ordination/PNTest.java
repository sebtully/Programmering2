package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PNTest {


    //Vi nåede ikke at lave test for alle metoder i denne klasse
    @Test
    void TC1_testGivdosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient, 1.0);

        LocalDate dato = LocalDate.of(2021, 1, 2);

        boolean forventetGivDosis = true;

        assertEquals(forventetGivDosis, pn.givDosis(dato));
    }

    @Test
    void TC2_testGivdosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient, 1.0);

        LocalDate dato = LocalDate.of(2021, 1, 13);

        boolean forventetGivDosis = true;

        assertEquals(forventetGivDosis, pn.givDosis(dato));
    }

    @Test
    void TC1_testSamletdosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient, 1.0);
        double antalEnheder = 1.0;

        int antalGangeGivet = pn.getAntalGangeGivet();

        double forventetSamletDosis = antalEnheder * antalGangeGivet;

        assertEquals(forventetSamletDosis, pn.samletDosis());
    }

    @Test
    void TC2_testSamletdosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient, 5.0);
        double antalEnheder = 5.0;

        int antalGangeGivet = pn.getAntalGangeGivet();

        double forventetSamletDosis = antalEnheder * antalGangeGivet;

        assertEquals(forventetSamletDosis, pn.samletDosis());
    }

    @Test
    void TC3_testSamletdosis(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient, 5.0);
        double antalEnheder = 2.0;

        int antalGangeGivet = pn.getAntalGangeGivet();

        double forventetSamletDosis = antalEnheder * antalGangeGivet;

        assertEquals(forventetSamletDosis, pn.samletDosis());
    }



    @Test
    void testGetAntalGangeGivet() {
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), laegemiddel, patient, 1.0);


        pn.givDosis(LocalDate.of(2021, 1, 1));
        pn.givDosis(LocalDate.of(2021, 1, 2));
        pn.givDosis(LocalDate.of(2021, 1, 3));
        pn.givDosis(LocalDate.of(2021, 1, 4));

        int forventetAntalGangeGivet = 4;

        int faktiskantalGangeGivet = pn.getAntalGangeGivet();

        assertEquals(forventetAntalGangeGivet, faktiskantalGangeGivet);
    }

    @Test
    void testDoegnDosis() {

    }
}