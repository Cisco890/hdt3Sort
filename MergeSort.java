import java.lang.Comparable;
import java.util.Arrays;
public class MergeSort<T extends Comparable<T>> implements ISorters<T> {

    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;

        T[] leftArray = Arrays.copyOfRange(array, 0, mid);
        T[] rightArray = Arrays.copyOfRange(array, mid, array.length);

        sort(leftArray);
        sort(rightArray);
        merge(leftArray, rightArray, array);

        return array;
    }

    private void merge(T[] leftArray, T[] rightArray, T[] array) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }
}
