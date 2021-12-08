import java.util.Scanner;

public class l002Pattern {
    public static Scanner scn = new Scanner(System.in);

    // 1st pattern 1
    public static void Triangle(int row) {
        int nst = 1, nsp = 0;
        for (int r = 1; r <= row; r++) {
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            } // after this loop we print the first line
            nst++;
            nsp--;
            System.out.println();
        }
    }

    // 2nd pattern2
    public static void pattern2(int row) {
        int nst = row, nsp = 0;
        for (int r = 1; r <= row; r++) {
            for (int cst = 1; cst <= nst; cst++) { // 2nd loop is for printing
                System.out.print("*\t");
            }
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            nst--;
            nsp++;
            System.out.println();
        }
    }

    // 3rd pattern3
    public static void mirrorTriangle(int row) {
        int nst = 1, nsp = row - 1;
        for (int r = 1; r <= row; r++) {
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            } // after this loop we print the first line
            nst++;
            nsp--;
            System.out.println();
        }
    }

    // 4th pattern 4
    public static void Reverse(int row) {
        int nst = row, nsp = 0;
        for (int r = 1; r <= row; r++) {
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            } // after this loop we print the first line
            nst--;
            nsp++;
            System.out.println();
        }
    }

    // 5th pattern 7th
    public static void pattern7(int row) { // this type of do tith i or j
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {
                if (i == j) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    // ques 6 -> pattern 8
    public static void pattern8(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {
                if (i + j == row + 1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    // ques7 -> pattern 9
    public static void pattern9(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {
                if (i == j || i + j == row + 1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    // ques8 -> pattern prctice 9.1cd.[observe the pattern that what is coming by
    // doing eg: i + j = 1 or i - j == 1]
    public static void pattern9_01(int row) {
        int p = row + 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {
                if (i + j == p || i + j == p - 2 || i + j == p + 2) { // observe kra hai row+ 1 center diagonal print
                                                                      // krta hai toh yeh kya krega
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    // ques9 -> pattern prctice 9.2
    public static void pattern9_02(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {
                if (i - j == 0 || i - j == -2 || i - j == 2) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void pattern5(int row) { // do this with nst ,cst
        int nst = 1, nsp = row / 2;
        for (int r = 1; r <= row; r++) {
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }

            // now think to go on the 2nd line
            if (r <= row / 2) { // ie mid
                nst += 2;
                nsp--;
            } else {
                nst = nst - 2;
                nsp++;
            }
            System.out.println();
        }
    }

    public static void pattern6(int row) { // till now we have done same no of rows and same no of columns but in this
                                           // we have row n and more column
        int nst = row / 2 + 1, nsp = 1;
        for (int r = 1; r <= row; r++) { // for row
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            for (int cst = 1; cst <= nst; cst++) { // means 3 loop lge 1st star , 2nd loop is for space and 3 rd is for
                                                   // again star
                System.out.print("*\t");
            }
            // now think to go on 2nd row
            if (r <= row / 2) {
                nst--;
                nsp += 2;
            } else {
                nst++;
                nsp -= 2;
            }
            System.out.println();
        }
    }

    public static void pattern15(int row) {
        int val = 1; // because to print the number pattern
        int nst = 1, nsp = row / 2;
        for (int r = 1; r <= row; r++) {
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print(val + "\t"); // to print the number
                if (cst <= nst / 2) // these are columns printing
                    val++;
                else
                    val--;
            }

            // now preparation to come to 2nd row
            if (r <= row / 2) {
                nsp--;
                nst += 2;
                val = r + 1;
            } else {
                nsp++;
                nst -= 2;
                val = row - r; // eg: row 5 - r (4) ie 1
            }

            System.out.println();
        }
    }

    public static void pattern15_01(int row) {
        int val = 1; // because to print the number pattern
        int nst = 1, nsp = row / 2;
        for (int r = 1; r <= row; r++) {
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print(val + "\t"); // to print the number
                if (cst <= nst / 2) // these are columns printing
                    val--;
                else
                    val++;
            }

            // now preparation to come to 2nd row
            if (r <= row / 2) {
                nsp--;
                nst += 2;
                val = r + 1;
            } else {
                nsp++;
                nst -= 2;
                val = row - r; // eg: row 5 - r (4) ie 1
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        // Triangle(n); //1st pattern
        // pattern2(n);
        // mirrorTriangle(n); //3rd pattern
        // Reverse(n); //4th pattern
        // pattern5(n);
        // pattern6(n);
        // pattern7(n);
        // pattern8(n);
        // pattern9(n);
        // pattern9_01(n);
        // pattern9_02(n);
        pattern15(n);
        pattern15_01(n);

    }

}