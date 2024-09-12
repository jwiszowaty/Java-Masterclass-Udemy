package ControlFlow;

public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        int initial = number;
        int reversed = 0;
        while(initial != 0) {
            reversed = reversed*10 + initial%10;
            initial /= 10;
        }
        return reversed == number;
    }
}
