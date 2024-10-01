package ControlFlow;

public class NumberOfDaysInMonth {
   public static boolean isLeapYear(int year) {
      if (year >= 1 && year <= 9999) {
         boolean isDivisibleBy4 = year % 4 == 0;
         boolean isDivisibleBy100 = year % 100 == 0;
         boolean isDivisibleBy400 = year % 400 == 0;
         if (isDivisibleBy4 && !isDivisibleBy100 || isDivisibleBy4 && isDivisibleBy100 && isDivisibleBy400) {
            return true;
         }
      }

      return false;
   }

   public static String getDaysInMonth(int month, int year) {
      int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      if (month >= 1 && month <= 12 && year >= 1 && year <= 9999) {
         if (isLeapYear(year)) {
            daysInMonth[1] = 29;
         }

         return Integer.toString(daysInMonth[month - 1]);
      } else {
         throw new IllegalArgumentException("month must be between 1 and 12\nyear must be between 1 and 9999");
      }
   }
}
