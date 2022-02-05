/*
also known as 'n array tree because we have given an arraylist usme jo sabse bda node element hoga vo hoga n array tree
2) in this , BT ke 2 child hote the toh or GT ke multiple child possible hoskte hai so 1 For loop lgana pdhega recursive call ke liye
3) isme base case ki need hi ni pdhti because agr child hoga hi nhi to for loop execute hi nhi hoga
4) when we are doing dry run visit in preorder try
 */
public class l003_GT {

  public static class Node {

    //Node node = new Node(10) -> jo 10 set hua vo constructor ke through hua
    int data = 0;
    ArrayList<Node> childs = new ArrayList<>();

    Node(int data) {
      this.data = data;
    }
  }

  //basic function that every DS have size, height,max,min
  //we dont need any base case if root == null to for loop hi nhi chlega
  public static int size(Node node) {
    int sz = 0;
    for (Node child : node.childs) { //childs arraylist me nodes hai isliye node type ka liya dataType
      sz += size(child); //in this there is not any left right concept
    }
    return sz + 1;
  }

  public static int height(Node node) {
    int h = -1;
    for (Node child : node.childs) {
      h = Math.max(h, height(child));
    }
    return h + 1;
  }

  public static int max(Node node) {
    // write your code here
    int maxEle = -(int) 1e8;
    for (Node child : node.childs) {
      maxEle = Math.max(maxEle, max(child));
    }
    return Math.max(maxEle, node.data);
  }

  public static int max_01(Node node) {
    // write your code here
    int maxEle = node.data;
    for (Node child : node.childs) {
      maxEle = Math.max(maxEle, max_01(child));
    }
    return maxEle;
  }

  public static int minimum(Node node) {
    int minEle = node.data;
    for (Node child : node.childs) {
      minEle = Math.min(minEle, minimum(child));
    }
    return minEle;
  }

  public static boolean find(Node node, int data) {
    boolean res = node.data == data;
    for (Node child : node.childs) {
      res = res || find(child, data);
    }
    return res;
  }

  public static void display(Node node) {
    //print 1st line
    System.out.print(node.data + " -> ");
    for (Node child : node.childs) {
      System.out.print(child.data + ",");
    }
    System.out.println();

    //faith -> niche wale child apna krke le aayege
    for (Node child : node.childs) {
      display(child);
    }
  }

  public static boolean nodeToRootPath(
    Node node,
    int data,
    ArrayList<Node> list
  ) {
    boolean res = node.data == data;
    for (Node child : node.childs) {
      res = res || find(child, data);
    }
    if (res) list.add(node); //means jidr true mila udr list me add krliya
    return res;
  }

  public static Node LCANode(Node node, int d1, int d2) {
    ArrayList<Node> list1 = new ArrayList<>();
    ArrayList<Node> list2 = new ArrayList<>();

    nodeToRootPath(node, d1, list1);
    nodeToRootPath(node, d2, list2);

    int i = list1.size() - 1;
    int j = list2.size() - 1;

    Node LCA = null;
    int LCADistance = 0;

    while (i >= 0 && j >= 0) {
      if (list1.get(i) != list2.get(j)) break; //means jidr bhi unequal aaya that is the lca
      //set the lca
      LCADistance++;
      LCA = list1.get(i);
      i--;
      j--;
    }
    return LCA;
  }

  public static int NodeToNodeDistance(Node node, int d1, int d2) {
    ArrayList<Node> list1 = new ArrayList<>();
    ArrayList<Node> list2 = new ArrayList<>();
    nodeToRootPath(node, d1, list1);
    nodeToRootPath(node, d2, list2);

    int i = list1.size() - 1;
    int j = list2.size() - 1;

    int LCADistance = 0;
    while (i >= 0 && j >= 0) {
      if (list1.get(i) != list2.get(j)) break;

      LCADistance++;
      i--;
      j--;
    }

    int distance = (list1.size() + list2.size() - 2 * (LCADistance) + 1); //DISTANCE IN TERMS OF NODES
    // int dis = (list1.size() + list2.size() - 2 * (LCADistance) + 1 - 1); //DISTANCE IN TERMS OF EDGES
    return distance;
  }

  public static Node getTail(Node node) {
    Node curr = node;
    while (curr.childs.size() == 1) {
      curr = curr.childs.get(0); //0 means 1 child
    }
    return curr;
  }

  public static void linearize_01(Node node) {
    for (Node child : node.childs) {
      linearize_01(child);
    }

    while (node.childs.size() > 1) {
      Node lc = node.childs.remove(node.childs.size() - 1);
      Node slc = node.childs.get(node.childs.size() - 1); //2nd last child ki tail chaiye so usse pehle puri tail get kri
      Node slt = getTail(slc);
      slt.childs.add(lc);
    }
  }

  public static void linearize(Node node) {
    for (Node child : node.childs) {
      linearize(child);
    }

    for (int i = node.childs.size() - 2; i >= 0; i--) { //loop start from the end
      Node tail = getTail(node.childs.get(i)); //child -> root ke ke 3 childs hai
      tail.childs.add(node.childs.get(i + 1));
      node.childs.remove(i + 1);
    }
  }

  public static Node linearize_Btr(Node node) {
    //faith hmko linearise list milegi aur sath sath hme tail bhi miljayega

    //how do we know ki hmara koi node tail hai
    if (node.children.size() == 0) {
      return node;
    }
    int n = node.childs.size();
    Node gtail = linearize_Btr(node.childs.get(n - 1));
    for (int i = n - 2; i >= 0; i--) {
      Node tail = linearize_Btr(node.childs.get(i));
      tail.childs.add(node.childs.get(i + 1));
      node.childs.remove(i + 1);
    }
    //final return kya krega 10 wala person ie Node?  sol tail so tail mangwaege
    return gtail;
  }

  //binary tree and generic  tree this ques is similar in both
  static int ceil;
  static int floor;

  public static void ceilAndFloor(Node node, int data) {
    // compare the node data
    if (node.data > data) {
      ceil = Math.min(ceil, node.data);
    }
    if (node.data < data) {
      floor = Math.max(floor, node.data);
    }

    //call for childs
    for (Node child : node.childs) {
      ceilAndFloor(child, data);
    }
  }

  //do this without static and global so iske liye hme helper function require hoga
  public static int kthLargest_(Node node, int bound) {
    int maxLargerThanBound = -(int) 1e8; //it give the largest value in the tree

    for (Node child : node.childs) {
      int recAns = kthLargest_(child, bound); //largest value dega but short than bound
      maxLargerThanBound = Math.max(maxLargerThanBound, recAns);
    }

    //hmko sab milgya but we did not compare this with root
    if (node.data < bound) {
      maxLargerThanBound = Math.max(maxLargerThanBound, node.data);
    }
    return maxLargerThanBound;
  }

  public static int kthLargest(Node node, int k) {
    int bound = (int) 1e8;
    while (k-- > 0) {
      bound = kthLargest_(node, bound);
    }
    return bound;
  }

  public static boolean areSimilar(Node n1, Node n2) {
    if (n1.childs.size() != n2.childs.size()) {
      return false;
    }

    for (int i = 0; i < n1.childs.size(); i++) {
      Node c1 = n1.childs.get(i);
      Node c2 = n2.childs.get(i);
      if (areSimilar(c1, c2) == false) return false;
    }
    return true;
  }
}
