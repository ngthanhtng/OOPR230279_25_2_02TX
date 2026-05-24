package model;

import utils.ValidationHelper;

import java.time.LocalDate;

public class BorrowSlip {

    private String slipId;
    private Reader reader;
    private Book book;

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private boolean returned;
    // Static
    private static int counter = 0;
    private static int totalSlips = 0;

    public BorrowSlip(Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        counter++;
        this.slipId = String.format("S%03d", counter);
        this.reader = reader;
        this.book = book;

        this.borrowDate = borrowDate;
        this.dueDate = dueDate;

        this.returned = false;
        totalSlips++;
    }

    public String getSlipId() {
        return slipId;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
        returned = true;
    }

    public boolean isOverdue(LocalDate currentDate) {
        return !returned && currentDate.isBefore(dueDate);
    }

    public void displayInfo() {
        System.out.println(
                "Slip ID: " + slipId +
                " | Reader: " + reader.getFullName() +
                " | Book: " + book.getTitle() +
                " | Borrow Date: " + borrowDate.format(ValidationHelper.DATE_FORMAT) +
                " | Due Date: " + dueDate.format(ValidationHelper.DATE_FORMAT) +
                " | Returned: " + returned
        );
    }
}