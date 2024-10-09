package ExpressionsStatementsAndMore;

public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour){
        double kilometerInMiles = 1.609;
        double speed = Math.round(kilometersPerHour / kilometerInMiles);
        return (kilometersPerHour >= 0) ? (long) speed : -1;
    }
    public static String printConversion(double kilometersPerHour) {

        if(kilometersPerHour < 0) {
            throw new IllegalArgumentException("number must not be negative");
        } else {
            long speedInMiles = toMilesPerHour(kilometersPerHour);
            StringBuilder message = new StringBuilder();
            message.append(kilometersPerHour).append(" km/h = ").append(speedInMiles).append(" mi/h");
            return message.toString();
        }
    }
}
