import java.util.LinkedList;
import java.util.Scanner;

public class ques {

  public class Node {

    int data = 0;
    Node next = null;

    //constructor
    Node(int data) {
      this.data = data;
    }
  }

  //jo require hai hme bydefault isko private rkhna chaiye taki bhar se koi access na kr paaye means hmari property ke through
  // hi access kre
  Node head = null;
  Node tail = null;

  //mid
  public int mid() {
    Node slow = head;
    Node fast = head;

    //   while(fast != null && fast.next != null) {  //mid 2 of even size linked list
    while (fast.next != null && fast.next.next != null) { //bydefault 1st mid find
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.data;
  }

  //reverse Pointer iterative
  public void reversePI() {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      Node forw = curr.next; // backup create

      curr.next = prev; //link

      prev = curr; //move
      curr = forw;
    }
    tail = head;
    head = prev;
  }

  //getNodeAt
  public Node getNodeAt(int idx) {
    Node curr = head;
    while (idx-- > 0) {
      curr = curr.next;
    }
    return curr;
  }

  //length
  public int length() {
    int length = 0;
    Node curr = head;
    while (curr != null) {
      curr = curr.next;
      length++;
    }
    return length;
  }

  //reverse Data Iterative
  public void reverseDI() {
    int i = 0, j = length() - 1;
    while (i < j) { //this compare via index
      Node left = getNodeAt(i);
      Node right = getNodeAt(j);

      //swap
      int temp = left.data;
      left.data = right.data;
      right.data = temp;

      i++;
      j--;
    }
  }

  //Reverse recursively
  private void displayReverseHelper(Node node) { //we get the head
    if (node == null) {
      return;
    }
    displayReverseHelper(node.next);
    System.out.println(node.data);
  }

  //reverse pointer recursive
  private void reversePRHelper(Node node) {
    if (node == null) {
      return;
    }
    reversePRHelper(node.next);
    if (node == tail) {
      //nothing to do
    } else {
      node.next.next = node;
    }
  }

  public void reversePR() {
    reversePRHelper(head);
    head.next = null;
    Node temp = head;
    head = tail;
    tail = temp;
  }

  //kth from the last
  public int KthFromLast(int k) {
    Node slow = head;
    Node fast = head;

    while (k-- > 0) {
      fast = fast.next;
    }
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow.data;
  }

  //merge 2 sorted linked list
  public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
    Node c1 = l1.head;
    Node c2 = l2.head;

    LinkedList ans = new LinkedList();
    while (c1 != null && c2 != null) {
      if (c1.data < c2.data) {
        ans.addLast(c1.data);
        c1 = c1.next;
      } else {
        ans.addLast(c2.data);
        c2 = c2.next;
      }
    }
    while (c1 != null) { //c2 is empty but
      ans.addLast(c1.data);
      c1 = c1.next;
    }
    while (c2 != null) {
      ans.addLast(c2.data);
      c2 = c2.next;
    }
    return ans;
  }

  public static Node midNode(Node head) {
    Node slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static LinkedList mergeSort(Node head, Node tail) {
    if (head == tail) { //means single element -> return type me ik extra ll bnate hai
      LinkedList base = new LinkedList();
      base.addLast(head.data);
      return base;
    }
    Node mid = midNode(head);
    Node head1 = head;
    Node tail1 = mid;
    Node head2 = mid.next;
    Node tail2 = tail;
    mid.next = null;
    LinkedList firstHalf = mergeSort(head1, tail1);
    LinkedList secondHalf = mergeSort(head2, tail2);

    return mergeTwoSortedLists(firstHalf, secondHalf);
  }
}
