package Opgaver;

public class Opgave4 {
    public static void main(String[] args) {
        System.out.println("2: " + hanoi(2));
        System.out.println("3: " + hanoi(3));
        System.out.println("4: " + hanoi(4));
        System.out.println("5: " + hanoi(5));
        System.out.println("6: " + hanoi(6));
        System.out.println("7: " + hanoi(7));
        System.out.println("8: " + hanoi(8));
        System.out.println("9: " + hanoi(9));
        System.out.println("10: " + hanoi(10));
        System.out.println("15: " + hanoi(15));
        System.out.println("20: " + hanoi(20));
        System.out.println("25: " + hanoi(25));

    }

    //Beregn antal flytninger der skal laves for at løse Towers of Hanoi
    public static int hanoi(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * hanoi(n - 1) + 1;
        }
    }
}
