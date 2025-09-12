package ca.bcit.comp2522.bank;

/**
 *
 */
public class Date {
    private final int year;
    private final int month;
    private final int day;
    private static final int DAY_ONE = 1;
    private static final int REMAINDER_OF_ZERO = 0;
    private static final int STARTING_OFFSET_ZERO = 0;
    private static final int LAST_TWO_DIGITS_OF_THOUSANDTHS = 100;
    private static final int DIVISION_BY_SEVEN = 7;
    private static final int DIVISION_BY_TWELVE = 12;
    private static final int DIVISION_BY_FOUR = 4;
    private static final int MULTIPLICATION_BY_TWELVE = 12;
    private static final int YEAR_NINETEEN_HUNDREDS = 1900;
    private static final int YEAR_NINETEEN_NINETY_NINE = 1999;
    private static final int OFFSET_INCREASE_SIX = 6;
    private static final int OFFSET_TWO = 2;
    private static final int MONTH_FIRST_SECOND = 2;
    private static final int YEAR_DIVISOR_FOUR_HUNDRED = 400;
    private static final int YEAR_DIVISOR_FOUR = 4;
    private static final int YEAR_DIVISOR_ONE_HUNDRED = 100;
    private static final int HIGHEST_MONTH_DAYS = 31;
    private static final int MONTH_WITH_THIRTY_DAYS = 30;
    private static final int LOWEST_NUMBER_OF_DAYS_IN_MONTH = 28;
    private static final int LEAP_YEAR_MONTH = 29;
    private static final int MONTH_DIVIDED_BY_TWO = 2;
    private static final int LOWEST_YEAR_ALLOWED = 1800;
    private static final int CURRENT_YEAR = 2025;
    private static final int DAY_OF_WEEK_SATURDAY = 0;
    private static final int DAY_OF_WEEK_SUNDAY = 1;
    private static final int DAY_OF_WEEK_MONDAY = 2;
    private static final int DAY_OF_WEEK_TUESDAY = 3;
    private static final int DAY_OF_WEEK_WEDNESDAY = 4;
    private static final int DAY_OF_WEEK_THURSDAY = 5;
    private static final int DAY_OF_WEEK_FRIDAY = 6;
    private static final int monthCode_JAN = 1;
    private static final int monthCode_FEB = 4;
    private static final int monthCode_MAR = 4;
    private static final int monthCode_APR = 0;
    private static final int monthCode_MAY = 2;
    private static final int monthCode_JUN = 5;
    private static final int monthCode_JUL = 0;
    private static final int monthCode_AUG = 3;
    private static final int monthCode_SEP = 6;
    private static final int monthCode_OCT = 1;
    private static final int monthCode_NOV = 4;
    private static final int monthCode_DEC = 6;
    private static final int MONTH_JAN = 1;
    private static final int MONTH_FEB = 2;
    private static final int MONTH_MAR = 3;
    private static final int MONTH_APR = 4;
    private static final int MONTH_MAY = 5;
    private static final int MONTH_JUN = 6;
    private static final int MONTH_JUL = 7;
    private static final int MONTH_AUG = 8;
    private static final int MONTH_SEP = 9;
    private static final int MONTH_OCT = 10;
    private static final int MONTH_NOV = 11;
    private static final int MONTH_DEC = 12;

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
    public Date(final int year,
                final int month,
                final int day) {
        Validation.validateNumber(year, LOWEST_YEAR_ALLOWED, CURRENT_YEAR);
        Validation.validateNumber(month, MONTH_JAN, MONTH_DEC);

        this.year = year;
        this.month = month;

        Validation.validateNumber(day, DAY_ONE, numberOfDaysInMonth(month, year));

        this.day = day;
    }

    /**
     * Getter method for instance variable day.
     * @return returns the value of day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Getter method for instance variable year.
     * @return returns the value of year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Getter method for instance variable month.
     * @return returns the value of month
     */
    public int getMonth() {
        return this.month;
    }


    /**
     * This function takes in yyyymmdd and formats it
     * @return the year month day formatted yyyymmdd
     */
    public String getYyyyMmDd() {
        return this.year + "-" +  this.month + "-" + this.day;
    }

