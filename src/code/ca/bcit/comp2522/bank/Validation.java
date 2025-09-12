package ca.bcit.comp2522.bank;

/**
 * Validation class is a helper class containing various validation
 * methods, to ensure that the data provided will not pose any harm
 * to either the program or the system running it.
 *
 * @author Mitchell Schaeffer, Joaquin Paredes
 * @version 1.0
 */
public class Validation {

    /**
     * Method to validate a String object to make sure that it is
     * not null, empty, does not contain the word 'admin', and it
     * is of the length allowed.
     *
     * @param stringToValidate the String object to validate
     * @param minStringSize the minimum size possible for the String object
     * @param maxStringSize the maximum size possible for the String object
     * @throws IllegalArgumentException if the String object is invalid
     */
    public static void validateString(final String stringToValidate,
                                      final int    minStringSize,
                                      final int    maxStringSize) {
        if (stringToValidate == null || stringToValidate.isBlank() ||
                stringToValidate.contains("admin") || stringToValidate.length() < minStringSize
                || stringToValidate.length() > maxStringSize) {
                throw new IllegalArgumentException("Invalid String provided");
        }
    }

    /**
     * Method to validate an integer to make sure that it is
     * between the lower and upper bound.
     *
     * @param numberToValidate the integer to validate
     * @param minNumber the smalled number allowed
     * @param maxNumber the biggest number allowed
     * @throws IllegalArgumentException if the number is invalid
     */
    public static void validateNumber(final int numberToValidate,
                                      final int minNumber,
                                      final int maxNumber) {
        if (numberToValidate < minNumber || numberToValidate > maxNumber) {
            throw new IllegalArgumentException("Invalid number provided");
        }
    }
}