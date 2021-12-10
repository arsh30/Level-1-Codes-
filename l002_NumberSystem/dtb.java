import java.util.Scanner;

public class dtb {

    public static Scanner scn = new Scanner(System.in);

    public static long decimalToBinary(long n) {
        long pow = 1, res = 0; // 10 raised to power 0

        while (n != 0) {
            // 1st find the remainder
            long remainder = n % 2;
            // 2nd then divide the number and will divide him by only the number that we
            // want to convert binary ie base 2
            n /= 2;

            /*
             * now the answer is from top to bottom but we want that the number should be in
             * reverse form (normal hum number reverse krte
             * hai is formulae se ans = ans * 10 + lastDigit; but in number system the power
             * is increase so we will make it in power form)
             */

            res += remainder * pow; // eg suppose remainder(last digit)0 * 10 raised to power 1, 1 * 10 raised to
                                    // power 2
            pow *= 10; // power is increase by 10
        }
        return res;
    }

    public static void main(String[] args) {
        long n = scn.nextLong();
        System.out.println(decimalToBinary(n));

    }

}