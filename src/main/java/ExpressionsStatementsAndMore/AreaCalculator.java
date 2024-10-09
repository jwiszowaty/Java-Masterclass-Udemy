package ExpressionsStatementsAndMore;

public class AreaCalculator {
    public static double area(double  radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("number must not be negative");
        } else {
            return Math.PI * Math.pow(radius, 2);
        }
    }
    public static double area(double x, double y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("numbers must not be negative");
        } else {
            return x * y;
        }
    }
}
