package Opgaver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilForsikringTest {

    @Test
    void beregnPraemie() {

        //Arrange

        BilForsikring bilforsikring = new BilForsikring();
        bilforsikring.setGrundpaemie(1100);

        int alder = 17;
        boolean isKvinde = true;
        int skadeFrieAar = 3;

        //Act
        double praemie = bilforsikring.beregnPraemie(alder, isKvinde, skadeFrieAar);

        //Assert
        assertEquals(1187.5, praemie);
    }
}
