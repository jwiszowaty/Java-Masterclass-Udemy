package ExpressionsStatementsAndMore;

public class PositiveNegativeZero {
    public static void checkNumber(int number){
        if(number > 0) {
            System.out.print("positive");
        } else if(number < 0){
            System.out.print("negative");
        } else {
            System.out.print("zero");
        }
    }
}
