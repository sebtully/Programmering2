package Opgave1;

import java.util.HashSet;

public class AndvendMetoderpaaHashSet {

    public static void main(String[] args) {
    // 1) Tilføj til main erklæring og oprettelse af en mængde baseret på et HashSet. Mængden skal indeholde heltal.
    // 2) Indsæt tallene 34,12,23,45,67,34,98 i mængden
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(34);
        hashSet.add(12);
        hashSet.add(23);
        hashSet.add(45);
        hashSet.add(67);
        hashSet.add(34);
        hashSet.add(98);

        // 3) Udskriv indholdet af mængden
        System.out.println("HashSet: " + hashSet);

        // 4) Indsæt tallet 23 i mængden
        hashSet.add(23);

        // 5) Udskriv indholdet af mængden
        System.out.println("HashSet: " + hashSet);

        // 6) Fjern elemenetet 67 fra mængden
        hashSet.remove(67);

        // 7) Undersøg om mængden indeholder elementet 23
        System.out.println("HashSet contains 23: " + hashSet.contains(23));

        // 8) Undersøg hvor mange elementer der er i mængden
        System.out.println("HashSet size: " + hashSet.size());

    }
}
