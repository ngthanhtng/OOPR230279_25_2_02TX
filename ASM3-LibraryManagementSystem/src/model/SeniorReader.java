package model;

public class SeniorReader extends CardHolder {

    private String seniorCardNumber;

    public SeniorReader(String fullName, String email, String seniorCardNumber) {
        super(fullName, email);
        this.seniorCardNumber = seniorCardNumber;
    }

    @Override
    public void renewCard(int months) {
        super.renewCard(months);
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0;
    }

    @Override
    public int getMaxBorrowLimit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getInfo() {
        /*
        super.getInfo() => Đây là static binding không phải dynamic binding vì gọi trực tiếp implementation của lớp cha.
        Không thể gọi super.getInfo() tại đây vì hàm getInfo() ở lớp cha là hàm abstract.
        */
        return "[Senior] ID: " + getReaderId() +
                ", Name: " + getFullName() +
                ", Email: " + getEmail() +
                ", Current Borrow: " + getCurrentBorrowCount() +
                ", Max Borrow: " + getMaxBorrowLimit() +
                ", [NCT - MIEN PHAT]";
    }

    public String getSeniorCardNumber() {
        return seniorCardNumber;
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }

    @Override
    protected void onBorrowSuccess(Book book) {
        super.onBorrowSuccess(book);
        System.out.println("  -> Da ghi nhan: Nguoi cao tuoi — khong thu phi phat");
    }
}