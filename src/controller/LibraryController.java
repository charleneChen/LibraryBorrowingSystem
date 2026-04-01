/**
 *
 * @author xlian/charlene
 */
package controller;

import java.util.ArrayList;

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

            // In Java, you cannot compare Strings using != or ==. Those operators compare the memory address (if they are the same object), not the actual text.
        } while (!choice.equals("0"));  
    }

    public void handleChoice(String choice) {
        switch (choice) {
            case "1":
                // Create
                handleBorrowBook();
                break;
            case "2":
                // Read
                handleShowActiveLoans();
                break;
            case "3":
                // Delete
                handleReturnBook();
                break;
            case "4":
                // Read
                handleShowPersonalLoans();
                break;
            case "5":
                // Read
                handleCheckBookAvailability();
                break;
            case "6":
                // Update
                handleUpdateBorrower();
                break;
            case "0":
                view.displayMessage("Goodbye!");
                break;
            default:
                view.displayMessage("Invalid choice, please try again.");
        }
    }

    public void handleBorrowBook() {
        // controller collects raw data from view
        String isbn = view.getUserInput("Enter book ISBN: ");
        String title = view.getUserInput("Enter book title: ");
        String author = view.getUserInput("Enter book author: ");
        String publisher = view.getUserInput("Enter book publisher: ");
        String borrower = view.getUserInput("Enter borrower name: ");

        // controller builds the book object
        Book book = new Book(isbn, title, author, publisher, borrower);

        // controller passes to inventory
        boolean success = inventory.addRecord(book);

        if (success) {
            // Tells the view to display success message
            view.displayMessage(book.getBorrower() + " has borrowed \"" + book.getTitle() + "\" successfully!");
        } else {
            // Tells the view to display error message
            view.displayMessage("Sorry, \"" + book.getTitle() + "\" is already borrowed.");
        }
        
    }

    public void handleReturnBook() {
        String isbn = view.getUserInput("Enter book ISBN: ");
        boolean success = inventory.removeRecord(isbn);

        if (success) {
            view.displayMessage("Book \"" + isbn + "\" returned successfully!");
            return;
        }

        view.displayMessage("Book \"" + isbn + "\" was not borrowed.");
    }

    // Returns a complete list of all currently borrowed books
    public void handleShowActiveLoans() {
        ArrayList<Book> activeLoans = inventory.getActiveLoans();

        if (activeLoans.isEmpty()) {
            view.displayMessage("No active loans at the moment.");
            return;
        }

        view.displayAllBorrowedBooks(activeLoans);  // pass to view to display
    }

    public void handleShowPersonalLoans() {
        // get borrower name from view
        String borrower = view.getUserInput("Enter borrower name: ");
        // get personal loans from inventory
        ArrayList<Book> borrowedBooks = inventory.getRecordsByBorrower(borrower);

        // controller decides what to display
        if (borrowedBooks.isEmpty()) {
            view.displayMessage(borrower + " has no active loans.");
            return;
        } 

        view.displayPersonalLoans(borrower, borrowedBooks);
    }

    public void handleCheckBookAvailability() {
        // get isbn from view
        String isbn = view.getUserInput("Enter book ISBN: ");
        // check availability in inventory
        boolean isContained = inventory.containsRecord(isbn);

        if (!isContained) {
            view.displayMessage("Book \"" + isbn + "\" is available to check out.");
            return;
        }

        view.displayMessage("Book \"" + isbn + "\" is currently borrowed.");
    }

    public void handleUpdateBorrower() {
        // get isbn from view
        String isbn = view.getUserInput("Enter book ISBN to update: ");
        // check availability in inventory
        boolean isContained = inventory.containsRecord(isbn);
        
        if (!isContained) {
            view.displayMessage("No record found for ISBN: " + isbn);
            return;
        }

        String borrower = view.getUserInput("Enter new borrower name: ");
        boolean success = inventory.updateRecord(isbn, borrower);

        if (success) {
            view.displayMessage("Record updated successfully!");
            return;
        }

        view.displayMessage("Failed to update record.");

    }

}
