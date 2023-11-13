import java.util.ArrayList;
import java.util.Random;

public class Opgave1_2 {

    static int pick;

    public static void main(String[] args) {
        ArrayList arr = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            pick = random.nextInt(100);
            arr.add(pick);

        }
        System.out.println("Opgave1" + "\n" + arr);
        System.out.println("Del1: " + ligeTal(arr));
        System.out.println("Del2 " + ligeTal2(arr));
        System.out.println();

    }

    // TODO: Opgave 1
    //Lav en rekursiv metode der kan finde antallet af lige tal i en liste
    public static int ligeTal(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        int firstElement = list.get(0);
        int restCount = ligeTal(new ArrayList<>(list.subList(1, list.size())));

        if (firstElement % 2 == 0) {
            return 1 + restCount;

        } else {
            return restCount;
        }
    }

    public static int ligeTal2(ArrayList<Integer> list) {
        return ligeTal2(list, 0);
    }

    private static int ligeTal2(ArrayList<Integer> list, int index) {
        int result;
        if (index == list.size()) {
            result = 0;
        } else if (list.get(index) % 2 == 0) {
            result = 1 + ligeTal2(list, index + 1);

        } else {
            result = ligeTal2(list, index + 1);
        }
        return result;

    }


    // TODO: Opgave 2
    // Et palindrom er en tekststreng der læses ens forfra og bagfra som f.eks ”ABBA” og ”radar”
    // Testes i Test klassen
    public static boolean pailndrom(String tekst) {
        return pailndrom(tekst.toCharArray(), 0, tekst.length() - 1);
    }

    // HjælpeMetode:
    private static boolean pailndrom(char[] tekst, int start, int slut) {
        if (slut - start < 1) {
            return true;
        } else if (tekst[start] == tekst[slut]) {
            return pailndrom(tekst, start + 1, slut - 1);
        }
        return false;
    }
}



