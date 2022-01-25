public class linkedlist {

  private class Node {

    int data = 0;
    Node next = null;

    //constructor
    Node(int data) {
      this.data = data;
    }
  }

  //and we have 3 thing head,tail,size which need to be private
  private Node head = null; //inko direct acccess nhi denge we give access through api like getFirst
  private Node tail = null;
  private int sizeOfLL = 0;

  //Basic Function , everytime it has these function isEmpty(), sizeOfLL
  public boolean isEmpty() {
    return this.sizeOfLL == 0;
  }

  //there are 2 types of function getter and setter these are getter and jo inko set krega vo inke andr ke function honge
  public int sizeOfLL() {
    return this.sizeOfLL;
  }

  public void display() {
    Node curr = this.head;
    while (curr != null) {
      System.out.println(curr.data + "->");
      curr = curr.next;
    }
    System.out.println();
  }

  //Exceptions
  private void EmptyException() throws Exception {
    if (this.sizeOfLL == 0) {
      throw new Exception("LinkedList is empty: -1");
    }
  }

  private void IndexOutOfBoundSizeExclusive(int idx) throws Exception {
    if (idx < 0 || idx >= this.sizeOfLL) throw new Exception(
      "Index Out of Bound: -1"
    );
  }

  private void IndexOutOfBoundSizeInclusive(int idx) throws Exception {
    if (idx < 0 || idx > this.sizeOfLL) throw new Exception(
      "Index Out of Bound: -1"
    );
  }

  //get ========================================================================

  public int getFirst() throws Exception {
    EmptyException();
    return this.head.data;
  }

  public int getLast() throws Exception {
    EmptyException();
    return this.tail.data;
  }

  private Node getNodeAt(int idx) {
    Node curr = this.head;
    while (idx-- > 0) {
      curr = curr.next;
    }
    return curr;
  }

  public int getAt(int idx, int data) throws Exception {
    IndexOutOfBoundSizeExclusive(idx);
    Node node = getNodeAt(idx);
    return node.data;
  }

  //add =====================================================================

  private void addFirstNode(Node node) {
    if (this.head == null) {
      this.head = node;
      this.tail = node;
    } else {
      node.next = this.head;
      this.head = node;
    }
    this.sizeOfLL++;
  }

  public void addFirst(int data) {
    Node node = new Node(data);
    addFirstNode(node);
  }

  private void addLastNode(Node node) {
    if (this.head == null) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
    this.sizeOfLL++;
  }

  public void addLast(int data) {
    Node node = new Node(data);
    addLastNode(node);
  }

  private void addAtNode(int idx, Node node) {
    if (this.sizeOfLL == 0) addFirstNode(node); else if (
      idx == this.sizeOfLL
    ) addLastNode(node); else {
      Node prev = getNodeAt(idx - 1);
      Node forw = prev.next;

      prev.next = node;
      node.next = forw;

      this.sizeOfLL++;
    }
  }

  public void addAt(int idx, int data) {
    IndexOutOfBoundSizeInclusive(idx);
    Node node = new Node(data);
    addAtNode(idx, node);
  }

  //remove =====================================================================

  private Node removeFirstNode() {
    Node removeNode = this.head;
    if (this.sizeOfLL == 1) {
      this.head = null;
      this.tail = null;
    } else {
      Node forw = this.head.next;
      removeNode.next = null;
      this.head = forw;
    }
    this.sizeOfLL--;
    return removeNode;
  }

  public int removeFirst() throws Exception {
    EmptyException();
    Node node = removeFirstNode();
    return node.data;
  }

  private Node removeLastNode() {
    Node removeNode = this.tail;
    if (this.sizeOfLL == 1) {
      this.head = null;
      this.tail = null;
    } else {
      Node secondLastNode = getNodeAt(this.sizeOfLL - 2);
      this.tail = secondLastNode;
      this.tail.next = null;
    }
    this.sizeOfLL--;
    return removeNode;
  }

  public int removeLast() throws Exception {
    EmptyException();
    Node node = removeLastNode();
    return node.data;
  }

  private Node removeNodeAt(int idx) {
    if (idx == 0) return removeFirstNode(); else if (
      idx == this.sizeOfLL - 1
    ) return removeLastNode(); else {
      Node prev = getNodeAt(idx - 1);
      Node curr = prev.next;
      Node forw = curr.next;

      prev.next = forw;
      curr.next = null;

      this.sizeOfLL--;
      return curr;
    }
  }

  public int removeAt(int idx) throws Exception {
    EmptyException();
    IndexOutOfBoundSizeExclusive(idx);
    Node node = removeNodeAt(idx);
    return node.data;
  }
}
