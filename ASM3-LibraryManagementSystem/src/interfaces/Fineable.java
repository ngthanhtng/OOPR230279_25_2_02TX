package interfaces;

public interface Fineable {

    // ===== Abstract methods =====
    double getFinePerDay();
    int getLateDays();
    boolean isPaid();

    // ===== Default method =====
    default double calculateTotalFine() {
        return getFinePerDay() * getLateDays();
    }

    // ===== Static method =====
    static boolean isValidFine(double finePerDay) {
        return finePerDay >= 0;
    }
}