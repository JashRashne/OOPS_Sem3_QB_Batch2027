import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first array
        System.out.print("Enter the number of elements in the first array: ");
        int n1 = scanner.nextInt();
        int[] array1 = new int[n1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        // Input for the second array
        System.out.print("Enter the number of elements in the second array: ");
        int n2 = scanner.nextInt();
        int[] array2 = new int[n2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        // Check if both arrays have the same unique elements
        boolean sameElements = haveSameElements(array1, array2);
        
        if (sameElements) {
            System.out.println("The arrays have the same elements (ignoring duplicates).");
        } else {
            System.out.println("The arrays do NOT have the same elements.");
        }

        scanner.close();
    }

    // Method to check for the same unique elements
    public static boolean haveSameElements(int[] array1, int[] array2) {
        // Compare unique elements of array1 with array2
        for (int i = 0; i < array1.length; i++) {
            if (!contains(array2, array1[i])) {
                return false; // Element not found
            }
        }

        // Compare unique elements of array2 with array1
        for (int i = 0; i < array2.length; i++) {
            if (!contains(array1, array2[i])) {
                return false; // Element not found
            }
        }

        return true; // All elements match
    }

    // Method to check if an array contains a specific element
    public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true; // Element found
            }
        }
        return false; // Element not found
    }
}
