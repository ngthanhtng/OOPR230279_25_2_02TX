package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidationHelper {

    private Scanner scanner = new Scanner(System.in);

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public int parseInt(int min, int max) {
        int input;
        do {
            try {
                input = Integer.parseInt(scanner.nextLine());

                if (input < min || input > max) {
                    System.out.println("Please enter a number between " + min + " and " + max);
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid number!");
            }
        } while (true);
    }

    public int parseInt() {
        int input;
        do {
            try {
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Invalid number!");
            }
        } while (true);
    }

    public int parsePositiveInt() {
        int input;
        do {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input <= 0) {
                    System.out.println("Please enter a number must be greater than zero!");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!");
            }
        } while (true);
    }

    public LocalDate parseDate() {
        LocalDate input;
        do {
            try {
                input = LocalDate.parse(scanner.nextLine(), DATE_FORMAT);
                return input;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date!");
            }
        } while (true);
    }
}
