package ca.bcit.comp2522.bank;

public class Date {
    private final int year;
    private final int month;
    private final int day;
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
    private static final int MONTH_JAN = 1;
    private static final int LOWEST_YEAR_ALLOWED = 1800;
    private static final int CURRENT_YEAR = 2025;
    private static final int MONTH_CODE_JAN = 1;
    private static final int MONTH_CODE_FEB = 4;
    private static final int MONTH_CODE_MAR = 4;
    private static final int MONTH_CODE_APR = 0;
    private static final int MONTH_CODE_MAY = 2;
    private static final int MONTH_CODE_JUN = 5;
    private static final int MONTH_CODE_JUL = 0;
    private static final int MONTH_CODE_AUG = 3;
    private static final int MONTH_CODE_SEP = 6;
    private static final int MONTH_CODE_OCT = 1;
    private static final int MONTH_CODE_NOV = 4;
    private static final int MONTH_CODE_DEC = 6;


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
        Validation.validateNumber(month, MONTH_JAN, MONTH_DECEMBER);

        this.year = year;
        this.month = month;

        Validation.validateNumber(day, 1, numberOfDaysInMonth(month, year));

        this.day = day;
    }


    public int getDay() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    /**
     * This function takes in yyyymmdd and formats it
     * @param year
     * @param month
     * @param day
     * @return the year month day formatted yyyymmdd
     */
    public static String getYyyyMmDd(final int year, final int month, final int day) {
        return year + "-" +  month + "-" + day;
    }


    /**
     * uses an algorithm given and finds the day of the week
     * @param year
     * @param month
     * @param day
     * @return returns the day of the week accurate for 1800 - 2000s
     */
    public static String getDayOfWeek(final int year, final int month, final int day) {
        int offset;
        if (year < 1900) {
            offset += 2;
        } else if (year > 1999) {
            offset += 6;
        }

        if (isLeapYear(year)) {
            offset += 6;
        }

        final int month_code;
        if (month == 1) {
           month_code = MONTH_CODE_JAN;
        } else if (month == 2) {
            month_code = MONTH_CODE_FEB;
        } else if (month == 3) {
            month_code = MONTH_CODE_MAR;
        } else if (month == 4) {
            month_code = MONTH_CODE_APR;
        } else if (month == 5) {
            month_code = MONTH_CODE_MAY;
        } else if (month == 6) {
            month_code = MONTH_CODE_JUN;
        } else if (month == 7) {
            month_code = MONTH_CODE_JUL;
        } else if (month == 8) {
            month_code = MONTH_CODE_AUG;
        } else if (month == 9) {
            month_code = MONTH_CODE_SEP;
        } else if (month == 10) {
            month_code = MONTH_CODE_OCT;
        } else if (month == 11) {
            month_code = MONTH_CODE_NOV;
        } else if (month == 12) {
            month_code = MONTH_CODE_DEC;
        }

        final int year_remainder = year % 100;
        final int twelves_in_year = year_remainder / 12;
        final int year_digits_minus_twelves_in_year = yearRemainder - twelves_in_year * 12;
        final int fours_in_digits_minus_twelve = year_digits_minus_twelves_in_year/ 4;
        final int day_of_month_add = day + twelves_in_year +
                years_digits_minus_twelves_in_year + fours_in_digits_minus_twelve;
        final int month_code_calc = day_of_the_month_add + month_code + offset;
        final int day_of_week = month_code_calc % 7;

        if (day_of_week == 0) {
            return "SUNDAY";
        } else if (day_of_week == 1) {
            return "SATURDAY";
        } else if (day_of_week == 2) {
            return "MONDAY";
        } else if (day_of_week == 3) {
            return "TUESDAY";
        } else if (day_of_week == 4) {
            return "WEDNESDAY";
        } else if (day_of_week == 5) {
            return "THURSDAY";
        } else if (day_of_week == 6) {
            return "FRIDAY";
        }
    }


    /**
     * takes in a year and returns if it is a leap year or not
     * @param year
     * @return true if leap year false if not
     */
    private static boolean isLeapYear(final int year) {
        return (year % YEAR_DIVISOR_FOUR == 0 && year % YEAR_DIVISOR_ONE_HUNDRED != 0)
                || (YEAR_DIVISOR_FOUR_HUNDRED == 0);
    }


    /**
     * This returns the number of days in a month based on the month and checks if
     * it is a leap year or not
     * @param month takes month checks days
     * @param year takes year makes sure it is not a leap year
     * @return days in a month given
     */
    private static int numberOfDaysInMonth(final int month, final int year) {
        if (month % MONTH_DIVIDED_BY_TWO != 0 && month < MONTH_JULY) {
           return HIGHEST_MONTH_DAYS;
        } else if ((month % MONTH_DIVIDED_BY_TWO == 0) && (month > MONTH_JUNE && month <= MONTH_DECEMBER)) {
            return HIGHEST_MONTH_DAYS;
        } else if (month == MONTH_FEB) {
            if (isLeapYear(year)) {
                return LEAP_YEAR_MONTH;
            } else {
                return LOWEST_NUMBER_OF_DAYS_IN_MONTH;
            }
        } else if ((month % MONTH_DIVIDED_BY_TWO == 0 && (month <= MONTH_JULY && month > MONTH_FEB)
                || (month > MONTH_JUNE && month % MONTH_DIVIDED_BY_TWO != 0))) {
            return MONTH_WITH_THIRTY_DAYS;
        } else {
            throw new IllegalArgumentException("That is not a valid month");
        }
    }


    public static void main(final String[] args) {
        Date d = new Date(1800, 12, 1);
//        System.out.println(numberOfDaysInMonth(8, 2000));
        System.out.println(d.getMonth());
        System.out.println(1977 % 100);
    }
}

