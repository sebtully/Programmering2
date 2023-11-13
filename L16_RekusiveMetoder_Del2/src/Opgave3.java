public class Opgave3 {

    public static void main(String[] args) {
        System.out.println("Opgave3: ");
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 5;
        boolean found = binaraySearch(array, target);

        if (found) {
            System.out.println("tallet: " + target + " er fundet");
        } else {
            System.out.println("tallet: " + target + " ikke fundet");
        }
    }

    public static boolean binaraySearch(int[] array, int target) {
        return binaraySearch(array, target, 0, array.length - 1);
    }

    private static boolean binaraySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;

        if (array[mid] == target) {
            return false;
        } else if (array[mid] < target) {
            return binaraySearch(array, target, mid + 1, high);
        } else {
            return binaraySearch(array, target, mid + 1, high);
        }
    }
}

