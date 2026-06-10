package model;

import util.ProductValidator;

public class Product {

    // Thuộc tính
    private String productCode;
    private String name;
    private double price;
    private int quantity;
    private boolean discontinued = false;

    private Category category;

    // Static
    private static int counter = 0;
    private static int totalProducts = 0;
    private static double totalRevenue = 0;

    // Constructor không tham số
    public Product() {
        this("Unknown", 0, 0);
    }

    // Constructor 2 tham số
    public Product(String name, double price) {
        this(name, price, 0);
    }

    // Constructor đầy đủ
    public Product(String name, double price, int quantity) {
        counter++;
        this.productCode = String.format("P-%04d", counter);

        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }

        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            this.price = 0;
        }

        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }

        totalProducts++;
    }

    // Constructor có category
    public Product(String name, double price, int quantity, Category category) {
        this(name, price, quantity);
        this.category = category;
    }

    // Getter
    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    // Setter
    public void setName(String name) {
        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            System.out.println("Tên không hợp lệ!");
        }
    }

    public void setPrice(double price) {
        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            System.out.println("Giá không hợp lệ!");
        }
    }

    public void setQuantity(int quantity) {
        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            System.out.println("Số lượng không hợp lệ!");
        }
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Bán sản phẩm
    public void sell(int amount) {
        if (discontinued) {
            System.out.println("Sản phẩm đã ngừng kinh doanh!");
            return;
        }

        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            totalRevenue += amount * price;

            System.out.println("Bán thành công " + amount + " sản phẩm.");
        } else {
            System.out.println("Số lượng bán không hợp lệ!");
        }
    }

    // Nhập thêm hàng
    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Nhập thêm hàng thành công.");
        } else {
            System.out.println("Số lượng nhập không hợp lệ!");
        }
    }

    // Hiển thị thông tin
    public void displayInfo() {
        System.out.println("===============");
        System.out.println("Mã SP: " + productCode);
        System.out.println("Loại: " + category);
        System.out.println("Tên: " + name);
        System.out.println("Giá: " + price);
        System.out.println("Tồn kho: " + quantity);

        if (discontinued) {
            System.out.println("Trạng thái: Ngừng kinh doanh");
        } else {
            System.out.println("Trạng thái: Đang bán");
        }
    }

    // Giảm giá
    public void applyPromotion(double discountPercent) {
        if (discountPercent > 0 && discountPercent <= 100) {
            price = price - (price * discountPercent / 100);
        }
    }

    // Static giảm giá toàn bộ
    public static void applyGlobalPromotion(Product[] products, double discountPercent) {
        for (Product p : products) {
            p.applyPromotion(discountPercent);
        }
    }

    // Ngừng kinh doanh
    public void discontinue() {
        discontinued = true;
    }

    /*
    Giải thích discontinue():
    Khi một sản phẩm bị ngừng kinh doanh,
    totalProducts KHÔNG nên giảm.
    Vì totalProducts đại diện cho tổng số sản phẩm
    đã từng được tạo trong hệ thống.
    Nếu giảm totalProducts sẽ làm sai thống kê lịch sử.
    Do đó ta dùng biến discontinued để đánh dấu sản phẩm
    ngừng bán thay vì xoá khỏi thống kê.
    */

    // Static methods
    public static int getTotalProducts() {
        return totalProducts;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static String getStoreReport() {
        return """
                ===== THỐNG KÊ TỔNG SP VÀ DANNH THU CỦA CỬA HÀNG =====
                Tổng sản phẩm: """ + totalProducts +
                "\nTổng doanh thu: " + totalRevenue;
    }

}
