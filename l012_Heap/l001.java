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

  // ques important sortKSortedArray important with time compplexity
  public static ArrayList<Integer> mergeKSortedLists(
    ArrayList<ArrayList<Integer>> lists
  ) {
    ArrayList<Integer> rv = new ArrayList<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (a, b) -> {
        return a[0] - b[0]; //we are putting 3 thing in pq that compares ie element,index,array of list
      }
    );

    for (int i = 0; i < lists.size(); i++) {
      pq.add(new int[] { lists.get(i).get(0), 0, i }); //starting me sab 0 element wale put krdiye pq me
    }

    while (pq.size() != 0) {
      int[] ar = pq.remove(); //remove kra or add krna ans me remove krne pr we get element, index, index of lists so we want element
      rv.add(ar[0]);

      //now increment the index jis list se remove kra tha
      int idx = ar[1]; //isliye catch kra taki next index put kr paye
      int listIdx = ar[2];
      int length = lists.get(listIdx).size(); //length isliye taki pta kr ske ki end hogya list ka
      if (idx + 1 < length) {
        ar[1]++; //increment the index of the remove element because usko add krna hai
        ar[0] = lists.get(listIdx).get(idx + 1); //store the next value;
        pq.add(ar);
      }
    }

    return rv;
  }

  /*
  ------------------------------------------------------------------------------------------
  //Note: whenever we want to traverse on the array store the index in any variable
 -------------------------------------------------------------------------------------------
 */

  public static ArrayList<Integer> mergeTwoList(
    ArrayList<Integer> list1,
    ArrayList<Integer> list2
  ) {
    //By: MergeSort It is Better than PriorityQueue
    ArrayList<Integer> ans = new ArrayList<>();
    int i = 0, n = list1.size();
    int j = 0, m = list2.size();

    while (i < n && j < m) {
      if (list1.get(i) < list2.get(j)) {
        ans.add(list1.get(i++));
      } else {
        ans.add(list2.get(j++)); //means first i add hoga then immediately ++ hoga
      }
    }

    while (i < n) { //means 2nd list 1 is left
      ans.add(list1.get(i));
      i++;
    }
    while (j < m) {
      ans.add(list2.get(j));
      j++;
    }
    return ans;
  }

  public static ArrayList<Integer> mergeKSortedLists(
    ArrayList<ArrayList<Integer>> lists,
    int si,
    int ei
  ) {
    //apply merge sort logic
    if (si == ei) {
      return lists.get(si);
    }

    int mid = (si + ei) / 2;
    ArrayList<Integer> list1 = mergeKSortedLists(lists, si, mid); //NOTE:  initialise krne k liye new ni krna pdhta kuch bhi
    ArrayList<Integer> list2 = mergeKSortedLists(lists, mid + 1, ei);

    return mergeTwoList(list1, list2);
  }

  /*
  Note: -> priority queue is slower because it made it on heap

        what is Anagram? 
        sol -> 1) same character with same frequency
               2)No different character are allowed
  */

  public static void main(String[] args) {
    // minPQ();
    maxPQ();
  }
}
