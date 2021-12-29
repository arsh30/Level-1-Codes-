import java.util.Scanner;

public class l001 {

  public static Scanner scn = new Scanner(System.in);

  public static void printIncreasing_(int a, int b) {
    // base case is very important in the recursion and in recursion each function is different
    // eg:PrintInc is P and then it calling itself so consider this is an P.P (means different stack aise behave krta hai), if ppp is main function and
    // other is pppp agar 3 ppp wale me kuch change hua toh niche wale function wale pr koi asar nhi pdhega

    System.out.println("hi" + a);
    printIncreasing(a + 1, b);
    System.out.println("bye" + a);
  }

  public static void printIncreasing(int a, int b) {
    if (a == b + 1) return;

    printIncreasing(a + 1, b);
    System.out.println("bye" + a);
    a += 10; //idr a ki value set krne se koi farak pdhega? no it is used anywhere
  }

  public static void pppppp(int a) {
    return;
  }

  public static void ppppp(int a) {
    System.out.println("hi" + " " + a);
    pppppp(a + 1);
    System.out.println("bye" + " " + a);
  }

  public static void pppp(int a) {
    System.out.println("hi" + " " + a);
    ppppp(a + 1);
    System.out.println("bye" + " " + a);
  }

  public static void ppp(int a) {
    System.out.println("hi" + " " + a);
    pppp(a + 1);
    System.out.println("bye" + " " + a);
  }

  public static void pp(int a) {
    System.out.println("hi" + " " + a);
    ppp(a + 1);
    System.out.println("bye" + " " + a);
  }

  public static void p(int a) {
    System.out.println("hi" + " " + a);
    pp(a + 1);
    System.out.println("bye" + " " + a);
  }

  //each function is different agar kisime change krege toh uska reflect kahin aur nhi pdhega
  //   Heap me agar change kro toh uska reflect har jgh show hota hai but agar primitive type me change kro toh uska change kahin aur reflect nhi hota

  //questions
  //   ques1->
  public static void printDecreasing(int n) {
    if (n == 0) { //base case always come in first
      return;
    }
    System.out.println(n); //make that faith into actual answer
    printDecreasing(n - 1); //faith
  }

  //RULES ->>
  //first think about faith
  //2nd make stack diagram
  // 3rd do dry run
  // 4) write code

  //   ==========================================
  //ques2 ->
  public static void printIncreasing(int n) {
    if (n == 0) { //base case always come in first
      return;
    }
    printIncreasing(n - 1); // faith
    System.out.println(n); //make that faith into actual answer
  }

  //   ques3->
  public static void pdi(int n) {
    if (n == 0) return;

    System.out.println(n);
    pdi(n - 1); //faith
    System.out.println(n);
  }

  //ques4->
  public static void pdiOddEven(int n) {
    if (n == 0) return;

    if (n % 2 != 0) System.out.println(n);
    pdiOddEven(n - 1); //faith
    if (n % 2 == 0) System.out.println(n);
  }

  //ques5 ->
  public static int factorial_(int n) {
    if (n == 0) return 1; //0! ie 1[base case]  -> tc o(1)

    int recAns = factorial(n - 1); // tc -> (t(n-1))

    return n * recAns; //o(1)
    // t(n)= 2n + 1 in term of O(n);
  }

  public static int factorial(int n) {
    //time complexity -> 2n (ek baar upr jaate and baar niche aate)
    // har element kitni baar visit hora hai
    return (n == 0) ? 1 : n * factorial(n - 1);
  }

  //class 2===========================================================

  //ques1->
  public static int power(int a, int b) { //this take a lot of TC Eg if b is 10 ^9 so ine operations perform honge
    // return (int)Math.pow(x,n);
    return (b == 0) ? 1 : power(a, b - 1) * a;
  }

  //ques2-> ALTERNATE BETTER APPROACH
  public static int power_(int a, int b) {
    // formula eg (a,b) => a , (b / 2) * (b / 2) => a,b but handle odd even cases
    if (b == 0) {
      return 1;
    }
    int smallAns = power(a, b / 2); //faith
    smallAns *= smallAns;
    return b % 2 == 0 ? smallAns : smallAns * a; //even : odd
  }

  public static int powerBtr2(int a, int b) {
    if (b == 0) return 1;
    int smallAns = powerBtr2(a, b / 2) * powerBtr2(a, b / 2);
    return b % 2 == 0 ? smallAns : smallAns * a;
  }

  //ques3 -> fibonacci
  public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  //ques4 -> tribonacci 1137
  public int tribonacci(int n) {
    if (n <= 2) return n == 2 ? 1 : n;

    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
  }

  //RECURSION WITH ARRAY
  // ques 1->
  public static void displayArr(int[] arr, int idx, int n) {
    // think print in increasing order number range 0 to n
    if (idx == n) return;
    System.out.println(arr[idx]);
    displayArr(arr, idx + 1, n);
  }

  //ques2->
  public static void displayArrReverse(int[] arr, int idx, int n) {
    // think print in Decreasing number
    if (idx == n) return;
    displayArrReverse(arr, idx + 1, n);
    System.out.println(arr[idx]);
  }

  //ques3->
  public static int maxOfArray(int[] arr, int idx) {
    if (idx == arr.length) return -(int) 1e9; //element mila hi nhi

    return Math.max(arr[idx], maxOfArray(arr, idx + 1)); //faith: 1 se end tak miljaega max then we compare with the 0 th index
  }

  //ques4->
  public static int firstIndex(int[] arr, int idx, int x, int n) {
    if (idx == n) return -1;
    if (arr[idx] == x) return idx;
    return firstIndex(arr, idx + 1, x, n);
  }

  //ques5->
  public static int lastIndex(int[] arr, int idx, int x, int n) {
    if (idx == -1) return -1;
    if (arr[idx] == x) return idx;
    return lastIndex(arr, idx - 1, x, n); //means loop starts from the end
  }

  // CLASS 2 ================================================================================

  //ques1 -> is palindrome
  public static boolean isPalindrome(int[] arr, int si, int ei) {
    if (si >= ei) return true;

    if (arr[si] != arr[ei]) return false;
    return isPalindrome(arr, si + 1, ei + 1);
  }

  //ques 2 ->
  public static void swap(int[] arr, int si, int ei) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void reverseArray(int[] arr, int si, int ei) {
    if (si >= ei) return;

    swap(arr, si, ei); //swap 1st and last index
    reverseArray(arr, si + 1, ei - 1); //faith-> middle se reverse hojega
  }

  //ques3 ->
  /* 
    recursion -> stack has power that we can make our answer in 2 ways
    1) upr jate hoye -> kisi cheez me store krle
    2) niche aate hoye -> return krle ie called backTracking
    3) do backTrack with p,pp,ppp,.....
  */

  public static void inverseArray(int[] arr, int idx) {
    if (idx == arr.length) return;

    int val = arr[idx]; //upr jate hoye value store krli ussi array me, hr jgh hmare stack ki space pr val pdha h
    inverseArray(arr, idx + 1); //faith -> 1se pura array reverse mil jaega jo iss call ke niche hoga ie back track

    arr[val] = idx; //jo array tha vo change krdiya 1st index ko value pr store kra
  }

  public static void main(String[] args) {
    // int a = scn.nextInt();
    int n = scn.nextInt();
    // printIncreasing(a, b);
    // p(a);
    // pdi(n);
    // pdiOddEven(n);
    // System.out.println(factorial_(n));
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    isPalindrome(arr, 0, arr.length - 1);

    for (int ele : arr) {
      System.out.println(ele);
    }
  }
}
