import java.util.Scanner;

public class FoodOrdering {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        // Display menu
        System.out.println("===== CAFETERIA MENU =====");
        System.out.println("Available items: Burger, Salad, Pizza, Coffee, Ice cream");
        System.out.println("==========================");
        
        System.out.print("Enter your order: ");
        String userOrder = inputScanner.nextLine().toLowerCase();
        
        switch (userOrder) {
            case "burger":
                System.out.println("You ordered a Burger.");
                break;
            case "salad":
                System.out.println("You ordered a Salad.");
                break;
            case "pizza":
                System.out.println("You ordered a Pizza.");
                break;
            case "coffee":
                System.out.println("You ordered a Coffee.");
                break;
            case "ice cream":
                System.out.println("You ordered a Ice cream.");
                break;
            default:
                System.out.println("We don't have that.");
                break;
        }
        
        inputScanner.close();
    }
}

