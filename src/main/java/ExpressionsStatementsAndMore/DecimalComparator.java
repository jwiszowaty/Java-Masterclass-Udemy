package ExpressionsStatementsAndMore;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double x, double y) {

        double xDecimals = x * 1000;
        double yDecimals = y * 1000;

        long xThreeDecimals = (long) xDecimals;
        long yThreeDecimals = (long) yDecimals;

        return xThreeDecimals == yThreeDecimals;
    }
}
