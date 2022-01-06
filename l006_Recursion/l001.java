import java.util.Scanner;

public class l001 {

  public static Scanner scn = new Scanner(System.in);

  public static void printIncreasing_(int a, int b) {
    // base case is very important in the recursion and in recursion each function is different
    // eg:PrintInc is P and then it calling itself so consider this is an P.P (means different stack aise behave krta hai), if ppp is main function and
    // other is pppp agar 3 ppp wale me kuch change hua toh niche wale function wale pr koi asar nhi pdhega

    System.out.println("hi" + a);
    printIncreasing(a + 1, b);
    System.out.println("bye" + a);
  }

  public static void printIncreasing(int a, int b) {
    if (a == b + 1) return;

    printIncreasing(a + 1, b);
    System.out.println("bye" + a);
    a += 10; //idr a ki value set krne se koi farak pdhega? no it is used anywhere
  }

  public static void pppppp(int a) {
    return;
  }

  public static void ppppp(int a) {
    System.out.println("hi" + " " + a);
    pppppp(a + 1);
    System.out.println("bye" + " " + a);
  }

  public static void pppp(int a) {
    System.out.println("hi" + " " + a);
    ppppp(a + 1);
    System.out.println("bye" + " " + a);
  }

  public static void ppp(int a) {
    System.out.println("hi" + " " + a);
    pppp(a + 1);
    System.out.println("bye" + " " + a);
  }

  public static void pp(int a) {
    System.out.println("hi" + " " + a);
    ppp(a + 1);
    System.out.println("bye" + " " + a);
  }

  public static void p(int a) {
    System.out.println("hi" + " " + a);
    pp(a + 1);
    System.out.println("bye" + " " + a);
  }

  //each function is different agar kisime change krege toh uska reflect kahin aur nhi pdhega
  //   Heap me agar change kro toh uska reflect har jgh show hota hai but agar primitive type me change kro toh uska change kahin aur reflect nhi hota

  //questions
  //   ques1->
  public static void printDecreasing(int n) {
    if (n == 0) { //base case always come in first
      return;
    }
    System.out.println(n); //make that faith into actual answer
    printDecreasing(n - 1); //faith
  }

  //RULES ->>
  //first think about faith
  //2nd make stack diagram
  // 3rd do dry run
  // 4) write code

  //   ==========================================
  //ques2 ->
  public static void printIncreasing(int n) {
    if (n == 0) { //base case always come in first
      return;
    }
    printIncreasing(n - 1); // faith
    System.out.println(n); //make that faith into actual answer
  }

  //   ques3->
  public static void pdi(int n) {
    if (n == 0) return;

    System.out.println(n);
    pdi(n - 1); //faith
    System.out.println(n);
  }

  //ques4->
  public static void pdiOddEven(int n) {
    if (n == 0) return;

    if (n % 2 != 0) System.out.println(n);
    pdiOddEven(n - 1); //faith
    if (n % 2 == 0) System.out.println(n);
  }

  //ques5 ->
  public static int factorial_(int n) {
    if (n == 0) return 1; //0! ie 1[base case]  -> tc o(1)

    int recAns = factorial(n - 1); // tc -> (t(n-1))

    return n * recAns; //o(1)
    // t(n)= 2n + 1 in term of O(n);
  }

  public static int factorial(int n) {
    //time complexity -> 2n (ek baar upr jaate and baar niche aate)
    // har element kitni baar visit hora hai
    return (n == 0) ? 1 : n * factorial(n - 1);
  }

  //class 2===========================================================

  //ques1->
  public static int power(int a, int b) { //this take a lot of TC Eg if b is 10 ^9 so ine operations perform honge
    // return (int)Math.pow(x,n);
    return (b == 0) ? 1 : power(a, b - 1) * a;
  }

  //ques2-> ALTERNATE BETTER APPROACH
  public static int power_(int a, int b) {
    // formula eg (a,b) => a , (b / 2) * (b / 2) => a,b but handle odd even cases
    if (b == 0) {
      return 1;
    }
    int smallAns = power(a, b / 2); //faith
    smallAns *= smallAns;
    return b % 2 == 0 ? smallAns : smallAns * a; //even : odd
  }

  public static int powerBtr2(int a, int b) {
    if (b == 0) return 1;
    int smallAns = powerBtr2(a, b / 2) * powerBtr2(a, b / 2);
    return b % 2 == 0 ? smallAns : smallAns * a;
  }

  //ques3 -> fibonacci
  public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  //ques4 -> tribonacci 1137
  public int tribonacci(int n) {
    if (n <= 2) return n == 2 ? 1 : n;

    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
  }

  //RECURSION WITH ARRAY
  // ques 1->
  public static void displayArr(int[] arr, int idx, int n) {
    // think print in increasing order number range 0 to n
    if (idx == n) return;
    System.out.println(arr[idx]);
    displayArr(arr, idx + 1, n);
  }

  //ques2->
  public static void displayArrReverse(int[] arr, int idx, int n) {
    // think print in Decreasing number
    if (idx == n) return;
    displayArrReverse(arr, idx + 1, n);
    System.out.println(arr[idx]);
  }

