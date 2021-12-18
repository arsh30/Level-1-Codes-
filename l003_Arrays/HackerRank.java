/*IMPORTANT NOTE: -> Array is reference dataType means usme agar kuch bhi changes kro toh pure array me reflet hote h
    Array ko kbhi bhi print nahi krna chaiye agar print krte hai toh uska adress print hoga not element
*/

import java.util.List;
public static List<Integer> reverseArray(List<Integer> a) {  //arraylist
    // Write your code here
        int i = 0; //means index
        int j = a.size() - 1;
        while(i < j){
            int val1 = a.get(i);  //dono value nikali
            int val2 = a.get(j);
            a.set(j, val1);
            a.set(i, val2);
            i++;
            j--;
        }
        return a;
    }
}
