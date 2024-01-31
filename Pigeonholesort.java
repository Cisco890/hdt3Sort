import java.util.Arrays;

public class Pigeonholesort<T extends Comparable<T>> implements ISorters<T> {

    @Override
    public T[] sort(T[] array) {
        int n = array.length;
        T min = array[0];
        T max = array[0];
        int range;
    
        for(int a = 0; a < n; a++){
            if (array[a].compareTo(max) > 0) {
                max = array[a];
            } 
            if (array[a].compareTo(min) < 0) {
                min = array[a];
            }
        }
        range = max.compareTo(min) + 1;
        int[] frequency = new int[range];
        Arrays.fill(frequency, 0);
    
        for (int i = 0; i < n; i++) {
            frequency[array[i].compareTo(min)]++;
        }

        int index = 0;
        for(int j = 0; j < range; j++){
            while (frequency[j]-- > 0){
                ((Incrementar<T>) min).increment();
                array[index++] = min;
            }
        }
        return array;
    }

    public interface Incrementar<T> {
        void increment();
    }
    
    public class Numero implements Incrementar<Numero> {
        private int value;
    
        public Numero(int value) {
            this.value = value;
        }
    
        public void increment() {
            value++;
        }
    }
    
}