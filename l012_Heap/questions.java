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

}
