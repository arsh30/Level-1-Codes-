import java.util.ArrayList;

public class l001 {

  public static class Node { //static because we treat like this as a function

    int data = 0;
    Node left = null; //because now we dont know that which is the left or right child, so we need to assign them
    Node right = null; //yeh dusre node ke address ko point krega

    //make constructor -> so we can easily put the data in the data
    Node(int data) {
      this.data = data;
    }
  }

  //tress are recursion way up

  //traversal of trees -> possible only bt,bst
  /*return all the pre order in an arrayList-> so we have two options either we can make it in the arguments so we direct return this
  or  we can change the return data type to ArrayList<Integer>  
  */

  //preOrder
  public static void preOrderTraversal(Node root, ArrayList<Integer> ans) {
    if (root == null) {
      return;
    }

    ans.add(root.data);
    preOrderTraversal(root.left, ans); //faith -> left subtree wll bring its pre order
    preOrderTraversal(root.right, ans); //faith -> right subtree will bring its own pre order
  }

  public static void inOrderTraversal(Node root, ArrayList<Integer> ans) {
    //base case is eg 2 is leaf then uske left ki call lgadi or udr root is null
    if (root == null) {
      return;
    }

    inOrderTraversal(root.left, ans); //faith -> left subtree wll bring its pre order
    ans.add(root.data);
    inOrderTraversal(root.right, ans); //faith -> right subtree will bring its own pre order
  }

  public static void postOrderTraversal(Node root, ArrayList<Integer> ans) {
    if (root == null) {
      return;
    }

    inOrderTraversal(root.left, ans); //faith -> left subtree wll bring its pre order
    ans.add(root.data);
    inOrderTraversal(root.right, ans); //faith -> right subtree will bring its own pre order
  }

  public static void traversal() {
    ArrayList<Integer> ans = new ArrayList<>();
    //   root initialize nhi kra because it is a part of class
    preOrderTraversal(root, ans);
    //   inOrderTraversal(root,ans);
    //   postOrderTraversal(root,ans);
  }

  //    basic function-> every DS have these function size,height,max,min
  //    do tree diagram with the help of stack -> on it call lgaege  left right krke
  public static int size(Node root) {
    if (root == null) {
      return 0;
    }
    int leftSize = size(root.left); //trees are way up recursion
    int rightSize = size(root.right);

    return leftSize + rightSize + 1;
  }

  //bydefault -> in term of edges
  public static int height(Node root) {
    if (root == null) return -1;

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  //in term of Nodes
  public static int heightInTermsOfNodes(Node root) {
    if (root == null) return 0;

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  //maximum
  public static int maximum(Node root) {
    if (root == null) {
      return -(int) 1e9; //most negative -> isse krege always jb max bole toh
    }
    int leftMax = maximum(root.left);
    int rightMax = maximum(root.right);

    return Math.max(Math.max(leftMax, rightMax), root.data);
  }

  //minimum
  public static int minimum(Node root) {
    if (root == null) {
      return -(int) 1e9; //most negative -> isse krege always jb max bole toh
    }
    int leftMin = minimum(root.left);
    int rightMin = minimum(root.right);

    return Math.min(Math.min(leftMin, rightMin), root.data);
  }

  //sum
  public static int sum(Node root) {
    if (root == null) {
      return 0;
    }
    int leftSum = sum(root.left);
    int rightSum = sum(root.right);

    return leftSum + rightSum + root.data;
  }

  /*
  important -> findData -> follows root to node path 
  1) && -> this operator says ki sari conditions ka true hona necesary hai
  2) || -> jese hi ik true milega to aaage ki koi bhi statements check nahi krega
  3) break -> aga yeh use krte hai
  */
  public static boolean findData(Node root, int data) {
    if (root == null) return false;

    boolean res = root.data == data;

    return res || findData(root.left, data) || findData(root.right, data);
  }

  public static boolean findData1(Node root, int data) {
    if (root == null) return false;
    if (root.data == data) return true;

    boolean left = findData1(root.left, data);
    boolean right = findData1(root.right, data);

    return left || right;
  }

  public static boolean findData2(Node root, int data) { //better approach
    if (root == null) return false;
    if (root.data == data) return true;

    boolean left = findData2(root.left, data);
    if (left) return true;

    boolean right = findData2(root.right, data);
    if (right) return true;

    return false;
  }

  //Node to root path -> it is very important function and it is kind of helper function for all nodes distance k in binary tree

  public static boolean rootToNodePath(
    Node root,
    int data,
    ArrayList<Node> ans
  ) {
    if (root == null) return false;
    boolean res =
      (root.data == data) ||
      rootToNodePath(root.left, data, ans) ||
      rootToNodePath(root.right, data, ans);
    if (res) {
      ans.add(root);
    }
    return res;
  }
}
