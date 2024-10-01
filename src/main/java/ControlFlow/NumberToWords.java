package ControlFlow;

public class NumberToWords {
   public static String numberToWords(int number) {
      StringBuilder string = new StringBuilder();
      if (number < 0) {
         throw new IllegalArgumentException("number must not be negative");
      } else {
         int length = getDigitCount(number);
         number = reverse(number);

         for(int i = 1; i <= length; ++i) {
            int lastDigit = number % 10;
            switch(lastDigit) {
            case 1:
               string.append("One ");
               break;
            case 2:
               string.append("Two ");
               break;
            case 3:
               string.append("Three ");
               break;
            case 4:
               string.append("Four ");
               break;
            case 5:
               string.append("Five ");
               break;
            case 6:
               string.append("Six ");
               break;
            case 7:
               string.append("Seven ");
               break;
            case 8:
               string.append("Eight ");
               break;
            case 9:
               string.append("Nine ");
               break;
            default:
               string.append("Zero ");
            }

            number /= 10;
         }

         return string.toString();
      }
   }

   public static int reverse(int number) {
      int reversed;
      for(reversed = 0; number != 0; number /= 10) {
         reversed *= 10;
         int lastDigit = number % 10;
         reversed += lastDigit;
      }

      return reversed;
   }

   public static int getDigitCount(int number) {
      if (number < 0) {
         return -1;
      } else {
         int count = 0;

         do {
            ++count;
            number /= 10;
         } while(number != 0);

         return count;
      }
   }
}
