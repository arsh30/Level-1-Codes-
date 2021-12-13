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

    // 30th dec
    // ques1->
    public static void addTwoArrays_01(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] ans = new int[Math.max(n, m) + 1];

        int i = n - 1, j = m - 1, k = ans.length - 1;
        int carry = 0;
        while (k >= 0) {
            // int sum = carry + a[i] + b[j]; // agar normal aise add krege or jb dono me se
            // koi number chota hogya toh j
            // ki value negative me aa skti hai so if case case se handle krege ki 0 toh
            // nahi toh hi add krege
            int sum = carry;
            if (i >= 0)
                sum += a[i--];
            if (j >= 0)
                sum += b[j--];
            // int sum = carry + (i >= 0 ? a[i--] : 0) + (j >= 0 ? b[j--] : 0);
            ans[k--] = sum % 10;
            carry = sum / 10;
        }
        // handle case agar starting me 0 hoye toh like 000001000
        for (int l = 0; l < ans.length; l++) {
            if (l == 0 && ans[l] == 0)
                continue;
            System.out.println(ans[l]);
        }
    }

    // repeat
    // public static void addTwoArrays(int[] a, int[] b) {
    // int n = a.length, m = b.length;
    // int[] ans = new int[Math.max(n, m) + 1];

    // int i = n - 1, j = m - 1, k = ans.length - 1;
    // int carry = 0;
    // while (k >= 0) {
    // int sum = carry;
    // if (i >= 0)
    // sum += a[i--];
    // if (j >= 0)
    // sum += b[j--];
    // // int sum = carry + (i >= 0 ? a[i--] : 0) + (j >= 0 ? b[j--] : 0);

    // ans[k--] = sum % 10;
    // carry = sum / 10;
    // }

    // for (int l = 0; l < ans.length; l++) {
    // if (l == 0 && ans[l] == 0)
    // continue;
    // System.out.println(ans[l]);
    // }
    // }

    public static void subtractTwoArrays(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] ans = new int[Math.max(n, m)];

        int i = n - 1, j = m - 1, k = ans.length - 1;
        int borrow = 0;
        while (k >= 0) {
            int sum = borrow + (j >= 0 ? b[j--] : 0) - (i >= 0 ? a[i--] : 0);
            // ans[k--] = sum % 10;.yeh krne ki need nhi h kyoki kabhi aisa hoega hi nahi
            // borrow = sum / 10;
            if (sum < 0) {
                sum += 10;
                borrow = -1;
            } else
                borrow = 0;

            ans[k--] = sum;
        }
        // handle case agar starting me 0 hoye toh like 000001000
        // for (int l = 0; l < ans.length; l++) {
        // // if (l == 0 && ans[l] == 0) yeh kabhi hoega hi nahi
        // // continue;
        // System.out.println(ans[l]);
        // }
        boolean is_You_Find_A_Non_Zero_Number = false;
        for (int l = 0; l < ans.length; l++) { // leadig 0 ko rokre h
            if (!is_You_Find_A_Non_Zero_Number && ans[l] == 0)
                continue;
            is_You_Find_A_Non_Zero_Number = true;
            System.out.println(ans[l]);
        }
    }

    // subarray-> total subarrays- > n * n + 1/ 2;
    public static void subArray(int[] arr) { // it require 3 loop
        for (int i = 0; i < arr.length; i++) { // this outer loop travels on the main array
            for (int j = i; j < arr.length; j++) { // goes till the ending point of the array,and only with these 2 loop
                                                   // it print the array

                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + "\t");
                }
                System.out.println();
            }
        }
    }

    // OR 2ND APPRACH SUBARRAY
    public static void subArray_01(int[] arr) { // it require 3 loop
        for (int sp = 0; sp < arr.length; sp++) { // 0-0,0-1,0-2,0-3 (LHS is sp loop , RHS is ep loop)
            for (int ep = sp; ep < arr.length; ep++) { // RHS value loop ie ending point. these 2 loop print the array
                                                       // only
                for (int i = sp; i <= ep; i++) { // travel the loop and print the array from starting to ending point
                    System.out.print(arr[i] + "\t");
                }
                System.out.println();
            }
        }
    }

    // extra ques -> solve the queries problem
    public static int[] prefixSumArray(int[] arr) {
        int[] psum = new int[arr.length + 1]; // 1size bda bnaya or by default in array is 0
        for (int i = 0; i < arr.length; i++) {
            // creae the psum array
            psum[i + 1] = psum[i] + arr[i];
        }
        return psum;
    }

    public static void resolveQuery() { // above function is helper function means jo cheze create krri hai idr se krri
                                        // hai
        // taking input of the given array
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        // call the main function
        int[] psum = prefixSumArray(arr); // note kuch initialise krne ke liye new nhi krna pdhta

        // taking input of the queries
        int q = scn.nextInt();

        while (q-- > 0) {
            int si = scn.nextInt();
            int ei = scn.nextInt();

            System.out.println(psum[ei + 1] - psum[si]); // eg like our psum array is starts with 0 and jo main array
                                                         // hai uska sum 1 aage hi hoga psum ke and calculate krenge

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

/*
 * TIME COMPLEXITIES OF ARRAY AND IMPORTANT TERMS
 * 
 */