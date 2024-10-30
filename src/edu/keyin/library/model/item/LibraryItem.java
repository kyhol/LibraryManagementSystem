package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

/**
 * Abstract base class for all library items.
 * Provides common attributes and functionality for books and periodicals.
 */
public abstract class LibraryItem {
    private String id;
    private String title;
    private String isbn;
    private String publisher;
    private int numberOfCopies;
    private Author author;

    /**
     * Enumeration representing the possible status of a library item.
     */
    public enum Status {
        AVAILABLE("Available"),
        CHECKED_OUT("Checked Out"),
        OVERDUE("Overdue");

        private final String value;

        /**
         * @param value String representation of the status
         */
        Status(String value) {
            this.value = value;
        }

        /**
         * @return String representation of the status
         */
        public String getValue() {
            return value;
        }

        /**
         * Converts string to Status enum value.
         * @param text Status string to convert
         * @return Corresponding Status enum value
         * @throws IllegalArgumentException if text doesn't match any status
         */
        public static Status fromString(String text) {
            for (Status status: Status.values()) {
                if (status.value.equalsIgnoreCase(text)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid status: " + text + ". Must be 'Available', 'Checked Out', or 'Overdue'");
        }
    }

    private Status status;

    /**
     * Constructs a new LibraryItem with specified attributes.
     * @param id Unique identifier
     * @param title Item title
     * @param isbn ISBN number
     * @param publisher Publisher name
     * @param numberOfCopies Number of available copies
     * @param author Item's author
     */
    public LibraryItem(String id, String title, String isbn, String publisher,
                       int numberOfCopies, Author author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.author = author;
    }

    /**
     * @return Item's unique identifier
     */
    public String getId() {
        return id;
    }

    /**
     * @param id New unique identifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Item's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title New title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Item's ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn New ISBN
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return Item's publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher New publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return Number of available copies
     */
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * @param numberOfCopies New number of copies
     */
    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    /**
     * @return Item's author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author New author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return Current status as string
     */
    public String getStatus() {
        return status.getValue();
    }

    /**
     * @param status New status
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}