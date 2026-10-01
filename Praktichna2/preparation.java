
import java.util.Random;

public class MatrixPreparation {

    // генерація масива
    public static int[][] generateMatrix(int rows, int cols, int minVal, int maxVal) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // формула для отримання випадкового числа
                matrix[i][j] = random.nextInt(maxVal - minVal + 1) + minVal;
            }
        }

        return matrix;
    }

    // метод для гарного виводу матриці
public static void printMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
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

    public static void main(String[] args) {
        int m = 2;
        int n = 3; 
        int min = 0;
        int max = 10;

        int[][] myMatrix = generateMatrix(m, n, min, max);
        printMatrix(myMatrix);
    }
}
