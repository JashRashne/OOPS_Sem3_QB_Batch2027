import java.util.Scanner;

public class RemoveExtraSpacesAndCountVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the string
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        // Remove extra spaces
        String trimmedString = removeExtraSpaces(input);

        // Count vowels
        int vowelCount = countVowels(trimmedString);

        // Output the results
        System.out.println("Output (without extra spaces): " + trimmedString);
        System.out.println("Number of vowels: " + vowelCount);
        
        scanner.close();
    }

    // Method to remove extra spaces
    private static String removeExtraSpaces(String str) {
        // Trim the string and replace multiple spaces with a single space
        return str.trim().replaceAll("\\s+", " ");
    }

    // Method to count vowels
    private static int countVowels(String str) {
        int count = 0;
        String vowels = "AEIOUaeiou"; // Include both uppercase and lowercase vowels
        for (char ch : str.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}
