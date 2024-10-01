package ControlFlow;

public class NumberInWord {
   public static String printNumberInWord(int number) {
      String var10000;
      switch(number) {
      case 0:
         var10000 = "ZERO";
         break;
      case 1:
         var10000 = "ONE";
         break;
      case 2:
         var10000 = "TWO";
         break;
      case 3:
         var10000 = "THREE";
         break;
      case 4:
         var10000 = "FOUR";
         break;
      case 5:
         var10000 = "FIVE";
         break;
      case 6:
         var10000 = "SIX";
         break;
      case 7:
         var10000 = "SEVEN";
         break;
      case 8:
         var10000 = "EIGHT";
         break;
      case 9:
         var10000 = "NINE";
         break;
      default:
         var10000 = "OTHER";
      }

      return var10000;
   }
}
