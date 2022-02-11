import java.util.Stack;

public class queueUsingStack_push_Efficient { //means we use stack inbuilt function to make queue

  //queue function are -> add,remove,peek
  //stack function are -> push,pop,peek

  Stack<Integer> st = new Stack<>();
  Stack<Integer> temp = new Stack<>();
  int peekValue = 0;

  public int size() {
    return st.size(); //size() -> inbuilt method of stack
  }

  public boolean isEmpty() {
    return st.isEmpty(); // -> isEmpty(); -> inbuilt method of stack
  }

  //O(1) -> because push efficient to add O(1) me hona chaiye
  public void add(int data) {
    if (st.size() == 0) { //if stack is empty then set the peekValue when it is empty
      this.peekValue = data;
    }
    st.push(data);
  }

  //0(1)
  public int peek() {
    return this.peekValue;
  }

  private void transferToAnotherStack() {
    while (st.size() != 0) {
      temp.push(st.pop());
    }
  }

  public int remove() {
    transferToAnotherStack();
    int removeData = temp.pop();

    while (temp.size() != 0) {
      this.add(temp.pop());
    }

    return removeData;
  }
}
/* queue using stack_Push means -> means we can only use stack functionality, so queue implement using stack functions

** stack,queue class khud ki likhli, agar bola jaye ki stack or queue implement kro using stack toh khud ka likhna 
hai to khud ka likhege. means 2 solution available for 

1) Bani bnai linked list ki feature use krle

2)agar bni bnai ni krni toh class implement krlege, so when they say ki stack bnao, to always use stack using linked list

3)inbuilt method of stack -> push,pop,peek

4) inbuilt method of queue -> add, remove, peek [jbhi yeh bnani hoegi to using linked list hi krege]

5) main concept -> queue implement krni hai using stack function, only 3 function 
    we can allowed size,push,pop,top,isEmpty  -> yeh sab allowed hai sirf

*** if we are making our stack using LinkedList. toh we use 3 functions of stack ie 1) addfirst(), 2) removefirst 3) getFirst

*/
