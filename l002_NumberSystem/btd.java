import java.util.Scanner;

public class btd {
    public static Scanner scn = new Scanner(System.in);

    public static long binaryToDecimal(long n) {
        long pow = 1, res = 0; // 10 raise power 1
        while (n != 0) {
            long lastDigit = n % 10; // 1st step jisme number me convert krna hai uss base se divide
            n /= 10;

            res += lastDigit * pow;
            pow *= 2; // power multiply hoegi jidr se convert krna hai uska base ie binary
        }
        return res;
    }

    public static void main(String[] args) {
        long n = scn.nextLong();
        System.out.println(binaryToDecimal(n));
    }

}