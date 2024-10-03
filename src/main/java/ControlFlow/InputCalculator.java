package ControlFlow;

import java.util.Scanner;

public class InputCalculator {
   public static void inputThenPrintSumAndAverage() {
      float sum = 0.0F;
      long avg = 0L;
      float count = 0.0F;
      Scanner scanner = new Scanner(System.in);

      while (true) {
         try {
            String nextEntry = scanner.nextLine();
            float num = (float) Integer.parseInt(nextEntry);
            sum += num;
            avg = (long) Math.ceil((double) (sum / ++count));
            scanner.close();
         } catch (NumberFormatException var7) {
            System.out.print("SUM = " + (int) sum + " AVG = " + avg);
            scanner.close();
         }
      }
      
      
   }
}
