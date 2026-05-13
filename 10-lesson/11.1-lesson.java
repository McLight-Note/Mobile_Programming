import java.util.Scanner;

public class Divisibility {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int userNumber = inputScanner.nextInt();
        
        boolean isDivisibleBy7 = (userNumber % 7 == 0);
        boolean isDivisibleBy5 = (userNumber % 5 == 0);
        
        if (isDivisibleBy7 && isDivisibleBy5) {
            System.out.println("number is divisible to both numbers");
        } else if (isDivisibleBy7) {
            System.out.println("number is divisible to 7");
        } else if (isDivisibleBy5) {
            System.out.println("number is divisible to 5");
        } else {
            System.out.println("None divisible number");
        }
        
        inputScanner.close();
    }
}

