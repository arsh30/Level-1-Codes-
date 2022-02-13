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

  public static void maxPQ(){
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        //   return a - b; //this - other gives default behaviour [in ascending order]
            return b - a;  //other - this reverse of default behaviour
      }); 
      for(int i = 10; i >= 0; i--){
          pq.add(i);
      }
      while(pq.size() != 0){
          int ele = pq.remove();
          System.out.print(ele + " ");
      }

  }

  public static void main(String[] args) {
    // minPQ();
    maxPQ();
  }
}
