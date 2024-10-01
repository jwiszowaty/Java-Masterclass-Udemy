package ControlFlow;

public class FactorPrinter {
   public static String printFactors(int number) {
      StringBuilder numbers = new StringBuilder();
      if (number < 1) {
         throw new IllegalArgumentException("number must be greater than or equal to 1");
      } else {
         for(int i = 1; i <= number; ++i) {
            float dividedFloat = (float)number / (float)i;
            int dividedInt = number / i;
            if (dividedFloat == (float)dividedInt) {
               numbers.append(i).append(" ");
            }
         }

         return numbers.toString();
      }
   }
}
