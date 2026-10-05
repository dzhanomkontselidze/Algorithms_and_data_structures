import java.util.Random;

public class Task1Matrix {

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
        if (matrix == null || matrix.length == 0) return;

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

    public static void printMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

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
                System.out.printf("%-15.2f", matrix[i][j]); 
            }
            System.out.println();
        }
    }

    public static double[][] subtractRowMean(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
          
            double sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }

            double mean = sum / cols;

            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] - mean;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int m = 3; 
        int n = 4; 
        int min = 0;
        int max = 10;

        int[][] originalMatrix = generateMatrix(m, n, min, max);

        System.out.println("=== Початкова матриця ===");
        printMatrix(originalMatrix);

   
        double[][] resultMatrix = subtractRowMean(originalMatrix);

        System.out.println("\n=== Матриця пiсля вiднiмання середнього арифметичного кожної строки ===");
        printMatrix(resultMatrix);
    }
}
