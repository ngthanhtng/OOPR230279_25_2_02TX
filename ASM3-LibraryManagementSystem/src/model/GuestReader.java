package model;

import model.Reader;

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
}