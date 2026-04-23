import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class library {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Initializing Library...");
        myLibrary.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        myLibrary.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        myLibrary.addBook(new Book("1984", "George Orwell"));
        
        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Add a new book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    myLibrary.printAvailableBooks();
                    break;
                case "2":
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    myLibrary.borrowBook(borrowTitle);
                    break;
                case "3":
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    myLibrary.returnBook(returnTitle);
                    break;
                case "4":
                    System.out.print("Enter the title of the new book: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter the author of the new book: ");
                    String newAuthor = scanner.nextLine();
                    myLibrary.addBook(new Book(newTitle, newAuthor));
                    break;
                case "5":
                    System.out.println("Exiting the Library System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Added: " + b.title);
    }

    public void borrowBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isAvailable) {
                    b.isAvailable = false;
                    System.out.println("Successfully borrowed: " + b.title);
                    return;
                } else {
                    System.out.println("Sorry, '" + b.title + "' is currently unavailable.");
                    return;
                }
            }
        }
        System.out.println("Oops, '" + title + "' was not found in the library.");
    }

    public void returnBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.isAvailable) {
                    b.isAvailable = true;
                    System.out.println("Successfully returned: " + b.title);
                    return;
                } else {
                    System.out.println("'" + b.title + "' is already in the library.");
                    return;
                }
            }
        }
        System.out.println("Sorry, we do not have a record of '" + title + "'.");
    }

    public void printAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        boolean anyAvailable = false;
        for (Book b : books) {
            if (b.isAvailable) {
                System.out.println("- " + b.title + " (by " + b.author + ")");
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No books are currently available.");
        }
        System.out.println("-----------------------\n");
    }
}
