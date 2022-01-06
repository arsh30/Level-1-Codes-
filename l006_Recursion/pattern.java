import java.util.Scanner;

public class pattern {

  public static Scanner scn = new Scanner(System.in);

  public static void printRectangle(int cst, int nst, int nor, int n, int m) {
    if (nor == n + 1) return;
    if (cst == nst + 1) {
      System.out.println();
      printRectangle(1, nst, nor + 1, n, m); //think to go in 2nd line and faith is 1 se end tk sab miljaege
      return;
    }
    System.out.print("*");
    printRectangle(cst + 1, nst, nor, n, m); //faith-> 2 - 5 tk print hojege in first line
  }

  //ques2
  public static void triangle(int cst, int nst, int nor, int n, int m) {
    if (nor == n + 1) return;

    //eg: to verify base case do dry run  (2 (cst) == (3)nst + 1);
    if (cst == nst + 1) { //think how to go on 2nd line
      System.out.println();
      triangle(1, nst + 1, nor + 1, n, m);
      return;
    }
    System.out.print("*"); //faith- > 1st end tk print hojege
    triangle(cst + 1, nst, nor, n, m);
  }

  //ques hacker rank

  public static void main(String[] args) {
    int n = 5, m = 5;
    // printRectangle(1, m, 1, n, m);
    printTriangle(1, m, 1, n, m);
  }
}
