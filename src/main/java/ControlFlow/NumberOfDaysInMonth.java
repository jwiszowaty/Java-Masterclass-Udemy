package ControlFlow;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {

        if (year >= 1 && year <= 9999) {

            boolean isDivisibleBy4 = (year % 4 == 0);
            boolean isDivisibleBy100 = (year % 100 == 0);
            boolean isDivisibleBy400 = (year % 400 == 0);

            if ((isDivisibleBy4 && !isDivisibleBy100) || (isDivisibleBy4 && isDivisibleBy100 && isDivisibleBy400)) {
                return true;
            }

        }
        return false;
    }
    public static int getDaysInMonth(int month, int year) {

        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        } else if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        return daysInMonth[month-1];
    }
}
