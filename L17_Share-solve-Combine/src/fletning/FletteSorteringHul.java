package fletning;

import java.util.ArrayList;

public class FletteSorteringHul {

    // den metode der saetter fletningen i gang
    public void fletteSort(ArrayList<Integer> list) {
        mergeSort(list, 0, list.size() - 1);
    }

    // den rekursive metode der implementere del-loes og kombiner skabelonen
    private void mergeSort(ArrayList<Integer> list, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergeSort(list, l, m);
            mergeSort(list, m + 1, h);
            merge(list, l, m, h);
        }
    }

    // den metode der sætter merge i gang
    public void merge(ArrayList<Integer> list) {
        merge(list, 0, list.size() / 2, list.size() - 1);
    }

    // kombiner er realiseret ved fletteskabelonen
    private void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int l = low;
        int m = middle + 1;

        

        }
    }

