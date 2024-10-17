import java.util.ArrayList;

public class Bookshop {
    private ArrayList<Book> inventory;

    public Bookshop() {
        inventory = new ArrayList<>();
        inventory.add(new Book("George Orwell", "1984", 15.99, "Secker & Warburg", 10));
        inventory.add(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 10.99, "Bloomsbury", 5));
        inventory.add(new Book("J.R.R. Tolkien", "The Hobbit", 12.99, "George Allen & Unwin", 3));
    }

    public void searchBook(String title, String author, int quantity) throws Exception {
        for (Book book : inventory) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                book.displayDetails();
                if (book.getStock() >= quantity) {
                    double totalCost = quantity * book.getPrice();
                    System.out.println("Total cost for " + quantity + " copies: $" + totalCost);
                    book.reduceStock(quantity);
                } else {
                    System.out.println("Required copies not in stock");
                }
                return;
            }
        }
        throw new Exception("Book not found in inventory.");
    }
}
