package model;

public abstract class Reader {

    private String readerId;
    private String fullName;
    private String email;

    // Số lượng sách đang mượn hiện tại
    private int currentBorrowCount;
    // Static
    private static int counter = 0;
    private static int totalReaders = 0;

    public Reader() {}

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

    public String getEmail() {
        return email;
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

    public abstract int getMaxBorrowLimit();

    public abstract double calculateLateFee(int daysLate);

    public abstract String getInfo();
}

/*
     * LSP VIOLATION
     * renewAllReaders() kỳ vọng mọi Reader đều hỗ trợ renewCard().
     * GuestReader không có thẻ nên không thể renewCard().
     * Khi GuestReader được truyền vào nơi đang mong đợi Reader, chương trình bị lỗi runtime.
     * Vì vậy GuestReader không thể thay thế hoàn toàn Reader => vi phạm LSP.
 */