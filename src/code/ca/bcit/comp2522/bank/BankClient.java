package ca.bcit.comp2522.bank;

public class BankClient {
    private final Name clientName;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final Date accountClosedDate;
    private final String clientID;

    private static final int MIN_STRING_SIZE = 6;
    private static final int MAX_STRING_SIZE = 7;

    public BankClient(final Name clientName, final Date birthDate) {
        this(clientName, birthDate, null, null, null, null);
    }

    public BankClient(final Name clientName, final Date birthDate, final Date deathDate) {
        this(clientName, birthDate, deathDate, null, null, null);
    }

    public BankClient(final Name clientName, final Date birthDate, final Date deathDate,
                      final Date signupDate, final String clientID) {
        this(clientName, birthDate, deathDate, signupDate, null, clientID);
    }

    public BankClient(final Name clientName, final Date birthDate, final Date deathDate,
                      final Date signupDate, final Date accountClosedDate, final String clientID) {
        Validation.validateString(clientID, MIN_STRING_SIZE, MAX_STRING_SIZE);

        this.clientName = clientName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signupDate = signupDate;
        this.accountClosedDate = accountClosedDate;

        this.clientID = clientID;
    }

    public String getDetails() {
        String stringToReturn;
        stringToReturn = "";

        stringToReturn += getClientDetails();

        if (!isAlive()) {
            stringToReturn = stringToReturn + clientName.getFullName() + " client #"
                    + clientID + " (Alive) joined the bank on " + signupDate.toString();
        } else {
            stringToReturn = stringToReturn + clientName.getFullName() + " client #"
                    + clientID + " (Deceased) joined the bank on " + signupDate.toString();
        }

        if (accountClosedDate != null) {
            stringToReturn = stringToReturn + " and closed their account on " + accountClosedDate.toString();
        }

        return stringToReturn;
    }

    public boolean isAlive() {
        return deathDate != null;
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

    public static void main(final String[] args) {
        BankClient client1;
        Name name;
        Date birth;
        Date death;
        Date signup;
        Date closed;
        String clientID;
        name = new Name("Albert", "Einstein");
        birth = new Date(1879, 3, 14);
        death = new Date(1955, 4, 18);
        signup = new Date(1900, 1, 1);
        closed = new Date(1950, 10, 14);
        clientID = "abc123";
        client1 = new BankClient(name, birth, death, signup, closed, clientID);
        System.out.println(client1.getDetails());
    }
}
