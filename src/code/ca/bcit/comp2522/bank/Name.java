package ca.bcit.comp2522.bank;

public class Name {
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
        Validation.validateString(firstName, 45);
        Validation.validateString(lastName, 45);
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
        return firstName.toUpperCase().charAt(0) + "." + lastName.toUpperCase().charAt(0) + ".";
    }

    /**
     * Method that returns the full name formatted correctly.
     *
     * @return returns both the first and last names together
     */
    public String getFullName() {
        return firstName.toUpperCase().charAt(0) + firstName.substring(1).toLowerCase() +
                " " + lastName.toUpperCase().charAt(0) + lastName.substring(1).toLowerCase();
    }

    /**
     *
     * @return
     */
    public String getReverseName() {
        String reversedFirstName;
        String reversedLastName;

        reversedFirstName = "";
        reversedLastName = "";

        for (int i = firstName.length() - 1; i >= 0; i--) {
            reversedFirstName = reversedFirstName + firstName.charAt(i);
        }
        for (int i = lastName.length() - 1; i >= 0; i--) {
            reversedLastName = reversedLastName + lastName.charAt(i);
        }

        return reversedLastName + " " + reversedFirstName;
    }

    public static void main(final String[] args) {
        Name newName;
        newName = new Name("tigadminER", "wooDS");

        System.out.println(newName.getReverseName());
        System.out.println(newName.getInitials());
    }
}
