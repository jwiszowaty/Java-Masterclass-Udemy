package ControlFlow;

public class NumberPalindrome {
   public static boolean isPalindrome(int number) {
      int initial = number;

      int reversed;
      for(reversed = 0; initial != 0; initial /= 10) {
         reversed = reversed * 10 + initial % 10;
      }

      return reversed == number;
   }
}
