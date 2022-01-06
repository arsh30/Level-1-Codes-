import java.util.ArrayList;
import java.util.Scanner;

public class l002 {

  public static Scanner scn = new Scanner(System.in);

  public static void printSS_wayup(String str, int idx, String ans) {
    // here, it only return the value in only the base case, if we want to print the answer, we can make only in BC and print also here
    // so here we take str,idx,as well as the answer in the parameter
    // string ans: we only declare the parameter dont need to use new keyword, so niche bss empty string pass krege main se
    if (idx == str.length()) {
      System.out.println(ans);
      return;
    }
    printSS_wayup(str, idx + 1, ans + str.charAt(idx)); //answer me add krte hi idx + 1 krdiya, TC -> ans + str.charAt(idx) IS O(N);
    printSS_wayup(str, idx + 1, ans);
  }

  /*Case2 -> with stringBuilder -> String is a primitive data type means agar recursive call me string 
me kuch add krege to udr hi hogi and agar recursive call se pehle krte hai toh vo usi function me add hogi ie p

2)stringBuilder is make on heap, heap pr jo cheez bnti bnti hai vo upr jati hai and vo niche bhi atti hai
So agar kuch add krre h string me to usko remove bhi krege

VERY IMPORTANT NOTE -> STRING VS STRING BUILDER
STRING -> isme hm simple add krke aage bhjte hai
STRINGBUILDER -> in this 1) we add , 2) call lgai, 3)  then jo add kra hai toh usko remove bhi krege (everytime agar hmne Sb use kra to yeh 3 steps follow krege necessary h because it is on heap)
*/

  public static void printSS_wayup_02(String str, int idx, StringBuilder ans) {
    if (idx == str.length()) {
      System.out.println(ans);
      return;
    }
    // sb me argument me add krna is impossible, sb is n heap, so ispe jo change krte upr jate hoye bnate h nd niche aakr remove

    ans.append(str.charAt(idx));
    printSS_wayup_02(str, idx + 1, ans);
    ans.deleteCharAt(ans.length() - 1);

    printSS_wayup_02(str, idx + 1, ans);
  }

  public static ArrayList<String> subseq03(String str, int idx) {
    if (idx == str.length()) {
      ArrayList<String> base = new ArrayList<>();
      base.add(""); //because agar [] return kra toh iske upr for loop hi nhi chlega
      return base;
    }

    ArrayList<String> recAns = subseq03(str, idx + 1); //faith (bc ka aajega subseq)
    ArrayList<String> myAns = new ArrayList<>(recAns); //nhi aane ki choice hogyi

    char ch = str.charAt(idx);
    for (String s : recAns) { //har string k pass jakr char add krege
      myAns.add(s + ch); //sabke aage 'a' lgadiya
    }
    return myAns;
  }

  //**** important -> do string ques with the "idx" way -> jbhi 2 call hongi tb 1st make tree then trace trough stack diag
  public static void subsequence() {
    String str = "abc";
    // printSS_wayup_02(str, 0, new StringBuilder());
    System.out.println(subseq03(str, 0));
  }

  public static void printASCIISS(String str, int idx, String ans) {
    if (idx == str.length()) {
      System.out.println(ans);
      return;
    }

    printASCIISS(str, idx + 1, ans + str.charAt(idx)); //faith -> first make tree and isse jo add hota hai vo different string me add hota hai
    printASCIISS(str, idx + 1, ans + (int) str.charAt(idx)); //ascii value
    printASCIISS(str, idx + 1, ans);
  }

  public static ArrayList<String> printASCIISS_Ret(String str, int idx) {
    if (idx == str.length()) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }
    //  faith-> 'bc' apna answer le aayega hm a ki 3 outcomes ko manage krke pura answer bnaege
    ArrayList<String> recAns = printASCIISS_Ret(str, idx + 1);
    ArrayList<String> myAns = new ArrayList<>();
    char ch = str.charAt(idx);
    for (String s : recAns) {
      myAns.add(ch + s);
      myAns.add((int) ch + s);
      myAns.add(s);
    }
    return myAns;
  }

  static String[] codes = {
    ".;",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tu",
    "vwx",
    "yz",
  }; //make this: to check which character does he have and to access those

  public static int printKPC(String str, int idx, String ans) {
    if (idx == str.length()) {
      System.out.println(ans);
      return 1;
    }
    char ch = str.charAt(idx); //1st step string mila h character usko number m convert kra
    String code = codes[ch - '0']; // 2nd step to convert into number isse hme 4 th idex ki string milgyi pqrs
    int count = 0;

    for (int i = 0; i < code.length(); i++) { //pqrs -> isko access kra or har charac nikala
      char c = code.charAt(i); //har character one b one aane lggaya
      count += printKPC(str, idx + 1, ans + c); //way up -> faith pehle 6 ko bole apne words bnaye or same work 7, 8 bhi kre
    }
    return count;
  }

  static String[] codes = {
    ".;",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tu",
    "vwx",
    "yz",
  }; //make this: to check which character does he have and to access those

  public static ArrayList<String> printKPC_ret(String str, int idx) {
    if (idx == str.length()) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> recAns = printKPC_ret(str, idx + 1);
    ArrayList<String> myAns = new ArrayList<>();

    char ch = str.charAt(idx);
    String code = codes[ch - '0']; // pqrs

    for (int i = 0; i < code.length(); i++) { //got p,q,r,s
      char c = code.charAt(i); //1st loop get p, nd loop got b and so on..
      for (String s : recAns) {
        myAns.add(c + s);
      }
    }
    return myAns;
  }

  public static void main(String[] args) {
    // String str = scn.next();
    // printSS(str, 0, "");
    String str = scn.nextLine();
    ArrayList<String> ans = printKPC_ret(str, 0); //note: jo data hm return type se krre hai final answer usi me catch krege
    System.out.println(ans);
    // subsequence();
  }
}
