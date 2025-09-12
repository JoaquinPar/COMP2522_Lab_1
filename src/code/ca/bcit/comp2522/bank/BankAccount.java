package ca.bcit.comp2522.bank;

public class BankAccount {

    private static final int MIN_ACCOUNT_NUMBER_LENGTH = 6;
    private static final int MAX_ACCOUNT_NUMBER_LENGTH = 7;
    //The mythical bank account class I will be working on
    private final BankClient client;
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
                       final Date       dateAccountOpened) {
        this(client, balanceUsd, pin, accountNumber, dateAccountOpened, null);
    }

    public BankAccount(final BankClient client,
                       final double     balanceUsd,
                       int              pin,
                       final String     accountNumber,
                       final Date       dateAccountOpened,
                       final Date       dateAccountClosed) {
        Validation.validateString(accountNumber, MIN_ACCOUNT_NUMBER_LENGTH, MAX_ACCOUNT_NUMBER_LENGTH);
        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.dateAccountOpened = dateAccountOpened;
        this.dateAccountClosed = dateAccountClosed;
    }

    /**
     * Amount user wants to deposit into account.
     * @param amountToDepositUsd amount we need to deposit
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
     * This checks if account is closed and if so returns false
     * @return returns false if account is closed
     */
    private boolean checkIfAccountOpened() {
        return (this.dateAccountClosed == null);
    }

    /**
     * This function checks if client is dead then returns their details
     * @return client name, balance, and when account was opened.
     */
    public String getDetails() {
        if (checkIfAccountOpened()) {
            return client.getClientName().getFullName() + " had " + "$" + this.balanceUsd + " in account #" + this.accountNumber
                    + " Which they opened on " + this.dateAccountOpened + "\n";
        } else {
            return client.getClientName().getFullName() + " had " + "$" + this.balanceUsd + " in account #" + this.accountNumber
                    + " Which they opened on " + this.dateAccountOpened + " and closed on" + this.dateAccountClosed + "\n";
        }
    }
}
