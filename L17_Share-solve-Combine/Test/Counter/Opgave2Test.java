package Counter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Opgave2Test {

    @org.junit.jupiter.api.Test
    void counter_test() {

        // Arrange
        List<Integer> elements = new ArrayList<>();
        elements.add(0);
        elements.add(1);
        elements.add(0);
        elements.add(0);
        elements.add(4);


        // Assert & Act
        assertEquals(3, Opgave2.counter(elements));
    }


}