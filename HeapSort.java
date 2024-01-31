import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> implements ISorters<T> {

    @Override
    public T[] sort(T[] arr) {
        int N = arr.length;

        // Construir el montículo (heapify)
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }

        // Extraer elementos del montículo uno por uno
        for (int i = N - 1; i > 0; i--) {
            // Intercambiar el elemento raíz (máximo) con el último elemento del montículo
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el montículo reducido
            heapify(arr, i, 0);
        }
        return arr;
    }

    private void heapify(T[] arr, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // Comprobar si el hijo izquierdo es mayor que el nodo raíz
        if (l < N && arr[l].compareTo(arr[largest]) > 0) {
            largest = l;
        }

        // Comprobar si el hijo derecho es mayor que el nodo raíz o el hijo izquierdo
        if (r < N && arr[r].compareTo(arr[largest]) > 0) {
            largest = r;
        }

        // Si el mayor no es el nodo raíz, intercambiar y hacer heapify en el subárbol afectado
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }
}