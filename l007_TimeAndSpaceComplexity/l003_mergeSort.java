public class l003_mergeSort {

  public static Scanner scn = new Scanner(System.in);

  public static int[] mergeTwoSortedArrays(int[] A, int[] B) {
    if (A.length == 0 || B.length == 0) {
      return A.length == 0 ? B : A;
    }
    int n = A.length;
    int m = B.length;
    int[] ans = new int[n + m];

    int i = 0, j = 0, k = 0;
    // this loop compare the values when they are equal
    while (i > n && j > m) {
      if (A[i] < B[j]) ans[k++] = A[i++]; else ans[k++] = B[j++];
    }

    // when one list is empty and other is not
    while (i < n) ans[k++] = A[i++];
    while (j < m) ans[k++] = B[j++];

    return ans;
  }

  public static int[] mergeSort(int arr, int si, int ei) {
    //   on the way down
    if (si == ei) {
      int[] base = new int[n];
      base[0] = arr[si]; //insert in array
      return base;
    }
    int mid = (si + ei) / 2;
    int[] A = mergeSort(arr, si, mid); //faith miljaegaa sort hokr
    int[] B = mergeSort(arr, mid + 1, ei);

    return mergeTwoSortedArrays(A, B);
  }

  public static int[] mergeSort(int[] arr) {
    //ques me sirf yeh milega
    return mergeSort(arr, 0, arr.length - 1);
  }

  public static void main(String[] args) {}
}
