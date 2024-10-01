package ControlFlow;

public class FirstLastDigitSum {
   public static String sumFirstAndLastDigit(int number) {
      if (number < 0) {
         throw new IllegalArgumentException("number must be greater than 0");
      } else {
         int sum = 0;

         for(sum = sum + number % 10; number > 9; number /= 10) {
         }

         sum += number;
         return Integer.toString(sum);
      }
   }
}
