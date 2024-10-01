package ControlFlow;

public class LargestPrime {
   public static String getLargestPrime(int number) {
      int factor = 0;
      if (number < 2) {
         throw new IllegalArgumentException("number must be greater than or equal to 2");
      } else {
         for(int i = 2; i * i <= number; ++i) {
            if (number % i == 0) {
               for(factor = i; number % i == 0; number /= i) {
               }
            }
         }

         return Integer.toString(number == 1 ? factor : number);
      }
   }
}
