/**
 *
 * @author xlian/charlene
 */
package model;

import java.util.ArrayList;

/*
    Assumptions:
    1. books must be borrowed individually, one at a time
    2. any book that isn't already checked out is available to borrow
    3. the library holds a single copy of each title
    4. books must be returned individually, one at a time
    5. books can be returned at any time, no minimum or maximum duration fot book loans
    6. each book has a unique ISBN
*/

public class BorrowingInventory {
    private ArrayList<Book> records;

    public BorrowingInventory() {
        this.records = new ArrayList<>();
    }

    // Add a new record
    public boolean addRecord(Book book) {
        // controller gets feedback
        if (containsRecord(book.getIsbn())) {
            return false;
        }
        this.records.add(book);
        return true;
    }

    // Read all 
    // Returns a list of all books currently checked out   
    public ArrayList<Book> getActiveLoans() {
        return new ArrayList<>(this.records); // return copy, not original list
    }

    // Read
    // Returns all borrowing records by a borrower's name
    public ArrayList<Book> getRecordsByBorrower(String borrower) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : this.records) {
            if (book.getBorrower().equals(borrower)) {
                books.add(book);
            }
        }
        return books;
    }

    // Read
    // Returns the borrowing record for the specified book ISBN
    private Book getRecordByIsbn(String isbn) {
        for (Book book : this.records) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Processes a return
    // Logic: method accepts only one book, enforcing a single return at a tinme
    // Note: there is no minimum loan duration or a fixed return deadline
    // Remove an existent record
    public boolean removeRecord(String isbn) {
        if (!containsRecord(isbn)) {
            return false; // return false when book is not found
        }

        this.records.remove(getRecordByIsbn(isbn));
        return true;
    }

    // Checks if a specific book has been checked out
    // if true, this book is not available
    // if false, this book is available
    // check by ISBN - it is unique per book
    public boolean containsRecord(String isbn) {
        for (Book book : this.records) {
            if (book.getIsbn().equals(isbn)) {
                return true;  // found = not available
            }
        }
        return false;  // not found = available
    }

    // Updates the borrower name on an existing record
    public boolean updateRecord(String isbn, String borrower) {
        Book book = getRecordByIsbn(isbn);

        if (book == null) {
            return false;
        }

        book.setBorrower(borrower);
        return true;
    }
}
