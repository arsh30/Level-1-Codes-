import java.util.Scanner;

public class l001 {
    public static Scanner scn = new Scanner(System.in);

    public static void display2(int[] arr) { // array pass kra reference pass hota hai means exact copy
        for (int i = 0; i < arr.length; i++) { // arr.length -> java function to find length
            System.out.print(arr[i] + " ");
        }
    }

    public static void test1() {
        int n = scn.nextInt();
        // how to declare array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { // input take
            arr[i] = scn.nextInt();
        }
        // to output
        display2(arr); // yeh reference pass hua hai exact copy upr
    }

    public static int maximum(int[] arr) {
        int maxEle = -(int) 1e9;

        for (int ele : arr) { /*
                               * foreach loop -> it only moves forward by step by step and it only gets the
                               * value and agar hmko position chahiye toh we write normal for loop
                               */

            if (ele > maxEle) {
                maxEle = ele; // maxele ko set krdiya
            }
        }
        return maxEle;
    }

    // ALTERNATE CODE

    public static int maximum2(int[] arr) {
        if (arr.length == 0)
            return -(int) 1e9;

        int maxEle = arr[0]; // here we let the first element as the maxele and then comparing with all
                             // others, jb aise krte hai then we add 1 if statement, for loop is always safe

        for (int ele : arr) {
            if (ele > maxEle) {
                maxEle = ele; // maxele ko set krdiya
            }
        }
        return maxEle;
    }

    public static int minimum(int[] arr) {
        int minEle = (int) 1e9;

        for (int ele : arr) {
            if (ele < minEle) {
                minEle = ele; // maxele ko set krdiya
            }
        }
        return minEle;
    }

    public static boolean findData(int[] arr, int data) {
        for (int ele : arr) {
            if (ele == data) {
                return true;
            }
        }
        return false;
    }

    public static void swap(int[] arr, int i, int j) { // eg 10,20,30
        int temp = arr[i]; // temp = 10
        arr[i] = arr[j]; // 10 = 30 ie 10 ki value 30 se assign hogyi [java always read from right to
                         // left]
        arr[j] = temp; // 30 = 10;
    }

    // for reverse aray-> we need 2 pointer at the begining and in the last
    // si -> starting index ,ei -> ending index
    public static void reverseArray(int[] arr, int si, int ei) { // eh argument niche main se pass hote hai
        while (si < ei) { // means si ei equal na aaje tab tak aage chlte rho
            swap(arr, si, ei);
            si++;
            ei--;
        }
    }

    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        // why % -> jo kai jise rotate agar uski value boht hi bdi hui means jitni array
        // ki
        // length hoti hai utne tak hi reverse hote hai after that repeate hone lgjate
        // hai elements so modulus krege
        k = k % n;

        if (k < 0) { // note: agar negative ko negative to positive me convert krna hota hai toh ussi
                     // number me ik negative lelo and ik plus lelo
            k += n;
        }

        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);

    }

    /*
     * inverse- > means original array me 0 posiition me 1 hai toh inverse array me
     * 1 position pr 0 hoga
     * and 1 pos 2 hai O.A. me then INVERSE ARRAY me 2 position pr hoga
     * so 1st hmko milega original array pr traverse krke
     */
    public static void inverse(int[] arr) {
        int[] inverseAns = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i];
            inverseAns[pos] = i;
        }
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void input(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void main(String[] args) {
        // array is inplace means main me array hota hai ussi ko change krte hai more
        // information in notes
        int n = scn.nextInt();
        int[] arr = new int[n];
        input(arr);// to take input from user
        maximum(arr);
        display(arr); // to display
        // test1();
    }
}