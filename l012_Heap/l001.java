import java.util.PriorityQueue;
import java.util.Scanner;

public class l001 {

  public static void minPQ() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(); //By default minimum priority queue [chotte value jo hngi unko priority milegi]
    for (int i = 10; i >= 0; i--) {
      pq.add(i);
    }

    while (pq.size() != 0) {
      int ele = pq.remove();
      System.out.print(ele + " ");
    }
  }

  public static void maxPQ() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(
      (a, b) -> {
        //   return a - b; //this - other gives default behaviour [in ascending order]
        return b - a; //other - this reverse of default behaviour
      }
    );
    for (int i = 10; i >= 0; i--) {
      pq.add(i);
    }
    while (pq.size() != 0) {
      int ele = pq.remove();
      System.out.print(ele + " ");
    }
  }

  public static void kLargestElements(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int ele : arr) {
      pq.add(ele);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    while (pq.size() != 0) {
      System.out.println(pq.remove());
    }
  }

  public static void kSmallest(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(
      (a, b) -> {
        return b - a;
      }
    );
    for (int ele : arr) {
      pq.add(ele);
      if (pq.size() > k) pq.remove();
    }

    while (pq.size() != 0) {
      System.out.println(pq.remove());
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int ele : nums) {
      map.put(ele, map.getOrDefault(ele, 0) + 1); //put all the element in HashMap and compare their frequency
    }

    // Array Contains -> value,frequency
    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (a, b) -> { //it will only run when the comparison takes place where a and b are arrays
        return a[1] - b[1];
      }
    );

    for (Integer e : map.keySet()) { //for loop hashmap or put them in pq one by one
      int val = e; //get the  key and their frequency put them in arrayList
      int freq = map.get(val); //get gives the values

      // int[] arr = new int[2]; //make 2 size array but this old way
      // arr[0] = val;
      // arr[1] = freq;

      int[] arr = new int[] { val, freq };
      pq.add(arr); //put the array in priority queue

      if (pq.size() > k) {
        pq.remove();
      }
    }
    int[] ans = new int[k]; //make an array to store the ans
    int idx = 0;
    while (pq.size() != 0) {
      ans[idx++] = pq.remove()[0]; //On removing, we get an array at 0 index
    }
    return ans;
  }

  public int[] topKFrequent2(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int ele : nums) {
      map.put(ele, map.getOrDefault(ele, 0) + 1); //put all the element in HashMap and compare their frequency
    }

    // Array Contains -> value,frequency
    PriorityQueue<Integer> pq = new PriorityQueue<>(
      (a, b) -> {
        return map.get(a) - map.get(b); //jab map.get kra to map ka address heap pr tha vo medium dono ke liye
        //same tha hashmap bhi usi ko belong krta tha or pq bhi, or pq ke hashmap ka address present tha or
        // dono ne lamda function override krri hui hai jiski vjah se communicate hora hai
      }
    );

    for (Integer e : map.keySet()) { //for loop hashmap or put them in pq one by one
      pq.add(e); //yeh direct key store kri hai pq me and yeh compare krega in hashmap ki frequency se
      if (pq.size() > k) {
        pq.remove();
      }
    }
    int[] ans = new int[k]; //make an array to store the ans
    int idx = 0;
    while (pq.size() != 0) {
      ans[idx++] = pq.remove(); //On removing, we get an array at 0 index
    }
    return ans;
  }

  //ques topk frequent words leetcode 692
  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<String> pq = new PriorityQueue<>(
      (a, b) -> {
        if (map.get(a) == map.get(b)) { //if both frequency are same then comapre to their lexical order
          return b.compareTo(a);
        }
        return map.get(a) - map.get(b);
      }
    );

    //traverse on the Hashmap
    for (String word : map.keySet()) { //this for loop we got the top frequent elements
      pq.add(word);
      if (pq.size() > k) pq.remove();
    }
    int idx = pq.size();
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < idx; i++) {
      ans.add("");
    }

    while (pq.size() != 0) {
      ans.set(--idx, pq.remove());
    }

    return ans;
  }

  //ques -> sortKsortedArray
  public static void sortKSortedArray(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int idx = 0;
    for (int ele : arr) {
      pq.add(ele);
      if (pq.size() > k) {
        arr[idx++] = pq.remove();
      }
    }
    while (pq.size() != 0) {
      arr[idx++] = pq.remove();
    }
    //Now print the array
    for (int ele : arr) {
      System.out.println(ele);
    }
  }

  public static void main(String[] args) {
    // minPQ();
    maxPQ();
  }
}
