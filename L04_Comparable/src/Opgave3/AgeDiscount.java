package Opgave3;

import java.time.LocalDate;

public class AgeDiscount implements Discount{
    private int rabat;

    public AgeDiscount(LocalDate BirthDate) {
        this.rabat = LocalDate.now().getYear() - BirthDate.getYear() ;
    }

    @Override
    public double getDiscount(double price) {
        double nyPris = 0;
        nyPris = price - ((1.0-(this.rabat/100.0))*price);
        return nyPris;
    }
}
