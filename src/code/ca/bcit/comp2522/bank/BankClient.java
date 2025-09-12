package ca.bcit.comp2522.bank;

/**
 *
 */
public class BankClient {

    private static final int MIN_STRING_SIZE = 6;
    private static final int MAX_STRING_SIZE = 7;

    private final Name clientName;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final String clientID;

    /**
     *
     * @param clientName Name object to hold name of client
     * @param birthDate Date object for the birth of client
     * @param signupDate Date object for when the client signed up
     * @param clientID String object for the ID of the client
     */
    public BankClient(final Name   clientName,
                      final Date   birthDate,
                      final Date   signupDate,
                      final String clientID) {
        this(clientName, birthDate, null, signupDate, clientID);
    }

    /**
     *
     * @param clientName Name object to hold name of client
     * @param birthDate Date object for the birth of client
     * @param deathDate Date object for when the client died (Can be null)
     * @param signupDate Date object for when the client signed up
     * @param clientID String object for the ID of the client
     */
    public BankClient(final Name   clientName,
                      final Date   birthDate,
                      final Date   deathDate,
                      final Date   signupDate,
                      final String clientID) {
        Validation.validateString(clientID, MIN_STRING_SIZE, MAX_STRING_SIZE);

        this.clientName = clientName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    /**
     * method to receive the client information.
     *
     * @return returns all the client info as a String object
     */
    public String getDetails() {
        String stringToReturn;
        stringToReturn = "";

        stringToReturn += getClientDetails();

        if (isAlive()) {
            stringToReturn = stringToReturn + clientName.getFullName() + " client #"
                    + clientID + " (Alive) joined the bank on " + signupDate.toString();
        } else {
            stringToReturn = stringToReturn + clientName.getFullName() + " client #"
                    + clientID + " (Deceased) joined the bank on " + signupDate.toString();
        }

        return stringToReturn;
    }

    /**
     * Method to check if the client is still alive or not.
     *
     * @return will return true if deathDate is null, false if not
     */
    public boolean isAlive() {
        return deathDate == null;
    }

    /**
     * Method to access the client's Name object.
     *
     * @return returns the clientName Name object
     */
    public Name getClientName() {
        return clientName;
    }

    /**
     * Method to get the client's Name information.
     *
     * @return returns the client's initials, full name, reversed name, birth and death date (if not null)
     */
    public String getClientDetails() {
        String stringToReturn;
        stringToReturn = "";

        stringToReturn = stringToReturn + clientName.getInitials() + ", " + clientName.getFullName() + ", "
                + clientName.getReverseName() + ". Born on " + birthDate.toString();

        if (deathDate != null) {
            stringToReturn = stringToReturn + ", died on " + deathDate.toString();
        }

        stringToReturn = stringToReturn + "\n";

        return stringToReturn;
    }
}
