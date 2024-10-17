import java.util.Scanner;

// Define the exam interface
interface Exam {
    boolean pass(int marks);
}

// Define the classify interface
interface Classify {
    String division(int average);
}

// Implement both interfaces in the result class
class Result implements Exam, Classify {
    
    // Method to check if the marks are passing
    @Override
    public boolean pass(int marks) {
        return marks > 40;
    }
    
    // Method to classify the division based on average marks
    @Override
    public String division(int average) {
        if (average >= 60) {
            return "First";
        } else if (average >= 50) {
            return "Second";
        } else if (average >= 40) {
            return "Third";
        } else {
            return "Pass";
        }
    }
    
    // Method to calculate average and check results
    public void calculateResult() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter marks for Subject 1: ");
        int subject1 = sc.nextInt();
        System.out.print("Enter marks for Subject 2: ");
        int subject2 = sc.nextInt();
        System.out.print("Enter marks for Subject 3: ");
        int subject3 = sc.nextInt();
        
        // Calculate average
        int totalMarks = subject1 + subject2 + subject3;
        int average = totalMarks / 3;

        // Check pass or fail
        boolean sub1Pass = pass(subject1);
        boolean sub2Pass = pass(subject2);
        boolean sub3Pass = pass(subject3);
        
        // Get division
        String divisionResult = division(average);
        
        // Output the results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + average);
        System.out.println("Passed in Sub 1: " + (sub1Pass ? "Yes" : "No"));
        System.out.println("Passedin Sub 2: " + (sub2Pass ? "Yes" : "No"));
        System.out.println("Passed in Sub 3: " + (sub3Pass ? "Yes" : "No"));
        System.out.println("Division: " + divisionResult);
    }
    
    public static void main(String[] args) {
        Result result = new Result();
        result.calculateResult();
    }
}
