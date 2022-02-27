import java.util.Scanner;
public class client {
  public static Scanner scn = new Scanner(System.in); 

  public static void main(String[] args) {
    HashMap1 map = new HashMap1();
    map.put(10, 1);
    map.put(11, 14);
    map.put(12, 16);
    map.put(13, 17);
    map.put(14, 8);
    map.put(15, 9);

    // System.out.println(map.get(12));
    // System.out.println(map.getOrDefault(120,null));
    // map.put(120,2);
    // System.out.println(map.get(120));

    //make a frequency map
    for(int i = 0; i <= 10; i++) {
        int a = scn.nextInt();
        map.put(a,map.getOrDefault(a,0) + 1);
    }

    System.out.println(map.get(1));
    System.out.println(map.get(3));
  }
}
