import java.util.Scanner;

public class CamelCaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accepting the sentence from the user
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        // Converting to camel case
        String camelCaseOutput = toCamelCase(input);

        // Displaying the result
        System.out.println("Output: " + camelCaseOutput);
    }

    private static String toCamelCase(String sentence) {
        // Splitting the sentence into words
        String[] words = sentence.split(" ");
        StringBuilder camelCaseSentence = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                // Capitalizing the first letter and appending the rest of the word
                camelCaseSentence.append(Character.toUpperCase(word.charAt(0)));
                camelCaseSentence.append(word.substring(1).toLowerCase());
                camelCaseSentence.append(" ");
            }
        }

        // Removing the trailing space and returning the result
        return camelCaseSentence.toString().trim();
    }
}
