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

  public static void main(String[] args) {
    // int a = scn.nextInt();
    int n = scn.nextInt();
    // printIncreasing(a, b);
    // p(a);
    // pdi(n);
    pdiOddEven(n);
  }
}
