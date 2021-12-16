import java.util.Scanner;

public class l001 {
    public static Scanner scn = new Scanner(System.in);

    /*
     * ques1 -> isPalindrome -> means string is foldable you can read the string
     * from the starting index as well as we can read from the ending of the string.
     * It remains same. if they are same means they are palindrome otherwise not
     * Eg: abccba (1st last pointer are equal toh aage chlo nothing to do. so jidr
     * unequal aagye means palindrome nhi hai string)
     * 
     * APPROACH:-> Take 2 pointer in the beginning of the string and other pointer
     * is at the end of the string
     * 2)i++ and j-- only if they are equal, i jab tak chota hai tab tak aage chlega
     * 3)when we get the unequal no return from there means it is not a palindrome
     * 
     */
    public static boolean isPalindrome(String str) {
        int si = 0; // note: string me 1st character acces direct krte hai 0 while in array arr[0]
        int ei = str.length() - 1;
        while (si <= ei) {
            if (str.charAt(si) != str.charAt(ei)) {
                return false;
            } else {
                si++;
                ei--;
            }
        }
        return true;
    }

    /*
     * Ques2 - > Substring formula -> (si,ei + 1) -> int terms of index
     * Substring formula -> (si,si + len) -> int terms of length make this formula,
     * because it issame in cpp.
     * how? -> len is ei + 1 -si => so put in formula -> (si, si + ei + 1 - si ) si
     * ,si cancel
     * overall in term of length (si, si + len)
     * 
     * Approach-> 1) means traverse on the string (1st loop)
     * 2) 2nd loop is for print the substring length (means kidr se kidr tak print
     * krni hai)
     * 3) Eg:-> "abcd" so substrings are a,ab,abc,abcd,b,bc,bcd,c,cd,d
     * 
     * NOTE: Substring of(0,0) is " ", and Substring of(2,1) -> not exist si is not
     * greater than ei
     */

    // travel on length
    public static void getAllSubstring(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int len = 1; i + len <= len; len++) {
                System.out.println(str.substring(i, i + len)); // time complexity of string is O(n);
            }
        }
    }

    // ques3 -?
    public static void getAllPalindromicSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int len = 1; i + len <= str.length(); len++) { // length means if they ki 1 se 2
                String s = str.substring(i, i + len);
                if (isPalindrome(s)) {
                    System.out.println(s);
                }
            }
        }
    }

    //ques4 -> 
    /*  means  koi string given hai eg abbbccdeefgg , so print those string which are in continous form if it is one then doesnot print
        output: ab3c2de2fg2 (a one time hai thats why we dont print the number)
    */
    public static void stringCompression() {
        
    }

    public static void main(String[] args) {
        String str = scn.next(); // taking input next or nextLine()
        getAllPalindromicSubstrings(str);
    }
}