  //ques3->
  public static int maxOfArray(int[] arr, int idx) {
    if (idx == arr.length) return -(int) 1e9; //element mila hi nhi

    return Math.max(arr[idx], maxOfArray(arr, idx + 1)); //faith: 1 se end tak miljaega max then we compare with the 0 th index
  }

  //ques4->
  public static int firstIndex(int[] arr, int idx, int x, int n) {
    if (idx == n) return -1;
    if (arr[idx] == x) return idx;
    return firstIndex(arr, idx + 1, x, n);
  }

  //ques5->
  public static int lastIndex(int[] arr, int idx, int x, int n) {
    if (idx == -1) return -1;
    if (arr[idx] == x) return idx;
    return lastIndex(arr, idx - 1, x, n); //means loop starts from the end
  }

  // CLASS 2 ================================================================================

  //ques1 -> is palindrome
  public static boolean isPalindrome(int[] arr, int si, int ei) {
    if (si >= ei) return true;

    if (arr[si] != arr[ei]) return false;
    return isPalindrome(arr, si + 1, ei + 1);
  }

  //ques 2 ->
  public static void swap(int[] arr, int si, int ei) {
    int temp = arr[si];
    arr[si] = arr[ei];
    arr[ei] = temp;
  }

  public static void reverseArray(int[] arr, int si, int ei) {
    if (si >= ei) return;

    swap(arr, si, ei); //swap 1st and last index
    reverseArray(arr, si + 1, ei - 1); //faith-> middle se reverse hojega
  }

  //ques3 ->
  /* 
    recursion -> stack has power that we can make our answer in 2 ways
    1) upr jate hoye -> kisi cheez me store krle
    2) niche aate hoye -> return krle ie called backTracking (means call ke niche work hua h)
    3) do backTrack with p,pp,ppp,.....
  */

  public static void inverseArray(int[] arr, int idx) {
    if (idx == arr.length) return;

    int val = arr[idx]; //upr jate hoye value store krli ussi array me, hr jgh hmare stack ki space pr val pdha h
    inverseArray(arr, idx + 1); //faith -> 1se pura array reverse mil jaega jo iss call ke niche hoga ie back track
    //har function alg alg h
    arr[val] = idx; //jo array tha vo change krdiya 1st index ko value pr store kra
  }

  //practice -> to use of return type ques
  public static int[] inverseArray_returnType_practice(int[] arr, int idx) {
    if (idx == arr.length) return arr; //agar aise parameter to jo array given hai voi return krdo ya
    // new array better is to make a new , isse hm original me change krke ussi ko return krre hai

    int val = arr[idx];

    int[] ar = inverseArray_returnType_practice(arr, idx + 1); //2nd step is to catch that in the given return type

    arr[val] = idx;
    return ar;
  }

  // =======================================================================================
  // class 4 ie 13 th ques1 ->
  public static int sumOfDigit(String str, int idx) {
    //eg: 1234
    if (idx == str.length()) return 0;

    int recAns = sumOfDigit(str, idx + 1); // we get sum of 234
    return recAns + str.charAt(idx) - '0'; //to covert it in char 'X' - 'x' = integer
  }

  // ques2 ->
  public static long stringToNumber(String str, int idx, long pow) {
    // loop starts from backword because agar front se start krege toh hmko power function use krna pdhega

    if (idx == -1) {
      return 0;
    }

    long recAns = stringToNumber(str, idx - 1, pow * 10); //upr jare hai idr se and we create the power,loop piche se chlaya

    return recAns + (str.charAt(idx) - '0') * pow;
  }

  //ques3 ->
  public static boolean checkReverse(String s1, int idx1, String s2, int idx2) {
    // [NOTE -> JB dry run krege toh dono string lekr krege and jb code likhe specially recursion ke toh hum index ke term me likhege
    if (idx2 == -1) return true;
    //faith: abcd(idx1 on a) , dcba ((idx2 on a) agar dono equal to sahi hai)
    if (s1.length() == s2.length()) {
      if (s1.charAt(idx1) != s2.charAt(idx2)) return false;
      return checkReverse(s1, idx1 + 1, s2, idx2 - 1);
    } else {
      System.out.println("false");
    }
  }

  //ques4 -> palindrome ofString [use this by difference method]
  public static boolean palidromeOfString(String str, int i, int j) {
   if( i >= j) return true;
    // 1st hmne dono character nikal liye['B' and 'b' are same that why we do this by diff]
    char ch1 = str.charAt(i);
    char ch2 = str.charAt(j);

    int diff1 = (ch1 >= 'A' && ch1 <= 'Z') ? ch1 - 'A' : ch1 - 'a';
    int diff2 = (ch2 >= 'A' && ch2 <= 'Z') ? ch2 - 'A' : ch2 - 'a';

    if(diff1 != diff2) return false;
    return palidromeOfString(str,i + 1, j - 1;)
  }

  //ques4->seperate duplicates[extra ques]
  /*[NOTE IMPORTANT -> Jbhi hm ques krte hai recursion me jo string hoti hai unko hum always idx ki approach se krege[in code]
                    and dry run ke time pr hm stack me dono string lekr krege  ]
  */

