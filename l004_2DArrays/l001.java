import java.util.Scanner;

public class l001 {
    public static Scanner scn = new Scanner(System.in);

    public static void input(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length; // means 0th row length,it is the matrix so for all columns it have same length

        for (int i = 0; i < n; i++) { // for rows
            for (int j = 0; j < m; j++) { // for columns loop
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void display1(int[][] arr) {
        int n = scn.nextInt();
        int m = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // FOREACH Loop of display
    public static void display(int[][] arr) {
        for (int[] ar : arr) { // single 1d array -> int ele : arr, so here arr 2 d usme ik one D array ha
            // pehle uspr loop lgaege then arr[0] pr ik hor array hai uspr loop elements
            // access krege
            for (int e : ar) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static int maximum_(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int maxEle = -(int) 1e9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxEle = Math.max(maxEle, arr[i][j]);
            }
        }
        return maxEle;
    }

    // using for Each loop ->
    public static int maximum(int[][] arr) {
        int maxEle = -(int) 1e9;
        for (int[] ar : arr) { // 1st dekhte hai ki arr ke andr kya hai(means kis dataType ki value hai) 1 hor
                               // aaray
            for (int e : ar) {
                maxEle = Math.max(maxEle, e);
            }
        }
        return maxEle;
    }

    public static int minimum(int[][] arr) {
        int minEle = (int) 1e9;
        for (int[] ar : arr) {
            for (int e : ar) {
                minEle = Math.min(minEle, e);
            }
        }
        return minEle;
    }

    public static boolean findData(int[][] arr, int data) {
        for (int[] ar : arr) {
            for (int e : ar) {
                if (e == data) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * ROTATE BY 90 DEGREE__________
     * 1st take transpose: -> in matrix that first row became 1st column , 2nd row
     * become 2nd column and so on(swap -> e(i,j) -> e(j,i)).so make sure that we
     * will move only in upper triangle or lower traingle
     * 
     * 
     * 2)then swap the columns(or reverse the columns) -> swap 1st column with 4 th
     * and 2nd with 3rd
     */

    // ques->1
    public static void waveTraversalLeftRight(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) { // row are same columns move 0-4 and 4-0 & 0-4 and then again 4-0 and so on
                                      // means left right. if the value is even then only it move left to right
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // ques2
    public static void waveTraversalUpAndDown(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for (int j = 0; j < m; j++) { // colum are same means move 0 to n-1 ,row move 0-4 and 4-0 & 0-4 and then again
                                      // 4-0 and so on
                                      // means top- bottom and bottom top. if the value is even then only it move left
                                      // to right
            if (j % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int i = n - 1; i >= 0; i--) { // bottom to top
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // ques3 ->
    /*
     * we use gap technique only in diagonal format base diagonal with 0 jump, and
     * use agla vala diagonal 1 ki jump pr hoga from base diagonal, and 3rd diagonal
     * jo vo3rd distance hoga from base diagonal and so on
     * 2) in gap "i" is always start from 0 and j is always start from gap
     * 3) and diagonal me move krna hai toh always move with the same speed i and j
     */
    public static void diagonalTraversal(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for (int gap = 0; gap < m; gap++) { // gap ko m pr rakha hai
            for (int i = 0, j = gap; i < n && j < m; i++, j++) { // row are fixed
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ques4
    public static void rotate90(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) { // if we travel the whole matrix it cant be reverse
                // so travel only in upper triangle: so start the loop with i
                // do swap for transpose -> move in upper triangle
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // reverse of columns
        // swap 1st column with last and 2nd column with 3rd
        int j1 = 0, j2 = m - 1;
        while (j1 < j2) {
            // again swap
            for (int i = 0; i < n; i++) { // when we do swap> only rows will change
                int temp = arr[i][j1];
                arr[i][j1] = arr[i][j2];
                arr[i][j2] = temp;
            }
            j1++;
            j2--;
        }
    }

    // ===========================
    // 2ndJan ->

    /*
     * ques1->EXIT POINT OF A MATRIX
     * 1) exit point of matrix-> wherever we get the 1 take the right turn from
     * there if it shows 1 means it goes straight.
     * 2)e have to specify(batana) the index where we exited (ho chuka) the matrix
     */
    public static void exitPointOfMatrix(int[][] arr) { // to access values -> eg:arr[1][3] = 3
        int r = 0, c = 0, dir = 0; // do this with the direction loop
        while (true) { // true means infinite loop
            dir = (dir + arr[r][c]) % 4;
            if (dir == 0) { // move , assume right - 0, down - 1, left- 2, up - 3
                c++; // when we move right the values of c is always increase
                // now find the break point
                if (c == arr[0].length) {
                    System.out.println(r); // output format first print row then column
                    System.out.println(c - 1);
                    break;
                }
            } else if (dir == 1) { // move down
                r++;
                if (r == arr.length) {
                    System.out.println(r - 1); // jo last point hoga usse ik pehele
                    System.out.println(c);
                    break;
                }

            } else if (dir == 2) { // move right
                c--;
                if (c == -1) { // means 0 tak valid hai jb use upr jaegi ie in negative then hm add krege + 1
                               // to access the element at 0 index
                    System.out.println(r);
                    System.out.println(c + 1);
                    break;
                }

            } else { // d = 3 move up means
                r--;
                if (r == -1) {
                    System.out.println(r + 1);
                    System.out.println(c);
                    break;
                }
            }

        }
    }

    public static void spiralDisplay(int[][] arr) {
        // think this by box by box, take 4 variable rmin rmax, cmin,cmax. means jb hmko
        // yeh pta hoga ki kidr se kidr tak jana then we can print the box
        int n = arr.length, m = arr[0].length;
        int tne = n * m; // means we cant travel any element more than once
        int rmin = 0, rmax = n - 1, cmin = 0, cmax = m - 1;
        while (tne > 0) { // note use while loop -> when we dont know the actual condition ki kab rukega
            // left wall
            for (int i = rmin; i <= rmax && tne > 0; i++) {
                tne--;
                System.out.println(arr[i][cmin]);
            }
            cmin++;
            // bottom wall
            for (int i = cmin; i <= cmax && tne > 0; i++) {
                tne--;
                System.out.println(arr[rmax][i]);
            }
            rmax--;
            // right wall
            for (int i = rmax; i >= rmin && tne > 0; i--) {
                tne--;
                System.out.println(arr[i][cmax]);
            }
            cmax--;
            // top wall
            for (int i = cmax; i >= cmin && tne > 0; i--) {
                tne--;
                System.out.println(arr[rmin][i]);
            }
            rmin++;
        }
    }

    public static void searchin2d(int[][] arr, int data) {
        int i = 0, j = arr[0].length - 1; // means start from the top right corner of 0th row
        while (i < arr.length && j >= 0) {
            /*
             * 2 possiblities:
             * 1) if data is greater than elements goes downward
             * 2) if data is smaller than elements goes left side
             */

            if (data == arr[i][j]) {
                System.out.println(i); // print only address
                System.out.println(j);
                return;
            } else if (data < arr[i][j]) { // arr[i][j] are elements
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        input(arr);
        // waveTraversalLeftRight(arr);
        // waveTraversalUpAndDown(arr);
        // diagonalTraversal(arr);
        exitPointOfMatrix(arr);
        // rotate90(arr);
        // display(arr);
    }

}
