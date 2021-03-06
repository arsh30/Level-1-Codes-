import java.util.ArrayList;
import java.util.LinkedList;
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

  //class 3=======================

  public static boolean isGraphConnected() {
    boolean[] vis = new boolean[N];
    int components = 0;
    for (int i = 0; i < N; i++) { //har vertex se dfs call krege[has path wala] if it is unvisited
      if (!vis[i]) {
        components++;
        dfs(i, vis);
      }
    }
    return components == 1; //agr true hoga to 1 otherwise false
  }

  public static void dfs_island(int[][] mat, int[][] dir, int i, int j) {
    mat[i][j] = 0;
    for (int d = 0; d < 4; d++) {
      int r = i + dir[d][0];
      int c = j + dir[d][1];

      if (
        r >= 0 &&
        r < mat.length &&
        c >= 0 &&
        c < mat[0].length &&
        mat[r][c] == 1
      ) {
        dfs_island(mat, dir, r, c);
      }
    }
  }

  public static int numberIsland(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    //make 2d direction matrix
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) { //means har cell se dfs call lgayi hai
        if (mat[i][j] == 1) {
          count++;
          dfs_island(mat, dir, i, j);
        }
      }
    }
    return count;
  }

  public static void hamintonian_dfs(
    int src,
    int originalSrc,
    boolean[] vis,
    int noOfEdges,
    String psf
  ) {
    if (noOfEdges == N - 1) {
      // means hmko 1 path milgya
      System.out.println(psf + src); //psf -> because hmne answer print krna hai
      int idx = findEdge(src, originalSrc);
      if (idx != -1) {
        System.out.print("*");
      }
      System.out.println();
      return;
    }

    vis[src] = true;
    for (Edge e : graph[src]) { //same call like printAll Path
      if (!vis[e.v]) hamintonian_dfs(
        e.v,
        originalSrc,
        vis,
        noOfEdges + 1,
        psf + src
      );
    }
    vis[src] = false;
  }

  public static void hamintonianPath() {
    boolean[] vis = new boolean[N];
    hamintonian_dfs(0, 0, vis, 0, "");
  }

  //MOON PROBLEM HACKER-RANK

  public static int moonDFS(
    ArrayList<Integer>[] graph,
    int src,
    boolean[] vis
  ) {
    //yeh 1 component ka size dega
    vis[src] = true;
    int size = 0;
    for (Integer e : graph[src]) {
      if (!vis[e]) {
        // abhi hme ik compoenent ka size pta lgana faith kya rkhe? left apna size le aayega right apna
        size += moonDFS(graph, e, vis); //e is nbr
      }
    }
    return size + 1;
  }

  public static long journeyToMoon(int n, int[][] astronaut) { //make a graph
    ArrayList<Integer>[] graph = new ArrayList[n]; //n is no of astranaut
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] a : astronaut) {
      //jo array hai usme u and v given hai so usse graph ko develop krege
      graph[a[0]].add(a[1]);
      graph[a[1]].add(a[0]);
    }
    // for(int i = 0; i < astronaut.size(); i++){
    //     List<Integer> li = astronaut.get(i);
    //     int u = li.get(0);
    //     int v = li.get(1);
    //     graph.get(u).add(v);
    //     graph.get(v).add(u);
    // }

    //now ab hme dfs apply krke pta krna hai ki kitne components hai or unka size kya hai

    ArrayList<Integer> sizeArray = new ArrayList<>();
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!vis[i]) sizeArray.add(moonDFS(graph, i, vis)); //sabhi component ka size pta lggya
    }

    long res = 0, ssf = 0;
    for (int ele : sizeArray) { //idr hmne pairs bnaege in O(n)
      res += ele * ssf;
      ssf += ele;
    }
    return res;
  }

  public static void BFS(int src, boolean[] vis) {
    int level = 0, cycleCount = 0;

    LinkedList<Integer> que = new LinkedList<>();
    que.addLast(src);

    while (que.size() != 0) {
      int size = que.size();
      System.out.print(level + " -> ");

      //findCycle
      while (size-- > 0) {
        int rvtx = que.removeFirst();
        if (vis[rvtx]) {
          cycleCount++;
          continue;
        }

        System.out.print(rvtx + " ");

        vis[rvtx] = true;
        for (Edge e : graph[rvtx]) {
          if (!vis[e.v]) {
            que.addLast(e.v);
          }
        }
      }
      System.out.println();
      level++;
    }
  }

  public static void BFS_02(int src, boolean[] vis) { //Without Cycle
    int level = 0, cycleCount = 0;
    LinkedList<Integer> que = new LinkedList<>();
    vis[src] = true;
    que.addLast(src);

    while (que.size() != 0) { //this loop is not neccessary, usefull in when cycle exist
      int size = que.size();
      System.out.print(level + " -> ");

      while (size-- > 0) { //jb tak que ke size 0 nhi hota tb tak
        int rvtx = que.removeFirst();

        //idr se cycle count wala remove kra

        System.out.print(rvtx + " ");
        for (Edge e : graph[rvtx]) {
          if (!vis[e.v]) {
            que.addLast(e.v);
            vis[e.v] = true;
          }
        }
      }

      System.out.println();
      level++;
    }
  }

  public static boolean isTree() {
    // No cycle and 1 GCC cunt
    return true;
  }

  public static boolean isForest() {
    // No cycle and more than 1 GCC coun
    return true;
  }

  public static boolean isBipartite(int src) {
    LinkedList<Integer> que = new LinkedList<>();
    int[] vis = new int[N];
    Arrays.fill(vis, -1); //fill the boolean arrays with -1

    que.addLast(src);
    int color = 0; //level

    while (que.size() != 0) {
      int size = que.size();

      while (size-- > 0) {
        int rvtx = que.removeFirst();

        //check cycle
        if (vis[rvtx] != -1) { //phle se present hai or dekha ki vo -1 nhi
          if (vis[rvtx] != color) { //then dekhege konse color ka hai, agar jo phle se vis me hai uska color or iska same nhi h means nhi h
            return false; //means color different hai
          }
          continue;
        }
        vis[rvtx] = color;

        for (Edge e : graph[rvtx]) {
          if (vis[e.v] == -1) {
            que.addLast(e.v);
          }
        }
      }
      color = (color + 1) % 2; //because 0, 1 me hi khele
    }
    return true;
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
    // Pair p = new Pair(); //kuch paas nahi kra
    // allSolution(0, 6, vis, p, "", 0, 30, 4);
    // System.out.println(
    //   "smallest Path= " + p.smallestPath + "@" + p.smallestWeight
    // );
    // System.out.println(
    //   "largest Path= " + p.largestPath + "@" + p.largestWeight
    // );
    // System.out.println("Ceil  of 30 = " + p.ceil);
    // System.out.println("Floor of 30 = " + p.floor);
    // System.out.println(
    //   "Kth Largest Path = " + pq.peek().psf + "@" + pq.peek().wsf
    // ); //pq sbse kth largest to peek pr hoga , pq is min type
    //nikala nhi hai bss direct same krre hai
    // display();

    // hamintonianPath();
    BFS(0, vis);
  }
}
