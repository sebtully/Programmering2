package Opgave1;

import java.util.ArrayList;

public class App {
    private static Person[] personer;

    public static void main(String[] args) {
        ArrayList<Mekaniker> mekanikere= new ArrayList<>();

        mekanikere.add(new Mekaniker("Hans", "Hansvej 1", 1990, 200));
        mekanikere.add(new Mekaniker("Grethe", "Grethevej 2", 1995, 250));
        mekanikere.add(new Værkfører("Jens", "Jensvej 3", 1990, 300, 2010, 5000));
        mekanikere.add(new Værkfører("Lone", "Lonevej 4", 1995, 350, 2015, 6000));

        System.out.println("Samlet løn: " + samletLøn(mekanikere));
    }

    public static int samletLøn(ArrayList<Mekaniker> mekanikere){
        int løn = 0;
        for (Mekaniker mekaniker : mekanikere) {
            løn += mekaniker.beregnLøn();
        }
        return løn;
    }

}