    /**
     * uses an algorithm given and finds the day of the week
     * @return returns the day of the week accurate for 1800 - 2000s
     */
    public String getDayOfWeek() {
        int offset = STARTING_OFFSET_ZERO;
        if (year < YEAR_NINETEEN_HUNDREDS) {
            offset += OFFSET_TWO;
        } else if (year > YEAR_NINETEEN_NINETY_NINE) {
            offset += OFFSET_INCREASE_SIX;
        }
        if (isLeapYear(year) && month <= MONTH_FIRST_SECOND) {
            offset += OFFSET_INCREASE_SIX;
        }
        //This takes month code based on algorithm to be able to determine day of the week/l
        int monthCode;
        if (month == MONTH_JAN) {
           monthCode = monthCode_JAN;
        } else if (month == MONTH_FEB) {
            monthCode = monthCode_FEB;
        } else if (month == MONTH_MAR) {
            monthCode = monthCode_MAR;
        } else if (month == MONTH_APR) {
            monthCode = monthCode_APR;
        } else if (month == MONTH_MAY) {
            monthCode = monthCode_MAY;
        } else if (month == MONTH_JUN) {
            monthCode = monthCode_JUN;
        } else if (month == MONTH_JUL) {
            monthCode = monthCode_JUL;
        } else if (month == MONTH_AUG) {
            monthCode = monthCode_AUG;
        } else if (month == MONTH_SEP) {
            monthCode = monthCode_SEP;
        } else if (month == MONTH_OCT) {
            monthCode = monthCode_OCT;
        } else if (month == MONTH_NOV) {
            monthCode = monthCode_NOV;
        } else if (month == MONTH_DEC) {
            monthCode = monthCode_DEC;
        } else {
            throw new IllegalArgumentException("this is not a valid month " + month);
        }

        final int year_remainder = year % LAST_TWO_DIGITS_OF_THOUSANDTHS;
        final int twelves_in_year = year_remainder / DIVISION_BY_TWELVE;
        final int year_digits_minus_twelves_in_year = year_remainder - twelves_in_year * MULTIPLICATION_BY_TWELVE;
        final int fours_in_digits_minus_twelve = year_digits_minus_twelves_in_year/ DIVISION_BY_FOUR;
        final int day_of_month_add = day + twelves_in_year +
                year_digits_minus_twelves_in_year + fours_in_digits_minus_twelve;
        final int monthCode_calc = day_of_month_add + monthCode + offset;
        final int day_of_week = monthCode_calc % DIVISION_BY_SEVEN;

        if (day_of_week == DAY_OF_WEEK_SUNDAY) {
            return "Sunday";
        }
        if (day_of_week == DAY_OF_WEEK_SATURDAY) {
            return "Saturday";
        }
        if (day_of_week == DAY_OF_WEEK_MONDAY) {
            return "Monday";
        }
        if (day_of_week == DAY_OF_WEEK_TUESDAY) {
            return "Tuesday";
        }
        if (day_of_week == DAY_OF_WEEK_WEDNESDAY) {
            return "Wednesday";
        }
        if (day_of_week == DAY_OF_WEEK_THURSDAY) {
            return "Thursday";
        }
        if (day_of_week == DAY_OF_WEEK_FRIDAY) {
            return "Friday";
        }
        throw new IllegalArgumentException("Nothing worked");
    }

    /**
     * takes in a year and returns if it is a leap year or not
     * @param year takes in year
     * @return true if leap year false if not
     */
    private static boolean isLeapYear(final int year) {
        return (year % YEAR_DIVISOR_FOUR == REMAINDER_OF_ZERO && year % YEAR_DIVISOR_ONE_HUNDRED != REMAINDER_OF_ZERO)
                || (year % YEAR_DIVISOR_FOUR_HUNDRED == REMAINDER_OF_ZERO);
    }

    /**
     * This returns the number of days in a month based on the month and checks if
     * it is a leap year or not
     * @param month takes month checks days
     * @param year takes year makes sure it is not a leap year
     * @return days in a month given
     */
    private static int numberOfDaysInMonth(final int month, final int year) {
        if (month % MONTH_DIVIDED_BY_TWO != REMAINDER_OF_ZERO && month < MONTH_JUL) {
           return HIGHEST_MONTH_DAYS;
        } else if ((month % MONTH_DIVIDED_BY_TWO == REMAINDER_OF_ZERO) && (month > MONTH_JUN && month <= MONTH_DEC)) {
            return HIGHEST_MONTH_DAYS;
        } else if (month == MONTH_FEB) {
            if (isLeapYear(year)) {
                return LEAP_YEAR_MONTH;
            } else {
                return LOWEST_NUMBER_OF_DAYS_IN_MONTH;
            }
        } else if ((month % MONTH_DIVIDED_BY_TWO == REMAINDER_OF_ZERO && (month <= MONTH_JUL && month > MONTH_FEB)
                || (month > MONTH_JUN && month % MONTH_DIVIDED_BY_TWO != REMAINDER_OF_ZERO))) {
            return MONTH_WITH_THIRTY_DAYS;
        } else {
            throw new IllegalArgumentException("That is not a valid month");
        }
    }

    /**
     * Method to return the name of the month.
     * @param month month to get the name of
     * @return will return the month name (i.e. January for month 1)
     */
    private String getMonthName(final int month) {
        if (month == MONTH_JAN) {
            return "January";
        } else if (month == MONTH_FEB) {
            return "February";
        } else if (month == MONTH_MAR) {
            return "March";
        } else if (month == MONTH_APR) {
            return "April";
        } else if (month == MONTH_MAY) {
            return "May";
        } else if (month == MONTH_JUN) {
            return "June";
        } else if (month == MONTH_JUL) {
            return "July";
        } else if (month == MONTH_AUG) {
            return "August";
        } else if (month == MONTH_SEP) {
            return "September";
        } else if (month == MONTH_OCT) {
            return "October";
        } else if (month == MONTH_NOV) {
            return "November";
        } else {
            return "December";
        }
    }

    /**
     * Method to print the full date as a string.
     *
     * @return will return Date in format Day, Month Day#, Year (i.e. Thursday, July 20, 2023)
     */
    public String toString() {
        return getDayOfWeek() + ", " + getMonthName(month) + " " + day + ", " + year;
    }
}

