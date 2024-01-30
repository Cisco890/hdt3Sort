import java.lang.Comparable;
public class GnomeSort<T extends Comparable<T>> implements ISorters<T> {

    @Override
    public T[] sort(T[] array) {
        int n = array.length;
        int index = 0;
        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (index < n && array[index].compareTo(array[index - 1]) >= 0) {
                index++;
            } else {
                if (index < n) {
                    T temp = array[index];
                    array[index] = array[index - 1];
                    array[index - 1] = temp;
                    index--;
                }
            }
        }
        return array;
    }
    
}

