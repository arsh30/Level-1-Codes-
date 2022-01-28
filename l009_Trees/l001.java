import java.util.ArrayList;
import java.util.List;

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

  public static void printAtDepthk(
    Node root,
    Node block,
    int k,
    ArrayList<Integer> ans
  ) {
    if (root == null || root == block || k < 0) {
      return;
    }
    if (k == 0) {
      ans.add(root.data);
      return;
    }
    printAtDepthk(root.left, block, k - 1, ans);
    printAtDepthk(root.right, block, k - 1, ans);
  }

  //leetcode 863 vvv imp
  public List<Integer> distanceK(Node root, Node target, int k) {
    ArrayList<Node> path = new ArrayList<>();
    rootToNodePath(root, target.data, path);

    Node block = null;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < path.size(); i++) {
      printAtDepthk(path.get(i), block, k - i, ans);
      block = path.get(i);
    }

    return ans;
  }

  // print single child node
  public static void printSingleChildNodes(Node node, Node parent) {
    if (node == null) return;
    if (parent != null && (parent.left == null || parent.right == null)) {
      // if (parent != null && (node.left == null || node.right == null)) -> ye krte to {
      System.out.println(node.data);
    }

    printSingleChildNodes(node.left, node);
    printSingleChildNodes(node.right, node);
  }

  //removee leaf
  public static Node removeLeaves(Node node) {
    if (node == null) return null;
    if (node.left == null && node.right == null) {
      return null;
    }
    node.left = removeLeaves(node.left);
    node.right = removeLeaves(node.right);

    return node;
  }

  //remove leaf with void type
  //try to solve the question in pre order
  public static void removeLeave(Node node, Node par) {
    if (node == null) return;

    if (node.left == null && node.right == null) {
      if (par.left == node) par.left = null; //node is leaf
      else if (par.right == node) par.right = null;
      return;
    }
    removeLeave(node.left, node);
    removeLeave(node.right, node);
  }

  public static Node removeLeave_01(Node node) {
    //handle case -> if root node is our leaf node
    if (node.left == null && node.right == null) {
      return null;
    }
    removeLeave(node, null);
    return node;
  }

  //Is BST
  public static Node prev = null;

  public static boolean isBST(Node node) {
    if (node == null) return false;

    boolean leftRes = isBST(node.left);
    if (!leftRes) return false; //means agar left subtree se pta lag gya ki bst nhi hai to aage check nhi krege
    if (prev != null && prev.data > node.data) return false;

    prev = node;
    boolean rightRes = isBST(node.right);
    if (!rightRes) return false;

    return true;
  }

  //do isBST with return type -> so for this we have to make a class
  public static class isBSTSolPair {

    int maxEle = -(int) 1e9;
    int minEle = (int) 1e9;
    boolean isBST = true;

    //for balance pair
    int height = -1;
    boolean isBal = true;

    //largest bst
    int largestBSTSize = 0;
    Node largestBSTNode = null;

    int totalNoOfBST = 0;
    //when we make a class so we have to make a constructor
    // public isBSTSolPair(int maxEle, int minEle, boolean isBST) {
    //   this.isBST = isBST;
    //   this.minEle = minEle;
    //   this.maxEle = maxEle;
    // }
    // //default constructor
    // public isBSTSolPair() {
    //   //nothing have to pass it is default constructor
    // }
  }

  public isBSTSolPair isBST_(Node node) {
    //return type
    if (node == null) {
      isBSTSolPair base = new isBSTSolPair();
      base.isBST = true;
      return base;
    }
    isBSTSolPair left = isBST_(node.left);
    isBSTSolPair right = isBST_(node.right);

    isBSTSolPair ans = new isBSTSolPair();

    if (
      left.isBST &&
      right.isBST &&
      left.maxEle < node.data &&
      node.data < right.minEle
    ) {
      //agar yeh sab hai to it is a bst, so we have to set them because hme return krna hai
      // so return krn hai ik new ans bnakr usme return krege
      ans.isBST = true;
      ans.maxEle = Math.max(node.data, right.maxEle);
      ans.minEle = Math.max(node.data, left.minEle);
    }
    return ans;
  }

  //ques-> balanc pair with return type
  public class isBalPair {

    int height = -1; //to check the balance from left and write so we need this, and yeh left balance hai right bhi balance hai
    //or yeh information hmne parent ko deni hai so we need extra parameter that is boolean bal
    boolean balanceTree = false;
    // public isBalPair(int height) {
    //   this.height = height;
    // }
  }

  public isBalPair isBal_(Node node) {
    if (node == null) {
      isBalPair base = new isBalPair();
      base.balanceTree = true;
      return base;
    }

    isBalPair left = isBal_(node.left);
    if (!left.balanceTree) return left;
    isBalPair right = isBal_(node.right);
    if (!right.balanceTree) {
      return right;
    }

    isBalPair myRes = new isBalPair();
    if (
      left.balanceTree &&
      right.balanceTree &&
      Math.abs(left.height - right.height) <= 1
    ) {
      //it means it is balance tree, so we have to set the values
      myRes.balanceTree = true;
      myRes.height = Math.max(left.height, right.height) + 1;
    }
    return myRes;
  }

  //========================================================================================
  // all in one
  public isBSTSolPair isBST_01(Node node) {
    if (node == null) {
      isBSTSolPair base = new isBSTSolPair();
      return base;
    }

    isBSTSolPair left = isBST_01(node.left);
    isBSTSolPair right = isBST_01(node.right);

    isBSTSolPair ans = new isBSTSolPair();

    //false mark krege
    ans.isBST = false;
    ans.isBal = false;

    //isBST
    if (
      left.isBST &&
      right.isBST &&
      left.maxEle < node.data &&
      node.data < right.minEle
    ) {
      ans.isBST = true;
    }

    //isBal
    if (
      left.isBal && right.isBal && Math.abs(left.height - right.height) <= 1
    ) {
      ans.isBal = true;
    }

    //max,min,height - > assume krke chlre ki bst hai
    ans.maxEle = Math.max(node.data, right.maxEle);
    ans.minEle = Math.min(node.data, left.minEle);
    ans.height = Math.max(left.height, right.height) + 1;

    //total no of bst -> jo answer aaya + agar hm bhi bst hai to 1 add krege otherwise we make it to 0
    ans.totalNoOfBST =
      left.totalNoOfBST + right.totalNoOfBST + (ans.isBST ? 1 : 0);

    //largestbstnode and largestbst size
    if (ans.isBST) {
      ans.largestBSTNode = node;
      ans.largestBSTSize += left.largestBSTSize + right.largestBSTSize + 1; //agar leftbstsize hai right bst size hai aur hm khud bhi bst hai to largest to hum khud hoye so + 1 apne naam ka
    } else {
      //agar khud bst nhi hai to largestbst left me exist krta hoga ya right me
      if (left.largestBSTSize > right.largestBSTSize) {
        ans.largestBSTNode = left.largestBSTNode;
        ans.largestBSTSize = left.largestBSTSize;
      } else {
        ans.largestBSTNode = right.largestBSTNode;
        ans.largestBSTSize = right.largestBSTSize;
      }
    }

    return ans;
  }
}
