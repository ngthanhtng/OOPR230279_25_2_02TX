package model;

public class Reader {

    private String readerId;
    private String fullName;
    private String email;

    // Số lượng sách đang mượn hiện tại
    private int currentBorrowCount;
    // Static
    private static int counter = 0;
    private static int totalReaders = 0;

    public Reader(String fullName, String email) {
        counter++;
        this.readerId = String.format("R%03d", counter);
        this.fullName = fullName;
        this.email = email;

        this.currentBorrowCount = 0;
        totalReaders++;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCurrentBorrowCount() {
        return currentBorrowCount;
    }

    public void increaseBorrowCount() {
        currentBorrowCount++;
    }

    public void decreaseBorrowCount() {
        currentBorrowCount--;
    }

    public int getMaxBorrowLimit() {
        return 0;
    }

    @Override
    public String toString() {
        return "Reader ID: " + readerId +
                ", Name: " + fullName +
                ", Email: " + email +
                ", Current Borrow: " + currentBorrowCount;
    }
}