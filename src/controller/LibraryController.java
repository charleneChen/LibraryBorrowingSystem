/**
 *
 * @author xlian/charlene
 */
package controller;

import model.BorrowingInventory;
import view.LibraryView;

public class LibraryController {
    private BorrowingInventory inventory;
    private LibraryView view;

    public LibraryController(BorrowingInventory inventory, LibraryView view) {
        this.inventory = inventory;
        this.view = view;
    }

    // CREATE
    public void addItem(String ISBN, String author, String publisher, String borrower) {

    }

    // READ (all)
    public void displayAllBorrowedBooks() {

    }

    // UPDATE

    // DELETE

}
