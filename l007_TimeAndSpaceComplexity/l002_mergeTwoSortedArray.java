import java.util.Scanner;

public class l002_mergeTwoSortedArray {

  public static Scanner scn = new Scanner(System.in);

  public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
    // Note: Jbhi hm iteration method use krte to base case me 0 th length ke liye bhi handle krege
    int n = arr1.length;
    int m = arr2.length;
    int[] ans = new int[n + m];

    // this loop when both sizes are same
    int i = 0, j = 0, k = 0;
    while (i < n && j < m) {
      if (arr1[i] < arr2[j]) ans[k++] = arr1[i++]; else ans[k++] = arr2[j++];
    }

    // if 2nd array wil finish first
    while (i < n) {
      ans[k++] = arr1[i++];
    }
    while (j < m) {
      ans[k++] = arr2[j++];
    }
    return ans;
  }

  public static void input(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
  }

  public static void output(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    int[] A = new int[n];
    input(A);

    int m = scn.nextInt();
    int[] B = new int[m];
    input(B);

    int[] ans = mergeTwoSortedArrays(A, B);
    output(ans);
  }
}
