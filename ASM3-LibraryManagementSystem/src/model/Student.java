package model;

import java.util.List;

public class Student extends CardHolder {

    public Student(String fullName, String email) {
        super(fullName, email);
    }

    @Override
    public void renewCard(int months) {
        super.renewCard(months);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 2000;
    }

    @Override
    public String getInfo() {
        return "[Student] ID: " + getReaderId() +
                ", Name: " + getFullName() +
                ", Email: " + getEmail() +
                ", Current Borrow: " + getCurrentBorrowCount() +
                ", Max Borrow: " + getMaxBorrowLimit();
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return !book.isReferenceOnly();
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "Sach tham khao chi doc tai cho — sinh vien khong duoc mang ve";
    }
}