import java.util.Scanner;

class Telephone {
    String name;
    String phoneno;
    int pincode;

    // Constructor
    public Telephone(String name, String phoneno, int pincode) {
        this.name = name;
        this.phoneno = phoneno;
        this.pincode = pincode;
    }
}

public class TelephoneDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Telephone[] telephoneList = new Telephone[5];

        // Input for 5 Telephone objects
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter name for Telephone " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter phone number for Telephone " + (i + 1) + ": ");
            String phoneno = scanner.nextLine();
            System.out.print("Enter pincode for Telephone " + (i + 1) + ": ");
            int pincode = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            telephoneList[i] = new Telephone(name, phoneno, pincode);
        }

        // Sort the telephone list based on pincode
        for (int i = 0; i < telephoneList.length - 1; i++) {
            for (int j = 0; j < telephoneList.length - 1 - i; j++) {
                if (telephoneList[j].pincode > telephoneList[j + 1].pincode) {
                    Telephone temp = telephoneList[j];
                    telephoneList[j] = telephoneList[j + 1];
                    telephoneList[j + 1] = temp;
                }
            }
        }

        // Display sorted Telephone objects in a tabular format
        System.out.printf("%-20s %-15s %-10s%n", "Name", "Phone No", "Pincode");
        System.out.println("------------------------------------------");
        for (Telephone telephone : telephoneList) {
            System.out.printf("%-20s %-15s %-10d%n", telephone.name, telephone.phoneno, telephone.pincode);
        }

        scanner.close();
    }
}
