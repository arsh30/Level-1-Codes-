public class basic {

  /*
    to make heap , we look the arr at the point of full-tree;
    complete tree: 1) filled with left to write and then top to down 
    */

  public static int height(int[] arr, int pi) { //parent index
    if (pi >= arr.length) { //means agar length ke bhar chle jaye
      return -1;
    }

    int lh = height(arr, 2 * pi + 1); //to obtain left child jese tree me node.left jate the
    int rh = height(arr, 2 * pi + 2); //to obtain right child

    return Math.max(lh, rh) + 1;
  }

  public static int size(int[] arr, int pi) {
    if (pi >= arr.length) return 0;

    int leftSize = size(arr, 2 * pi + 1);
    int rightSize = size(arr, 2 * pi + 2);

    return leftSize + rightSize + 1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {
      10,
      20,
      30,
      -2,
      -3,
      -4,
      5,
      6,
      7,
      8,
      9,
      22,
      11,
      13,
      14,
    };
    // System.out.println(height(arr, 0));
    System.out.println(size(arr, 0));
  }
}
