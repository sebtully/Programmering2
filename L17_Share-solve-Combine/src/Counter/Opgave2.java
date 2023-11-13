package Counter;

import java.util.List;

public class Opgave2 {

    public static int counter(List<Integer> elements) {
        return counter(elements, 0, elements.size() - 1);
    }

    private static int counter(List<Integer> elements, int l, int h) {
        int countZero = 0;
        if (l == h) {
            if (elements.get(l) == 0) {
                countZero++;
            }
        } else {
            int m = (l + h) / 2;
            int count1 = counter(elements, l, m);
            int count2 = counter(elements, m + 1, h);
            countZero = count1 + count2;
        }
        return countZero;
    }
}
