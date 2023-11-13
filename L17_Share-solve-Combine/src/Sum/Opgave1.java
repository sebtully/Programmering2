package Sum;

import java.util.ArrayList;
import java.util.List;

public class Opgave1 {

    public static int sum(List<Integer> numbers) {


        return sum(numbers, 0, numbers.size() - 1);
    }

    private static int sum(List<Integer> numbers, int l, int h) {
        int result = 0;
        if (l == h) {
            result = numbers.get(l);
        } else {
            int m = (l + h) / 2;
            int sum1 = sum(numbers, l, m);
            int sum2 = sum(numbers, m + 1, h);
            result = sum1 + sum2;
        }
        return result;
    }

}
