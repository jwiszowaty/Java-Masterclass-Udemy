package ExpressionsStatementsAndMore;

public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour){
        double kilometerInMiles = 1.609;
        double speed = Math.round(kilometersPerHour / kilometerInMiles);
        return (kilometersPerHour >= 0) ? (long) speed : -1;
    }
    public static void printConversion(double kilometersPerHour) {

        if(kilometersPerHour < 0) {
            System.out.print("Invalid Value");
        } else {
            long speedInMiles = toMilesPerHour(kilometersPerHour);
            String message = kilometersPerHour + " km/h = " + speedInMiles + " mi/h";
            System.out.print(message);
        }
    }
}
