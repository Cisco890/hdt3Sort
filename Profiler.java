import java.util.function.Consumer;

public class Profiler {
    public static void profileSort(String sortName, Integer[] numbers, Consumer<Integer[]> sortMethod) {
        Integer[] numbersCopy = numbers.clone();
        long startTime = System.currentTimeMillis();
        sortMethod.accept(numbersCopy);
        long endTime = System.currentTimeMillis();
        System.out.println(sortName + " Time: " + (endTime - startTime) + " ms");
    }

    public static void profileSort(String sortName, int[] numbers, Consumer<int[]> sortMethod) {
        int[] numbersCopy = numbers.clone();
        long startTime = System.currentTimeMillis();
        sortMethod.accept(numbersCopy);
        long endTime = System.currentTimeMillis();
        System.out.println(sortName + " Time: " + (endTime - startTime) + " ms");
    }
}

