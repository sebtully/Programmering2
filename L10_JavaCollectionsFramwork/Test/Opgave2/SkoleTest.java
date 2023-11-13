package opgave2;

import Opgave2.List.Skole;
import Opgave2.List.Studerende;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkoleTest {

    @Test
    void test_opretSkoleMedStuderende() {
        Studerende studerende1 = new Studerende(1, "Studerende1", List.of(7));
        Studerende studerende2 = new Studerende(2, "Studerende2", List.of(10));
        Studerende studerende3 = new Studerende(3, "Studerende3", List.of(4));

        ArrayList<Studerende> studerendeList = new ArrayList<>();
        studerendeList.add(studerende1);
        studerendeList.add(studerende2);
        studerendeList.add(studerende3);

        Skole skole = new Skole("Skole", studerendeList);

        assertEquals("Skole", skole.getNavn());
        assertEquals(3, skole.getStuderende().size());
        assertEquals(7, skole.gennemsnit());

    }

}