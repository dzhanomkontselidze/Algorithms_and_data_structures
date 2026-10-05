import java.util.Random;

public class Task3Matrix {

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

  
    public static int[][] removeMaxRowsAndCols(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 1. Знаходимо максимальне значення в матриці
        int maxVal = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                }
            }
        }

        System.out.println("Максимальний елемент у матриці: " + maxVal);

      
        boolean[] removeRow = new boolean[rows];
        boolean[] removeCol = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == maxVal) {
                    removeRow[i] = true;
                    removeCol[j] = true;
                }
            }
        }

        int newRows = 0;
        for (int i = 0; i < rows; i++) {
            if (!removeRow[i]) newRows++;
        }

        int newCols = 0;
        for (int j = 0; j < cols; j++) {
            if (!removeCol[j]) newCols++;
        }

        if (newRows == 0 || newCols == 0) {
            System.out.println("Усі рядки або стовпці було видалено!");
            return new int[0][0];
        }

        int[][] result = new int[newRows][newCols];
        int r = 0;
        for (int i = 0; i < rows; i++) {
            if (removeRow[i]) continue; 

            int c = 0;
            for (int j = 0; j < cols; j++) {
                if (removeCol[j]) continue; 

                result[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }

        return result;
    }

    public static void main(String[] args) {
        int m = 4; 
        int n = 4;
        int min = 0;
        int max = 10;

        int[][] originalMatrix = generateMatrix(m, n, min, max);

        System.out.println("=== Початкова матриця ===");
        printMatrix(originalMatrix);

        System.out.println("\n=== Видалення рядків та стовпців ===");
        int[][] reducedMatrix = removeMaxRowsAndCols(originalMatrix);

        System.out.println("\n=== Результат ===");
        printMatrix(reducedMatrix);
    }
}
