import java.util.Scanner;

public class binarySubtraction {
    public static Scanner scn = new Scanner(System.in);

    public static long decimalSubtarction(long n, long m) {
        long borrow = 0, res = 0, pow = 1;
        while (n != 0 || m != 0) {
            long sum = (m % 10 + borrow) - n % 10;
            n /= 10;
            m /= 10;

            if (sum < 0) {
                // then take borrow
                sum += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }
            res += sum * pow;
            pow *= 10;

        }
        return res;
    }

    
    public static long binarySubtarction(long n, long m) {
        long borrow = 0, res = 0, pow = 1;
        //m< n
        while (n != 0 || m != 0) {
            long sum = (m % 10 + borrow) - n % 10;
            n /= 10;
            m /= 10;

            if (sum < 0) {
                // then take borrow
                sum += 2;
                borrow = -1;
            } else {
                borrow = 0;
            }
            res += sum * pow;
            pow *= 10;

        }
        return res;
    }

    
    public static void main(String[] args){
        long n = scn.nextLong();
        long m = scn.nextLong();        
    }
}