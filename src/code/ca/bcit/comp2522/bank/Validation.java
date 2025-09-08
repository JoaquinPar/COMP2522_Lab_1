package ca.bcit.comp2522.bank;

public class Validation {
    public static void validateString(final String stringToValidate, final int maxStringSize) {
        if (stringToValidate == null || stringToValidate.isBlank() ||
                stringToValidate.contains("admin") || stringToValidate.length() >= maxStringSize) {
            throw new IllegalArgumentException();
        }
    }
}