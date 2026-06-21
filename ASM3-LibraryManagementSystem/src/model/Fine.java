package model;

import interfaces.Fineable;

public class Fine implements Fineable {

    private double finePerDay;
    private int lateDays;
    private boolean paid;

    public Fine(double finePerDay, int lateDays, boolean paid) {

        if (!Fineable.isValidFine(finePerDay)) {
            throw new IllegalArgumentException(
                    "Fine per day must be non-negative!"
            );
        }

        this.finePerDay = finePerDay;
        this.lateDays = lateDays;
        this.paid = paid;
    }

    @Override
    public double getFinePerDay() {
        return finePerDay;
    }

    @Override
    public int getLateDays() {
        return lateDays;
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    public void payFine() {
        paid = true;
    }

    @Override
    public String toString() {
        return "Late days: " + lateDays
                + ", Fine/day: " + finePerDay
                + ", Total: " + calculateTotalFine()
                + ", Paid: " + paid;
    }
}