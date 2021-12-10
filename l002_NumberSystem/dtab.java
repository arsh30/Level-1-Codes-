import java.util.Scanner;

public class dtab {
    public static Scanner scn = new Scanner(System.in);

    public static long decimalToAnyBase(long n, long base) {
        long pow = 1, res = 0;
        while (n != 0) {
            long remainder = n % base;
            n /= base;

            res += remainder * pow; // to read from bottom to top
            pow *= 10; // multiply with 10 because jo given number tha vo decimal me hai
        }
        return res;
    }

    public static void main(String[] args) {
        long n = scn.nextLong();
        long base = scn.nextLong();
        System.out.println(decimalToAnyBase(n, base));
        
    }

}