package utils;

/**
 * StringUtils Class help to deal with strings
 */
public final class StringUtils {

    /**
     * Tell if val is blank.
     *
     * @return true if val is Empty or null
     */
    public static boolean isBlank(final String val) {
        return (val == null) || val.isEmpty() || val.trim().isEmpty();
    }
}
