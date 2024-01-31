public class QuickSort<T extends Comparable<T>> implements ISorters<T> {
    
    @Override
    public T[] sort(T[] array) {
        quickSort(array, 0,array.length);
        return array;
    }

    private void quickSort(T[] array, int inicio, int fin) {
        if (inicio >= fin) return;
        
        T pivote = array[inicio];
        int elemIzq = inicio + 1;
        int elemDer = fin;
        
        while (elemIzq <= elemDer) {
            while (elemIzq <= fin && array[elemIzq].compareTo(pivote) < 0) {
                elemIzq++;
            }
            while (elemDer > inicio && array[elemDer].compareTo(pivote) >= 0) {
                elemDer--;
            }
            if (elemIzq < elemDer) {
                T temp = array[elemIzq];
                array[elemIzq] = array[elemDer];
                array[elemDer] = temp;
            }
        }
        
        if (elemDer > inicio) {
            T temp = array[inicio];
            array[inicio] = array[elemDer];
            array[elemDer] = temp;
        }
        
        quickSort(array, inicio, elemDer - 1);
        quickSort(array, elemDer + 1, fin);
    }

}