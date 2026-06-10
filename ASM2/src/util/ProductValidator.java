package util;

public class ProductValidator {

    // Kiểm tra tên hợp lệ
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 2;
    }

    // Kiểm tra giá hợp lệ
    public static boolean isValidPrice(double price) {
        return price >= 0;
    }

    // Kiểm tra số lượng hợp lệ
    public static boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }
}