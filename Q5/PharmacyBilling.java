import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Medicine {
    String name;
    double rate;
    int quantity;

    Medicine(String name, double rate, int quantity) {
        this.name = name;
        this.rate = rate;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return rate * quantity;
    }
}

public class PharmacyBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Medicine> medicines = new ArrayList<>();
        String choice;

        do {
            System.out.print("Enter medicine name: ");
            String name = scanner.nextLine();

            System.out.print("Enter medicine rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            medicines.add(new Medicine(name, rate, quantity));

            System.out.print("Do you want to add another medicine? (yes/no): ");
            choice = scanner.nextLine();

        } while (choice.equalsIgnoreCase("yes"));

        double totalAmount = 0;

        System.out.printf("%-3s %-15s %-5s %-8s %-8s%n", "No.", "Name", "Rate", "Quantity", "Rupees");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < medicines.size(); i++) {
            Medicine medicine = medicines.get(i);
            double medicineTotal = medicine.getTotalPrice();
            totalAmount += medicineTotal;

            System.out.printf("%-3d %-15s %-5.2f %-8d %-8.2f%n", (i + 1), medicine.name, medicine.rate, medicine.quantity, medicineTotal);
        }

        System.out.printf("Total : %.2f%n", totalAmount);
        scanner.close();
    }
}
