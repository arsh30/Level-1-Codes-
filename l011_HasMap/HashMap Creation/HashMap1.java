import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap1 {

  private class Node {

    int key;
    int value;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    // @Override
    // public String toString() {
    //   return key + "=" + value;
    // }
  }

  LinkedList<Node>[] buckets; //2nd step to make buckets and make nodes jisme key value hoga

  int noOfElements = 0; //total no of element present in hashmap
  int maxSizeOfBucket = 0; //all index of array or groupNo

  private void initialise(int size) { //3rd step where we new all the linked list
    buckets = new LinkedList[size]; //abhi ik array create hua with null address

    for (int i = 0; i < size; i++) { // har address pr new kri linked list
      buckets[i] = new LinkedList<>(); //har bucket pr linked list hai
    }

    this.maxSizeOfBucket = size; //jo size aaya utne size ka array create hua
    this.noOfElements = 0;
  }

  public HashMap1() { //3rd step hashmap constructor
    initialise(10);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    //same work krege jese hm keyset mangware the
    for (int i = 0; i < buckets.length; i++) {
      //har bucket pr arrayList pdhi hai uska group mangwaya
      LinkedList<Node> group = this.buckets[i];

      //loop chla kar print krliya
      int size = group.size(); //linkedlist function
      while (size-- > 0) {
        sb.append(group.getFirst()); //yeh krne se milega hmko Node, so hm node ka jo address hai vo print hoga , so hmko node ke andr bhi
        //   toString krna pdhega -> so Node ke upr toString kra toh vo uska adress nhi print krega direct krega direct keyvalue print krega
        group.addLast(group.removeFirst());
      }
    }
    sb.append("]");
    return sb.toString();
  }

  // Basic functions ->
  public int size() {
    return this.noOfElements;
  }

  public boolean isEmpty() {
    return this.size() == 0; //yeh current function
  }

  private void reHash() {
    LinkedList<Node>[] temp = this.buckets; //1) copy the data into new array
    initialise(2 * this.maxSizeOfBucket); //create this temp double size

    for (int i = 0; i < temp.length; i++) {
      LinkedList<Node> group = temp[i]; //1st group mangwaya
      int size = group.size(); // iterates over the loop
      while (size-- > 0) {
        Node node = group.removeFirst();
        put(node.key, node.value);
      }
    }
  }

  public void put(Integer key, Integer value) {
    LinkedList<Node> group = group(key); //1st we have to bring the l=group ie linkedlist
    boolean res = containsKey(key); //means add the key jo hmko chahiye vo first place pr aajegi
    if (res) {
      //if result is true so update the value
      group.getFirst().value = value;
    }
    Node node = new Node(key, value);
    group.addLast(node);
    this.noOfElements++;

    //doing hashing
    double lamda = (0.4 * this.maxSizeOfBucket);
    if (group.size() > lamda) reHash();
  }

  //If we found value, return the value ptherwise return null
  public Integer get(Integer key) {
    LinkedList<Node> group = group(key); //find the group eg: key is usa  yeh puri list le aaya
    boolean res = containsKey(key); //contains -> get element ko first position pr le aayi
    if (res) {
      return group.getFirst().value;
    }
    return null;
  }

  public Integer remove(Integer key) {
    LinkedList<Node> group = group(key); //it bring the list where we have to remove the element
    boolean res = containsKey(key); // list ka element first position pr laya contains key
    if (res) {
      return group.removeFirst().value;
    }
    this.noOfElements--;
    return null;
  }

  public boolean containsKey(Integer key) {
    //first we find he group -> vo groupNo apne aap nikal lega
    LinkedList<Node> group = group(key); //eg: we send the key switzerland -> uski puri linkedlist dedi we have to traverse them
    int size = group.size(); // in built to find the size of ll -> size();

    while (size-- > 0) {
      if (group.getFirst().key == key) {
        return true;
      }

      group.addLast(group.removeFirst());
    }
    return false;
  }

  private void allKeysOfGroup(LinkedList<Node> group, ArrayList<Integer> ans) {
    //we have group of linkedlist ik ik krke element ko traverse krege or ans me add krege
    int size = group.size();
    while (size-- > 0) {
      ans.add(group.getFirst().key);
      group.addLast(group.removeFirst()); //time complexity of addlast remove first is O(1)
    }
  }

  public ArrayList<Integer> keySet() {
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < buckets.length; i++) {
      allKeysOfGroup(this.buckets[i], ans); //this.buckets[i] -> idr ik arraylist hai har index pr, initialise me kra hai hmne set
    }
    return ans;
  }

  public Integer getOrDefault(Integer key, Integer defaultValue) {
    Integer value = get(key);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }

  public void putIfAbsent(Integer key, Integer value) {
    LinkedList<Node> group = group(key);
    boolean res = containsKey(key);
    if (!res) put(key, value);
  }

  private LinkedList<Node> group(Integer key) { // 1 group is called linkedlist
    Integer groupNo = groupNo(key); //1) yeh group konse group ko belong krta kese pta lgaya so hmne group no mangwaya
    return this.buckets[groupNo]; //eg we go to 2nd index -> arr[2] uspr rakhi ll mil jaegi
  }

  private Integer groupNo(Integer key) { //group no is indexes of array
    //we pass the key ->  ie is the integer in this
    Integer hc = Math.abs(key.hashCode());

    //mode krege array ke size se taki uss uss jgh hi group ho bss, so first make the buket size

    return hc % maxSizeOfBucket; //maxSizeOfBucket set krra hai initialise, and modulus isliye kra taki 0 - 10(sie) le bicha hi index
    //aaye
  }
}
