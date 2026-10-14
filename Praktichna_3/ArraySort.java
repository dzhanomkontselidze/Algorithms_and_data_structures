import java.util.Random;


public class ArraySorter {
    //Array generation
  
    public static int[] generateArray(int length, int min, int max) {
        int[] array = new int[length];
      
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
    //Array output
    
    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[cell - " + i + ",value - " + array[i] + "]");
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    //Sorting types
    private static boolean isWrongOrder(int a, int b, boolean ascending) {
        if (ascending) {
            return a > b;
        } else {
            return a < b;
        }
    }
    public static void bubbleSort(int[] array, boolean ascending) {
        int n = array.length;
        for (int pass = 0; pass < n - 1; pass++) {
            for (int i = 0; i < n - 1 - pass; i++) {
                if (isWrongOrder(array[i], array[i + 1], ascending)) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
    public static void insertionSort(int[] array, boolean ascending) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && isWrongOrder(array[j], current, ascending)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void selectionSort(int[] array, boolean ascending) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int selectedIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (isWrongOrder(array[selectedIndex], array[j], ascending)) {
                    selectedIndex = j;
                }
            }
            if (selectedIndex != i) {
                int temp = array[i];
                array[i] = array[selectedIndex];
                array[selectedIndex] = temp;
            }
        }
    }
    public static int[] copyArray(int[] source) {
        int[] copy = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        return copy;
    }
}
