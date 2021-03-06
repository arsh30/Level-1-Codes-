public class questions {

  /*
     what is Anagram?  -> jinka frequency map same hota hai
        sol -> 1) same character with same frequency
               2)No different character are allowed
    */

  //242 leetcode
  public boolean isAnagram_ArrayApproach(String s, String t) {
    if (s.length() != t.length()) return false;
    // HashMap<Character,Integer> map = new HashMap<>();
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      // char ch = s.charAt(i);
      // map.put(ch,map.getOrDefault(ch,0) + 1);
      freq[s.charAt(i) - 'a']++; //because to obtain the mapping
      freq[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < freq.length; i++) {
      if (freq[i] != 0) return false;
    }

    return true;
  }

  public boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      if (map.containsKey(ch) == false) { //agar character hai hi nahi
        return false;
      } else if (map.get(ch) == 1) { //remove from hashmap
        map.remove(ch);
      } else {
        //otherwise frequency ik se kam krdi jaye
        map.put(ch, map.get(ch) - 1);
      }
    }
    return map.size() == 0; //agar yeh 0 hai to true
  }

  //ques 242 leetcode
  public String RLES(String str) { //run length encoded string ie a1b2c3
    int[] freq = new int[26]; //find frequency of each character
    for (int i = 0; i < str.length(); i++) {
      freq[str.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (freq[i] != 0) {
        sb.append((char) (i + 'a'));
        sb.append(freq[i]);
      }
    }
    return sb.toString();
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    /*
        String -> means yeh btaega ki leader kon hai and arraylist me kon ja skta hai
        */
    for (String s : strs) {
      String rles = RLES(s); //it gives the frequency of each string
      map.putIfAbsent(rles, new ArrayList<>()); //put the frequency of each string in HashMap
      map.get(rles).add(s);
    }
    List<List<String>> ans = new ArrayList<>();
    for (String key : map.keySet()) {
      ans.add(map.get(key)); //assigning the values
    }
    return ans;
  }

  //leetcode 215
  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  //do this with our own heap
  public void heapify(int[] nums, int pi, int li) { //li -> lastIndex
    int maxIdx = pi;
    int lci = 2 * pi + 1;
    int rci = 2 * pi + 2;

    if (lci <= li && nums[lci] > nums[maxIdx]) {
      maxIdx = lci;
    }
    if (rci <= li && nums[rci] > nums[maxIdx]) {
      maxIdx = rci;
    }
    if (pi != maxIdx) {
      swap(nums, pi, maxIdx);
      heapify(nums, maxIdx, li);
    }
  }

  public int findKthLargest(int[] nums, int k) {
    int n = nums.length;
    for (int i = n - 1; i >= 0; i--) { //convert into heap
      heapify(nums, i, n - 1);
    }
    //find kth largest
    int lastIndex = n - 1;
    while (k > 1) {
      swap(nums, 0, lastIndex--);
      heapify(nums, 0, lastIndex);
      k--;
    }
    return nums[0]; //top element
  }

  //leetcode 378
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length, m = matrix[0].length;
    PriorityQueue<Integer> pq = new PriorityQueue<>(
      (a, b) -> {
        return matrix[a / m][a % m] - matrix[b / m][b % m]; //it convert 1d to 2d
      }
    );

    for (int i = 0; i < n; i++) pq.add(i * m + 0); //2d to 1d

    while (--k > 0) {
      int idx = pq.remove();
      int r = idx / m;
      int c = (idx % m) + 1;
      if (c < m) pq.add(r * m + c);
    }
    int idx = pq.peek();
    return matrix[idx / m][idx % m];
  }
}
