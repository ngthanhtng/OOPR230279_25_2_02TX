import model.Category;
import model.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //region Bài 1: Class Book
        Book book1 = new Book();
        Book book2 = new Book("Dế mèn phiêu lưu ký", "Tô Hoài", 1941, 130000);
        Book book3 = new Book("Chí phèo", "Nam Cao");

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();

        System.out.println("Áp dụng giảm giá 10% cho cuốn sách 3:");
        book3.applyDiscount(10);
        book3.displayInfo();

        System.out.println("******************************");
        System.out.println("******************************");
        //endregion

        //region Bài 2: Class Rectangle
        Rectangle rec1 = new Rectangle();
        Rectangle rec2 = new Rectangle(4);
        Rectangle rec3 = new Rectangle(3, 5);

        System.out.printf("Rec1 - Area: %.2f - Perimeter: %.2f - Is square: %b%n", rec1.getArea(), rec1.getPerimeter(), rec1.isSquare());
        System.out.printf("Rec2 - Area: %.2f - Perimeter: %.2f - Is square: %b%n", rec2.getArea(), rec2.getPerimeter(), rec2.isSquare());
        System.out.printf("Rec3 - Area: %.2f - Perimeter: %.2f - Is square: %b%n", rec3.getArea(), rec3.getPerimeter(), rec3.isSquare());

        // Test copy constructor
        System.out.println("Rectangle 4 (Copy of Rectangle 3)");
        Rectangle rec4 = new Rectangle(rec3);
        System.out.printf("Rec4 - Area: %.2f - Perimeter: %.2f - Is square: %b%n", rec4.getArea(), rec4.getPerimeter(), rec4.isSquare());

        // Test scale
        rec3.scale(2);
        System.out.println("Sau khi scale rec3 * 2:");
        System.out.printf("Rec3 - Area: %.2f - Perimeter: %.2f - Is square: %b%n", rec3.getArea(), rec3.getPerimeter(), rec3.isSquare());

        System.out.println("******************************");
        System.out.println("******************************");
        //endregion

        //region Bài 3: Class BankAccount
        BankAccount acc1 = new BankAccount(10002004, "Nguyen Thanh Tung", 200000);
        BankAccount acc2 = new BankAccount(10001999, "Bui Thi Lan", 50000);

        //Nạp và rút tiền
        System.out.println("=== Nạp và rút tiền ===");
        acc1.deposit(500000);
        acc1.withdraw(35000);
        acc1.displayInfo();
        System.out.println();

        System.out.println("=== Test số tiền nạp, rút không hợp lệ ===");
        //Nạp số âm
        acc1.deposit(-100000);
        //Rút quá số dư
        acc1.withdraw(900000);
        acc1.displayInfo();
        System.out.println();

        //Chuyển tiền
        System.out.println("=== Chuyển tiền qua tài khoản khác ===");
        acc1.transfer(acc2, 200000);

        System.out.println("\n=== Thông tin sau giao dịch ===");
        acc1.displayInfo();
        System.out.println();
        acc2.displayInfo();

        System.out.println("******************************");
        System.out.println("******************************");
        //endregion

        //region Bài 4: Class Employee
        // Tạo nhân viên
        Employee emp1 = new Employee("Thu", 2900000);
        Employee emp2 = new Employee("Nam", 2300000);
        Employee emp3 = new Employee("Kieu", 3140000);

        // In ID
        System.out.println("ID emp1: " + emp1.getId());
        System.out.println("ID emp2: " + emp2.getId());
        System.out.println("ID emp3: " + emp3.getId());

        // In thông tin công ty
        System.out.println("Company: " + Employee.companyName);
        // In tổng số nhân viên
        System.out.println("Employee Count: " + Employee.getEmployeeCount());
        // In tổng lương
        System.out.println("Total Salary: " + Employee.getTotalSalary());
        // In lương trung bình
        System.out.println("Average Salary: " + Employee.getAverageSalary());

        // Thay đổi lương
        emp1.setSalary(1970000);

        System.out.println("\nSau khi đổi lương emp1:");
        System.out.println("New Salary emp1: " + emp1.getSalary());
        System.out.println("Total Salary: " + Employee.getTotalSalary());
        System.out.println("Average Salary: " + Employee.getAverageSalary());

        // Tăng lương theo %
        emp2.raiseSalary(8);

        System.out.println("\nSau khi tăng lương emp2 8%:");
        System.out.println("Salary emp2: " + emp2.getSalary());
        System.out.println("Total Salary: " + Employee.getTotalSalary());

        // Đổi tên công ty
        Employee.changeCompanyName("FutureTech");
        System.out.println("\nCompany mới: " + Employee.companyName);
        /*
        Giải thích mở rộng:
        Nếu trong main không tạo object nào mà gọi:
        Employee.getAverageSalary();
        => Chương trình vẫn chạy được.
        Vì getAverageSalary() là phương thức static,
        nó thuộc về class chứ không thuộc object.
        */

        System.out.println("******************************");
        System.out.println("******************************");
        //endregion

        //region Bài 5: Class Product + Package
        // Tạo category
        Category phone = new Category("C01", "Điện thoại");
        Category laptop = new Category("C02", "Laptop");

        // Tạo sản phẩm
        Product p1 = new Product();
        Product p2 = new Product("iPhone 15", 25000);
        Product p3 = new Product("MacBook Air", 32000, 10);
        Product p4 = new Product("Samsung S24", 22000, 20, phone);

        p3.setCategory(laptop);

        // Hiển thị thông tin
        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        p4.displayInfo();
        System.out.println();

        // Bán hàng
        p3.sell(2);

        // Nhập hàng
        p2.restock(15);

        // Giảm giá riêng
        p4.applyPromotion(10);

        // Giảm giá toàn bộ
        Product[] products = {p1, p2, p3, p4};
        Product.applyGlobalPromotion(products, 5);

        // Ngừng kinh doanh
        p1.discontinue();

        // In lại thông tin
        System.out.println("\nSau cập nhật:");
        for (Product p : products) {
            p.displayInfo();
        }

        // Báo cáo cửa hàng
        System.out.println();
        System.out.println(Product.getStoreReport());

        // Kiểm tra mã sản phẩm
        System.out.println("\nMã sản phẩm:");
        System.out.println(p1.getProductCode());
        System.out.println(p2.getProductCode());
        System.out.println(p3.getProductCode());
        System.out.println(p4.getProductCode());
        //endregion
    }
}