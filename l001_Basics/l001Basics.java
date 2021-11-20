import java.util.Scanner;

public class l001Basics {
    public static Scanner scn = new Scanner(System.in);

    public static int multiply(int a , int b) {
        int c = a * b;
        return c;
    }
    public static int add(int a , int b) {
        int c = a + b;
        return c;
    }
    public static int subtract(int a , int b) {
        int c = a - b;
        return c;
    }
    public static int divide(int a , int b) {
        int c = a / b;
        return c;
    }
    public static void printMessage() {
        System.out.println("hello this is arsh");
    }
    // public static void main(String[] args) { //static means sbse phle compile hoti hai
    //     //java jo input leti hai vo String.args se leti hai
    //     System.out.println("hello"); //ln is for nextLine
    //     System.out.print("pepcoder");
    // }
    public static void main(String[] args) {
        int a = scn.nextInt(); //in java:if we take the input first we import the scanner and make public static scanner scn = new scanner(system,in) then make variables in main
        int b = scn.nextInt();
        
        // System.out.println(multiply(a, b));
        // System.out.println(add(a, b));
        // System.out.println(subtract(a, b));
        // System.out.println(divide(a, b));

        printZ();
        int marks = scn.nextInt();
        gradingSystem(marks);
    }
    //START WITH FUNCTIONS

    //ques1 printz
    public static void printZ() {
        System.out.println("*****");
        System.out.println("   *");
        System.out.println("  *");
        System.out.println(" *");
        System.out.println("*****");
    }

    //ques2 -> Grading System
    public static void gradingSystem(int marks) {
        if (marks > 90) {
            System.out.println("excellent");
        } else if (marks > 80 && marks <= 90) {
            System.out.println("good");
        } else if (marks > 70 && marks <= 80) {
            System.out.println("fair");
        } else if (marks > 60 && marks <= 70) {
            System.out.println("meets expectations");
        } else {
            System.out.println("below par");
        }
    }

}