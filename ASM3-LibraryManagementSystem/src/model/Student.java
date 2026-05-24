package model;

public class Student extends Reader {

    public Student(String fullName, String email) {
        super(fullName, email);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Student" + ", Max Borrow: " + getMaxBorrowLimit();
    }
}