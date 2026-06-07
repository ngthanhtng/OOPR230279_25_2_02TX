package model;

public class Lecturer extends CardHolder {

    public Lecturer(String fullName, String email) {
        super(fullName, email);
    }

    @Override
    public void renewCard(int months) {
        super.renewCard(months);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1000;
    }

    @Override
    public String getInfo() {
        return "[Lecturer] ID: " + getReaderId() +
                ", Name: " + getFullName() +
                ", Email: " + getEmail() +
                ", Current Borrow: " + getCurrentBorrowCount() +
                ", Max Borrow: " + getMaxBorrowLimit();
    }
}