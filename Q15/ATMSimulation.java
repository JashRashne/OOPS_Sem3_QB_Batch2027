import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class ATMSimulation {
    private double balance;

    public ATMSimulation(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Current balance: $" + balance);
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMSimulation atm = new ATMSimulation(1000.00); // Initial balance

        while (true) {
            System.out.println("\nATM Operations:");
            System.out.println("1) Withdrawal of amount");
            System.out.println("2) Deposit of amount");
            System.out.println("3) Statement of balance");
            System.out.println("4) Exit");
            System.out.print("Select an operation: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    try {
                        atm.withdraw(withdrawalAmount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.displayBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
