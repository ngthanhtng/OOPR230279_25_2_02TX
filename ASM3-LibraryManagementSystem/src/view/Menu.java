package view;

import model.Book;
import model.BorrowSlip;
import model.Reader;
import model.ReaderType;
import service.Librarian;
import service.Library;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private Library library;
    private Librarian librarian;
    private Scanner scanner;

    public Menu(Library library, Librarian librarian) {
        this.library = library;
        this.librarian = librarian;

        scanner = new Scanner(System.in);

        // AUTO LOAD SAMPLE DATA
        addSampleData();
    }

    private void addSampleData() {
        // ================= BOOKS =================
        library.addBook(
                new Book(
                        "Dac Nhan Tam",
                        "Dale Carnegie",
                        2019,
                        5
                )
        );

        library.addBook(
                new Book(
                        "Lap Trinh Java Co Ban",
                        "Nguyen Van Long",
                        2021,
                        4
                )
        );

        library.addBook(
                new Book(
                        "Toi Tai Gioi Ban Cung The",
                        "Adam Khoo",
                        2018,
                        6
                )
        );

        library.addBook(
                new Book(
                        "Cho Toi Xin Mot Ve Di Tuoi Tho",
                        "Nguyen Nhat Anh",
                        2008,
                        3
                )
        );

        library.addBook(
                new Book(
                        "Clean Code",
                        "Robert C. Martin",
                        2020,
                        2
                )
        );

        library.addBook(
                new Book(
                        "Ky Nang Giao Tiep",
                        "Le Tham Duong",
                        2022,
                        5
                )
        );

        // ================= READERS =================
        library.addReader(
                new Reader(
                        "Nguyen Van An",
                        "an@gmail.com",
                        ReaderType.STUDENT
                )
        );

        library.addReader(
                new Reader(
                        "Tran Thi Mai",
                        "mai@gmail.com",
                        ReaderType.STUDENT
                )
        );

        library.addReader(
                new Reader(
                        "Le Hoang Nam",
                        "nam@gmail.com",
                        ReaderType.LECTURER
                )
        );

        library.addReader(
                new Reader(
                        "Pham Thu Ha",
                        "ha@gmail.com",
                        ReaderType.LECTURER
                )
        );

        library.addReader(
                new Reader(
                        "Vo Minh Quan",
                        "quan@gmail.com",
                        ReaderType.STUDENT
                )
        );

        // ================= SLIPS =================
        librarian.borrowBook(
                        library,
                        library.findReaderById("r001"),
                        library.findBookById("b001"),
                        7
        );

        librarian.borrowBook(
                        library,
                        library.findReaderById("r003"),
                        library.findBookById("b002"),
                        14
        );

        librarian.borrowBook(
                        library,
                        library.findReaderById("r003"),
                        library.findBookById("b005"),
                        14
        );

        librarian.borrowBook(
                        library,
                        library.findReaderById("r005"),
                        library.findBookById("b002"),
                        4
        );

        System.out.println(
                "Sample data added successfully!"
        );
    }

    public void start() {
        int choice;
        do {
            showMenu();

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addReader();
                    break;
                case 3:
                    library.showAllBooks();
                    break;
                case 4:
                    library.showAllReaders();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    searchBook();
                    break;
                case 8:
                    library.showAllSlips();
                    break;
                case 9:
                    showOverdueSlips();
                    break;
                case 10:
                    library.mostBorrowedBook();
                    library.topReader();
                    break;
                case 0:
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // ================= MENU =================
    private void showMenu() {
        System.out.println("\n===== LIBRARY MANAGEMENT =====");

        System.out.println("1. Add Book");
        System.out.println("2. Add Reader");

        System.out.println("3. Show All Books");
        System.out.println("4. Show All Readers");

        System.out.println("5. Borrow Book");
        System.out.println("6. Return Book");

        System.out.println("7. Search Book");

        System.out.println("8. Show Borrow Slips");

        System.out.println("9. Show Overdue Slips");

        System.out.println("10. Statistics");

        System.out.println("0. Exit");
    }

    // ================= ADD BOOK =================
    private void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Publish Year: ");
        int year =
                Integer.parseInt(scanner.nextLine());

        System.out.print("Quantity: ");
        int quantity =
                Integer.parseInt(scanner.nextLine());

        Book book = new Book( title, author, year, quantity);

        library.addBook(book);

        System.out.println(
                "Book added successfully!"
        );
    }

    // ================= ADD READER =================
    private void addReader() {
        System.out.print("Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("1. STUDENT");
        System.out.println("2. LECTURER");

        int typeChoice =
                Integer.parseInt(scanner.nextLine());

        ReaderType type;

        if (typeChoice == 1) {

            type = ReaderType.STUDENT;

        } else {

            type = ReaderType.LECTURER;
        }

        Reader reader = new Reader(name, email, type);

        library.addReader(reader);

        System.out.println("Reader added successfully!");
    }

    // ================= BORROW =================
    private void borrowBook() {
        System.out.print("Reader ID: ");
        String readerId = scanner.nextLine();

        Reader reader = library.findReaderById(readerId);

        if (reader == null) {
            System.out.println("Reader not found!");
            return;
        }

        System.out.print("Book ID: ");
        String bookId = scanner.nextLine();

        Book book = library.findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        System.out.print("Borrow duration (days): ");
        int borrowDuration = Integer.parseInt(scanner.nextLine());

        if (borrowDuration <= 0) {
            System.out.println("Borrow duration must be greater than zero!");
            return;
        }

        librarian.borrowBook(library, reader, book, borrowDuration);
    }

    // ================= RETURN =================
    private void returnBook() {
        System.out.print("Slip ID: ");
        String slipId = scanner.nextLine();

        BorrowSlip slip = library.findSlipById(slipId);

        if (slip == null) {
            System.out.println("Slip not found!");
            return;
        }

        System.out.print("Return day (yyyy-MM-dd): ");
        LocalDate returnDate = LocalDate.parse(scanner.nextLine());

        librarian.returnBook(slip, returnDate);
    }

    // ================= SEARCH =================
    private void searchBook() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        library.searchBook(keyword);
    }

    // ================= OVERDUE =================
    private void showOverdueSlips() {
        System.out.print("Enter current year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter current month: ");
        int month = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter current day: ");
        int day = Integer.parseInt(scanner.nextLine());

        LocalDate currentDate = LocalDate.of(year, month, day);

        library.showOverdueSlips(currentDate);
    }
}