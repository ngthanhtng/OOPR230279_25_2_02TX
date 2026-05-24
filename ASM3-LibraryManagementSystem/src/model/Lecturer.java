package model;

public class Lecturer extends Reader {

    public Lecturer(String fullName, String email) {
        super(fullName, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Lecturer" + ", Max Borrow: " + getMaxBorrowLimit();
    }
}