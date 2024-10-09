package ExpressionsStatementsAndMore;

public class PositiveNegativeZero {
    public static String checkNumber(int number){
        if(number > 0) {
            return "positive";
        } else if(number < 0){
            return "negative";
        } else {
            return "zero";
        }
    }
}
