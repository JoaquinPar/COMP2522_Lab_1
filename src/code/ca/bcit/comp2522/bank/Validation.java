package ca.bcit.comp2522.bank;

public class Validation {
    private static final int BANKACCOUNTNUMBERLENGTHMINSIX = 6;
    private static final int BANKACCOUNTNUMBERLENGTHMAXSEVEN = 7;

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

    /**
     * This funcation checks the length of account number given to it
     * to make sure that it is a valid account number
     * @param accountToValidate This checks the account number given to it and makes
     *                          sure it is within the parameters given for it.
     */
    public static void validateAccountNumber(final String accountToValidate) {
        if (accountToValidate.length() < BANKACCOUNTNUMBERLENGTHMINSIX
                || accountToValidate.length() > BANKACCOUNTNUMBERLENGTHMAXSEVEN) {
            throw new IllegalArgumentException("Invalid account Numbering");
        }
    }
}