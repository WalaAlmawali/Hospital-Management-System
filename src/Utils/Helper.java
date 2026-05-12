package Utils;

public class Helper {

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




}
