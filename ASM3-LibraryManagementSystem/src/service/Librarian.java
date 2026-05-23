package service;

import model.Book;
import model.BorrowSlip;
import model.Reader;
import utils.FineCalculator;

import java.time.LocalDate;

public class Librarian {

    public boolean borrowBook(Library library, Reader reader, Book book, int borrowDuration) {
        // Kiểm tra tồn kho
        if (!book.isAvailable()) {
            System.out.println("Book out of stock!");
            return false;
        }

        if (reader.getCurrentBorrowCount() >= reader.getMaxBorrowLimit()) {
            System.out.println("Borrow limit exceeded!");
            return false;
        }

        // Mượn thành công
        book.borrowBook();
        reader.increaseBorrowCount();

        BorrowSlip slip = new BorrowSlip( reader, book, LocalDate.now(),
                LocalDate.now().plusDays(borrowDuration));
        library.addSlip(slip);

        System.out.println("Borrow successful!");
        return true;
    }

    public void returnBook(BorrowSlip slip, LocalDate returnDate) {
        // Tránh trả nhiều lần
        if (slip.isReturned()) {
            System.out.println( "Book already returned!");
            return;
        }

        // Cộng kho
        slip.getBook().returnBook();
        slip.getReader().decreaseBorrowCount();

        // Cập nhật phiếu
        slip.returnBook(returnDate);

        // Tính tiền phạt
        long fine = FineCalculator.calculateFine(slip);

        if (fine > 0) {
            System.out.println("Late return!");
            System.out.println("Fine: " + fine + " VND");

        } else {
            System.out.println("Returned on time!");
        }
    }
}