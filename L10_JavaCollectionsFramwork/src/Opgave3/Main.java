package Opgave3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<opgave3.Studerende> studerendeTreeSet = new TreeSet<>();

        studerendeTreeSet.add(new opgave3.Studerende(1, "Hans", new ArrayList<>(Arrays.asList(12))));
        studerendeTreeSet.add(new opgave3.Studerende(2, "Bent", new ArrayList<>(Arrays.asList(12, 10, 7))));
        studerendeTreeSet.add(new opgave3.Studerende(3, "Jens", new ArrayList<>(Arrays.asList(12, 10, 7))));

        for (opgave3.Studerende studerende : studerendeTreeSet) {
            System.out.println(studerende);
        }
    }
}
