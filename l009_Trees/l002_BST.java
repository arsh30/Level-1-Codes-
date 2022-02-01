import java.util.Scanner;

public class l002_BST {

  public static Scanner scn = new Scanner(System.in);

  public static class Node {

    int data = 0;
    Node left = null;
    Node right = null;

    //constructor
    Node(int data) {
      this.data = data;
    }
  }

  public static Node constructTree(int[] arr, int si, int ei) {
    if (si > ei) return null;

    int mid = (si + ei) / 2;
    Node node = new Node(arr[mid]);

    node.left = constructTree(arr, si, mid - 1);
    node.right = constructTree(arr, mid + 1, ei);

    return node;
  }

  public static Node constructTree() {
    int n = scn.nextInt();
    int[] arr = new int[n];

    return constructTree(arr, 0, n - 1);
  }

  //is bst -> size , sum are same as in binary tree
  public static int size(Node node) {
    if (node == null) return 0;

    int left = size(node.left);
    int right = size(node.right);
    return left + right + 1;
  }

  public static int sum(Node node) {
    if (node == null) return 0;

    int leftSum = sum(node.left);
    int rightSum = sum(node.right);
    return leftSum + rightSum + node.data;
  }

  public static int height(Node node) {
    if (node == null) return -1;
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  //jisme bhi values me change hota hai -> BST -> Time complexity is O(logn)
  public static int maximumItr(Node node) {
    Node curr = node;
    while (curr.right != null) {
      curr = curr.right;
    }
    return curr.data;
  }

  public static int maximumRec(Node node) {
    if (node.right != null) {
      return maximumRec(node.right);
    } else {
      return node.data;
    }
  }

  public static int minimumItr(Node node) {
    Node curr = node;
    while (curr.left != null) {
      curr = curr.left;
    }
    return curr.data;
  }

  public static int minimumRec(Node node) {
    if (node.left != null) {
      return minimumRec(node.left);
    } else {
      return node.data;
    }
  }

  public static boolean findRec(Node node, int data) {
    if (node == null) return false;
    if (data > node.data) {
      return findRec(node.right, data);
    } else if (data < node.data) {
      return findRec(node.left, data);
    } else { //if node.data == data
      return true;
    }
  }

  public static boolean findItr(Node node, int data) {
    Node curr = node;
    while (curr != null) {
      if (curr.data == data) {
        return true;
      } else if (curr.data < data) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
    return false;
  }

  public static Node add(Node node, int data) {
    if (node == null) {
      Node baseNode = new Node(data, null, null);
      return baseNode;
    }
    if (data > node.data) {
      node.right = add(node.right, data);
    } else if (data < node.data) {
      node.left = add(node.left, data);
    } else {
      //nothing to do
    }
    return node;
  }

  public static Node addDataItr(Node node, int data) {
    if (node == null) return new Node(data, null, null);

    Node curr = node;
    Node addNode = new Node(data, null, null); //the node to be add

    while (true) {
      if (curr.data == data) {
        break;
      } else if (data > curr.data) {
        if (curr.right != null) {
          curr = curr.right;
        } else {
          curr.right = addNode;
          break;
        }
      } else {
        if (curr.left != null) {
          curr = curr.left;
        } else {
          curr.left = addNode;
          break;
        }
      }
    }
    return node;
  }

  //remove child -> ============================
  public static int max(Node node) {
    Node curr = node;
    while (curr.right != null) {
      curr = curr.right;
    }
    return curr.data;
  }

  public static Node remove(Node node, int data) {
    if (node == null) return null;
    if (data > node.data) {
      node.right = remove(node.right, data);
    } else if (data < node.data) {
      node.left = remove(node.left, data);
    } else {
      //work
      if (node.left != null && node.right != null) {
        int leftMax = max(node.left);
        node.data = leftMax;
        node.left = remove(node.left, leftMax); //left side me se data ko remove kra then usko attach kra
        return node;
      } else if (node.left != null) {
        return node.left; //upr jo call lgayi thi node.left usse attach hojega
      } else if (node.right != null) {
        return node.right;
      } else {
        //it is leave
        return null;
      }
    }

    return node;
  }

  public static int lca(Node node, int d1, int d2) {
    // write your code here
    if (d1 < node.data && d2 < node.data) {
      return lca(node.left, d1, d2);
    } else if (d1 > node.data && d2 > node.data) { //agar dono bde hai to obvsly  right me milege
      return lca(node.right, d1, d2);
    } else {
      //means idr dono divide hore hai to vo dono divide hore h
      return node.data;
    }
  }
}
