//  queue functions add,remove,peek, isEmpty, size
//  stack functions push,pop,peek

//note: [java me khud ki queue nhi hoti jb vo bnate to always using linkedlist krke hi bnate hai]

import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue_pop {

  Queue<Integer> que = new LinkedList<>(); //queue aise bnate because iske paas khud ka nhi hai
  Queue<Integer> temp = new LinkedList<>();

  public int size() {
    return this.que.size();
  }

  public boolean isEmpty() {
    return this.que.isEmpty();
  }

  //O(n)
  public void push(int data) {
    //tranfer all element into other
    while (this.que.size() != 0) {
      this.temp.add(this.que.remove());
    }

    this.que.add(data); //que is empty, so data add kra

    while (this.temp.size() != 0) {
      this.que.add(this.temp.remove());
    }
  }

  //O(1)
  public int peek() {
    return this.que.peek();
  }

  //O(1)
  public int pop() {
    return this.que.remove();
  }
}
