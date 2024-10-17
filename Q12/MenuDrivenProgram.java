import java.util.Scanner;

public class MenuDrivenProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Read a floating-point number");
            System.out.println("2. Count the number of digits in an integer");
            System.out.println("3. Check if three numbers are equal, different, or neither");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a floating-point number: ");
                    float floatNumber = scanner.nextFloat();
                    if (floatNumber == 0) {
                        System.out.println("zero");
                    } else if (floatNumber > 0) {
                        System.out.println("positive");
                    } else {
                        System.out.println("negative");
                    }
                    break;

                case 2:
                    System.out.print("Enter an integer: ");
                    int intNumber = scanner.nextInt();
                    int count = 0;
                    if (intNumber == 0) {
                        count = 1; // Special case for zero
                    } else {
                        int temp = Math.abs(intNumber); // To handle negative numbers
                        while (temp > 0) {
                            count++;
                            temp /= 10;
                        }
                    }
                    System.out.println("Number of digits: " + count);
                    break;

                case 3:
                    System.out.print("Enter three numbers: ");
                    int num1 = scanner.nextInt();
                    int num2 = scanner.nextInt();
                    int num3 = scanner.nextInt();
                    if (num1 == num2 && num2 == num3) {
                        System.out.println("All numbers are equal");
                    } else if (num1 != num2 && num2 != num3 && num1 != num3) {
                        System.out.println("All numbers are different");
                    } else {
                        System.out.println("Neither all are equal or different");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }

            System.out.println(); // For better readability

        } while (choice != 4);

        scanner.close();
    }
}
