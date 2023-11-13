package Sum;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Opgave1Test {

    @org.junit.jupiter.api.Test
    void sum_test_even_number() {

        // Arrange
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        // Act
        int actualSum = Opgave1.sum(numbers);
        int expectedSum = 10;

        // Assert
        assertEquals(expectedSum, actualSum);
    }

    @org.junit.jupiter.api.Test
    void sum_test_uneven_number() {

        // Arrange
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Act
        int actualSum = Opgave1.sum(numbers);
        int expectedSum = 15;

        // Assert
        assertEquals(expectedSum, actualSum);
    }



}