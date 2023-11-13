package snackssupply;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SnackBar<E>  {
    // TODO: Implement sortSnacks(E[] snackContainer)

    public<E extends Comparable<E>> E[] sortSnacks(E[] snackContainer) {
        // array to arrayList -> collections.sort -> arrayList to array
        ArrayList<E> sortering = new ArrayList<>(List.of(snackContainer));
        Collections.sort(sortering);
        E[] sorteret = (E[]) sortering.toArray();
        return sorteret;

    }
}
