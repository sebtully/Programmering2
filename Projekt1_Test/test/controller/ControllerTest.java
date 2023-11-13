package controller;

import ordination.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    @Test
    void TC1_testOpretPNOrdination() {
        //Test1 (arrange opretter objekter)
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double antal = 123.0;

        //Act (udfør metoden)
        PN pn = controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);

        //Assert (sammenlign forventet med faktisk)
        assertEquals(startDen, pn.getStartDen());
        assertEquals(slutDen, pn.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(pn));
        assertEquals("Acetylsalicylsyre", pn.getLaegemiddel().getNavn());
        assertEquals(antal, pn.getAntalEnheder());


    }
    @Test
    void TC2_testOpretPNOrdination(){
        // Test2
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double antal = 0;



        PN pn = controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);


        assertNotNull(pn);
        assertEquals(startDen, pn.getStartDen());
        assertEquals(slutDen, pn.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(pn));
        assertEquals("Acetylsalicylsyre", pn.getLaegemiddel().getNavn());
        assertEquals(antal, pn.getAntalEnheder());
    }

    @Test
    void TC3_testOpretPNOrdination(){
        // Test3 fejl - startdato er efter slutdato
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 12);
        LocalDate slutDen = LocalDate.of(2021, 1, 10);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double antal = 20.0;
        PN pn = controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
    }

    @Test
    void TC4_testOpretPNOrdination(){
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = null;
        Laegemiddel laegemiddel = null;
        double antal = 6.0;
        PN pn = controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);

    }

    @Test
    void TC1_testDagligFastOrdination(){
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double morgen = 2.0;
        double middag = 0.0;
        double aften = 1.0;
        double nat = 0.0;

        Dosis[] expectedDoser = {
                new Dosis(LocalTime.of(8, 0), morgen),
                new Dosis(LocalTime.of(12, 0), middag),
                new Dosis(LocalTime.of(18, 0), aften),
                new Dosis(LocalTime.of(22, 0), nat)
        };

        DagligFast dagligFast = controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morgen, middag, aften, nat);

        assertNotNull(dagligFast);
        assertEquals(startDen, dagligFast.getStartDen());
        assertEquals(slutDen, dagligFast.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(dagligFast));
        assertEquals("Acetylsalicylsyre", dagligFast.getLaegemiddel().getNavn());

        Dosis[] actualDoser = dagligFast.getDoser();
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }
    }

    @Test
    void TC2_testDagligFastOrdination(){
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double morgen = 2.0;
        double middag = 0.0;
        double aften = 0.0;
        double nat = 0.0;

        Dosis[] expectedDoser = {
                new Dosis(LocalTime.of(8, 0), morgen),
                new Dosis(LocalTime.of(12, 0), middag),
                new Dosis(LocalTime.of(18, 0), aften),
                new Dosis(LocalTime.of(22, 0), nat)
        };

        DagligFast dagligFast = controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morgen, middag, aften, nat);

        assertNotNull(dagligFast);
        assertEquals(startDen, dagligFast.getStartDen());
        assertEquals(slutDen, dagligFast.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(dagligFast));
        assertEquals("Acetylsalicylsyre", dagligFast.getLaegemiddel().getNavn());

        Dosis[] actualDoser = dagligFast.getDoser();
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }
    }

    @Test
    void TC3_testDagligFastOrdination(){
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double morgen = 0.0;
        double middag = 0.0;
        double aften = 0.0;
        double nat = 0.0;

        Dosis[] expectedDoser = {
                new Dosis(LocalTime.of(8, 0), morgen),
                new Dosis(LocalTime.of(12, 0), middag),
                new Dosis(LocalTime.of(18, 0), aften),
                new Dosis(LocalTime.of(22, 0), nat)
        };

        DagligFast dagligFast = controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morgen, middag, aften, nat);

        assertNotNull(dagligFast);
        assertEquals(startDen, dagligFast.getStartDen());
        assertEquals(slutDen, dagligFast.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(dagligFast));
        assertEquals("Acetylsalicylsyre", dagligFast.getLaegemiddel().getNavn());

        Dosis[] actualDoser = dagligFast.getDoser();
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }
    }

    @Test
    void TC4_testDagligFastOrdination(){
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double morgen = 210.0;
        double middag = 0.0;
        double aften = 0.0;
        double nat = 0.0;

        Dosis[] expectedDoser = {
                new Dosis(LocalTime.of(8, 0), morgen),
                new Dosis(LocalTime.of(12, 0), middag),
                new Dosis(LocalTime.of(18, 0), aften),
                new Dosis(LocalTime.of(22, 0), nat)
        };

        DagligFast dagligFast = controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morgen, middag, aften, nat);

        assertNotNull(dagligFast);
        assertEquals(startDen, dagligFast.getStartDen());
        assertEquals(slutDen, dagligFast.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(dagligFast));
        assertEquals("Acetylsalicylsyre", dagligFast.getLaegemiddel().getNavn());

        Dosis[] actualDoser = dagligFast.getDoser();
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }
    }

    @Test
    void TC1_testOpretDagligSkaevOrdination(){
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalTime[] tid = {LocalTime.of(8, 0), LocalTime.of(12, 30), LocalTime.of(18, 45)};
        double[] antal = {1.0, 0.5, 2.0};

        Dosis[] expectedDoser = {
                new Dosis(tid[0], antal[0]),
                new Dosis(tid[1], antal[1]),
                new Dosis(tid[2], antal[2])
        };

        DagligSkaev dagligSkaev = controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, tid, antal);

        assertNotNull(dagligSkaev);
        assertEquals(startDen, dagligSkaev.getStartDen());
        assertEquals(slutDen, dagligSkaev.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(dagligSkaev));
        assertEquals("Acetylsalicylsyre", dagligSkaev.getLaegemiddel().getNavn());

        Dosis[] actualDoser = dagligSkaev.getDoser().toArray(new Dosis[0]);
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }

    }

    @Test
    void TC2_testOpretDagligSkaevOrdination(){
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalTime[] tid = {LocalTime.of(8, 30), LocalTime.of(11, 30), LocalTime.of(16, 30)};
        double[] antal = {0.0, 0.0, 0.0};

        Dosis[] expectedDoser = {
                new Dosis(tid[0], antal[0]),
                new Dosis(tid[1], antal[1]),
                new Dosis(tid[2], antal[2])
        };

        DagligSkaev dagligSkaev = controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, tid, antal);

        assertNotNull(dagligSkaev);
        assertEquals(startDen, dagligSkaev.getStartDen());
        assertEquals(slutDen, dagligSkaev.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(dagligSkaev));
        assertEquals("Acetylsalicylsyre", dagligSkaev.getLaegemiddel().getNavn());

        Dosis[] actualDoser = dagligSkaev.getDoser().toArray(new Dosis[0]);
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }

    }

    @Test
    void TC3_testOpretDagligSkaevOrdination(){
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalTime[] tid = {LocalTime.of(9, 00), LocalTime.of(15, 30), LocalTime.of(21, 30)};
        double[] antal = {210.0, 0.0, 0.0};

        Dosis[] expectedDoser = {
                new Dosis(tid[0], antal[0]),
                new Dosis(tid[1], antal[1]),
                new Dosis(tid[2], antal[2])
        };

        DagligSkaev dagligSkaev = controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, tid, antal);

        assertNotNull(dagligSkaev);
        assertEquals(startDen, dagligSkaev.getStartDen());
        assertEquals(slutDen, dagligSkaev.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(dagligSkaev));
        assertEquals("Acetylsalicylsyre", dagligSkaev.getLaegemiddel().getNavn());

        Dosis[] actualDoser = dagligSkaev.getDoser().toArray(new Dosis[0]);
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }

    }

    @Test
    void TC4_testOpretDagligSkaevOrdination(){
        //test af fejl
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalTime[] tid = {LocalTime.of(8, 30), LocalTime.of(11, 00), LocalTime.of(16, 30), LocalTime.of(20, 45)};
        double[] antal = {1.0, 1.5, 2.0};

        Dosis[] expectedDoser = {
                new Dosis(tid[0], antal[0]),
                new Dosis(tid[1], antal[1]),
                new Dosis(tid[2], antal[2])
        };

        DagligSkaev dagligSkaev = controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, tid, antal);

        assertNotNull(dagligSkaev);
        assertEquals(startDen, dagligSkaev.getStartDen());
        assertEquals(slutDen, dagligSkaev.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(dagligSkaev));
        assertEquals("Acetylsalicylsyre", dagligSkaev.getLaegemiddel().getNavn());

        Dosis[] actualDoser = dagligSkaev.getDoser().toArray(new Dosis[0]);
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }

    }

    @Test
    void TC1_testOrdinationPNAnvendt() {
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);

        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(startDen, slutDen, laegemiddel, patient, 1.0);

        LocalDate gyldigDato = LocalDate.of(2021, 1, 10);


        assertTrue(pn.givDosis(gyldigDato));
    }

    @Test
    void TC2_testOrdinationPNAnvendt() {
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);

        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(startDen, slutDen, laegemiddel, patient, 1.0);

        LocalDate gyldigDato = LocalDate.of(2021, 1, 12);


        assertTrue(pn.givDosis(gyldigDato));
    }

    @Test
    void TC3_testOrdinationPNAnvendt() {
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);

        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        PN pn = new PN(startDen, slutDen, laegemiddel, patient, 1.0);

        LocalDate gyldigDato = LocalDate.of(2021, 1, 15);


        assertTrue(pn.givDosis(gyldigDato));
    }

    @Test
    void  TC1_testAnbefaletDosisPrDoegn(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1.0, 1.5, 2.0, "Ml");


        double anbefaletDosis1 = laegemiddel.getEnhedPrKgPrDoegnNormal() * patient.getVaegt();

        assertEquals(95.1, anbefaletDosis1);
    }

    @Test
    void  TC2_testAnbefaletDosisPrDoegn(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 24);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1.0, 1.5, 2.0, "Ml");


        double anbefaletDosis1 = laegemiddel.getEnhedPrKgPrDoegnLet() * patient.getVaegt();

        assertEquals(24, anbefaletDosis1);
    }

    @Test
    void  TC3_testAnbefaletDosisPrDoegn(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 119);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1.0, 1.5, 2.0, "Ml");


        double anbefaletDosis1 = laegemiddel.getEnhedPrKgPrDoegnNormal() * patient.getVaegt();

        assertEquals(178.5, anbefaletDosis1);
    }

    @Test
    void  TC4_testAnbefaletDosisPrDoegn(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 82.8);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1.0, 1.5, 2.0, "Ml");


        double anbefaletDosis1 = laegemiddel.getEnhedPrKgPrDoegnNormal() * patient.getVaegt();

        assertEquals(124.2, anbefaletDosis1);
    }

    @Test
    void  TC5_testAnbefaletDosisPrDoegn(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 25);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1.0, 1.5, 2.0, "Ml");


        double anbefaletDosis1 = laegemiddel.getEnhedPrKgPrDoegnLet() * patient.getVaegt();

        assertEquals(25, anbefaletDosis1);
    }

    @Test
    void  TC6_testAnbefaletDosisPrDoegn(){
        Patient patient = new Patient("123456-7890", "Jane Jensen", 121);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1.0, 1.5, 2.0, "Ml");


        double anbefaletDosis1 = laegemiddel.getEnhedPrKgPrDoegnTung() * patient.getVaegt();

        assertEquals(242, anbefaletDosis1);
    }


}
