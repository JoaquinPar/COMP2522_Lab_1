package ca.bcit.comp2522.bank;

public class Date {
    private static final int YEAR;
    private static final int MONTH;
    private static final int DAY;
    private static final int YEAR_DIVISOR_FOUR_HUNDRED = 400;
    private static final int YEAR_DIVISOR_FOUR = 4;
    private static final int YEAR_DIVISOR_ONE_HUNDRED = 100;
    private static final int HIGHEST_MONTH_DAYS = 31;
    private static final int MONTH_WITH_THIRTY_DAYS = 30;
    private static final int LOWEST_NUMBER_OF_DAYS_IN_MONTH = 28;
    private static final int LEAP_YEAR_MONTH = 29;
    private static final int MONTH_JUNE = 6;
    private static final int MONTH_AUGUST = 8;
    private static final int MONTH_FEB = 2;
    private static final int MONTH_JULY = 7;
    private static final int MONTH_DECEMBER = 12;
    private static final int MONTH_DIVIDED_BY_TWO = 2;
    private static final int MONTH_CODE_JAN = 1;
    private static final int LOWEST_YEAR_ALLOWED = 1800;
    private static int CURRENT_YEAR = 2025;
//    private final int

    /* We need to add a leap year func
    * and a way to check how many days there are
    * in a month
    * as well as validating the year which is easy*/

    /**
     *
     * @param year only allow between 1800 to current year
     * @param month Only allows months 1-12
    public static void main(final String[] args) {
        Name newName;
        newName = new Name("John", "Doe");

        System.out.println(newName.getReverseName());
        System.out.println(newName.getInitials());
    }
     * @param day only allows days  1-31, 1-28, 1-29, 1-30
     */
    public Date(int year, int month, int day) {
        Validation.validateNumber(year, LOWEST_YEAR_ALLOWED, CURRENT_YEAR);
        Validation.validateNumber(month, 1, 12);

        this.YEAR = year;
        this.MONTH = month;

        Validation.validateNumber(day, 1, numberOfDaysInMonth(month, year));

        this.DAY = day;
    }


    public static String getDay(int day) {
        return 
    }

    /**
     * This function takes in yyyymmdd and formats it
     * @param year
     * @param month
     * @param day
     * @return the year month day formatted yyyymmdd
     */
    public static String getYyyyMmDd(int year, int month, int day) {
        return year + "-" +  month + "-" + day;
    }


    /**
     * takes in a year and returns if it is a leap year or not
     * @param year
     * @return true if leap year false if not
     */
    private static boolean isLeapYear(int year) {
        return (year % YEAR_DIVISOR_FOUR == 0 && year % YEAR_DIVISOR_FOUR_HUNDRED == 0)
                || (year % YEAR_DIVISOR_FOUR == 0 && year % YEAR_DIVISOR_ONE_HUNDRED != 0);
    }


    /**
     * This returns the number of days in a month based on the month and checks if
     * it is a leap year or not
     * @param month takes month checks days
     * @param year takes year makes sure it is not a leap year
     * @return days in a month given
     */
    private static int numberOfDaysInMonth(int month, int year) {
        if (month % MONTH_DIVIDED_BY_TWO != 0 && month < MONTH_JULY) {
           return HIGHEST_DAYS_IN_MONTH;
        } else if ((month % MONTH_DIVIDED_BY_TWO == 0) && (month > MONTH_JUNE && month < MONTH_DECEMBER)) {
            return HIGHEST_DAYS_IN_MONTH;
        } else if (month == MONTH_FEB) {
            if (isLeapYear(year)) {
                return LEAP_YEAR_MONTH;
            } else {
                return LOWEST_NUMBER_OF_DAYS_IN_MONTH;
            }
        } else if ((month % MONTH_DIVIDED_BY_TWO == 0 && (month < MONTH_JULY && month > MONTH_FEB)
                || (month > MONTH_JUNE && month % MONTH_DIVIDED_BY_TWO != 0)) {
            return MONTH_WITH_THIRTY_DAYS;
        } else {
            Throw new IllegalArgumentException("Somehow you bypassed all the month checks");
            return 0;
        }
    }




    public static void main(String[] args) {
        Date d = new Date(1800, 13, 1);

        System.out.println(numberOfDaysInMonth(8, 2000));

    }
}

