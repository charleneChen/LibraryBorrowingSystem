/**
 *
 * @author xlian/charlene
 */
package model;

import java.util.ArrayList;

/*
    Assumptions:
    1. you can check out a maximum of 5 books
    2. books must be borrowed individually
    3. any book that isn't already checked out is available to borrow
    4. the library holds a single copy of each title
    5. books must be returned individually
    6. books can be returned at any time, no minimum or maximum duration fot book loans
*/

public class BorrowingInventory {
    private ArrayList<Book> records;

    public BorrowingInventory() {
        records = new ArrayList<>();
    }

    /*
        Creat
        Constraints:
        1. Maximum limit of 5 books per borrower
        2. only one copy of a specific title can be borrowed at a time
     */
    public boolean borrowBook(Book book) {
        // controller gets feedback
        if (isBorrowed(book)) {
            return false;
        }
        addRecord(book);
        return true;
        
    }

    // Read all 
    // Returns a list of all books currently checked out   
    public ArrayList<Book> getActiveLoans() {
        return new ArrayList<>(records); // return copy, not original list
    }

    // Read
    // Returns all borrowing records by borrower name
    public boolean getRecordsByBorrower(String borrower) {
        return false;
    }

    // Read
    // Returns the borrowing record for the specified book title
    public void getRecordByTitle(String title) {

    }

    // Processes a return
    // Logic: method accepts only one book, enforcing a single return at a tinme
    // Note: there is no minimum loan duration or a fixed return deadline
    public void returnBook(Book book) {
        removeRecord(book);
    }

    
    // Checks if a specific book has been checked out
    private boolean isBorrowed(Book book) {
        return this.records.contains(book);
    }
     
    // Add a new record
    private void addRecord(Book book) {
        // defensive, last line of defense
        if (isBorrowed(book)) {
            return;  // silently reject, no message here
        }
        this.records.add(book);
    }

    // Remove an existent record
    private void removeRecord(Book book) {
        this.records.remove(book);
    }
}
