

public class SumEvenNumbers {
    static class OddNumberException extends Exception {
        public OddNumberException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        int sum = 0;

        for (String arg : args) {
            try {
                int number = Integer.parseInt(arg);
                
                // Check for termination condition
                if (number == 0) {
                    break;
                }

                // Check if the number is odd
                if (number % 2 != 0) {
                    throw new OddNumberException("Odd Number: " + number);
                }

                // Add to sum if the number is even
                sum += number;

            } catch (OddNumberException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + arg + ". Please enter valid integers.");
            }
        }

        System.out.println("Sum of all even numbers: " + sum);
    }

}