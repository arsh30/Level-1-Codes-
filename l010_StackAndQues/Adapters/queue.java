//implementation of queue using linked list [here we are using inBuilt linkedlist method, agr koi inbuilt
// linkedlist mana krde to write our own link list]
//inBuilt method of queue are -> push, pop, front
import java.util.LinkedList;

public class queue {

  private LinkedList<Integer> ll = new LinkedList<>();

  public int size() {
    return ll.size();
  }

  public boolean isEmpty() {
    return ll.size() == 0;
  }

  public void push(int data) {
    ll.addLast(data);
  }

  public int front() {
    return ll.getFirst();
  }

  public int pop() {
    return ll.removeFirst();
  }
}
