import java.util.*;

public class question {

  public boolean isBipartite(int[][] graph, int src, int[] vis) { //yeh compoenent btaega ki vo biparite hai ya nahi
    //-1 -> unviisted, 1 -> green, 2-> red
    LinkedList<Integer> que = new LinkedList<>();
    que.addLast(src);
    int color = 0;

    while (que.size() != 0) {
      int size = que.size();
      while (size-- > 0) {
        int rvtx = que.removeFirst();
        if (vis[rvtx] != -1) { //means its a cycle, to dekege ki konse color ka present hai phle
          if (vis[rvtx] != color) return false; //conflict

          continue;
        }

        vis[rvtx] = color;
        for (int v : graph[rvtx]) {
          if (vis[v] == -1) { // means unvisited hai
            que.addLast(v);
          }
        }
      }
      color = (color + 1) % 2; //2 range ke andr hi rakhenege color
    }
    return true;
  }

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] vis = new int[n];
    Arrays.fill(vis, -1);

    //upr wala functio ik component btaega ki vo bipartite hai ya nahi
    //agar pura graph dekhna ho ki bipartite hai to har vtex se call lgaege
    for (int i = 0; i < n; i++) {
      if (vis[i] == -1 && !isBipartite(graph, i, vis)) return false;
    }
    return true;
  }

  public static int spreadInfection(int src, int timeLimit) { //without cycle
    LinkedList<Integer> que = new LinkedList<>();
    boolean[] vis = new boolean[N];
    que.addLast(src);
    vis[src] = true;

    int time = 0, infectCount = 1;

    while (que.size() != 0) {
      int size = que.size();
      while (size-- > 0) {
        int rvtx = que.removeFirst();

        //   if(vis[rvtx]){  //this to check the cycle

        //   }

        for (Edge e : graph[rvtx]) {
          if (!vis[e.v]) { //agar visited nhi h
            vis[e.v] = true;
            que.addLast(e.v);
            if (time + 1 < timeLimit) {
              infectCount++;
            } else {
              return infectCount;
            }
          }
        }
      }
      time++;
    }
    return infectCount;
  }
}
