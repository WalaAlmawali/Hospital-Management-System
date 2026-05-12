package Utils;

public class Helper {

    // Check if Object is null
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    // Check if String is null OR empty
    public static boolean isNull(String str) {
        return str == null || str.trim().isEmpty();
    }

}
