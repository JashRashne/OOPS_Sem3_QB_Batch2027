class Book {
    private String author;
    private String title;
    private double price;
    private String publisher;
    private int stock;

    // Constructor
    public Book(String author, String title, double price, String publisher, int stock) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.publisher = publisher;
        this.stock = stock;
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getStock() {
        return stock;
    }

    // Method to update stock
    public void reduceStock(int quantity) {
        stock -= quantity;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Publisher: " + publisher);
        System.out.println("Available Stock: " + stock);
    }
}
