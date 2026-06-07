import model.DigitalAccount;
import model.GuestAccount;
import model.LecturerAccount;
import model.StudentAccount;
import service.Librarian;
import service.Library;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        // Khởi tạo
        Library library = new Library();
        Librarian librarian = new Librarian();

        Menu menu = new Menu(library, librarian);

        // ASM5 + nâng cao
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

        // ASM 1-4
        menu.start();
    }
}
