package service;

import model.Book;
import model.BorrowSlip;
import model.Reader;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Reader> readers = new ArrayList<>();
    private ArrayList<BorrowSlip> slips = new ArrayList<>();

    // ================= ADD =================
    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void addSlip(BorrowSlip slip) {
        slips.add(slip);
    }

    // ================= FIND =================
    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getBookId().equalsIgnoreCase(id)) {
                return b;
            }
        }

        return null;
    }

    public Reader findReaderById(String id) {
        for (Reader r : readers) {
            if (r.getReaderId().equalsIgnoreCase(id)) {
                return r;
            }
        }

        return null;
    }

    public BorrowSlip findSlipById(String id) {
        for (BorrowSlip s : slips) {
            if (s.getSlipId().equalsIgnoreCase(id)) {
                return s;
            }
        }

        return null;
    }

    // ================= SHOW =================
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books!");
            return;
        }

        for (Book b : books) {
            b.displayInfo();
        }
    }

    public void showAllReaders() {
        if (readers.isEmpty()) {
            System.out.println("No readers!");
            return;
        }

        for (Reader r : readers) {
            System.out.println(r.toString());
        }
    }

    public void showAllSlips() {
        if (slips.isEmpty()) {
            System.out.println("No borrow slips!");
            return;
        }

        for (BorrowSlip s : slips) {
            s.displayInfo();
        }
    }

    // ================= SEARCH =================
    public void searchBook(String keyword) {
        boolean found = false;

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                b.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found!");
        }
    }

    // ================= OVERDUE =================
    public void showOverdueSlips(LocalDate currentDate) {
        boolean found = false;

        for (BorrowSlip s : slips) {
            if (s.isOverdue(currentDate)) {
                s.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No overdue slips!");
        }
    }

    // ================= STATISTICS =================
    public void mostBorrowedBook() {
        if (slips.isEmpty()) {
            System.out.println("No borrow data!");
            return;
        }

        Book mostBook = null;
        int maxCount = 0;

        for (Book b : books) {
            int count = 0;
            for (BorrowSlip s : slips) {
                if (s.getBook().equals(b)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostBook = b;
            }
        }

        if (mostBook != null) {
            System.out.println("\nMost Borrowed Book:");
            mostBook.displayInfo();
            System.out.println("Total Borrows: " + maxCount);
        }
    }

    public void topReader() {
        if (slips.isEmpty()) {
            System.out.println("No borrow data!");
            return;
        }

        Reader topReader = null;
        int maxCount = 0;

        for (Reader r : readers) {
            int count = 0;
            for (BorrowSlip s : slips) {
                if (s.getReader().equals(r)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                topReader = r;
            }
        }

        if (topReader != null) {
            System.out.println("\nTop Reader:");
            System.out.println(topReader.toString());
            System.out.println("Total Borrows: " + maxCount);
        }
    }
}