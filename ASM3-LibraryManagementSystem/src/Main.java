import interfaces.Borrowable;
import interfaces.Fineable;
import interfaces.Notifiable;
import model.*;
import service.Librarian;
import service.Library;
import service.LibraryManager;
import utils.GenericStack;
import utils.LibraryUtils;
import utils.Pair;
import view.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Khởi tạo
        Library library = new Library();
        Librarian librarian = new Librarian(
                "TT01",
                "Le Thi Duyen",
                "0904",
                "Morning",
                library);

        Menu menu = new Menu(library, librarian);

        //region ASM 5 + nâng cao
        System.out.println();
        System.out.println("===========================");
        System.out.println("********** ASM 5 **********");
        System.out.println("===========================");
        library.showLateFees(7);

        /*
        Câu hỏi 1.1: Nên tạo một lớp cha trung gian DigitalAccount không? Hay để cả 4 lớp phẳng?
            Nên. Nếu không tạo thì 4 lớp (StudentAccount, LecturerAccount, GuestAccount, LibraryCard)
            sẽ bị lặp lại: accountId, displayName, authenticate(), getDownloadLimit(), requestDownload()
            => vi phạm DRY.
        Câu hỏi 1.2: Lớp nào nên là abstract class, lớp nào là concrete class?
            Abstract cho DigitalAccount vì không tồn tại "tài khoản số chung chung".
            Concrete cho StudentAccount, LecturerAccount, GuestAccount, LibraryCard vì có thể tạo object.
        Câu hỏi 1.3: Phương thức authenticate() và getDownloadLimit() nên là abstract hay có cài đặt mặc định?
            Nên là abstract. Lý do, mỗi loại đều có cách xác thực khác nhau:
                StudentAccount	Password
                LecturerAccount	OTP
                GuestAccount	Không cần
                LibraryCard     RFID
            Không thể có implementation mặc định hợp lý.
        Câu hỏi 1.4: Tại sao GuestAccount và LibraryCard KHÔNG NÊN kế thừa từ Reader?
            Reader là: Người mượn sách thư viện
            GuestAccount là: Tài khoản tải ebook
            LibraryCard là: Thẻ RFID

            Không thể tồn tại quan hệ: GuestAccount IS-A Reader? => vì điều này là sai.
            Tương tự: LibraryCard IS-A Reader? Sai.

            Đúng hơn là: GuestAccount HAS-A Reader hoặc LibraryCard HAS-A Reader
                => (chứa hoặc liên kết với độc giả).
        */
        DigitalAccount student =
                new StudentAccount(
                        "A001",
                        "An",
                        "123456"
                );

        DigitalAccount lecturer =
                new LecturerAccount(
                        "A002",
                        "Nam",
                        "917323"
                );

        DigitalAccount guest =
                new GuestAccount(
                        "A003",
                        "Thuong"
                );

        student.requestDownload(1);
        student.requestDownload(3);

        lecturer.requestDownload(100);

        guest.requestDownload(0);
        guest.requestDownload(2);
        /*
         * DESIGN RATIONALE
         *
         * 1. DigitalAccount là abstract class vì không tồn tại
         *    tài khoản số chung chung, chỉ có các loại cụ thể.
         *
         * 2. GuestAccount và LibraryCard không kế thừa Reader
         *    vì chúng không phải là Reader (không thỏa quan hệ IS-A).
         *    Thay vào đó, chúng có thể liên kết với Reader thông qua
         *    quan hệ HAS-A (composition/association).
         *
         * 3. Lợi thế thiết kế hiện tại:
         *    - Tận dụng đa hình thông qua DigitalAccount.
         *    - Dễ mở rộng thêm loại tài khoản mới mà không sửa code cũ.
         *    - Giảm trùng lặp code nhờ kế thừa từ lớp cha abstract.
         *
         *    Rủi ro / hạn chế cần cải thiện:
         *    - authenticate(String credential) chưa linh hoạt vì
         *      các loại tài khoản sử dụng cơ chế xác thực khác nhau
         *      (email + password, email + OTP, RFID,...).
         *    - Chưa có cơ chế bảo mật và quản lý số lần tải thực tế.
         */
        //endregion

        //region ASM 6 + nâng cao
        System.out.println();
        System.out.println("===========================");
        System.out.println("********** ASM 6 **********");
        System.out.println("===========================");
        library.addReader(
                new SeniorReader(
                        "Truong Minh Nhat",
                        "nhat@gmail.com",
                        "CC2024001"
                )
        );

        library.showAllReaders();
        System.out.printf("Total fee over 5 days: %.0f VND%n", library.calculateTotalLateFee(5));

        Reader found = library.findReaderByName("Nhat");
        if (found != null) {
            System.out.println(found.getInfo());
        }

        library.printSeniorReaders();

        ArrayList<CardHolder> holders = new ArrayList<>();
        for (Reader reader : library.getReaders()) {
            if (reader instanceof CardHolder) {
                holders.add((CardHolder) reader);
            }
        }

        library.renewAllCardHolders(holders, 1);

        Library.printFeeReport(library.getReaders(), 5);
        //endregion

        //region ASM 7 + nâng cao
        System.out.println();
        System.out.println("===========================");
        System.out.println("********** ASM 7 **********");
        System.out.println("===========================");
        System.out.println("=== Thang binh thuong ===");
        library.calculateTotalLateFee(7);

        System.out.println("=== Thang tu thien ===");
        library.setFeePolicy(new CharityFeePolicy());
        library.calculateTotalLateFee(7);

        System.out.println("=== Thang khai truong ===");
        library.setFeePolicy(new WaivedFeePolicy());
        library.calculateTotalLateFee(7);

        // Compile Error:
        // library.addReader(librarian); // Librarian không phải Reader.
        // Thiết kế mới an toàn hơn.
        //endregion

        //region ASM C5-D1
        System.out.println();
        System.out.println("===============================");
        System.out.println("********** ASM C5-D1 **********");
        System.out.println("===============================");
        Borrowable book1 = library.findBookById("B001");
        Borrowable book2 = library.findBookById("B005");

        book1.borrowBy("R001", "2026-06-18");
        book2.borrowBy("R004", "2026-06-20");
        System.out.println("Available: " + book2.isAvailable()); // true

        // Dung static method cua interface
        System.out.println(Borrowable.isValidBorrowDuration(10)); // true
        System.out.println(Borrowable.isValidBorrowDuration(20)); // false

        // Dung default method
        System.out.println(book1.calculateFine(3)); // 15000.0

        book1.returnBook("2024-09-15");

        System.out.println();
        Fine fine = new Fine(5000, 7, false);

        System.out.println("Fine/day: " + fine.getFinePerDay());
        System.out.println("Late days: " + fine.getLateDays());
        System.out.println("Total fine: " + fine.calculateTotalFine());

        System.out.println(
                Fineable.isValidFine(fine.getFinePerDay())
        );

        System.out.println();
        LibraryManager manager = new LibraryManager();

        ArrayList<Borrowable> borrowables = new ArrayList<>();
        borrowables.add(book1);
        borrowables.add(book2);

        manager.processAllBorrowable(borrowables);

        ArrayList<Notifiable> users = new ArrayList<>();
        users.add(library.findReaderById("R001"));
        users.add(library.findReaderById("R002"));

        manager.notifyAll(users, "Library will be closed tomorrow.");
        //endregion

        //region ASM C5-D2
        System.out.println();
        System.out.println("===============================");
        System.out.println("********** ASM C5-D2 **********");
        System.out.println("===============================");
        // ================= String Stack =================
        GenericStack<String> history = new GenericStack<>();

        history.push("Muon sach B001");
        history.push("Tra sach B002");
        history.push("Cap nhat doc gia R001");

        System.out.println("Top element: " + history.peek());

        System.out.println("Pop: " + history.pop());
        System.out.println("Pop: " + history.pop());

        System.out.println("Current size: " + history.size());

        // ================= Integer Stack =================
        GenericStack<Integer> errorCodes = new GenericStack<>();

        errorCodes.push(100);
        errorCodes.push(200);
        errorCodes.push(404);

        System.out.println("\nError codes in stack:");

        while (!errorCodes.isEmpty()) {
            System.out.println(errorCodes.pop());
        }

        System.out.println();
        // ================= Pair<String, Integer> =================
        Pair<String, Integer> pBook1 = new Pair<>("B001", 15);
        Pair<String, Integer> pBook2 = new Pair<>("B002", 8);

        System.out.println(pBook1);
        System.out.println(pBook2);

        int result = Pair.comparePairs(pBook1, pBook2);

        if (result > 0) {
            System.out.println(pBook1.getKey() + " has more borrows.");
        } else if (result < 0) {
            System.out.println(pBook2.getKey() + " has more borrows.");
        } else {
            System.out.println("Both books have the same borrow count.");
        }

        // ================= Pair<String, String> =================
        Pair<String, String> reader = new Pair<>("Nguyen Van An", "R001");

        System.out.println("\nOriginal Pair:");
        System.out.println(reader);

        Pair<String, String> swapped = Pair.swap(reader);

        System.out.println("After swap:");
        System.out.println(swapped);

        Integer[] numbers = {
                library.findBookById("b001").getQuantity(),
                library.findBookById("b002").getQuantity(),
                library.findBookById("b003").getQuantity(),
                library.findBookById("b004").getQuantity(),
                library.findBookById("b005").getQuantity()
        };
        System.out.println("Min = " + LibraryUtils.findMin(numbers));

        System.out.println("=== Print Books ===");
        LibraryUtils.printAll(library.getBooks());

        List<Object> destination = new ArrayList<>();
        LibraryUtils.copyList(destination, library.getReaders());

        System.out.println("=== Destination ===");
        LibraryUtils.printAll(destination);
        //endregion

        //region ASM 1-4
        System.out.println();
        System.out.println("=============================");
        System.out.println("********** ASM 1-4 **********");
        System.out.println("=============================");
        menu.start();
        //endregion
    }
}
