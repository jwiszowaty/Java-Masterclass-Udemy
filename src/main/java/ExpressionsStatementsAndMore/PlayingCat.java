package ExpressionsStatementsAndMore;

public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature) {
        boolean allYearRoundTemperatureRequirement = (temperature >= 25 && temperature <= 35);
        boolean summerTemperatureRequirement = (temperature >= 25 && temperature <= 45);
        if (allYearRoundTemperatureRequirement || (summer && summerTemperatureRequirement)) {
            return true;
        }
        return false;
    }
}
