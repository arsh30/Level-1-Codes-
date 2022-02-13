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
      pq.add(e);
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

  public static void main(String[] args) {
    // minPQ();
    maxPQ();
  }
}
