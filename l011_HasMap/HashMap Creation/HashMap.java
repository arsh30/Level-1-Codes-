import java.util.ArrayList;
import java.util.LinkedList;

//note -> we pass the reference dataType ie Integer to generate hashcode
public class HashMap {

  public class Node {

    int key = 0;
    int value = 0;

    //constructor
    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private LinkedList<Node>[] buckets;
  private int noOfElements = 0; //total no of elements
  private int maxSizeOfBucket = 0; //size of array

  private void initialise(int size) {
    buckets = new LinkedList[size]; //abhi inme null pdha har array list rakhenge
    for (int i = 0; i < size; i++) {
      buckets[i] = new LinkedList<>();
    }
    this.maxSizeOfBucket = size;
  }

  //constructor
  public HashMap() { //default constructr
    initialise(10);
  }

  public Integer size() {
    return this.noOfElements;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void put(Integer key, Integer value) {}

  // if you found return value if not return null.
  public Integer get(Integer key) {
    //to get -> we need groupNo -> uspr arrayList hai
    LinkedList<Node> group = group(key); //we got the group jisme element present hai
    boolean res = containsKey(key);
    if (res) {
      return group.getFirst().value;
    }
    return null;
  }

  public Integer remove(Integer key) {
    LinkedList<Node> group = group(key);
    boolean res = containsKey(key); //contains key se data first position pr le aaye
    if (res) {
      return group.removeFirst().value;
    }
    return null;
  }

  public boolean containsKey(Integer key) {
    //note-> hm hashmap ke andr jakr change krege [note: jo bhi cheeze heap pr bnti hai uske andr jakr change kro becuase uske address ko asar na pdhe]

    LinkedList<Node> group = group(key); //it automatically finds the hashcode -> hm hash function me dalre hai
    int size = group.size();
    while (size-- > 0) { //searching in linked list
      if (group.getFirst().key == key) return true;
      group.addLast(group.removeFirst()); //addLast time complexity is O(1) and remove is also O(1)
    }
    return false;
  }

  public ArrayList<Integer> keySet() {}

  public Integer getOrDefault(Integer key, Integer defaultValue) {
    Integer value = get(key);
    if (value == null) return defaultValue;

    return value;
  }

  public void putIfAbsent(Integer key, Integer value) {}

  private LinkedList<Node> group(int key) { //these two function are very important
    int groupNo = groupNo(key);
    return this.buckets[groupNo];
  }

  private Integer groupNo(Integer key) { //that is indices of array
    Integer hc = Math.abs(key.hashCode()); //it gives hascode for every index
    return hc % maxSizeOfBucket; // hashfunction
  }
}
