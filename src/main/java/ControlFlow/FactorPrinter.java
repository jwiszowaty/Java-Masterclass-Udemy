package ControlFlow;

public class FactorPrinter {
    public static void printFactors(int number) {
        if(number < 1) {
            System.out.print("Invalid Value");
        }
        for (int i = 1; i <= number; i++) {
            float dividedFloat = (float) number / i;
            int dividedInt = number / i;
            if (dividedFloat == dividedInt) {
                System.out.print(i + " ");
            }
        }
    }
}
