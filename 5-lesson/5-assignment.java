import java.util.Scanner;

public class GachonUniversity {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        double angle = Math.PI / 4;
        int a = 23;
        double b = 245;

        System.out.println("sin(45): " + Math.sin(angle));
        System.out.println("cos(45): " + Math.cos(angle));
        System.out.println("tan(45): " + Math.tan(angle));

        System.out.println("asin(0.7071): " + Math.asin(0.7071));
        System.out.println("acos(0.7071): " + Math.acos(0.7071));
        System.out.println("atan(1): " + Math.atan(1));
    }
}