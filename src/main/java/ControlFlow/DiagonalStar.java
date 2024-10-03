package ControlFlow;

public class DiagonalStar {
   public static String printSquareStar(int number) {
      StringBuilder string = new StringBuilder();
      if (number < 5) {
         throw new IllegalArgumentException("number must be greater than or equal to 5");
      } else {
         for(int i = 1; i <= number; ++i) {
            StringBuilder lineString = new StringBuilder();

            for(int j = 1; j <= number; ++j) {
               if (i != 1 && i != number && j != 1 && j != number && j != i && j != number - i + 1) {
                  lineString.append(" ");
               } else {
                  lineString.append("*");
               }
            }

            string.append(lineString.toString() + "\n");
         }

         return string.toString();
      }
   }
}
