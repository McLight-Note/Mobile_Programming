import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter first number (num1): ");
        double num1 = inputScanner.nextDouble();
        
        System.out.print("Enter second number (num2): ");
        double num2 = inputScanner.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = inputScanner.next().charAt(0);
        
        double result = 0;
        boolean validOperator = true;
        
        if (operator == '+') {
            result = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = " + result);
        } else if (operator == '-') {
            result = num1 - num2;
            System.out.println(num1 + " - " + num2 + " = " + result);
        } else if (operator == '*') {
            result = num1 * num2;
            System.out.println(num1 + " * " + num2 + " = " + result);
        } else if (operator == '/') {
            if (num2 != 0) {
                result = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + result);
            } else {
                System.out.println("Error: Cannot divide by zero!");
                validOperator = false;
            }
        } else {
            System.out.println("Invalid operator");
            validOperator = false;
        }
        
        inputScanner.close();
    }
}
