/*NOTE -> make sure to make the stack is in Integer rather than characters because
hm integer ie idx ke through character access kr skte hai 
*/

import java.util.Scanner;

public class questions {

  public static Scanner scn = new Scanner(System.in);

  public static boolean isBalancedBrackets(String str) {
    //need a stack to store the elements
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(' || ch == '[' || ch == '{') st.push(ch); else if (
        ch == ')' || ch == ']' || ch == '}'
      ) { //3 possiblities to push in stack
        if (st.size() == 0) return false; //eg ](a + b) [ => to stack me to kuch hoega nahi that means stack is empty return false
        else if (ch == ')' && st.peek() != '(') return false; else if (
          ch == ']' && st.peek() != '['
        ) return false; else if (
          ch == '}' && st.peek() != '{'
        ) return false; else { //means character same hai
          st.pop(); // means stack element or jo charac aaya vo same hai to pop kro
        }
      }
    }
    return st.size() == 0; //means stack size is agar 0 hai to true nhi to false
  }

  //ques2 ->

  public static void main(String[] args) throws Exception {
    String str = scn.nextLine();
    System.out.println(isBalancedBrackets(str));
  }
}
