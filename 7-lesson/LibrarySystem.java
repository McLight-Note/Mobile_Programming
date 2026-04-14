import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availability=" + (isAvailable ? "Available" : "Not Available") +
                '}';
    }
}

class Library {
    private ArrayList<Book> bookCollection;

    public Library() {
        this.bookCollection = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookCollection.add(book);
        System.out.println("Added book: " + book.getTitle() + " by " + book.getAuthor());
    }

    public void borrowBook(String title) {
        for (Book book : bookCollection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Successfully borrowed: " + title);
                } else {
                    System.out.println("Book not available: " + title);
                }
                return;
            }
        }
        System.out.println("Book not found in library: " + title);
    }

    public void returnBook(String title) {
        for (Book book : bookCollection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Successfully returned: " + title);
                } else {
                    System.out.println("This book was not borrowed: " + title);
                }
                return;
            }
        }
        System.out.println("Book not found in library: " + title);
    }

    public void printAvailableBooks() {
        System.out.println("\n=== Available Books in Library ===");
        boolean foundAvailable = false;
        for (Book book : bookCollection) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
                foundAvailable = true;
            }
        }
        if (!foundAvailable) {
            System.out.println("No available books at this time");
        }
    }

    public void printAllBooks() {
        System.out.println("\n=== All Books in Library ===");
        for (Book book : bookCollection) {
            System.out.println(book);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library cityLibrary = new Library();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");
        Book book4 = new Book("Pride and Prejudice", "Jane Austen");

        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);
        cityLibrary.addBook(book3);
        cityLibrary.addBook(book4);

        cityLibrary.printAllBooks();

        cityLibrary.printAvailableBooks();

        System.out.println("\n=== Borrowing Books ===");
        cityLibrary.borrowBook("The Great Gatsby");
        cityLibrary.borrowBook("1984");

        System.out.println("\n=== Attempting to Borrow Already Borrowed Book ===");
        cityLibrary.borrowBook("The Great Gatsby");

        cityLibrary.printAvailableBooks();

        System.out.println("\n=== Returning Books ===");
        cityLibrary.returnBook("The Great Gatsby");

        cityLibrary.printAvailableBooks();

        System.out.println("\n=== Attempting to Return Non-Borrowed Book ===");
        cityLibrary.returnBook("To Kill a Mockingbird");

        cityLibrary.printAllBooks();
    }
}
