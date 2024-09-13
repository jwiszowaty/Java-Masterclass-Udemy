package ControlFlow;

public class SharedDigit {
    public static boolean hasSharedDigit(int x, int y) {
        if (x <10 || x >99||y<10||y>99) {
            return false;
        }
        while(x != 0) {
            int xDigit = x%10;
            int yOriginal = y;
            x /= 10;
            while(y != 0){
                int yDigit = y%10;
                y /= 10;
                if(xDigit == yDigit) {
                    return true;
                }
            }
            y = yOriginal;
        }
        return false;
    }
}
