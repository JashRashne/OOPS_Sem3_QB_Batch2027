import java.util.Scanner;

class IncorrectAnswerException extends Exception {
    public IncorrectAnswerException(String message) {
        super(message);
    }
}

public class PrimeMinisterQuiz {
    private static final String CORRECT_ANSWER = "Narendra Modi";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        
        while (attempts < 3) {
            System.out.println("Who is the Prime Minister of India?");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(CORRECT_ANSWER)) {
                System.out.println("Excellent");
                break;
            } else {
                attempts++;
                if (attempts < 3) {
                    try {
                        throw new IncorrectAnswerException("Try again");
                    } catch (IncorrectAnswerException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("The correct answer is: " + CORRECT_ANSWER);
                }
            }
        }

        scanner.close();
    }
}
