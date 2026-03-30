/**
 *
 * @author xlian/charlene
 */
package model;

public class Book {
    private String isbn, title, author, publisher, borrower;

    public Book(String isbn, String title, String author, String publisher, String borrower) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.borrower = borrower;
    }

    public String getIsbn() {
        return isbn;
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
