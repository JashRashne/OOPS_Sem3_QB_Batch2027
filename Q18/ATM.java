import java.util.Scanner;

class ATM {
    private double balance;

    public ATM() {
        this.balance = 0.0; // Initial balance
    }

    public void deposit(double amount) throws Exception {
        if (amount > 100000) {
            throw new Exception("Deposit amount exceeds the limit of 100,000 RS.");
        }
        balance += amount;
        System.out.println("Successfully deposited: " + amount + " RS.");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount + " RS.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance + " RS.");
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an operation:");
            System.out.println("1) Withdrawal of amount");
            System.out.println("2) Deposit of amount");
            System.out.println("3) Statement of balance");
            System.out.println("4) Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        atm.deposit(depositAmount);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
