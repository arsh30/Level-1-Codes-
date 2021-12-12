import java.util.Scanner;

public class binaryAddition {
    public static Scanner scn = new Scanner(System.in);

    public static long anyBaseAddition(long n, long m, long base) {
        long carry = 0, res = 0, pow = 1;
        while (n != 0 || m != 0 || carry != 0) {
            long sum = carry + n % 10 + m % 10;  //eg 1st number is 256 and 2nd is 753 chota kra unko by dividing 
            n /= 10; //chota dono numbers ko
            m /= 10;

            long lastDigit = sum % base;  //because we are doing with anybase
            carry = sum / base;

            res += lastDigit * pow;  //to reverse
            pow *= 10;  //do this with lcm way divididng 10 because sum nikalte type divide 10 se kra h

        }
        return res;
    }

    public static void main(String[] args) {
        long n = scn.nextLong();
        long m = scn.nextLong();
        long base = scn.nextLong();
        System.out.println(anyBaseAddition(n, m));

    }
}