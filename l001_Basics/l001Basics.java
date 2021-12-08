import java.util.Scanner;

public class l001Basics {
    public static Scanner scn = new Scanner(System.in);

    public static int multiply(int a, int b) { // note: jb kuch return tb main me kisi variable me catch krte h always
        int c = a * b;
        return c;
    }

    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static int subtract(int a, int b) {
        int c = a - b;
        return c;
    }

    public static int divide(int a, int b) {
        int c = a / b;
        return c;
    }

    public static void printMessage() { // jb return type void ho then we only just call the function kisi me catch
                                        // vgara nahi krte
        System.out.println("hello this is arsh");
    }

    // public static void main(String[] args) { //static means sbse phle compile
    // hoti hai
    // //java jo input leti hai vo String.args se leti hai
    // System.out.println("hello"); //ln is for nextLine
    // System.out.print("pepcoder");
    // }

    // START WITH FUNCTIONS

    // ques1 printz
    public static void printZ() {
        System.out.println("*****");
        System.out.println("   *");
        System.out.println("  *");
        System.out.println(" *");
        System.out.println("*****");
    }

    // ques2 -> Grading System
    public static void gradingSystem(int marks) {
        if (marks > 90) {
            System.out.println("excellent");
        } else if (marks > 80 && marks <= 90) {
            System.out.println("good");
        } else if (marks > 70 && marks <= 80) {
            System.out.println("fair");
        } else if (marks > 60 && marks <= 70) {
            System.out.println("meets expectations");
        } else {
            System.out.println("below par");
        }
    }

    /*
     * NOTE: JO Cheez return krta hai function usko hm niche jo main hota hai udr
     * catch krege then print krwaege
     * 2) Jo void hota usko dirct call lgate hai hm
     * 3) jo variable bnte hai vo niche se reference jata hai ie means jo bhi upr
     * variable use krne hai vo niche bante hai
     */

    // CLASS 2: 23 DEC===========================================

    /*
     * [NOTE -> jbhi java ki file compile krte hai tb ">" jiski taraf muh open hota
     * usme se read krta hai and jiski taraf tika arrow hota usme throw krta file
     * command: javac l001Basics.java && java l001Basics < input.txt > output.txt]
     * 
     * for loop -> for (int i = 0; i < 10; i++); 1st argument is initialiser yeh 1
     * time hi bnate hai, 2nd argument is "condition", 3rd argument is incr or
     * decrem
     * 
     * while loop - > initailise;
     * while(condion){
     * do task;
     * incre; we do this increment in the end of the while loop
     * }
     */
    public static void printNTime(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println("hello");
        }
    }

    // ques1:
    public static void printTableOfN(int n) { // in java automatically type caste in the string
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + "X" + i + "=" + n * i);
        }
    }

    // ques2 -> print table till m
    public static void printTableTillM(int m) {
        for (int i = 1; i <= m; i++) {
            printTableOfN(i);
            System.out.println();
        }
    }

    // ques3 -> odd and even [means n no milege input sbke liye btayege ki od hai
    // even]
    public static void oddEven(int n) {
        if (n % 2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }

    public static void checkNforOddEven() {
        int n = scn.nextInt(); // we get n input (means total kitne number h) and check for each number
                               // wheteher it is odd or not
        for (int i = 1; i <= n; i++) {
            int a = scn.nextInt(); // and check the each number it is odd or even
            oddEven(a);
        }
    }

    /*
     * ques4 -> IsPrime [prime no are those which divide only by itself and 1]
     * 
     * 2) means if it divide between in the range [2 to N-1] mean no is not prime0
     */
    public static boolean isPrime(int n) { // not prime -> if it divides between 2 to N-1
        // for (int i = 2; i < n; i++) {
        for (int i = 2; i * i <= n; i++) { // optimization version i is divisor jo which come in the denominator
            if (n % i == 0) // agar complete dvide hogya toh not prime
                return false;
        }
        return true;
    }

    public static void primeNumber() {
        int t = scn.nextInt(); // means we have given t numbers input eg t = 5;
        for (int i = 0; i <= t; i++) {
            int n = scn.nextInt(); // means t ke andr ke 15 number har ik liye btare h ki vo prime h ya nahi

            if (isPrime(n)) {
                System.out.println("Number is prime");
            } else {
                System.out.println("Number is Not Prime");
            }
        }
    }

    // ques5 -> prime no till N [we given 2 numbers low,high,print all primeNumber
    // between them]
    public static void primeTillN(int low, int high) {
        for (int i = low; i <= high; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }

    // ques6 -> print Fibonacci till N [0,1,1,2,3,5]


    // ques7 -> count digit of A number

    /*
     * agar hm number ko sirf 10 se divide krte hai then the number will get short,
     * so har divide pr changes aate hai mmeans number chota hota hai
     * 
     * [doubt:-> isme hm modulus kyo nhi usse kra because hme yeh nahi pta ki rukna
     * kidr hai and modulus gives us remainder ie 0 , therefore 0 is also a digit
     * Eg:-> 1000 length is 4] but jb isko modulus krege then we will get 0 pta kese
     * lgae ki digit aani band hogyi hai
     * 
     * 2) Use WHILE LOOP -> Mostly used When we dont know the exact idea when will
     * we stop
     * 
     */
    public static int countDigits(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    // ques8 -> Print in a Reverse
    public static void reverse(int n) {
        while (n != 0) {
            int lastDigit = n % 10; // means divide krege remainder ko print krege just
            n = n / 10;
            System.out.println(lastDigit);
        }
    }

    // ques9 -> Reverse number
    public static int reverseNumber(int n) {
        int ans = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            n = n / 10;

            ans = ans * 10 + lastDigit; // eg: 123 => 0 * 10 + 3 = 3
        } // ans = 3 * 10 + 2 = 32;
        return ans;
    }

    //==============================================================
    //CLASS3 -> 26TH DEC PATTERNS on different file

    public static void main(String[] args) {
        // int a = scn.nextInt(); // in java:if we take the input first we import the
        // scanner and make public
        // // static scanner scn = new scanner(system,in) then make variables in main
        // int b = scn.nextInt();

        // System.out.println(multiply(a, b));
        // System.out.println(add(a, b));
        // System.out.println(subtract(a, b));
        // System.out.println(divide(a, b));

        // printZ();
        // int marks = scn.nextInt();
        // gradingSystem(marks);
        // int n = scn.nextInt();
        // printNTime(n);
        // printTableOfN(n);
        // printTableTillM(n);
        // int n = scn.nextInt(); // idr use krne k liye pass bhi krege
        int low = scn.nextInt();
        int high = scn.nextInt();

        // oddEven(n);
        // primeNumber();
        primeTillN(low, high); // idr arguments me vo pass krte hai jo hmne idr declare kra aur upr function me
                               // jo mrji pass krlo

    }
}