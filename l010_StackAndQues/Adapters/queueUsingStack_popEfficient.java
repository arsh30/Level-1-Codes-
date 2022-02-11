//implement queue using stack function
import java.util.Stack;

public class queueUsingStack_popEfficient {

  //queue function are -> add,remove,peek
  //stack function are -> push,pop,peek

  Stack<Integer> st = new Stack<>();
  Stack<Integer> temp = new Stack<>();

  public int size() {
    return st.size();
  }

  public boolean isEmpty() {
    return st.isEmpty();
  }

  public void transferToAnotherStack() {
    while (st.size() != 0) {
      this.temp.push(this.st.pop());
    }
  }

  //0(n) -> pop efficient means remove run in o(1)
  public void add(int data) {
    transferToAnotherStack();
    this.st.push(data);

    while (this.temp.size() != 0) {
      this.st.push(temp.pop());
    }
  }

  //O(1)
  public int peek() {
    return this.st.peek();
  }

  //O(1)
  public int remove() {
    return this.st.pop();
  }
}
