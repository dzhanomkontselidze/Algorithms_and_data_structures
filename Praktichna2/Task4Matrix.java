import java.util.concurrent.ThreadLocalRandom;

public class Task4Matrix {

    public static int[][] generateMatrix(int rows, int cols, int minVal, int maxVal) {
        int[][] matrix = new int[rows][cols];
        for (int[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                row[j] = ThreadLocalRandom.current().nextInt(minVal, maxVal + 1);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Матриця порожня!");
            return;
        }

        System.out.printf("%-12s", "");
        for (int j = 1; j <= matrix[0].length; j++) {
            System.out.printf("%-15s", "стовпець " + j);
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%-12s", "рядок " + (i + 1));
            for (int value : matrix[i]) {
                System.out.printf("%-15d", value);
            }
            System.out.println();
        }
    }

    public static void rotate90ClockwiseInPlace(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        if (n != matrix[0].length) {
            throw new IllegalArgumentException("In-place обертання можливе лише для квадратних матриць (N x N)!");
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix) {
            for (int j = 0; j < n / 2; j++) {
                int temp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3, 3, 1, 9);

        System.out.println("=== Початкова квадратна матриця ===");
        printMatrix(matrix);

        rotate90ClockwiseInPlace(matrix);

        System.out.println("\n=== Матриця після обертання на 90° за годинниковою стрілкою (In-Place) ===");
        printMatrix(matrix);
    }
}
