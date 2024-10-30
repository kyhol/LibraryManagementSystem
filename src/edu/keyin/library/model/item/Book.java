package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

/**
 * Represents a book in the library system, extending the base LibraryItem class.
 * Includes functionality for managing book types and availability.
 */
public class Book extends LibraryItem {
    /**
     * Enumeration of valid book types with string representation.
     */
    public enum BookType {
        PRINTED("Printed"),
        ELECTRONIC("Electronic"),
        AUDIO("Audio");

        private final String value;

        /**
         * Constructs a BookType with the specified string value.
         * @param value The string representation of the book type
         */
        BookType(String value) {
            this.value = value;
        }

        /**
         * Gets the string representation of the book type.
         * @return The book type as a string
         */
        public String getValue() {
            return value;
        }

        /**
         * Converts a string to the corresponding BookType enum value.
         * @param text The string to convert
         * @return The matching BookType enum value
         * @throws IllegalArgumentException if the string doesn't match any valid book type
         */
        public static BookType fromString(String text) {
            for (BookType type : BookType.values()) {
                if (type.value.equalsIgnoreCase(text)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid book type: " + text + ". Must be 'Printed', 'Electronic', or 'Audio'");
        }
    }

    private BookType type;

    /**
     * Constructs a new Book with the specified attributes.
     * @param id Unique identifier for the book
     * @param title Title of the book
     * @param isbn ISBN number
     * @param publisher Publisher of the book
     * @param numberOfCopies Number of copies available
     * @param author Author of the book
     * @param type Type of the book (Printed/Electronic/Audio)
     */
    public Book(String id, String title, String isbn, String publisher,
                int numberOfCopies, Author author, String type) {
        super(id, title, isbn, publisher, numberOfCopies, author);
        setType(type);
    }

    /**
     * Gets the type of the book.
     * @return The book type as a string
     */
    public String getType() {
        return type.getValue();
    }

    /**
     * Sets the type of the book.
     * @param type The book type as a string
     * @throws IllegalArgumentException if the type is invalid
     */
    public void setType(String type) {
        this.type = BookType.fromString(type);
    }

    /**
     * Checks if the book is available for borrowing.
     * @return true if there are copies available, false otherwise
     */
    public boolean isAvailable() {
        return getNumberOfCopies() > 0;
    }

    /**
     * Processes checking out a copy of the book.
     * @return true if checkout successful, false if no copies available
     */
    public boolean checkOutCopy() {
        if (isAvailable()) {
            setNumberOfCopies(getNumberOfCopies() - 1);
            return true;
        }
        return false;
    }

    /**
     * Processes returning a copy of the book.
     * Increments the number of available copies.
     */
    public void returnCopy() {
        setNumberOfCopies(getNumberOfCopies() + 1);
    }

    /**
     * Returns a string representation of the Book object.
     * @return A string containing the book's details
     */
    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", type=" + type +
                ", copies available=" + getNumberOfCopies() +
                '}';
    }
}