package ca.bcit.comp2522.bank;


/**
 * This class represents a {@code Name} for a client with a first and
 * last name. This class also provides methods so that the information
 * of it can be acquired outside itself.
 *
 * @author Mitchell Schaeffer, Joaquin Paredes
 * @version 1.0
 */
public class Name {
    private static final int INDEX_OFFSET = 1;
    private static final int FIRST_CHARACTER_INDEX = 0;
    private static final int SECOND_CHARACTER_INDEX = 1;
    private static final int MIN_LENGTH_OF_NAMES = 1;
    private static final int MAX_LENGTH_OF_NAMES = 45;

    private final String firstName;
    private final String lastName;

    /**
     * Constructs a Name object only if the provided names are valid.
     * Once validated, it will assign the values to the respective
     * first and last name variables.
     *
     * @param firstName the first name entered by the user
     * @param lastName the last name entered by the user
     */
    public Name(final String firstName,
                final String lastName) {
        Validation.validateString(firstName, MIN_LENGTH_OF_NAMES, MAX_LENGTH_OF_NAMES);
        Validation.validateString(lastName, MIN_LENGTH_OF_NAMES, MAX_LENGTH_OF_NAMES);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Getter method for firstName.
     *
     * @return returns the value of the string firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method for lastName.
     *
     * @return returns the value of the string lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method that returns the initials of the first and last name in #.#. format.
     *
     * @return returns the initials of first and last name
     */
    public String getInitials() {
        return firstName.toUpperCase().charAt(FIRST_CHARACTER_INDEX) + "." +
                lastName.toUpperCase().charAt(0) + ".";
    }

    /**
     * Method that returns the full name formatted correctly.
     *
     * @return returns both the first and last names together
     */
    public String getFullName() {
        return firstName.toUpperCase().charAt(FIRST_CHARACTER_INDEX) +
                firstName.substring(SECOND_CHARACTER_INDEX).toLowerCase() +
                " " + lastName.toUpperCase().charAt(FIRST_CHARACTER_INDEX) +
                lastName.substring(SECOND_CHARACTER_INDEX).toLowerCase();
    }

    /**
     * Method to reverse the first and last name.
     *
     * @return return the reversed string
     */
    public String getReverseName() {
        String reversedFirstName;
        String reversedLastName;

        reversedFirstName = "";
        reversedLastName = "";

        for (int i = firstName.length() - INDEX_OFFSET; i >= 0; i--) {
            reversedFirstName = reversedFirstName + firstName.charAt(i);
        }
        for (int i = lastName.length() - INDEX_OFFSET; i >= 0; i--) {
            reversedLastName = reversedLastName + lastName.charAt(i);
        }

        return reversedLastName + " " + reversedFirstName;
    }
}
