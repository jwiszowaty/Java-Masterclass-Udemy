package ControlFlow;

public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if(first < 10 || second < 10) {
            return -1;
        }
        int maxDivisor = 0;
        for (int i = 1; i <= first; i++) {
            for (int j = 1; j <= second; j++) {
                float divided1 = (float) first/i;
                float divided2 = (float) second/j;
                if (divided1 == first/i && divided2 == second/j) {
                    maxDivisor = (i == j) ? j : maxDivisor;
                }
            }
        }
        return maxDivisor;
    }
}
