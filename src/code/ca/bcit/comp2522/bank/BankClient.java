package ca.bcit.comp2522.bank;

public class BankClient {
    private final Name clientName;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final String clientID;

    private static final int MIN_STRING_SIZE = 6;
    private static final int MAX_STRING_SIZE = 7;

    public BankClient(final Name   clientName,
                      final Date   birthDate,
                      final Date   signupDate,
                      final String clientID) {
        this(clientName, birthDate, null, signupDate, clientID);
    }

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

    public boolean isAlive() {
        return deathDate == null;
    }

    public Name getClientName() {
        return clientName;
    }

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
