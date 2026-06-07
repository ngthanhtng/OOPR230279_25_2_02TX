package service;

import model.Book;
import model.BorrowResult;
import model.BorrowSlip;
import model.Reader;
import utils.FineCalculator;

import java.time.LocalDate;

public class Librarian {

    private String employeeId;
    private String fullName;
    private String phone;
    private String shift;

    private Library library;

    public Librarian(String employeeId, String fullName, String phone, String shift, Library library) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.phone = phone;
        this.shift = shift;
        this.library = library;
    }

    /*
     * ASM07
     * Thủ thư xử lý cho mượn qua Template Method
     */
    public void processLoan(Reader reader, Book book, int borrowDuration) {
        System.out.println("[Librarian " + fullName + "] Processing...");

        BorrowResult result = reader.processBorrow(book);

        System.out.println(result.getMessage());

        if (result.isSuccess()) {
            BorrowSlip slip =
                    new BorrowSlip(
                            reader,
                            book,
                            LocalDate.now(),
                            LocalDate.now().plusDays(borrowDuration)
                    );

            library.addSlip(slip);
        }
    }

    /*
     * Giữ lại logic trả sách cũ
     */
    public void processReturn(BorrowSlip slip, LocalDate returnDate) {
        if (slip.isReturned()) {
            System.out.println("Book already returned!");
            return;
        }

        slip.getBook().returnBook();
        slip.getReader().decreaseBorrowCount();

        slip.returnBook(returnDate);

        double fine = FineCalculator.calculateFine(slip);

        if (fine > 0) {
            System.out.println("Late return!");
            System.out.println("Fine: " + fine + " VND");
        } else {
            System.out.println("Returned on time!");
        }
    }
}

