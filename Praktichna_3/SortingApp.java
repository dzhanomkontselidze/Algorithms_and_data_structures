import java.util.Random;

public class SortingApp {

    // 1. Метод, що генерує масив заданої довжини у заданому діапазоні [min, max]
    public static int[] generateArray(int length, int min, int max) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }
        return array;
    }

    // 2. Метод, що виводить елементи масиву у заданому форматі
    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("{}");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < array.length; i++) {
            sb.append("[cell - ").append(i).append(",value - ").append(array[i]).append("]");
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        System.out.println(sb.toString());
    }

    // 3. Сортування бульбашкою (Bubble sort)
    public static void bubbleSort(int[] array, boolean ascending) {
        if (array == null || array.length <= 1) return;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Визначаємо умову заміни залежно від напрямку сортування
                boolean condition = ascending ? (array[j] > array[j + 1]) : (array[j] < array[j + 1]);
                if (condition) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 4. Сортування вставками (Insertion sort)
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

    // 5. Сортування вибором (Selection sort)
    public static void selectionSort(int[] array, boolean ascending) {
        if (array == null || array.length <= 1) return;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int extremeIdx = i;
            for (int j = i + 1; j < n; j++) {
                boolean condition = ascending ? (array[j] < array[extremeIdx]) : (array[j] > extremeIdx);
                // Виправлення умови для вибору хіджа/мінімуму/максимуму:
                if (ascending) {
                    if (array[j] < array[extremeIdx]) extremeIdx = j;
                } else {
                    if (array[j] > array[extremeIdx]) extremeIdx = j;
                }
            }
            // Обмін елементів
            int temp = array[extremeIdx];
            array[extremeIdx] = array[i];
            array[i] = temp;
        }
    }

    // Головний метод для перевірки та демонстрації
    public static void main(String[] args) {
        int length = 5;
        int min = 1;
        int max = 20;

        System.out.println("=== 1. BUBBLE SORT ===");
        int[] arr1 = generateArray(length, min, max);
        System.out.print("Початковий: ");
        printArray(arr1);
        System.out.print("За зростанням (true): ");
        bubbleSort(arr1, true);
        printArray(arr1);
        System.out.print("За спаданням (false): ");
        bubbleSort(arr1, false);
        printArray(arr1);

        System.out.println("\n=== 2. INSERTION SORT ===");
        int[] arr2 = generateArray(length, min, max);
        System.out.print("Початковий: ");
        printArray(arr2);
        System.out.print("За зростанням (true): ");
        insertionSort(arr2, true);
        printArray(arr2);
        System.out.print("За спаданням (false): ");
        insertionSort(arr2, false);
        printArray(arr2);

        System.out.println("\n=== 3. SELECTION SORT ===");
        int[] arr3 = generateArray(length, min, max);
        System.out.print("Початковий: ");
        printArray(arr3);
        System.out.print("За зростанням (true): ");
        selectionSort(arr3, true);
        printArray(arr3);
        System.out.print("За спаданням (false): ");
        selectionSort(arr3, false);
        printArray(arr3);
    }
}
