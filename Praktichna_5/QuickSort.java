import java.util.Arrays;
import java.util.Random;

public class QuickSortApp {

    public static int[] generateArray(int length, int min, int max) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }
        return array;
    }

  
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(int[] array, boolean ascending) {
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1, ascending);
    }

    private static void quickSort(int[] array, int low, int high, boolean ascending) {
        if (low < high) {                                   
            int pivotIndex = partition(array, low, high, ascending);
            quickSort(array, low, pivotIndex - 1, ascending);   
            quickSort(array, pivotIndex + 1, high, ascending);  
        }
    }


    private static int partition(int[] array, int low, int high, boolean ascending) {
        int pivot = array[high];
        int i = low;                                       
        for (int j = low; j < high; j++) {
            boolean goesLeft = ascending ? (array[j] < pivot) : (array[j] > pivot);
            if (goesLeft) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, high);                               
        return i;
    }

    public static boolean isSorted(int[] array, boolean ascending) {
        if (array == null || array.length <= 1) return true;
        for (int i = 1; i < array.length; i++) {
            if (ascending && array[i - 1] > array[i]) return false;
            if (!ascending && array[i - 1] < array[i]) return false;
        }
        return true;
    }

    public static void bubbleSort(int[] array, boolean ascending) {
        if (array == null || array.length <= 1) return;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean condition = ascending ? (array[j] > array[j + 1]) : (array[j] < array[j + 1]);
                if (condition) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] array, boolean ascending) {
        if (array == null || array.length <= 1) return;
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && (ascending ? (array[j] > key) : (array[j] < key))) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(int[] array, boolean ascending) {
        if (array == null || array.length <= 1) return;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int extremeIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (ascending) {
                    if (array[j] < array[extremeIdx]) extremeIdx = j;
                } else {
                    if (array[j] > array[extremeIdx]) extremeIdx = j;
                }
            }
            swap(array, extremeIdx, i);
        }
    }

    

    private static double measure(int[] original, String name, boolean ascending) {
        int[] copy = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        switch (name) {
            case "quick":     quickSort(copy, ascending);     break;
            case "bubble":    bubbleSort(copy, ascending);    break;
            case "insertion": insertionSort(copy, ascending); break;
            case "selection": selectionSort(copy, ascending); break;
        }
        long end = System.nanoTime();
        if (!isSorted(copy, ascending)) {
            System.out.println("ПОМИЛКА: " + name + " відсортував неправильно!");
        }
        return (end - start) / 1_000_000.0;
    }

    public static void main(String[] args) {

        int[] demo = generateArray(10, 1, 50);
        System.out.println("Початковий:   " + Arrays.toString(demo));
        quickSort(demo, true);
        System.out.println("За зростанням: " + Arrays.toString(demo)
                + "  впорядкований? " + isSorted(demo, true));
        quickSort(demo, false);
        System.out.println("За спаданням:  " + Arrays.toString(demo)
                + "  впорядкований? " + isSorted(demo, false));


        int[] sizes = {1_000, 10_000, 100_000};
        System.out.println();
        System.out.printf("%-10s %12s %12s %12s %12s%n",
                "Розмір", "Quick, мс", "Bubble, мс", "Insertion, мс", "Selection, мс");

        for (int size : sizes) {
            int[] data = generateArray(size, 1, 1_000_000);
            System.out.printf("%-10d %12.2f %12.2f %12.2f %12.2f%n",
                    size,
                    measure(data, "quick", true),
                    measure(data, "bubble", true),
                    measure(data, "insertion", true),
                    measure(data, "selection", true));
        }
    }
}
