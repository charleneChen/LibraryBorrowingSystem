/**
 *
 * @author xlian/charlene
 */
package controller;

import model.Book;
import model.BorrowingInventory;
import view.LibraryView;

/*
    handles user action and validation message
*/

public class LibraryController {
    private BorrowingInventory inventory;
    private LibraryView view;

    public LibraryController(BorrowingInventory inventory, LibraryView view) {
        this.inventory = inventory;
        this.view = view;
    }

    public void run() {
        String choice;
        do {
            view.displayWelcome();
            view.displayMenu();
            choice = view.getUserInput("Enter your choice: ");  // get input from view
            handleChoice(choice);  // controller decides action
        } while (choice != "666");  
    }

    public void handleChoice(String choice) {
        switch (choice) {
            case "1":
                borrowBook();
                break;
            case "2":
                getActiveLoans();
                break;
            case "3":
                returnBook();
                break;
            case "4":
                getPersonalLoans();
                break;
            case "5":
                checkAvailability();
                break;
            case "666":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    // Creat
    public void borrowBook() {
        // controller collects raw data from view
        String isbn = view.getUserInput("Enter book ISBN: ");
        String title = view.getUserInput("Enter book title: ");
        String author = view.getUserInput("Enter book author: ");
        String publisher = view.getUserInput("Enter book publisher: ");
        String borrower = view.getUserInput("Enter borrower name: ");

        // controller builds the book object
        Book book = new Book(isbn, title, author, publisher, borrower);

        // controller passes to inventory
        boolean success = inventory.borrowBook(book);

        if (success) {
            // Tells the view to display success message
            view.displayMessage("\"" + book.getTitle() + "\' borrowed successfully!");
        } else {
            // Tells the view to display error message
            view.displayMessage("Sorry, \"" + book.getTitle() + "\" is already bowrrowed.");
        }
        
    }

    // Read (all)
    // Returns a complete list of all currently borrowed books
    public void getActiveLoans() {
        view.displayAllBorrowedBooks();
    }

    public void getPersonalLoans() {

    }

    public void checkAvailability() {

    }

    // UPDATE
    public void returnBook() {

    }

    // DELETE

}
