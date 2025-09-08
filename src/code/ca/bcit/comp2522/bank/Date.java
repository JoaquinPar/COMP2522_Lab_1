package ca.bcit.comp2522.bank;

public class Date {
    private final int YEAR = null;
    private final int MONTH;
    private final int DAY;
    private final int YEARDIVISORFOURHUNDRED = 400;
    private final int YEARDIVISORFOUR = 4;
    private final int YEARDIVISORONEHUNDRED = 100;

    /* We need to add a leap year func
    * and a way to check how many days there are
    * in a month
    * as well as validating the year which is easy*/

    /**
     *
     * @param year only allow between 1800 to current year
     * @param month Only allows months 1-12
     * @param day only allows days  1-31, 1-28, 1-29, 1-30
     */
    public Date(int year, int month, int day) {
        this.year = YEAR;
        this.month = MONTH;
        this.day = DAY;
    }

    public static String getYyyyMmDd(int year, int month, int day) {
        return year + "-" +  month + "-" + day;
    }


    /**
     * takes in a year and returns if it is a leap year or not
     * @param year
     * @return true if leap year false if not
     */
    private static boolean isLeapYear(int year) {
        return (year % YEARDIVISORFOUR == 0 && year % YEARDIVISORFOURHUNDRED == 0)
                || (year % YEARDIVISORFOUR == 0 && year % YEARDIVISORONEHUNDRED != 0);
    }


    /**
     * This returns the number of days in a month based on the month and checks if
     * it is a leap year or not
     * @param month takes month checks days
     * @param year takes year makes sure it is not a leap year
     * @return days in a month given
     */
    private static int numberOfDaysInMonth(int month, int year) {
        if (month % 2 != 0 && month < 7) {
           return 31;
        } else if ((month % 2 == 0) && (month > 6 && month < 12)) {
            return 31;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month % 2 == 0 && (month < 7 && month > 2)) {
            return 30;
        } else {
            System.out.println("There is an error");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(numberOfDaysInMonth(8, 2000));

    }
}

