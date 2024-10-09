package ExpressionsStatementsAndMore;

public class MinutesToYearsDaysCalculator {
    public static String printYearsAndDays(long minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("number must not be negative");
        } else {

            int oneHourInMinutes = 60;
            int oneDayInHours = 24;
            int oneYearInDays = 365;

            int hours = (int) minutes / oneHourInMinutes;
            int days = (int) hours / oneDayInHours;
            int years = (int) days / oneYearInDays;
            days =  days % oneYearInDays;
            StringBuilder message = new StringBuilder();
            message.append(minutes).append(" min = ").append(years).append(" y and ").append(days).append(" d");
            return message.toString();
        }
    }
}
