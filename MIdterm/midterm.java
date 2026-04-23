import java.util.Scanner;

public class midterm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        if (str.contains("Java")) {
            System.out.println("String contains 'Java'");
        } else {
            System.out.println("String does not contain 'Java'");
        }
    }
}
