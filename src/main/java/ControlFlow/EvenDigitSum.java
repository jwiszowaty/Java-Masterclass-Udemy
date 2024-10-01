package ControlFlow;

import lombok.Generated;

public class EvenDigitSum {
   public static String getEvenDigitSum(int number) {
      if (number < 0) {
         throw new IllegalArgumentException("number must be greater than or equal to 0");
      } else {
         int sum = 0;
         while (number != 0) {
            int lastDigit = number % 10;
            number /= 10;
            if (lastDigit % 2 == 0) {
               sum += lastDigit;
            }
         }
         return Integer.toString(sum);
      }
   }
}
