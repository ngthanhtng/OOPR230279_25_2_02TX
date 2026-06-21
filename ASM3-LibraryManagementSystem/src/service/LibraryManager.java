package service;

import interfaces.Borrowable;
import interfaces.Notifiable;
import model.Book;

import java.util.List;

public class LibraryManager {

    // Chỉ duyệt và in trạng thái, KHÔNG thay đổi dữ liệu
    public void processAllBorrowable(List<Borrowable> items) {
        System.out.println("===== BORROWABLE ITEMS =====");
        for (Borrowable item : items) {
            Book book = (Book) item;
            System.out.println("Book: " + book.getTitle());

            if (item.isAvailable()) {
                System.out.println("- Available: " + book.getQuantity() + " books");
            } else {
                System.out.println("- Not available." + book.getQuantity() + " books");
            }

            if (item.getBorrowerId() != null) {
                System.out.println("- Borrower: " + item.getBorrowerId());
            }
        }
    }

    public void notifyAll(List<Notifiable> users, String message) {
        System.out.println("===== SEND NOTIFICATIONS =====");
        for (Notifiable user : users) {
            user.sendNotification(message);
        }
    }
}