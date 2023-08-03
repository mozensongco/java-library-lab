package libraryLab;
import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
	
	private ArrayList<Book> catalog;
	private static String openingHours = "9am to 5pm";
	private String address;
	
	public Library(String address) {
		this.catalog = new ArrayList<Book>();
		this.address = address;
	}
	
	public void addBook(Book book) {
		this.catalog.add(book);
	}
	
	public static void printOpeningHours() {
		System.out.printf("Libraries are open from %s.", openingHours);
	}
	
	public void printAddress() {
		System.out.printf("%s\n", this.address);
	}
	
	public void borrowBook(String title) {
		for (Book book : this.catalog) {
			if (book.getTitle().equals(title)) {
				if (book.isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
					return;
				} else {
					book.borrowed();
					System.out.printf("You successfully borrowed %s\n", title);
					return;
				}
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	public void printAvailableBooks() {
		if (this.catalog.size() == 0) {
			System.out.println("No book in catalog");
		} else {
			for (Book book : this.catalog) {
				if (!book.isBorrowed()) {
					System.out.printf("%s\n", book.getTitle());
				}
			}
		}
	}
	
	public void returnBook(String title) {
		for (Book book : this.catalog) {
			if (book.getTitle().equals(title)) {
				book.returned();
				System.out.printf("You successfully returned %s\n", title);
				return;
			}
		}
	}

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}