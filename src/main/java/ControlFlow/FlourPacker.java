package ControlFlow;

public class FlourPacker {
   public static String canPack(int fiveKilo, int oneKilo, int goal) {
      if (fiveKilo >= 0 && oneKilo >= 0 && goal >= 0) {
         while(fiveKilo != 0 && goal / 5 > 0) {
            goal -= 5;
            --fiveKilo;
         }

         while(oneKilo != 0 && goal > 0) {
            --goal;
            --oneKilo;
         }

         return goal != 0 ? "false" : "true";
      } else {
         return "false";
      }
   }
}
