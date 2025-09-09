package ca.bcit.comp2522.bank;

public class Name {
    private static final int INDEX_OFFSET = 1;
    private static final int FIRST_CHARACTER_INDEX = 0;
    private static final int SECOND_CHARACTER_INDEX = 1;
    private static final int MAX_LENGTH_OF_NAMES = 45;


    private final String firstName;
    private final String lastName;


    /**
     * Need to make this validate if the names are longer than 45 characters,
     * it must also not contain admin in any letter casing, cannot be null
     * nor blank.
     *
     * @param firstName
     * @param lastName
     */
    public Name(String firstName, String lastName) {
        Validation.validateString(firstName, MAX_LENGTH_OF_NAMES);
        Validation.validateString(lastName, MAX_LENGTH_OF_NAMES);
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
        return firstName.toUpperCase().charAt(FIRST_CHARACTER_INDEX) + "." + lastName.toUpperCase().charAt(0) + ".";
    }

    /**
     * Method that returns the full name formatted correctly.
     *
     * @return returns both the first and last names together
     */
    public String getFullName() {
        return firstName.toUpperCase().charAt(FIRST_CHARACTER_INDEX) + firstName.substring(SECOND_CHARACTER_INDEX).toLowerCase() +
                " " + lastName.toUpperCase().charAt(FIRST_CHARACTER_INDEX) + lastName.substring(SECOND_CHARACTER_INDEX).toLowerCase();
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

    public static void main(final String[] args) {
        Name newName;
        newName = new Name("John", "Doe");

        System.out.println(newName.getReverseName());
        System.out.println(newName.getInitials());
    }
}
