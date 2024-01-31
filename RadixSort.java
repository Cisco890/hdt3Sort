import java.util.Arrays;
import java.lang.Comparable;
 
public class RadixSort<T extends Comparable<T>> implements ISorters<T> {

    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int max = getMax(array);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }

        return array;
    }

    private int getMax(T[] array) {
        int max = 0;
        for (T element : array) {
            int value = ((Integer) element).intValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private void countingSort(T[] array, int exp) {
        int n = array.length;
        Object[] output = new Object[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            int index = ((Integer) array[i]).intValue() / exp;
            count[index % 10]++;
        }


        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = ((Integer) array[i]).intValue() / exp;
            output[count[index % 10] - 1] = array[i];
            count[index % 10]--;
        }


        System.arraycopy(output, 0, array, 0, n);
    }
}
