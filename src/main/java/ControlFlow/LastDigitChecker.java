package ControlFlow;

public class LastDigitChecker {
   public static boolean hasSameLastDigit(int x, int y, int z) {
      if (isValid(x) && isValid(y) && isValid(z)) {
         x %= 10;
         y %= 10;
         z %= 10;
         if (x == y || x == z || y == z) {
            return true;
         }
      }

      return false;
   }

   public static boolean isValid(int number) {
      return number <= 1000 && number >= 10;
   }
}
