package Opgaver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BiblotekTest {

    @Test
    void beregnBøde_1dag_barn() {

        // Arrange
        LocalDate beregnetDato = LocalDate.of(2023,6,1);
        LocalDate faktiskDato = LocalDate.of(2023,6,2);
        boolean voksen = false;

        Biblotek biblotek = new Biblotek();
        int forventetBøde = 10;

        // Act
        int faktiskBøde = biblotek.beregnBøde(beregnetDato,faktiskDato,voksen);

        // Assert
        assertEquals(forventetBøde,faktiskBøde);




    }
}