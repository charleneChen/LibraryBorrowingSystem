/**
 *
 * @author xlian/charlene
 */
package model;

public class Book {
    private String ISBN, title, author, publisher, borrower;

    public Book(String ISBN, String title, String author, String publisher, String borrower) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.borrower = borrower;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
}
