package ControlFlow;

public class NumberToWords {
    public static void numberToWords(int number) {
        if (number<0) {
            System.out.println("Invalid Value");
        } else {
            int length = getDigitCount(number);
            number = reverse(number);
            for (int i = 1; i <= length; i++) {
                int lastDigit = number%10;
                switch(lastDigit) {
                    case 1:
                        System.out.print("One ");
                        break;
                    case 2:
                        System.out.print("Two ");
                        break;
                    case 3:
                        System.out.print("Three ");
                        break;
                    case 4:
                        System.out.print("Four ");
                        break;
                    case 5:
                        System.out.print("Five ");
                        break;
                    case 6:
                        System.out.print("Six ");
                        break;
                    case 7:
                        System.out.print("Seven ");
                        break;
                    case 8:
                        System.out.print("Eight ");
                        break;
                    case 9:
                        System.out.print("Nine ");
                        break;
                    default:
                        System.out.print("Zero ");
                }
                number /=10;
            }
        }

    }
    public static int reverse(int number) {
        int reversed = 0;
        while(number != 0 ){
            reversed*=10;
            int lastDigit = number%10;
            reversed += lastDigit;
            number/=10;
        }
        return reversed;
    }
    public static int getDigitCount(int number) {
        if(number < 0) {
            return -1;
        }
        int count = 0;
        do {
            count++;
            number/=10;
        } while(number!=0);
        return count;
    }
}
