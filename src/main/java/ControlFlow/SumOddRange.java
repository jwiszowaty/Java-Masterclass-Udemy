package ControlFlow;

public class SumOddRange {
   public static boolean isOdd(int number) {
      return number % 2 == 1;
   }

   public static String sumOdd(int start, int end) {
      if (start >= 0 && end >= 0 && end >= start) {
         int sum = 0;

         for(int i = start; i <= end; ++i) {
            if (isOdd(i)) {
               sum += i;
            }
         }

         return Integer.toString(sum);
      } else {
         throw new IllegalArgumentException("number must not be negative AND start must be lower than end");
      }
   }
}
