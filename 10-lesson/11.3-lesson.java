import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int userNumber = inputScanner.nextInt();
        
        boolean isDivisibleBy2 = (userNumber % 2 == 0);
        boolean isDivisibleBy3 = (userNumber % 3 == 0);
        
        if (isDivisibleBy2 && isDivisibleBy3) {
            System.out.println("FizzBuzz");
        } else if (isDivisibleBy2) {
            System.out.println("Fizz");
        } else if (isDivisibleBy3) {
            System.out.println("Buzz");
        } else {
            System.out.println("out of FizzBuzz");
        }
        
        inputScanner.close();
    }
}
