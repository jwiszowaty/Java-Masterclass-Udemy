package ControlFlow;

public class PerfectNumber {
   public static String isPerfectNumber(int number) {
      if (number < 1) {
         throw new IllegalArgumentException("number must be greater than 1");
      } else {
         int sum = 0;

         for(int i = 1; i < number; ++i) {
            float devided = (float)number / (float)i;
            if (devided == (float)(number / i)) {
               sum += i;
            }
         }

         return sum == number ? "true" : "false";
      }
   }
}