  public static String seprateDuplicate_wayDown(String str) {
    //jidr bhi 2 same conseqetive character milege to unke bich me * append krwadenege
    if(str.length() == 1) return "";  //"" nhi kr skte becuase agar kra to we get a null point exception
    //  empty string result catch krega index exist hi nhi krta


    char ch = str.charAt(0);
    String ros = str.substring(1);  //1se end tak ki string bhjdi
    
    String result = seprateDuplicate(ros);  //faith
    //verify 1st and last charact
    if(ch != result.charAt(0))
    return ch + result;
    else return ch + "*" + result;

   /* [note: return type recursion mostly used in dp important isko kisi variable
    me catch krna neccessary h coz use hm niche use krte hai]*/
  }

  public static void seperateDuplaicates_wayup(String str,int idx, String ans) {
    /* [note: return type recursion mostly used in dp important isko kisi variable
    me catch krna neccessary h coz use hm niche use krte hai]*/
    if(idx == str.length()-1){
      System.out.println(ans + str.charAt(str.length() - 1));
      return;
    }

    //note: way up is more easier than return type recursion and it is usefull in graph

    char ch = str.charAt(idx);
    
    //kuch add krege upr jate hoye -> toh  better to make new string agr bina extra space krna hota to we use linked list
    if(idx == str.charAt(idx + 1)){
      seperateDuplaicates_wayup(str,idx+1,ans+ch + "*");
    }else 
    seperateDuplaicates_wayup(str,idx+1,ans+ch);

  }

  //ques5->
  public static void removeAdjacentDuplicates_wayup(String str,int idx ,String ans) {
    /*
    WayUp -> isme hme ik "answer" name ki string lenge because we have to make our answer when we going upward so usko kahin store krlege
    2)isme idx bhi le skte
    */
    if(idx == str.length() - 1){
      System.out.println(ans + str.charAt(idx));
      return;
    }
    char ch = str.charAt(idx);
    if(ch != str.charAt(idx + 1))
      removeAdjacentDuplicates_wayup(str,idx+1,ans+ ch);
    else
      removeAdjacentDuplicates_wayup(str,idx + 1,ans);

  }

  public static String removeAdjacentDuplicates(String str) {
    if(str.length() == 1)
    return str;

    char ch = str.charAt(0);
    String ros = str.substring(1);

    String result = removeAdjacentDuplicates(ros);
    if(ch != result.charAt(0)) return ch +result;
    return result;    
  }

  // =======================================================================================
    //ques1->
   // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-22movecharacters/problem
 
//  ques2->
  // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-23countorremovehi
   public static int countAllHi(String str,int idx) {
        
        if(idx >= str.length() - 1){  //means hm end tak chle gye ie 11 index so we will not hi from there 
            return 0;
        }
        String s = str.substring(idx,idx+2);  //take 2 substring only at one time
        // if(str == s) never do this compare in string because it compare adress so use ".equals"
          if(s.equals("hi")){
              return countAllHi(str,idx+2) + 1;  //+1 kyoki hm khud bhi hii the
          } else {
               return countAllHi(str,idx+1); //because 1st charact is not start with "i" 
          }
    }
    
    public static void countAllHi(String str,int idx,String ans) {
        //way up isme hum apna answer upr jate huye bnate h so ans variable me store krlete h
        if(idx >= str.length() - 1){  //means hm end tak chle gye ie 11 index so we will not hi from there 
            if(idx == str.length() - 1) ans += str.charAt(idx);
            System.out.println(ans);
            return;
        }
        String s = str.substring(idx,idx+2);  //take 2 substring only at one time
          if(s.equals("hi")){
               countAllHi(str,idx+2,ans);  //if it is hi then nothing to do
          } else {
               countAllHi(str,idx+1,ans + str.charAt(idx)); //agar equal nhi h toh ans me vo charac add krdo 
          }
    }
    
    public static String countAllHi_(String str,int idx) {
        if(idx >= str.length() - 1){  //means hm end tak chle gye ie 11 index so we will not hi from there 
            if(idx == str.length() - 1) return (str.charAt(idx) + "");
            return"";
        }
        String s = str.substring(idx,idx+2);  //take 2 substring only at one time
          if(s.equals("hi")){
              return countAllHi_(str,idx+2);  //means hi remove hokr aagye hai
          } else {
              return str.charAt(idx) + countAllHi_(str,idx+1); //upr se jo bhi aaya sab remove hogya aur hum hi ke equal nhi h to aage add krdo 
          }
    }
    
  public static void main(String[] args) {
    // int a = scn.nextInt();
    // int n = scn.nextInt();
    // printIncreasing(a, b);
    // p(a);
    // pdi(n);
    // pdiOddEven(n);
    // System.out.println(factorial_(n));
    // String str = scn.next();
    // int div = scn.nextInt();
    // System.out.println(stringToNumber(str, str.length() - 1, 1) / div);

    //main for count or remove hi
     String str = scn.next();
        int n = scn.nextInt();
        
        System.out.println(countAllHi(str,0));
        System.out.println(countAllHi_(str,0).charAt(n));
        countAllHi(str,0,"");
  }
}
