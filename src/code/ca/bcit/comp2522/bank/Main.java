package ca.bcit.comp2522.bank;

public class Main {

    private static final int yearOfEighteenSeventyNine = 1879;
    private static final int dayOfFourteen = 14;
    private static final int monthOfThree = 3;
    private static final int yearOfNineteenFiftyFive = 1955;
    private static final int dayOfEighteen = 18;
    private static final int monthOfFour = 4;
    private static final int yearOfNinteenFifty = 1950;
    private static final int dayOfEleven = 11;
    private static final int monthOfOne = 1;

    public static void main(String[] args) {
        final Date birth;
        final Date death;
        final Name name;
        final BankAccount bankAccount;
        final Date signup;
        final String clientId;
        birth = new Date(yearOfEighteenSeventyNine, monthOfThree, dayOfFourteen);
        death = new Date(yearOfNineteenFiftyFive, monthOfFour, dayOfEighteen);
        signup = new Date (yearOfNinteenFifty, monthOfOne, dayOfEleven);
        name = new Name("Albert", "Einstein");
        clientId = "abc123";


        BankClient client = new BankClient(name , birth, death, signup, clientId);
        System.out.println(name.getInitials());
        System.out.println(name.getFullName());
        System.out.println(name.getReverseName());
        System.out.println(client.getClientDetails());

    }


}
