import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int x = obj.nextInt();
        if (x > 0) {
            System.out.println("positive");
        } else{
            System.out.println("negative");
        }
    }
}
