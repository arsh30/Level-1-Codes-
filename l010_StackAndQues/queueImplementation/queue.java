public class queue {

  protected int[] arr = null;
  protected int capacity = 0;
  protected int elementCount = 0;
  protected int front = 0;
  protected int back = 0;

  protected void initialiseVariable(int capacity) {
    this.capacity = capacity;
    this.arr = new int[this.capacity];
    this.elementCount = 0;
    this.front = 0;
    this.back = 0;
  }

  //make constructor
  public queue() {
    initialiseVariable(10);
  }

  public queue(int size) {
    initialiseVariable(size);
  }

  //basic functions====================
  public int size() {
    return this.elementCount;
  }

  public boolean isEmpty() {
    return this.elementCount == 0; //if 0 then return true
  }

  //   @Override
  //   public String toString(){
  //       return "Arshdeep";
  //   }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(); //we use string builder because hm nhi chahte har baar console pr jakr print hoye fir dubara chle so instead of this hmne ik hi baar add kra hai or ik baar print kra
    sb.append("[");
    for (int i = 0; i < this.elementCount; i++) {
      int idx = (this.front + i) % this.capacity;
      sb.append(this.arr[idx]); //add element in the array
      if (i != this.elementCount - 1) sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
  }

  //   public String display() {
  //     StringBuilder sb = new StringBuilder(); //we use string builder because hm nhi chahte har baar console pr jakr print hoye fir dubara chle so instead of this hmne ik hi baar add kra hai or ik baar print kra
  //     sb.append("[");
  //     for (int i = 0; i < this.elementCount; i++) {
  //       int idx = (this.front + i) % this.capacity;
  //       sb.append(this.arr[idx]); //add element in the array
  //       if (i != this.elementCount - 1) sb.append(", ");
  //     }
  //     sb.append("]");
  //     return sb.toString();
  //   }

  // Handling Exceptions=========================================================
  private void overFlowException() throws Exception {
    if (this.capacity == this.elementCount) {
      throw new Exception("QueueisFull");
    }
  }

  private void underFlowException() throws Exception {
    if (this.elementCount == 0) {
      throw new Exception("QueueisEmpty");
    }
  }

  //Queue Function ->  push, pop, front [top]===================================
  protected void push_(int data) {
    this.arr[this.back] = data; //1st data add krdiya
    this.elementCount++;
    this.back = (this.back + 1) % this.capacity;
  }

  public void push(int data) throws Exception {
    overFlowException();
    push_(data);
  }

  public int front() throws Exception { //top is same
    underFlowException();
    return this.arr[this.front];
  }

  protected int pop_() {
    int returnValue = this.arr[this.front];
    this.arr[this.front] = 0; //set default value

    this.elementCount--;
    this.front = (this.front + 1) % this.capacity;
    return returnValue;
  }

  public int pop() throws Exception {
    underFlowException();
    return pop_();
  }
}
/*
this.capacity -> isliye liya because array me kuch bhi data hoskta hai, so arr.length isliye
nhi kra because arr me main data hai isliye usko kbhi bhi touch nhi krne dete
*/
