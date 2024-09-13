package ControlFlow;

public class LargestPrime {
    public static int getLargestPrime(int number) {
        int factor = 0;
        if (number >= 2) {
            for (int i = 2; i * i <= number; i++) {
                if (number%i != 0) {
                    continue;
                }
                factor = i;
                while (number%i == 0) {
                    number /= i;
                }
            }
            return number == 1 ? factor : number;
        }
        return -1;
    }
}
