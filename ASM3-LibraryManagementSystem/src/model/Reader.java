package model;

public class Reader {

    private String readerId;
    private String fullName;
    private String email;
    private ReaderType type;

    // Số lượng sách đang mượn hiện tại
    private int currentBorrowCount;
    // Static
    private static int counter = 0;
    private static int totalReaders = 0;

    public Reader(String fullName, String email, ReaderType type) {
        counter++;
        this.readerId = String.format("R%03d", counter);
        this.fullName = fullName;
        this.email = email;
        this.type = type;

        this.currentBorrowCount = 0;
        totalReaders++;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getFullName() {
        return fullName;
    }

    public ReaderType getType() {
        return type;
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
        if (type == ReaderType.STUDENT) {
            return 3;
        }
        return 5;
    }

    public void displayInfo() {
        System.out.println("ID: " + readerId + " | Name: " + fullName + " | Type: " + type + " | Borrowed: " + currentBorrowCount);
    }
}