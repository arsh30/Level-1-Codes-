/* It is always dynamic, java me khud ki queue nhi hoti so jbhi hme bnanai ho to using linked list queue implement krege

2) It is mostly used to make this, So jbhi koi stack, queue, ArrayList implement krne ko bole to we can only use 3 functions ie
 is addFirst, addLast, removeFirst,getFirst linked list operations

*/

public class stack {

  private LinkedList<Integer> ll = new LinkedList<>();

  //in this we use the following methods of linked list

  public int size() {
    return ll.size();
  }

  public boolean isEmpty() {
    return ll.size() == 0;
  }

  public void push(int data) {
    ll.addFirst(data);
  }

  public int top() {
    return ll.getFirst();
  }

  public int pop() {
    return ll.removeFirst();
  }
}
/*
LINKED LIST INBUILT METHODS ->
1) addFirst() ->	Adds an item to the beginning of the list., Time Complexity ->  O(1)
2) addLast() ->	Add an item to the end of the list,	 Time Complexity -> O(1)
3) removeFirst() -> Remove an item from the beginning of the list,	 Time Complexity -> O(1)
4) removeLast() ->	Remove an item from the end of the list	, Time Complexity -> O(n)
5) getFirst()	-> Get the item at the beginning of the list,	Time Complexity ->
6) getLast() -> Get the item at the end of the list, Time Complexity ->
size() -> it gives the size  TIME complexity is Ammortized O(1);

STACK INBUILT METHOD -> Push, pop, top

QUEUE INBUILT METHOD -> Push, pop, front
*/
