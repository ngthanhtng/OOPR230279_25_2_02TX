public class Book {
    String title;
    String author;
    int year;
    double price;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        year = 2000;
        price = 0;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        year = 2026;
        price = 100000;
    }

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public void displayInfo() {
        System.out.printf("Sách: %s - Tác giả: %s - Năm: %d - Giá: %.2f%n", title, author, year, price);
    }

    public void applyDiscount(double percent) {
        price = price * (1 - percent / 100);
    }
}
