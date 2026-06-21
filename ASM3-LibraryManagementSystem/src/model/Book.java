package model;

import interfaces.Borrowable;

public class Book implements Borrowable {

    private String bookId;
    private String title;
    private String author;
    private int publishYear;
    private int quantity;
    private boolean referenceOnly;
    private String currentBorrowerId; // null neu chua ai muon
    private String borrowDate;

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
        this.currentBorrowerId = null;

        this.currentBorrowCount = 0;
        totalBooks++;
    }

    public Book(String title, String author, int publishYear, int quantity, boolean referenceOnly) {
        this(title, author, publishYear, quantity);
        this.referenceOnly = referenceOnly;
    }

    public Book(String title, String author) {
        this(title, author, 2000, 1);
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

    @Override
    public void borrowBy(String readerId, String date) {
        if (!isAvailable()) {
            System.out.println("Book '" + title + "' is not available.");
            return;
        }
        this.currentBorrowerId = readerId;
        this.borrowDate        = date;
        System.out.println("Book '" + title + "' borrowed by " + readerId);
    }

    @Override
    public void returnBook(String date) {
        System.out.println("Book '" + title + "' returned on " + date);
        this.currentBorrowerId = null;
        this.borrowDate        = null;
    }

    @Override
    public boolean isAvailable() {
        return quantity > 0;
    }

    @Override
    public String getBorrowerId() {
        return currentBorrowerId;
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

    @Override
    public String toString() {
        return
                        "ID: " + bookId +
                        " | Title: " + title +
                        " | Author: " + author +
                        " | Year: " + publishYear +
                        " | Quantity: " + quantity +
                        " | Borrowed: " + currentBorrowCount +
                        " | Is Reference Only: " + referenceOnly;
    }
}