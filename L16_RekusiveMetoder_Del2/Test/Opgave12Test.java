import static org.junit.jupiter.api.Assertions.*;

class Opgave12Test {

    @org.junit.jupiter.api.Test
    void pailndrom_valid() {

        // Arrange
        String pal1 = "anna";
        String pal2 = "abba";
        String pal3 = "bob";

        // Act & Assert
        assertTrue(Opgave1_2.pailndrom(pal1));
        assertTrue(Opgave1_2.pailndrom(pal2));
        assertTrue(Opgave1_2.pailndrom(pal3));

    }

    @org.junit.jupiter.api.Test
    void pailndrom_invalid() {
            // Arrange
            String pal4 = "sovs";
            String pal5 = "tully";
            String pal6 = "jan";

            // Act & Assert
            assertFalse(Opgave1_2.pailndrom(pal4));
            assertFalse(Opgave1_2.pailndrom(pal5));
            assertFalse(Opgave1_2.pailndrom(pal6));
        }

    }
