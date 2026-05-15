package Utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("EMPTY INPUT");
            }
        }

        return input;
    }

    /** Reads an integer from the console. */

    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                return Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println("INVALID NUMBER");
            }
        }
    }

    public static int getIntInput(String prompt, int min, int max) {
        while (true) {
            int val = getIntInput(prompt);
            if( HelperUtils.isValidNumber(val,min,max))return val;
            System.out.println("NOT IN RANGE");
        }
    }

    public static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                return Double.parseDouble(raw);
            } catch (NumberFormatException e) {
                System.out.println("INVALID NUMBER");
            }
        }
    }


    public static LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();

            try {
                return LocalDate.parse(raw);
            } catch (DateTimeParseException e) {
                System.out.println("INVALID DATE");
            }
        }
    }

    public static boolean getConfirmation(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String raw = scanner.nextLine().trim();
            if (raw.equalsIgnoreCase("y")) return true;
            if (raw.equalsIgnoreCase("n")) return false;
            System.out.println("Please enter 'y' or 'n'");
        }
    }

    public static LocalTime getTimeInput(String prompt) {
        while (true) {
            System.out.print(prompt + " (HH:mm): ");
            String raw = scanner.nextLine().trim();

            try {
                return LocalTime.parse(raw);
            } catch (DateTimeParseException e) {
                System.out.println("INVALID TIME");
            }
        }
    }


}
