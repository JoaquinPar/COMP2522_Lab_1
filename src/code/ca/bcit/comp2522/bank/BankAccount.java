package ca.bcit.comp2522.bank;

public class BankAccount {
    //The mythical bank account class I will be working on
    private final BankClient client;
    private final Name name;
    private double balanceUsd;
    private final Date dateAccountOpened;
    private final Date dateAccountClosed;
    //if I make pin final then it can not be changed even if user forgets their pin
    private final int pin;
    private final String accountNumber;

    public BankAccount(final BankClient client,
                       final double     balanceUsd,
                       int              pin,
                       final String     accountNumber,
                       final Name       clientName,
                       final Date       dateAccountOpened) {
        this.client = client;
        this.balanceUsd = balanceUsd;
        this.name = clientName;
        this.pin = pin;
        Validation.validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        this.dateAccountOpened = dateAccountOpened;
        this.dateAccountClosed = null;
    }

    public BankAccount(final BankClient client,
                       final double     balanceUsd,
                       int              pin,
                       final String     accountNumber,
                       final Name       clientName,
                       final Date       dateAccountOpened,
                       final Date       dateAccountClosed) {
        this.client = client;
        this.balanceUsd = balanceUsd;
        this.name = clientName;
        this.pin = pin;
        Validation.validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        this.dateAccountOpened = dateAccountOpened;
        this.dateAccountClosed = dateAccountClosed;
    }

    /**
     * Amount user wants to deposit into account.
     * @param amountToDepositUsd
     */
    public void deposit(final double amountToDepositUsd) {
        balanceUsd += amountToDepositUsd;
    }

    /**
     * Withdraw from account without the pin
     * @param amountToWithdrawUsd amount user wants to withdraw
     */
    public void withdrawFromAccount(final double amountToWithdrawUsd) {
        if (balanceUsd < amountToWithdrawUsd) {
            throw new IllegalArgumentException("Not sufficient funds");
        }
        balanceUsd -= amountToWithdrawUsd;
    }

    /**
     * Checks if the user has enough funds then their pin
     * and then withdraws it from their account balance
     * @param amountToWithdrawUsd Amount wanting to withdraw in USD
     * @param pinToMatch The users pin
     */
    public void withdrawFromAccountWithPin(final double amountToWithdrawUsd, int pinToMatch) {
        if (balanceUsd < amountToWithdrawUsd) {
            throw new IllegalArgumentException("Not sufficient funds");
        }
        if (pinToMatch != pin) {
            System.out.println("yo this guys pin is wrong he stealing");
        }
        if (pinToMatch == pin) {
            balanceUsd -= amountToWithdrawUsd;
        }
    }

    /**
     * This function checks if client is dead then returns their details
     * @return client name, balance, and when account was opened.
     */
    public String getDetails() {
        if (client.isAlive()) {
            return name.getFullName() + "had " + "$" + this.balanceUsd + " in account #: " + this.accountNumber
                    + " Which they opened on " + this.dateAccountOpened.getDayOfWeek() + " " + this.dateAccountOpened;
        } else {
            return name.getFullName() + "had " + "$" + this.balanceUsd + " in account #: " + this.accountNumber
                    + " Which they opened on " + this.dateAccountOpened + " "  + this.dateAccountOpened + " and closed on " + this.dateAccountClosed.getDayOfWeek() + " " + this.dateAccountClosed;
        }
    }
}
