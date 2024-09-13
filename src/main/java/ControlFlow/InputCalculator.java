package ControlFlow;

import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        // write code here
        float sum = 0;
        long avg = 0;
        float count = 0.0f;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                String nextEntry = scanner.nextLine();
                float num = Integer.parseInt(nextEntry);
                sum += num;
                avg = (long) Math.ceil(sum/++count);
            } catch(NumberFormatException nfe) {
                break;
            }
        }
        System.out.print("SUM = " + (int) sum + " AVG = " + avg);
    }
}
