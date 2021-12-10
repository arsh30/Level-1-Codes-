import java.util.Scanner;

public class abtab {
    public static Scanner scn = new Scanner(System.in);

    public static long anyBaseToDecimal(long n, long base) {
        long pow = 1, res = 0;
        while (n != 0) {
            long lastDigit = n % 10;
            n /= 10;

            res += lastDigit * pow; //to read from bottom to top
            pow *= base; //power vo hoti hai jisse hme bola convert k liye
        }
        return res;
    }
    
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
        long base1 = scn.nextLong();
        long base2 = scn.nextLong();
        long ans1 = anyBaseToDecimal(n, base1);
        long ans2 = decimalToAnyBase(ans1, base2);
        System.out.println(ans2);
    }
}