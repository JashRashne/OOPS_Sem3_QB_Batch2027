import java.util.Scanner;

// Custom exception class
class NotPalindromeException extends Exception {
    public NotPalindromeException(String message) {
        super(message);
    }
}

public class PalindromeChecker {

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        try {
            if (!isPalindrome(input)) {
                throw new NotPalindromeException("String is not a Palindrome");
            }
            System.out.println("The string is a Palindrome.");
        } catch (NotPalindromeException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
