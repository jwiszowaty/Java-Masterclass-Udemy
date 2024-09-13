package ExpressionsStatementsAndMore;

public class BarkingDog {
    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay){
        if(isBarking && (hourOfDay >= 0 && hourOfDay <= 23)){
            return (hourOfDay < 8 || hourOfDay > 22);
        } else {
            return false;
        }
    }
}
