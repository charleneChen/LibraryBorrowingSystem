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
        System.out.println("----------------------------------------------------");
        System.out.printf("%12s%s\n", "", "Library Borrowing System");
        System.out.println("----------------------------------------------------");

    }

    public void displayMenu() {
        System.out.printf("%5s%s\n", "", "1. Borrow a book");
        System.out.printf("%5s%s\n", "", "2. Display all borrowed books");
        System.out.printf("%5s%s\n", "", "3. Return a book / Delete a borrowing record");
        System.out.printf("%5s%s\n", "", "4. View personal loans");
        System.out.printf("%5s%s\n", "", "5. Check book availability");
        System.out.printf("%5s%s\n", "", "6. Update borrower / Update a borrowing record");
        System.out.printf("%5s%s\n", "", "0. Exit");
    }

    public void displayMessage(String message) {
        System.out.println("\n===========================================");
        System.out.println(message);
        System.out.println("===========================================\n");
    }

    // Display prompts, View captures input and return it to Controller
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayAllBorrowedBooks(ArrayList<Book> books) {
        String format = "%-20s %-40s %-20s %-20s %-20s%n";

        System.out.println("\n==============================================================================");
        System.out.printf("%45s%n", "All Borrowed Books");
        System.out.println("==============================================================================");
        System.out.printf(format, "ISBN", "Title", "Author", "Publisher", "Borrower");
        System.out.println("------------------------------------------------------------------------------");

        for (Book book : books) {
            System.out.printf(format,
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getBorrower()
            );
        }

        System.out.println("==============================================================================\n");
    }

    public void displayPersonalLoans(String borrower, ArrayList<Book> books) {
        String format = "%-20s %-40s %-20s %-20s %-20s%n";

        System.out.println("\n==============================================================================");
        System.out.printf("%45s%n", "Personal Loans for " + borrower);
        System.out.println("==============================================================================");
        System.out.printf(format, "ISBN", "Title", "Author", "Publisher", "Borrower");
        System.out.println("------------------------------------------------------------------------------");

        for (Book book : books) {
            System.out.printf(format,
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getBorrower()
            );
        }

        System.out.println("==============================================================================\n");
    }
}
