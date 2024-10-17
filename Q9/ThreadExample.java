import java.util.Scanner;

class AdditionThread extends Thread {
    private int n;

    public AdditionThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of numbers from 1 to " + n + " is: " + sum);
        try {
            Thread.sleep(10000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted");
        }
    }
}

class EvenNumbersRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("First 10 even numbers:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(2 * i);
        }
        try {
            Thread.sleep(10000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted");
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number n: ");
        int n = scanner.nextInt();
        
        // Create and start the addition thread
        AdditionThread additionThread = new AdditionThread(n);
        additionThread.setPriority(5); // Set priority to 5
        additionThread.start();

        // Create and start the even numbers thread
        Thread evenNumbersThread = new Thread(new EvenNumbersRunnable());
        evenNumbersThread.setPriority(7); // Set priority to 7
        evenNumbersThread.start();

        try {
            // Wait for both threads to finish
            additionThread.join();
            evenNumbersThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted");
        }

        System.out.println("Both threads have completed execution.");
        scanner.close();
    }
}

