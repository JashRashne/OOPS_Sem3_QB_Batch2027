import java.util.Scanner;

public class SimpleSortAndCount {

    // Method to sort the letters of a word
    private static String sortWord(String word) {
        char[] chars = word.toCharArray();
        
        // Bubble sort to sort characters
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - 1 - i; j++) {
                if (chars[j] > chars[j + 1]) {
                    // Swap characters
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return new String(chars);
    }
    
    // Method to count vowels and consonants
    private static void countVowelsAndConsonants(String sentence) {
        int vowels = 0;
        int consonants = 0;
        
        for (char ch : sentence.toCharArray()) {
            if (Character.isLetter(ch)) {
                char lowerChar = Character.toLowerCase(ch);
                if ("aeiou".indexOf(lowerChar) >= 0) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input from the user
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        
        // Split the input into words and sort each word
        String[] words = input.split(" ");
        StringBuilder sortedSentence = new StringBuilder();
        
        for (String word : words) {
            sortedSentence.append(sortWord(word)).append(" ");
        }
        
        // Display the sorted sentence
        System.out.println("Sorted version of string: " + sortedSentence.toString().trim());
        
        // Count and display vowels and consonants
        countVowelsAndConsonants(input);
        
        scanner.close();
    }
}
