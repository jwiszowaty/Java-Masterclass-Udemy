package ExpressionsStatementsAndMore;

public class IntEqualityPrinter {
    public static String printEqual(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0) {
            throw new IllegalArgumentException("numbers must not be negative");
        } else {
            boolean allEqual = (x == y && x == z & y == z);
            boolean allDifferent = (x != y && x != z & y != z);

            if (allEqual) {
                return "All numbers are equal";
            } else if (allDifferent) {
                return "All numbers are different";
            } else {
                return "Neither all are equal or different";
            }

        }
    }
}
