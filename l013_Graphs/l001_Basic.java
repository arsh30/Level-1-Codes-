import java.util.ArrayList;

public class l001_Basic {

  public static class Edge {

    int v = 0;
    int w = 0;

    //constructor
    Edge(int v, int w) {
      this.v = v;
      this.w = w;
    }

    public String toString() {
      return "(" + v + "," + w + ")";
      //   return "Arshdeep singh over riding";
    }
  }

  public static int N = 7;
  public static ArrayList<Edge>[] graph = new ArrayList[N]; // isse ik array bna jo ll store krta but abhi null hai because

  //new nhi kra means ik array usme al pdhi hai or edge hai usme wt, v bhi h

  public static void addEdge(int u, int v, int w) {
    graph[u].add(new Edge(v, w));
    graph[v].add(new Edge(u, w)); //2 side because it is biderctional
  }

  public static void display() {
    for (int i = 0; i < N; i++) {
      System.out.print(i + "->");
      for (Edge e : graph[i]) { //note:-[graph me loop aise hi chlaege] graph[i] -> we get the list of array
        System.out.print(e);
        // System.out.print("(" + e.v + "," + e.w + ")");
      }
      System.out.println();
    }
  }

  public static int findEdge(int u, int v) {
    //return the index
    for (int i = 0; i < graph[u].size(); i++) {
      Edge e = graph[u].get(i); //edge nikali -> ik ik krke edge mijaegi inse
      if (e.v == v) {
        return i;
      }
    }
    return -1;
  }

  public static void removeEdge(int u, int v) {
    int idx1 = findEdge(u, v); //complete remove krna hai u ko v se and v ko u se
    int idx2 = findEdge(v, u);

    if (idx1 == -1 || idx2 == -1) {
      return;
    }

    graph[u].remove(idx1);
    graph[v].remove(idx2);
  }

  public static void removeVtx(int u) { //remove 3rd vertex
    while (graph[u].size() != 0) { //Note: array, arrayList me loop hmesha piche se chlate hai agar remove krna ho to due to shifting
      int n = graph[u].size();
      Edge e = graph[u].get(n - 1); //e -> it have an edge ie u,v , so hmko bss v chaiye so we write e.v
      removeEdge(u, e.v);
    }
  }

  public static boolean hasPath(int src, int dest, boolean[] vis) {
    if (src == dest) return false;
    boolean res = false;
    for (Edge e : graph[src]) { //sare nbr pr call lgayi
      if (!vis[e.v]) res = res || hasPath(e.v, dest, vis);
    }
    return res;
  }

  public static void main(String[] args) {
    for (int i = 0; i < N; i++) { //These steps will make an arraylist of array
      graph[i] = new ArrayList<>();
    }

    addEdge(0, 1, 10);
    addEdge(0, 3, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 40);
    addEdge(3, 4, 2);
    addEdge(4, 5, 2);
    addEdge(4, 6, 8);
    addEdge(5, 6, 3);

    boolean[] vis = new boolean[N];
    System.out.print(hasPath(0, 6, vis));

    display();
  }
}
