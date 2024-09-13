package ControlFlow;

public class FlourPacker {
    public static boolean canPack(int fiveKilo, int oneKilo, int goal) {
        if (fiveKilo < 0 || oneKilo < 0 || goal < 0) {
            return false;
        }
        while (fiveKilo != 0 && goal/5 > 0) {
            goal -= 5;
            fiveKilo--;
        }
        while (oneKilo!=0 && goal > 0){
            goal -= 1;
            oneKilo--;
        }
        if (goal!=0) {
            return false;
        }
        return true;
    }
}
