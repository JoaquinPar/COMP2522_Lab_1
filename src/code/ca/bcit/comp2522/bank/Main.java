package ca.bcit.comp2522.bank;

public class Main {

    //Constants for Client Albert Einstein
    private static final int YEAR_OF_EIGHTEEN_SEVENTY_NINE = 1879;
    private static final int FOURTEENTH_DAY = 14;
    private static final int MONTH_OF_MARCH = 3;
    private static final int YEAR_OF_NINETEEN_FIFTY_FIVE = 1955;
    private static final int EIGHTEENTH_DAY = 18;
    private static final int MONTH_OF_APRIL = 4;
    private static final int YEAR_OF_NINETEEN_HUNDRED = 1900;
    private static final int FIRST_DAY = 1;
    private static final int MONTH_OF_JANUARY = 1;
    private static final int YEAR_OF_NINETEEN_FIFTY = 1950;
    private static final int MONTH_OF_OCTOBER = 10;

    //Constants for Nelson Mandela except the dates repeated
    private static final int YEAR_OF_NINETEEN_EIGHTEEN = 1918;
    private static final int MONTH_OF_JULY = 7;
    private static final int YEAR_OF_TWO_THOUSAND_THIRTEEN = 2013;
    private static final int FIFTH_DAY = 5;
    private static final int MONTH_OF_DECEMBER = 12;
    private static final int YEAR_OF_NINETEEN_NINETY_FOUR = 1994;
    private static final int TENTH_DAY = 10;
    private static final int MONTH_OF_MAY = 5;

    //Constants for Frida Kahlo, except those repeated
    private static final int YEAR_OF_NINETEEN_O_SEVEN = 1907;
    private static final int SIXTH_DAY = 6;
    private static final int YEAR_OF_NINETEEN_FIFTY_FOUR = 1954;
    private static final int THIRTEENTH_DAY = 13;
    private static final int YEAR_OF_NINETEEN_FORTY = 1940;

    //Constants for Jacky Chan, except those repeated
    private static final int SEVENTH_DAY = 7;
    private static final int YEAR_OF_NINETEEN_EIGHTY = 1980;

    //Constants for instantiating the different BankAccounts
    private static final int BALANCE_OF_ONE_THOUSAND = 1000;
    private static final int PIN_OF_THREE_ONE_FOUR_ONE = 3141;
    private static final int BALANCE_OF_TWO_THOUSAND = 2000;
    private static final int PIN_OF_FOUR_SIX_SIX_FOUR = 4664;
    private static final int BALANCE_OF_FIVE_HUNDRED = 500;
    private static final int PIN_OF_NINETEEN_ZERO_SEVEN = 1907;
    private static final int BALANCE_OF_THREE_THOUSAND = 3000;
    private static final int PIN_OF_NINETEEN_FIFTY_FOUR = 1954;

    public static void main(final String[] args) {
        Date birth;
        Date death;
        Name name;
        Date signup;
        Date accountClosed;
        String clientId;
        final BankClient client1;
        final BankClient client2;
        final BankClient client3;
        final BankClient client4;
        final BankAccount bankAccount1;
        final BankAccount bankAccount2;
        final BankAccount bankAccount3;
        final BankAccount bankAccount4;
        birth = new Date(YEAR_OF_EIGHTEEN_SEVENTY_NINE, MONTH_OF_MARCH, FOURTEENTH_DAY);
        death = new Date(YEAR_OF_NINETEEN_FIFTY_FIVE, MONTH_OF_APRIL, EIGHTEENTH_DAY);
        signup = new Date(YEAR_OF_NINETEEN_HUNDRED, MONTH_OF_JANUARY, FIRST_DAY);
        accountClosed = new Date (YEAR_OF_NINETEEN_FIFTY, MONTH_OF_OCTOBER, FOURTEENTH_DAY);
        name = new Name("Albert", "Einstein");
        clientId = "abc123";

        client1 = new BankClient(name, birth, death, signup, clientId);
        System.out.println(client1.getDetails());
        bankAccount1 = new BankAccount(client1, BALANCE_OF_ONE_THOUSAND, PIN_OF_THREE_ONE_FOUR_ONE,
                "123456", signup, accountClosed);
        System.out.println(bankAccount1.getDetails());

        birth = new Date(YEAR_OF_NINETEEN_EIGHTEEN, MONTH_OF_JULY, EIGHTEENTH_DAY);
        death = new Date(YEAR_OF_TWO_THOUSAND_THIRTEEN, MONTH_OF_DECEMBER, FIFTH_DAY);
        signup = new Date(YEAR_OF_NINETEEN_NINETY_FOUR, MONTH_OF_MAY, TENTH_DAY);
        name = new Name("Nelson", "Mandela");
        clientId = "654321";

        client2 = new BankClient(name, birth, death, signup, clientId);
        System.out.println(client2.getDetails());
        bankAccount2 = new BankAccount(client2, BALANCE_OF_TWO_THOUSAND, PIN_OF_FOUR_SIX_SIX_FOUR, "856492", signup);
        System.out.println(bankAccount2.getDetails());

        birth = new Date(YEAR_OF_NINETEEN_O_SEVEN, MONTH_OF_JULY, SIXTH_DAY);
        death = new Date(YEAR_OF_NINETEEN_FIFTY_FOUR, MONTH_OF_JULY, THIRTEENTH_DAY);
        signup = new Date(YEAR_OF_NINETEEN_FORTY, MONTH_OF_JANUARY, FIRST_DAY);
        accountClosed = new Date(YEAR_OF_NINETEEN_FIFTY_FOUR, MONTH_OF_JULY, THIRTEENTH_DAY);
        name = new Name("Frida", "Kahlo");
        clientId = "frd123";

        client3 = new BankClient(name, birth, death, signup, clientId);
        System.out.println(client3.getDetails());
        bankAccount3 = new BankAccount(client3, BALANCE_OF_FIVE_HUNDRED,
                PIN_OF_NINETEEN_ZERO_SEVEN, "947392", signup, accountClosed);
        System.out.println(bankAccount3.getDetails());

        birth = new Date(YEAR_OF_NINETEEN_FIFTY_FOUR, MONTH_OF_APRIL, SEVENTH_DAY);
        signup = new Date(YEAR_OF_NINETEEN_EIGHTY, MONTH_OF_OCTOBER, FIRST_DAY);
        name = new Name("Jacky", "Chan");
        clientId = "chan789";

        client4 = new BankClient(name, birth, signup, clientId);
        System.out.println(client4.getDetails());
        bankAccount4 = new BankAccount(client4, BALANCE_OF_THREE_THOUSAND, PIN_OF_NINETEEN_FIFTY_FOUR,
                "8503759", signup);
        System.out.println(bankAccount4.getDetails());
    }
}
