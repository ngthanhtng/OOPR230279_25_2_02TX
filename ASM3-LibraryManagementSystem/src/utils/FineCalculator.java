package utils;

import model.BorrowSlip;

import java.time.temporal.ChronoUnit;

public class FineCalculator {

//    private static final long FINE_PER_DAY = 5000;

    public static double calculateFine(BorrowSlip slip) {
        // Chưa trả sách
        if (!slip.isReturned()) {
            return 0;
        }

        // Trả đúng hạn
        if (!slip.getReturnDate().isAfter(slip.getDueDate())) {
            return 0;
        }

        long lateDays = ChronoUnit.DAYS.between(slip.getDueDate(), slip.getReturnDate());
        return slip.getReader().calculateLateFee((int) lateDays);
    }
}