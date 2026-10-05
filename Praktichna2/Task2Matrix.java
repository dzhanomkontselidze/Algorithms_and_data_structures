import java.util.Random;

public class Task2Matrix {


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

    public static int[][] cyclicShiftRightAndUp(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
  
                int newRow = (i - (k % rows) + rows) % rows;

              
                int newCol = (j + (k % cols) + cols) % cols;

                shiftedMatrix[newRow][newCol] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    public static void main(String[] args) {
        int m = 3; 
        int n = 4; 
        int min = 0;
        int max = 10;
        int k = 1;  

        int[][] originalMatrix = generateMatrix(m, n, min, max);

        System.out.println("=== Початкова матриця ===");
        printMatrix(originalMatrix);

        int[][] shiftedMatrix = cyclicShiftRightAndUp(originalMatrix, k);

        System.out.println("\n=== Матриця після циклічного зсуву на " + k + " позицію(-ї) вправо та догори ===");
        printMatrix(shiftedMatrix);
    }
}
