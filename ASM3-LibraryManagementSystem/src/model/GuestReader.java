package model;

import model.Reader;

import java.util.List;

public class GuestReader extends Reader {

    public GuestReader() {}

    @Override
    public int getMaxBorrowLimit() {
        return 0;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0;
    }

    @Override
    public String getInfo() {
        return "Guest Reader";
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return false;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }
}