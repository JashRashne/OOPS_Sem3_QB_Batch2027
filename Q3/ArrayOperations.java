
import java.util.Arrays;
import java.util.*;

public class ArrayOperations {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        Scanner sc = new Scanner(System.in);
        // Test if the array contains a specific value
        System.out.println("Enter value to be found : ");
        int valueToFind = sc.nextInt();
        System.out.println("Contains " + valueToFind + ": " + contains(array, valueToFind));

        // Remove a specific element
        System.out.println("Enter value to be removed : ");

        int valueToRemove = sc.nextInt();
        array = removeElement(array, valueToRemove);
        System.out.println("Array after removing " + valueToRemove + ": " + Arrays.toString(array));

        // Insert an element at a specific position
        System.out.println("Enter value to be inserted : ");

        int valueToInsert = sc.nextInt();
        System.out.println("Enter position at which value to be inserted : ");

        int position = sc.nextInt();
        array = insertElement(array, valueToInsert, position);
        System.out.println("Array after inserting " + valueToInsert + " at position " + position + ": " + Arrays.toString(array));

        // Find the maximum and minimum value
        System.out.println();
        System.out.println("Maximum value: " + findMax(array));
        System.out.println("Minimum value: " + findMin(array));
    }

    // Method to check if the array contains a specific value
    public static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    // Method to remove a specific element from the array
    public static int[] removeElement(int[] array, int value) {
        return Arrays.stream(array)
                     .filter(element -> element != value)
                     .toArray();
    }

    // Method to insert an element at a specific position
    public static int[] insertElement(int[] array, int value, int position) {
        if (position < 0 || position > array.length) {
            throw new ArrayIndexOutOfBoundsException("Position out of bounds");
        }
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, position);
        newArray[position] = value;
        System.arraycopy(array, position, newArray, position + 1, array.length - position);
        return newArray;
    }

    // Method to find the maximum value in the array
    public static int findMax(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    // Method to find the minimum value in the array
    public static int findMin(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }
}


