import java.util.Scanner;

public class anybaseMultiplication {
    public static Scanner scn = new Scanner(System.in);

    public static long multiplyNumberWithDigit(long n, long digit, long base, long pow) {
        long res = 0,carry = 0;
        //yeh function sirf single digit multiply krega ie with 10 to the power 0
        while (n != 0) {
            long sum = (n % 10) * digit + carry;
            long lastDigit = sum % base;
            carry = sum / base;

            res += lastDigit * pow;
            pow *= 10;
        }
        return res;
    }
}