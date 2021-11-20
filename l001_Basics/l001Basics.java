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
        
        System.out.println(multiply(a, b));
        System.out.println(add(a, b));
        System.out.println(subtract(a, b));
        System.out.println(divide(a, b));
    }
    //START WITH FUNCTIONS

}