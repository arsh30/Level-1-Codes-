//in this we dont use any linked list features, we make our own linked list
public class queue01 {

  public class Node {

    int data = 0;
    Node nex = null;

    //constructor
    Node(int data) {
      this.data = data;
    }
  }

  private Node head = null;
  private Node tail = null;
  private int elementCount = 0;

  private void addLastNode(int data) {
    Node node = new Node(data);
    if (this.elementCount == 0) { //means head tail null pr hai
      this.head = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
    this.elementCount++;
  }

  private int removeFirst() {
    Node removeNode = this.head;
    if (this.elementCount == 1) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = removeNode.next;
    }
    removeNode.next = null;
    this.elementCount--;
    return removeNode;
  }

  public int size() {
    return this.elementCount;
  }

  public boolean isEmpty() {
    return this.elementCount == 0;
  }

  public void push(int data) {
    addLastNode(data);
  }

  public int front() {
    return this.head.data;
  }

  public int pop() {
    return removeFirst();
  }
}
