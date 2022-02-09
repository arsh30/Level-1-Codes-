public class Stack {

  protected int[] arr = null;
  protected int tos = -1;
  protected int elementCount = 0; //No of element present in the stack
  protected int capacity = 0; // maximum no of element that array can hold

  protected void initialiseVariable(int capacity) {
    //this function sets the value of array and usko 0 se initialise krdega
    this.capacity = capacity;
    this.arr = new arr[this.capacity];
    this.elementCount = 0;
    this.tos = -1;
  }

  //making constructor -> to initialise the values[whenever we make the object, sbse pehele constructor hi execute hota hai]
  public Stack() {
    initialiseVariable(10); //default size that is capacity
  }

  public Stack(int size) {
    initialiseVariable(size);
  }

  //basic function -> size and isEmpty ==========================================
  public int size() {
    return this.elementCount;
  }

  public boolean isEmpty() {
    return this.elementCount == 0; //agar 0 hai to true return kregga
  }

  //display ->
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < this.elementCount; i++) {
      sb.append(this.arr[i]);

      if (i != this.elementCount - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  //exception handling==============================================================
  private void overFlowException() throws Exception {
    //we need capacity -> that is size of array
    if (this.capacity == this.elementCount) {
      throw new Exception("SizeIsFfull");
    }
  }

  private void underFlowException() throws Exception {
    if (this.elementCount == 0) {
      throw new Exception("StackIsEmpty");
    }
  }

  //Stack functions ==============================================================
  protected void push_(int data) {
    this.arr[++this.tos] = data; //pre increment = ++1 output = 2[starting me hojega];
    this.elementCount++;
  }

  public void push(int data) throws Exception {
    //1st think about the exceptions
    overFlowException();
    push_(data);
  }

  public int top() throws Exception {
    underFlow();
    return this.arr[this.tos];
  }

  protected int pop_() {
    int returnValue = this.arr[this.tos];
    this.arr[this.top--] = 0;
    this.elementCount--;
    return returnValue;
  }

  public int pop() throws Exception {
    underFlowException();
    return pop_();
  }
}
/* a) if some one ask to write the class, so basic cheez hi use krege that is
Array because agar koi stl use krne ke liye mana krde, agar bole arraylist use krna hai to apni likho, hashmap
ko implement krna hai to khud ka bnao same linked list, array jo hai usse sab implement hojata hai


*/
