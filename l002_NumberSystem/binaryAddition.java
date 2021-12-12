import java.util.Scanner;

public class binaryAddition {
    public static Scanner scn = new Scanner(System.in);

    public static long binaryAddition(long n, long m) {
        long carry = 0, res = 0, pow = 1;
        while (n != 0 || m != 0 || carry != 0) {
            long sum = 0;
            sum += (carry + n + m) % 10;  //we do 1st divide with 10 because -> 1st think about decimal addition
            n /= 10; //chota dono numbers ko
            m /= 10;

            long lastDigit = sum % 2;
            carry = sum / 2;

            res += lastDigit * pow;  //to reverse
            pow *= 10;  //do this with lcm way divididng

        }
        return res;
    }

    public static void main(String[] args) {
        long n = scn.nextLong();
        long m = scn.nextLong();
        System.out.println(binaryAddition(n, m));

    }
}