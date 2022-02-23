public class heapSort {

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static boolean compareTo(int a, int b, boolean isMax) {
    //a ke baare me sochna hota hai
    if (isMax) {
      return a > b; //a ka b bda hona jruri hai jo niche work krre the vo idr krege
    } else {
      return a < b;
    }
  }

  public static void heapify(int pi, int[] arr, int lastIndex, boolean isMax) {
    // lastIndex -> because we have to pass the range itne se itna array sort krna hai
    int maxIdx = pi;
    int lci = 2 * pi + 1;
    int rci = 2 * pi + 2;

    // if (lci <= lastIndex && arr[lci] > arr[maxIdx]) { // if we want  to print in decreasing order, only we do is to change the sign
    if (lci <= lastIndex && compareTo(arr[lci], arr[maxIdx], isMax)) { // 
      maxIdx = lci;
    }
    if (rci <= lastIndex && compareTo(arr[rci], arr[maxIdx], isMax)) {
      maxIdx = rci;
    }

    if (pi != maxIdx) {
      swap(arr, maxIdx, pi);
      heapify(maxIdx, arr, lastIndex, isMax);
    }
  }

  public static void display(int[] arr) {
    for (int ele : arr) System.out.print(ele + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
    boolean isMax = false;
    //1st convert whole array into heap loop starts from back, maxHeap
    int n = arr.length;
    for (int i = n - 1; i >= 0; i--) heapify(i, arr, n - 1, isMax);

    // display(arr);

    //now convert the heap array into sorting
    int li = n - 1; //lastIndex
    while (li >= 0) {
      swap(arr, 0, li);
      li--;
      heapify(0, arr, li, isMax);
    }
    display(arr);
  }
}
