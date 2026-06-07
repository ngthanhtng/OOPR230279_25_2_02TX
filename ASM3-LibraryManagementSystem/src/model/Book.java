package model;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private int publishYear;
    private int quantity;
    private boolean referenceOnly;

    // Số lượng sách được mượn hiện tại
    private int currentBorrowCount;
    // Static
    private static int counter = 0;
    private static int totalBooks = 0;

    public Book(String title, String author, int publishYear, int quantity) {
        counter++;
        this.bookId = String.format("B%03d", counter);
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.referenceOnly = false;

        this.currentBorrowCount = 0;
        totalBooks++;
    }

    public Book(String title, String author, int publishYear, int quantity, boolean referenceOnly) {
        counter++;
        this.bookId = String.format("B%03d", counter);
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.referenceOnly = referenceOnly;

        this.currentBorrowCount = 0;
        totalBooks++;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCurrentBorrowCount() {
        return currentBorrowCount;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public boolean isReferenceOnly() {
        return referenceOnly;
    }

    public void borrowBook() {
        quantity--;
        currentBorrowCount++;
    }

    public void returnBook() {
        quantity++;
        currentBorrowCount--;
    }

    public void displayInfo() {
        System.out.println(
                        "ID: " + bookId +
                        " | Title: " + title +
                        " | Author: " + author +
                        " | Year: " + publishYear +
                        " | Quantity: " + quantity +
                        " | Borrowed: " + currentBorrowCount +
                        " | Is Reference Only: " + referenceOnly
        );
    }
}