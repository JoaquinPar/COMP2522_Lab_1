package ca.bcit.comp2522.bank;

public class BankClient {
    private Name clientName;
    private Date birthDate;
    private Date deathDate;
    private Date signupDate;
    private String clientID;

    public BankClient(final Name clientName, final Date birthDate, final Date deathDate) {
        this.clientName = clientName;
        this.birthDate = birthDate;

        if  (deathDate != null) {
            this.deathDate = deathDate;
        }
    }

    public String getDetils() {
        if (deathDate != null) {
            return clientName.toString() + " (Died " + deathDate.toString() + ") was born on" + birthDate.toString() + "!";
        }

        return  clientName.toString() + " (Alive) " + birthDate.toString() + "!";
    }
}
