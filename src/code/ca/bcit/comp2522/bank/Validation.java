package ca.bcit.comp2522.bank;

public class Validation {
    public static void validateString(final String stringToValidate, final int minStringSize, final int maxStringSize) {
        if (stringToValidate == null || stringToValidate.isBlank() ||
                stringToValidate.contains("admin") || stringToValidate.length() < minStringSize
                || stringToValidate.length() > maxStringSize) {
                throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(final int numberToValidate, final int minNumber, final int maxNumber) {
        if (numberToValidate < minNumber || numberToValidate > maxNumber) {
            throw new IllegalArgumentException();
        }
    }
}