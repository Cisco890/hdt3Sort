import java.util.Arrays;
import java.lang.Comparable;
 
ublic class RadixSort<T extends Comparable<T>> implements ISorters<T> {

    @Override
    public T[] sort(T[] array) {
        T max = getMax(array);
        int maxDigit = getMaxDigit(max);

        for (int place = 1; place <= maxDigit; place *= 10) {
            countingSort(array, place);
        }

        return array;
    }

    private void countingSort(T[] array, int place) {
        int size = array.length;
        T[] output = Arrays.copyOf(array, size);
        int[] count = new int[10];

        for (int i = 0; i < size; i++) {
            int digit = getDigit(array[i], place);
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            int digit = getDigit(array[i], place);
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, array, 0, size);
    }

    private int getMaxDigit(T max) {
        int maxDigit = 0;
        for (int i = 1; getMaxDigitValue(max, i) > 0; i++) {
            maxDigit = i;
        }
        return maxDigit;
    }

    private int getMaxDigitValue(T max, int place) {
        int digitValue = getDigit(max, place);
        return digitValue / 10;
    }

    private int getDigit(T element, int place) {
        String stringValue = element.toString();
        int length = stringValue.length();

        if (place <= length) {
            char digitChar = stringValue.charAt(length - place);
            return Character.getNumericValue(digitChar);
        } else {
            return 0;
        }
    }

    private T getMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
