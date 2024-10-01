package ControlFlow;

public class GreatestCommonDivisor {
   public static String getGreatestCommonDivisor(int first, int second) {
      if (first >= 10 && second >= 10) {
         int maxDivisor = 0;

         for(int i = 1; i <= first; ++i) {
            for(int j = 1; j <= second; ++j) {
               float divided1 = (float)first / (float)i;
               float divided2 = (float)second / (float)j;
               if (divided1 == (float)(first / i) && divided2 == (float)(second / j)) {
                  maxDivisor = i == j ? j : maxDivisor;
               }
            }
         }

         return Integer.toString(maxDivisor);
      } else {
         throw new IllegalArgumentException("numbers must be greater than 10");
      }
   }
}
