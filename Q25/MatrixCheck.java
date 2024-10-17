import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SymmetricMatrixException extends Exception {
    public SymmetricMatrixException(String message) {
        super(message);
    }
}

public class MatrixCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 1: Vector Management
        List<Integer> numbers = new ArrayList<>();

        // Accepting five integers from the command line
        System.out.println("Enter five integers:");
        for (int i = 0; i < 5; i++) {
            numbers.add(scanner.nextInt());
        }

        // Add a member at a specified location
        System.out.println("Enter a number to add:");
        int newNumber = scanner.nextInt();
        System.out.println("Enter the position (0 to " + numbers.size() + "):");
        int position = scanner.nextInt();
        numbers.add(position, newNumber);

        // Delete the last member
        if (!numbers.isEmpty()) {
            numbers.remove(numbers.size() - 1);
        }

        // Print the contents of the vector
        System.out.println("Current list of numbers: " + numbers);

        // Part 2: Symmetric Matrix Check
        System.out.println("Enter the size of the matrix (n x n):");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // Accepting the matrix
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        try {
            checkSymmetric(matrix);
            int nonDiagonalSum = sumNonDiagonal(matrix);
            System.out.println("The matrix is symmetric.");
            System.out.println("Sum of non-diagonal elements: " + nonDiagonalSum);
        } catch (SymmetricMatrixException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    // Method to check if the matrix is symmetric
    private static void checkSymmetric(int[][] matrix) throws SymmetricMatrixException {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    throw new SymmetricMatrixException("The matrix is not symmetric.");
                }
            }
        }
    }

    // Method to calculate the sum of non-diagonal elements
    private static int sumNonDiagonal(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) { // Exclude diagonal elements
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
