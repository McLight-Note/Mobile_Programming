import java.util.Scanner;

public class GameMenu {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        // Display menu
        System.out.println("===== GAME MENU =====");
        System.out.println("1 -> Start Game");
        System.out.println("2 -> Load Game");
        System.out.println("3 -> Exit");
        System.out.println("====================");
        
        System.out.print("Enter your choice: ");
        int userChoice = inputScanner.nextInt();
        
        if (userChoice == 1) {
            System.out.println("Start Game");
        } else if (userChoice == 2) {
            System.out.println("Load Game");
        } else if (userChoice == 3) {
            System.out.println("Exit");
        } else {
            System.out.println("Invalid option");
        }
        
        inputScanner.close();
    }
}
