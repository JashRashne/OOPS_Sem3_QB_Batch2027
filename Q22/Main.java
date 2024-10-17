import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookshop bookshop = new Bookshop();

        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author's name: ");
        String author = scanner.nextLine();
        System.out.print("Enter the number of copies required: ");
        int quantity = scanner.nextInt();

        try {
            bookshop.searchBook(title, author, quantity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
