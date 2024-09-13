package ExpressionsStatementsAndMore;

public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.print("Invalid Value");
        } else {

            int oneHourInMinutes = 60;
            int oneDayInHours = 24;
            int oneYearInDays = 365;

            int hours = (int) minutes / oneHourInMinutes;
            int days = (int) hours / oneDayInHours;
            int years = (int) days / oneYearInDays;
            days =  days % oneYearInDays;

            System.out.print(minutes + " min" + " = " + years + " y and " + days + " d");
        }
    }
}
