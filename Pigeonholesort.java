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
        int minValue = Integer.parseInt(min.toString());
        for(int j = 0; j < range; j++){
            while (frequency[j]-- > 0){
                array[index++] = j + minValue;
            }
        }
        return array;
    }
    
}
// public static void pigeonhole_sort(int arr[], int n)
// {
//     int min = arr[0];
//     int max = arr[0];
//     int range, i, j, index;

//     for (int a = 0; a < n; a++) {
//         if (arr[a] > max)
//             max = arr[a];
//         if (arr[a] < min)
//             min = arr[a];
//     }

//     range = max - min + 1;
//     int[] phole = new int[range];
//     Arrays.fill(phole, 0);

//     for (i = 0; i < n; i++)
//         phole[arr[i] - min]++;

//     index = 0;

//     for (j = 0; j < range; j++)
//         while (phole[j]-- > 0)
//             arr[index++] = j + min;
