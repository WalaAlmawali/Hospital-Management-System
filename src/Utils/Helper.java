package Utils;
import java.util.UUID;
import java.util.Random;

public class Helper {

    private static final Random random = new Random();


    // *****Null Check Methods (Overloaded)*****

    // Check if Object is null
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    // Check if String is null OR empty
    public static boolean isNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Check if Object is NOT null
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    // Check if String is NOT null AND not empty
    public static boolean isNotNull(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // *****String Validation Methods (Overloaded) *****

    //  Check not null and not empty
    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    //  Check minimum length

    public static boolean isValidString(String str, int minLength) {

        if (!isValidString(str)) {
            return false;
        }

        return str.trim().length() >= minLength;
    }

    //  Check length range (min - max)
    public static boolean isValidString(String str, int minLength, int maxLength) {

        if (!isValidString(str)) {
            return false;
        }

        int length = str.trim().length();

        return length >= minLength && length <= maxLength;
    }

   // Validate using regex pattern

    public static boolean isValidString(String str, String regex) {

        if (!isValidString(str) || regex == null) {
            return false;
        }

        return str.matches(regex);
    }

    // *****ID Generation Methods (Overloaded)*****

    // Generate random UUID
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    // Generate ID with prefix (e.g., PAT-12345)
    public static String generateId(String prefix) {

        if (prefix == null || prefix.trim().isEmpty()) {
            prefix = "ID";
        }

        int number = 10000 + random.nextInt(90000); // 5-digit number

        return prefix + "-" + number;
    }

    // Generate ID with prefix + custom length number
    public static String generateId(String prefix, int length) {

        if (prefix == null || prefix.trim().isEmpty()) {
            prefix = "ID";
        }

        if (length <= 0) {
            length = 5;
        }

        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length) - 1;

        int number = min + random.nextInt(max - min + 1);

        return prefix + "-" + number;
    }



}
