import java.util.Random;

public class Task4Matrix {


    public static int[][] generateMatrix(int rows, int cols, int minVal, int maxVal) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(maxVal - minVal + 1) + minVal;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Матриця порожня!");
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.printf("%-12s", "");
        for (int j = 0; j < cols; j++) {
            System.out.printf("%-15s", "стовпець " + (j + 1));
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.printf("%-12s", "рядок " + (i + 1));
            for (int j = 0; j < cols; j++) {
                System.out.printf("%-15d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotate90ClockwiseInPlace(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int n = matrix.length;
        if (n != matrix[0].length) {
            throw new IllegalArgumentException("In-place обертання можливе лише для квадратних матриць (N x N)!");
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3; 
        int min = 1;
        int max = 9;

       
        int[][] squareMatrix = generateMatrix(n, n, min, max);

        System.out.println("=== Початкова квадратна матриця ===");
        printMatrix(squareMatrix);

        rotate90ClockwiseInPlace(squareMatrix);

        System.out.println("\n=== Матриця після обертання на 90° за годинниковою стрілкою (In-Place) ===");
        printMatrix(squareMatrix);
    }
}
