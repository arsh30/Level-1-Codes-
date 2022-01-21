import java.util.Scanner;

public class l001 {

  public static Scanner scn = new Scanner(System.in);

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void moveToLast(int arr[], int si, int ei) {
    // sbse first element ko last me pahunch aayege
    // so first write first iteration
    for (int i = si + 1; i <= ei; i++) {
      if (arr[i - 1] > arr[i]) swap(arr, i - 1, i);
    }
  }

  public static void bubble(int arr[], int n) {
    int ei = n - 1;
    for (int i = 0; i < n; i++) { //n is size, iterations
      moveToLast(arr, 0, ei - i);
      //means 1st 0 to ei - 1 ie 8, 2nd 0 to ei - 2 ie 7
      //means 3rd 0 to ei - 3 ie 7, 4h 0 to ei - 4 ie 6.....
    }
  }

  //   SELECTION SORT
  public static void moveToStart(int[] arr, int si, int ei) { //main
        for (int i = si + 1; i <= ei; i++) {
            if (arr[si] > arr[i])
                swap(arr, si, i);
        }
    }
  // public static int moveToStart(int[] arr, int si, int ei) {
  //   int smallIdx = si; //isme smallIdx lenge then sabse compare krege then return krege niche

  //   for (int i = si + 1; i <= ei; i++) {
  //     if (isSmaller(arr, i, smallIdx)) smallIdx = i;
  //   }
  //   return smallIdx;
  // }

  public static void selectionSort(int[] arr) {
    // here we send the starting value and ending values ie si,ei
    int n = arr.length;
    int ei = n - 1;
    for (int i = 0; i < n - 1; i++) { //means jb last me 2 elem bchege to unko compare krne ka koi faida nahi
      int idx = moveToStart(arr, i, ei);
      swap(arr, i, idx);
    }
  }

  public static void main(String[] args) {}
}
