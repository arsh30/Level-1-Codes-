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
}
