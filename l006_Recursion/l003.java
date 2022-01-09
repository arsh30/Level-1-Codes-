import java.util.Scanner;

public class l003 {

  public static Scanner scn = new Scanner(System.in);

  // here we use the direction loop, ideally we will use 4 if so instead of this we use direction loop
  /*Vector theory -> it has magnitude as well as direction eg: we have to move somewhere so hm x me kuch add krege
                and 'y' me kuch add krege uss direction pr aajaege
                Assume EveryDirection has a vector ie i^, j ^ 
                */
  // note: jbhi 4 direction me call lge ya backword bhi move krna ho toh always use DFS, ie true and do false again concept
  public static int floodFill(
    int sr,
    int sc,
    int er,
    int ec,
    boolean[][] vis, //yeh isliye because we can trace them ki kisko visit kr chuke hai, and iska jo size hoga vo jitne number visit honge utna hi hoga
    int[][] dir,
    String[] dirS,
    String ans
  ) {
    if (sr == er && sc == ec) {
      System.out.println(ans);
      return 1;
    }
    vis[sr][sc] = true;
    int n = vis.length;
    int m = vis[0].length;
    int count = 0;

    for (int d = 0; d < dir.length; d++) { //dir ki row ke liye sirf
      int r = sr + dir[d][0]; //dir[d][0] ie i cap
      int c = sc + dir[d][1]; //dir[d][0] ie j cap

      // check the boundry is in range or not
      if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]) { //!vis[r][c] -> means check krke jaege jidr jare h vo visited na ho
        count += floodFill(r, c, er, ec, vis, dir, dirS, ans + dirS[d]); //ans + dirS[d] -> ans me add kra jis jagah gye hai vo direct ka name
      }
    }

    vis[sr][sc] = false;
    return count;
  }

  //   Radius concept -> means agar hmko print krna ho circle me to aise krege ki ik radius ka loop lgadenege pehle at max 1 ,1 ki hi jump
  // lekr jara hai, radius concept concept is that max jump leskta hai then accoriding to radius

  public static int floodFill_withJump(
    int sr,
    int sc,
    int er,
    int ec,
    boolean[][] vis,
    int[][] dir,
    String[] dirS,
    String ans
  ) {
    if (sr == er && sc == ec) {
      System.out.println(ans);
      return 1;
    }
    // use -> radius loop
    vis[sr][sc] = true;

    int n = vis.length;
    int m = vis[0].length;
    int count = 0;

    for (int rad = 1; rad <= Math.max(n, m); rad++) for (
      int d = 0;
      d < dir.length;
      d++
    ) {
      int r = sr + rad * dir[d][0];
      int c = sc + rad * dir[d][1]; //unit vector j cap

      // check that we are in range in or not
      if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]) {
        count +=
          floodFill_withJump(r, c, er, ec, vis, dir, dirS, ans + dirS[d] + rad);
      }
    }

    vis[sr][sc] = false; //this is backtracking
    return count;
  }

  public static void displayBoard(int[][] chess) {
    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess[0].length; j++) {
        System.out.print(chess[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
  }

  public static int knightTour(
    int sr,
    int sc,
    int move,
    int tnc,
    int[][] vis,
    int[][] dir
  ) {
    if (move == tnc) {
      // hmne matrix 0 se start kra hai to 25 tnc me 24 call lg kr add hoga ik bchega usko add krege
      vis[sr][sc] = move;
      displayBoard(vis);
      vis[sr][sc] = 0;
      return 1;
    }

    vis[sr][sc] = move; //initial move aate hi

    int n = vis.length;
    int m = vis[0].length;
    int count = 0;
    for (int d = 0; d < dir.length; d++) {
      int r = sr + dir[d][0];
      int c = sc + dir[d][1];

      // check we are in the boundary or not
      if (r >= 0 && c >= 0 && r < n && c < m && vis[r][c] == 0) {
        count += knightTour(r, c, move + 1, tnc, vis, dir);
      }
    }
    vis[sr][sc] = 0;
    return count;
  }

  public static int findTargetSumWays(int[] nums, int S, int idx) {
    if (idx == nums.length) { 
      return S == 0 ? 1 : 0;
    }
    int count = 0;

    count += findTargetSumWays(nums, S - nums[idx], idx + 1); //S is target eg S = 100, 100 - nums[idx(10)] = 90 so idx + 1apna target le aao
    count += findTargetSumWays(nums, S - (-nums[idx]), idx + 1);
    return count;
  }

  // https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
  // https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
  // https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/?ref=rp
  // https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/?ref=rp

  public static void main(String[] args) {
    // int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
    int[][] dir = {
      { -2, 1 },
      { -1, 2 },
      { 1, 2 },
      { 2, 1 },
      { 2, -1 },
      { 1, -2 },
      { -1, -2 },
      { -2, -1 },
    };
    String[] dirS = { "L", "D", "R", "U" };

    int n = 3, m = 3;
    boolean[][] vis = new boolean[n][m];
    // System.out.println(floodFill(0, 0, n - 1, m - 1, vis, dir, dirS, ""));
    System.out.println(
      floodFill_withJump(0, 0, n - 1, m - 1, vis, dir, dirS, "")
    );
  }
}
