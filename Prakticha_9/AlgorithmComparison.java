import java.util.Arrays;
import java.util.Random;

public class AlgorithmComparison {

    public static void main(String[] args) {
        int[] sizes = {10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};
        int runs = 3; 

        System.out.printf("%-15s | %-22s | %-22s | %-22s%n",
                "Розмір даних", "Спосіб 1 (Сортування)", "Спосіб 2 (Топ-6 масив)", "Спосіб 3 (6 максимумів)");
        System.out.println("-------------------------------------------------------------------------------------------");

        for (int n : sizes) {
            long[] t1 = new long[runs];
            long[] t2 = new long[runs];
            long[] t3 = new long[runs];

            boolean skipSlowSort = n > 100_000; // Захист від зависання коли буде мільйн елементів

            for (int r = 0; r < runs; r++) {

                int[] original = generateRandomArray(n, -10_000, 10_000);

                //(Insertion Sort)
                if (!skipSlowSort) {
                    int[] copy1 = Arrays.copyOf(original, original.length);
                    long start1 = System.currentTimeMillis();
                    find6thBySimpleSort(copy1);
                    t1[r] = System.currentTimeMillis() - start1;
                }

                //Підтримка відсортованого масиву з 6 найбільших
                int[] copy2 = Arrays.copyOf(original, original.length);
                long start2 = System.currentTimeMillis();
                find6thByTop6Array(copy2);
                t2[r] = System.currentTimeMillis() - start2;

                //6-разовий пошук
                int[] copy3 = Arrays.copyOf(original, original.length);
                long start3 = System.currentTimeMillis();
                find6thBySixMaxPasses(copy3);
                t3[r] = System.currentTimeMillis() - start3;
            }

            String res1 = skipSlowSort ? "Занадто довго O(N^2)" : formatResult(t1);
            String res2 = formatResult(t2);
            String res3 = formatResult(t3);

            System.out.printf("%-15s | %-22s | %-22s | %-22s%n", n, res1, res2, res3);
        }
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] arr = new int[size];
        int bound = max - min + 1;
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound) + min;
        }
        return arr;
    }

    //За спаданням (Insertion Sort) і вибір 6-го елемента
    public static int find6thBySimpleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) { 
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr[5];
    }

    //Масив із 6 найбільших елементів
    public static int find6thByTop6Array(int[] arr) {
        int[] top6 = new int[6];
        Arrays.fill(top6, Integer.MIN_VALUE);

        for (int num : arr) {
            if (num > top6[5]) {
                top6[5] = num;
                for (int i = 5; i > 0 && top6[i] > top6[i - 1]; i--) {
                    int temp = top6[i];
                    top6[i] = top6[i - 1];
                    top6[i - 1] = temp;
                }
            }
        }
        return top6[5];
    }

    //6 разів шукаємо максимум і замінюємо його на Integer.MIN_VALUE
    public static int find6thBySixMaxPasses(int[] arr) {
        int sixthMax = Integer.MIN_VALUE;

        for (int step = 0; step < 6; step++) {
            int maxVal = Integer.MIN_VALUE;
            int maxIdx = -1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > maxVal) {
                    maxVal = arr[i];
                    maxIdx = i;
                }
            }

            sixthMax = maxVal;
            if (maxIdx != -1) {
                arr[maxIdx] = Integer.MIN_VALUE; 
            }
        }
        return sixthMax;
    }

    
    private static String formatResult(long[] times) {
        long avg = (times[0] + times[1] + times[2]) / 3;
        return String.format("%d(%d %d %d)", avg, times[0], times[1], times[2]);
    }
}
