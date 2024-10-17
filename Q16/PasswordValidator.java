import java.util.Scanner;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        // Check if password length is at least 10 characters
        if (password.length() < 10) {
            return false;
        }

        // Check if first character is an uppercase letter
        if (!Character.isUpperCase(password.charAt(0))) {
            return false;
        }

        // Check for only letters and digits and count digits
        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return false; // Invalid character found
            }
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        // Check if there are at least 2 digits
        return digitCount >= 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to validate: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password is invalid.");
        }

        scanner.close();
    }
}
