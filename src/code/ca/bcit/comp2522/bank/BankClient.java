package ca.bcit.comp2522.bank;

public class BankClient {
    private final Name clientName;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final String clientID;

    public BankClient(final Name clientName, final Date birthDate) {
        this(clientName, birthDate, null, null, null);
    }

    public BankClient(final Name clientName, final Date birthDate, final Date deathDate) {
        this(clientName, birthDate, deathDate, null, null);
    }

    public BankClient(final Name clientName, final Date birthDate, final Date deathDate,
                      final Date signupDate, final String clientID) {
        this.clientName = clientName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    public String getDetails() {
        String stringToReturn;
        stringToReturn = "";

        if (clientID == null) {
            stringToReturn = stringToReturn + getClientDetails() + "\n";
            if (!isAlive()) {
                stringToReturn = stringToReturn + clientName.getFullName() + " (Alive) was born on "
                        + birthDate.toString() + "!";
            } else {
                stringToReturn = stringToReturn + clientName.getFullName() + " (Died "
                        + deathDate.toString() + ") was born on" + birthDate.toString() + "!";
            }
        } else {
            if (isAlive()) {
                stringToReturn = stringToReturn + clientName.getFullName() + " client "
                        + clientID + " (Alive) joined the bank on " + signupDate.toString();
            } else {
                stringToReturn = stringToReturn + clientName.getFullName() + " client "
                        + clientID + " (Deceased) joined the bank on " + signupDate.toString();
            }
        }

        return stringToReturn;
    }

    public boolean isAlive() {
        return deathDate != null;
    }

    public String getClientDetails() {
        return clientName.getInitials() + ", " + clientName.getFullName() + ", "
                + clientName.getReverseName();
    }
}
