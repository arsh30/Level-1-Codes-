//  queue functions add,remove,peek, isEmpty, size
//  stack functions push,pop,peek

//note: [java me khud ki queue nhi hoti jb vo bnate to always using linkedlist krke hi bnate hai]

import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue_push {

  Queue<Integer> que = new LinkedList<>(); //queue aise bnate because iske paas khud ka nhi hai
  Queue<Integer> temp = new LinkedList<>();
  int peekEle = 0;

  public int size() {
    return this.que.size();
  }

  public boolean isEmpty() {
    return this.que.isEmpty();
  }

  //O(1)
  public void push(int data) {
    this.peekEle = data; //jabhi data add kre tbhi peek element set krlo
    this.que.add(data);
  }

  //O(1)
  public int top() {
    return this.peekEle;
  }

  //O(n)
  public int pop() {
    //transfer to another stack[jab tak 1 element ni rehta]
    while (this.que.size() != 1) {
      this.temp.add(this.que.remove());
    }

    int removeData = this.que.remove();

    while (this.temp.size() != 0) {
      this.push(this.temp.remove());
    }
    return removeData;
  }
}
