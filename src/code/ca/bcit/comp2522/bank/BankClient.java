package ca.bcit.comp2522.bank;

public class BankClient {
    private final Name clientName;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final Date accountClosedDate;
    private final String clientID;

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

        if (clientID == null) {
            stringToReturn = stringToReturn + getClientDetails() + "\n";
            if (!isAlive()) {
                stringToReturn = stringToReturn + clientName.getFullName() + " (Alive) was born on "
                        + birthDate.toString() + "!";
            } else {
                stringToReturn = stringToReturn + clientName.getFullName() + " (Died "
                        + deathDate.toString() + ") was born on " + birthDate.toString() + "!";
            }
        } else {
            if (isAlive()) {
                stringToReturn = stringToReturn + clientName.getFullName() + " client #"
                        + clientID + " (Alive) joined the bank on " + signupDate.toString();
            } else {
                stringToReturn = stringToReturn + clientName.getFullName() + " client #"
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

        client1 = new BankClient(name, birth, death);
        System.out.println(client1.getDetails());
        client1 = new BankClient(name, birth, death, signup, closed, clientID);
        System.out.println(client1.getDetails());
    }
}
