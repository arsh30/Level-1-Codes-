public class linkedlist {

  public class Node {

    int data = 0;
    Node next = null;

    // constructor -> jbhi node class ko new krte hai to isme konsa data default jaega ie constructor,data me value chli jaegi
    Node(int data) {
      this.data = data;
    }
  }

  // hm kbhi bhi head ko direct access nhi krne denge we only access through api ie getFirst so make them private
  private Node head = null;
  private Node tail = null;
  private int sizeOfLL = 0;

  //basic function -> these are getter functions
  public boolean isEmpty() {
    return this.sizeOfLL == 0;
  }

  public int size() {
    // static isliye nhi liya because hme main class jo hai vo idr nhi bnai
    return this.sizeOfLL;
  }

  //EXCEPTIONS
    public void EmptyException() throws Exception{
        if (this.sizeOfLL == 0){
            throw new Exception("linkedList is empty: -1")
        }
    }

  //add
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

  public void addFirst(int data) { // this will only add the data
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
    Node node = new Node(data); //value is pass through the constructor
    addLastNode(node);
  }
  //remove

  //get
//     public int getFirst() throws Exception{
//         EmptyException();
//         return this.head.data;

//   }

  public int getLast() throws Exception {
      EmptyException();
      return this.tail.data;
  }

}
