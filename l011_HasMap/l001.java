import java.util.ArrayList;
import java.util.HashMap;

public class l001 {

  public static void basic_01() {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("India", 111);
    map.put("Russia", 222);
    map.put("USA", 333);
    map.put("England", 444);

    // System.out.println(map);
    //if we want to print one by one, so we use forEach loop

    // for(String keys : map.keySet()){
    //     System.out.println(keys + "->" + map.get(keys));
    // }

    String key = "USA";
    if (map.containsKey(key)) {
      System.out.println(map.get(key));
    } else {
      System.out.println("Not found");
    }
  }

  //   QUESTIONS===========================================================
  //ques1 ->
  public static void printFrequency(String str) {
    HashMap<Character, Integer> map = new HashMap<>();
    // for (int i = 0; i < str.length(); i++) {
    //   char ch = str.charAt(i);

    //   //check ki hashmap me present hai ya nahi
    //   if (map.containsKey(ch)) {
    //     map.put(ch, map.get(ch) + 1);
    //   } else {
    //     map.put(ch, 1);
    //   }
    // }

    //alternate method to print the frequency without ifElse
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    System.out.println(map);
  }

  //ques2 ->
  public static void highestFrequencyChar(String str) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    char ans = ' ';
    int freq = 0;

    //iterate the loop over the map
    for (Character ch : map.keySet()) {
      if (map.get(ch) > freq) {
        freq = map.get(ch);
        ans = ch;
      }
    }
    System.out.println(map);
    System.out.println(ans);
  }

  //ques3 -> position of all characters
  public static void positionOfAllCharacters(String str) {
    HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
    // for (int i = 0; i < str.length(); i++) {
    //   char ch = str.charAt(i);

    //   if (!map.containsKey(ch)) {
    //     map.put(ch, new ArrayList<>());  //it is very important to do initialise, means hmne abhi data btaya konsa usko initialise nahi kra abhi tak
    //   }
    //   map.get(ch).add(i);  //isse array ka address ara hai aur uss pr jakr hmne  add kra index
    // }
    // System.out.println(map);

    //alternate approach
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      map.putIfAbsent(ch, new ArrayList<>()); //means agar element present nahi hai to hi new krega arraylist otherwise nahi krega
      map.get(ch).add(i);
    }

    for (Character ch : map.keySet()) {
      System.out.println(ch + " -> " + map.get(ch));
    }
  }

  //ques4
  public static void intersectionOfTwoArrayWithoutDuplicates(
    int[] arr1,
    int[] arr2
  ) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int ele : arr1) {
      map.put(ele, map.getOrDefault(ele, 0) + 1);
    }

    for (int ele : arr2) {
      if (map.containsKey(ele)) {
        System.out.println(ele);
        map.remove(ele);
      }
    }
  }

  //ques5
  public static void intersectionOfTwoArrayWithDuplicates(
    int[] arr1,
    int[] arr2
  ) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int ele : arr1) { //to put all the element in hashmap for frequency
      map.put(ele, map.getOrDefault(ele, 0) + 1);
    }

    for (int ele : arr2) {
      if (map.containsKey(ele)) {
        System.out.println(ele);

        map.put(ele, map.get(ele) - 1); //set the frequency

        if (map.get(ele) == 0) { //agar frequency 0 hui toh return
          map.remove(ele);
        }
      }
    }
  }

  public static void longestConsequtiveSequenceOfElement(int[] arr) {
    for (int ele : arr) {
      map.put(ele + map.getOrDefault(ele, 0) + 1);
    }
    int maxLength = 0;
    int sp = 0;

    for (int ele : arr) {
      if (!map.containsKey(ele)) continue; //element not found in hashmap to nothing have to do //means pehle hi kisi ka sequence ban gya

      map.remove(ele);
      int leftEle = ele - 1;
      int rightEle = ele + 1;

      while (map.containsKey(leftEle)) {
        map.remove(leftEle);
        leftEle--;
      }
      while (map.containsKey(rightEle)) {
        map.remove(rightEle);
        rightEle++;
      }

      //ab aate hi length nikal lo and set the maxlen
      int len = rightEle - leftEle - 1;
      if (len > maxLength) {
        maxLength = len;
        sp = leftEle + 1;
      }
    }

    for (int i = 0; i < maxLength; i++) {
      System.out.println(sp + i);
    }
  }

  public static void main(String[] args) {
    String str = "abcaaaaabbbcbbcccaa";
    // basic_01();
    // printFrequency(str);
    // highestFrequencyChar(str);
    positionOfAllCharacters(str);
  }
}
