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

    // ques8 -> pattern prctice 9.1cd.
    public static void pattern9B(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {

            }
        }

    }

    // ques9 -> pattern prctice 9.2
    public static void pattern9C(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {

            }
        }

    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        // mirrorTriangle(n);
        // System.out.println();
        // Triangle(n);
        // System.out.println();
        // Reverse(n);
        // pattern2(n);
        // pattern7(n);
        // pattern8(n);
        pattern9(n);

    }

}