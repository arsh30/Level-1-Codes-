import java.util.ArrayList;
import java.util.PriorityQueue;

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

  //class 2

  public static boolean hasPath(int src, int dest, boolean[] vis) {
    if (src == dest) {
      return true;
    }

    boolean res = false;
    vis[src] = true;
    for (Edge e : graph[src]) { //sare nbr pr call lgayi
      if (!vis[e.v]) res = res || hasPath(e.v, dest, vis); // res = res || hasPath(e.v, dest, vis);
    }
    return res;
  }

  public static int allPaths(int src, int dest, boolean[] vis, String ans) { //same as has path, bss isme false mark krege jab jaege
    if (src == dest) {
      System.out.println(ans + dest);
      return 1;
    }
    int count = 0;

    vis[src] = true; //because infinite call na lgjaye

    for (Edge e : graph[src]) { //ik edge me e or v hai to hme v compare krna
      if (!vis[e.v]) count += allPaths(e.v, dest, vis, ans + src); //edge ke andr destination dekhna that is v
    }

    vis[src] = false;
    return count;
  }

  public static void printPreOrder(
    int src,
    boolean[] vis,
    String ans,
    int wsf
  ) {
    //it does not any base case because jab sare true hojege to call lgegi hi nahi

    System.out.println(src + " -> " + ans + src + " @ " + wsf);
    vis[src] = true; //step 1
    for (Edge e : graph[src]) { //step 2 -> visited nbr -> we get the (0,1) and (0,3) edge
      if (!vis[e.v]) printPreOrder(e.v, vis, ans + src, wsf + e.w);
    }
    vis[src] = false;
  }

  public static void postOrder(int src, boolean[] vis, String ans, int wsf) {
    vis[src] = true;
    for (Edge e : graph[src]) {
      if (!vis[e.v]) postOrder(e.v, vis, ans + src, wsf + e.w);
    } //this for loop complete 1st iteration complete to print 1st postOrder
    System.out.println(src + "->" + ans + src + "@" + wsf);
    vis[src] = false;
  }

  public static class Pair {

    int largestWeight = -(int) 1e9;
    String largestPath = "";
    int smallestWeight = (int) 1e9;
    String smallestPath = "";

    int ceil = (int) 1e9;
    String ceilPath = "";
    int floor = -(int) 1e9;
    String floorPath = "";
  }

  // to find kth largest
  public static class pqPair {

    int wsf = 0;
    String psf = ""; //it  is a answer

    pqPair(int wsf, String psf) {
      this.wsf = wsf;
      this.psf = psf;
    }
  }

  static PriorityQueue<pqPair> pq = new PriorityQueue<>(
    (a, b) -> {
      return a.wsf - b.wsf; //compare on terms of weight
    }
  );

  public static void allSolution(
    int src,
    int dest,
    boolean[] vis,
    Pair p,
    String psf,
    int wsf,
    int givenWeight,
    int k
  ) {
    if (src == dest) {
      //means sare answer idr hi milege, to jo work hoga idr hi hoga
      if (wsf > p.largestWeight) {
        p.largestWeight = wsf;
        p.largestPath = psf + dest;
      }
      if (wsf < p.smallestWeight) {
        p.smallestWeight = wsf;
        p.smallestPath = psf + dest;
      }

      //Now find ceil and floor
      if (wsf < givenWeight) {
        p.floor = Math.max(p.floor, wsf); //idr sare weight to aagye hai tbhi
      }
      if (wsf > givenWeight) {
        p.ceil = Math.min(p.ceil, wsf);
      }

      //find kth largest
      pq.add(new pqPair(wsf, psf + dest)); //add wsf and psf
      if (pq.size() > k) {
        pq.remove();
      }

      return;
    }
    vis[src] = true;
    for (Edge e : graph[src]) {
      if (!vis[e.v]) allSolution(
        e.v,
        dest,
        vis,
        p,
        psf + src,
        wsf + e.w,
        givenWeight,
        k
      );
    }
    vis[src] = false;
  }

  public static void dfs(int src, boolean[] vis) { //src is vertex
    vis[src] = true;
    for (Edge e : graph[src]) {
      if (!vis[e.v]) dfs(e.v, vis);
    }
  }

  public static void gcc() {
    boolean[] vis = new boolean[N];
    int components = 0;
    for (int i = 0; i < N; i++) { //har vertex se dfs call krege[has path wala] if it is unvisited
      if (!vis[i]) {
        components++;
        dfs(i, vis);
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < N; i++) { //These steps will make an arraylist of array
      graph[i] = new ArrayList<>();
    }

    addEdge(0, 1, 10);
    addEdge(0, 3, 40);
    addEdge(1, 2, 10);
    addEdge(2, 3, 10);
    addEdge(3, 4, 2);
    addEdge(4, 5, 3);
    addEdge(4, 6, 8);
    addEdge(5, 6, 3);
    addEdge(2, 5, 5);

    boolean[] vis = new boolean[N];
    // System.out.print(allPaths(0, 6, vis, ""));
    // printPreOrder(0, vis, "", 0);
    // postOrder(0, vis, "", 0);
    Pair p = new Pair(); //kuch paas nahi kra
    allSolution(0, 6, vis, p, "", 0, 30, 4);
    System.out.println(
      "smallest Path= " + p.smallestPath + "@" + p.smallestWeight
    );
    System.out.println(
      "largest Path= " + p.largestPath + "@" + p.largestWeight
    );
    System.out.println("Ceil  of 30 = " + p.ceil);
    System.out.println("Floor of 30 = " + p.floor);
    System.out.println(
      "Kth Largest Path = " + pq.peek().psf + "@" + pq.peek().wsf
    ); //pq sbse kth largest to peek pr hoga , pq is min type
    //nikala nhi hai bss direct same krre hai
    // display();
  }
}
