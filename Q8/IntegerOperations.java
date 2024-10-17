import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerOperations {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Accepting two integers from the user
            System.out.print("Enter the first integer: ");
            int num1 = Integer.parseInt(reader.readLine());
            System.out.print("Enter the second integer: ");
            int num2 = Integer.parseInt(reader.readLine());

            // Calculating required values
            int sum = num1 + num2;
            int difference = num1 - num2;
            int product = num1 * num2;
            double average = (num1 + num2) / 2.0;
            int max = Math.max(num1, num2);
            int min = Math.min(num1, num2);

            // Printing results
            System.out.println("Sum: " + sum);
            System.out.println("Difference: " + difference);
            System.out.println("Product: " + product);
            System.out.println("Average: " + average);
            System.out.println("Maximum: " + max);
            System.out.println("Minimum: " + min);

            // Breaking both integers into individual digits
            System.out.print("Digits in sequence are  : " + num1 + " " + num2);

        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        }
    }

    private static void printDigits(int number) {
        // Converting the integer to a string to iterate over each digit
        String numberStr = String.valueOf(number);
        for (char digit : numberStr.toCharArray()) {
            System.out.print(digit + " ");
        }
        System.out.println(); // New line after printing digits
    }
}
