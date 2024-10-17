import java.util.Arrays;
import java.util.Scanner;

public class SimpleArrayOperations {

    // a. Find common elements between two arrays
    public static void findCommonElements(int[] array1, int[] array2) {
        System.out.print("Common elements: ");
        for (int num1 : array1) {
            for (int num2 : array2) {
                if (num1 == num2) {
                    System.out.print(num1 + " ");
                }
            }
        }
        System.out.println();
    }

    // b. Remove duplicate elements from an array
    public static int[] removeDuplicates(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (array[i] == temp[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[index++] = array[i];
            }
        }
        return Arrays.copyOf(temp, index); // Return only the unique elements
    }

    // c. Find the second largest element in an array
    public static int findSecondLargest(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }
        return second;
    }

    // d. Find the second smallest element in an array
    public static int findSecondSmallest(int[] array) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : array) {
            if (num < first) {
                second = first;
                first = num;
            } else if (num < second && num > first) {
                second = num;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for first array
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        System.out.println("Enter " + size1 + " elements for the first array:");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        // Taking input for second array
        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        System.out.println("Enter " + size2 + " elements for the second array:");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        // a. Common elements
        findCommonElements(array1, array2);

        // b. Remove duplicates
        System.out.print("Enter the size of the array with duplicates: ");
        int sizeDuplicates = scanner.nextInt();
        int[] arrayWithDuplicates = new int[sizeDuplicates];
        System.out.println("Enter " + sizeDuplicates + " elements for the array with duplicates:");
        for (int i = 0; i < sizeDuplicates; i++) {
            arrayWithDuplicates[i] = scanner.nextInt();
        }
        int[] noDuplicates = removeDuplicates(arrayWithDuplicates);
        System.out.println("Array without duplicates: " + Arrays.toString(noDuplicates));

        // c. Second largest
        int secondLargest = findSecondLargest(array1);
        System.out.println("Second largest element in the first array: " + secondLargest);

        // d. Second smallest
        int secondSmallest = findSecondSmallest(array2);
        System.out.println("Second smallest element in the second array: " + secondSmallest);
        
        scanner.close();
    }
}
