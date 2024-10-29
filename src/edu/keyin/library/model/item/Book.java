package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public class Book extends LibraryItem {
    // Define enum for valid book types
    public enum BookType {
        PRINTED("Printed"),
        ELECTRONIC("Electronic"),
        AUDIO("Audio");

        private final String value;

        BookType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        // Helper method to convert string to enum
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

    public Book(String id, String title, String isbn, String publisher,
                int numberOfCopies, Author author, String type) {
        super(id, title, isbn, publisher, numberOfCopies, author);
        setType(type);
    }

    public String getType() {
        return type.getValue();
    }

    public void setType(String type) {
        this.type = BookType.fromString(type);
    }

    // Add methods to check and manage availability
    public boolean isAvailable() {
        return getNumberOfCopies() > 0;
    }

    // Method to handle when a copy is borrowed
    public boolean checkOutCopy() {
        if (isAvailable()) {
            setNumberOfCopies(getNumberOfCopies() - 1);
            return true;
        }
        return false;
    }

    // Method to handle when a copy is returned
    public void returnCopy() {
        setNumberOfCopies(getNumberOfCopies() + 1);
    }

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