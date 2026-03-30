/**
 *
 * @author xlian/charlene
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Book;

public class LibraryView {
    private Scanner scanner = new Scanner(System.in);

    public void displayWelcome() {
        System.out.println("----------------------------------");
        System.out.printf("%5s%s\n", "", "Library Borrowing System");
        System.out.println("----------------------------------");

    }

    public void displayMenu() {
        System.out.printf("%5s%s\n", "", "1. Borrow a book");
        System.out.printf("%5s%s\n", "", "2. Display all borrowed books");
        System.out.printf("%5s%s\n", "", "3. Return a book / Delete a borrowing record");
        System.out.printf("%5s%s\n", "", "4. View personal loans");
        System.out.printf("%5s%s\n", "", "5. Check book availability");
        System.out.printf("%5s%s\n", "", "6. Update a borrowing record / Update borrower");
        System.out.printf("%5s%s\n", "", "0. Exit");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Display prompts, View captures input and return it to Controller
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayAllBorrowedBooks(ArrayList<Book> books) {
        System.out.println("--- All Borrowed Books ---");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + "by " + book.getAuthor());
        }
        System.out.println("--------------------------");
    }

    public void displayPersonalLoans(String borrower, ArrayList<Book> books) {
        System.out.println("--- Personal Loans for " + borrower + " ---");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + "by " + book.getAuthor());
        }
        System.out.println("--------------------------");

    }
}
