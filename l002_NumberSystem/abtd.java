import java.util.Scanner;

public class abtd {
    public static Scanner scn = new Scanner(System.in);

    public static long anyBaseToDecimal(long n,long base) {
        long pow = 1, res = 0;
        while (n != 0) {
            long lastDigit = n % 10;
            n /= 10;

            res += lastDigit * pow;  //to read from bottom to top
            pow *= base;  //power vo hoti hai jisse hme bola convert k liye
        }
        return res;
    }
    
    public static void main(String[] args) {
        long n = scn.nextLong();
        long base = scn.nextLong();
        long base1 = scn.nextLong();  //for piping
        System.out.println(anyBaseToDecimal(n, base));
        System.out.println(base1);
    }

}