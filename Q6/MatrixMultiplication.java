import java.util.Scanner;

public class MatrixMultiplication {

    // Custom exception for matrix multiplication
    static class MatrixMultiplicationException extends Exception {
        public MatrixMultiplicationException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Matrix A
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int colsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][colsA];

        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // Input for Matrix B
        System.out.print("Enter the number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int colsB = scanner.nextInt();
        int[][] matrixB = new int[rowsB][colsB];

        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        try {
            int[][] result = multiplyMatrices(matrixA, matrixB);
            System.out.println("Result of Matrix Multiplication:");
            printMatrix(result);
        } catch (MatrixMultiplicationException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) throws MatrixMultiplicationException {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        // Check if the number of columns in matrix A equals the number of rows in matrix B
        if (colsA != rowsB) {
            throw new MatrixMultiplicationException("Matrices cannot be multiplied: incompatible dimensions.");
        }

        // Create the result matrix
        int[][] result = new int[rowsA][colsB];

        // Perform matrix multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0; // Initialize the result cell
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
