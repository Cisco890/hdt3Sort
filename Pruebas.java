import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Pruebas {
    
    @Test
    public void RadixSortTEST(){
        RadixSort<Integer> sorter = new RadixSort<>();
        Integer[] array = {5, 3, 8, 2, 1, 7, 4, 6};
        Integer[] sortedArray = sorter.sort(array);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void MergeSortTEST(){
        MergeSort<Integer> sorter = new MergeSort<>();
        Integer[] array = {5, 3, 8, 2, 1, 7, 4, 6};
        Integer[] sortedArray = sorter.sort(array);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void GnomeSortTEST(){
        GnomeSort<Integer> sorter = new GnomeSort<>();
        Integer[] array = {5, 3, 8, 2, 1, 7, 4, 6};
        Integer[] sortedArray = sorter.sort(array);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void QuickSortTEST(){
        QuickSort<Integer> sorter = new QuickSort<>();
        Integer[] array = {5, 3, 8, 2, 1, 7, 4, 6};
        Integer[] sortedArray = sorter.sort(array);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void HeapSortTEST(){
        HeapSort<Integer> sorter = new HeapSort<>();
        Integer[] array = {5, 3, 8, 2, 1, 7, 4, 6};
        Integer[] sortedArray = sorter.sort(array);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, sortedArray);
    }
}
