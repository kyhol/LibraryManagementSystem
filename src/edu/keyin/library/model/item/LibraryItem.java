package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public abstract class LibraryItem {
    private String id;
    private String title;
    private String isbn;
    private String publisher;
    private int numberOfCopies;
    private Author author;

    public enum Status {
        AVAILABLE("Available"),
        CHECKED_OUT("Checked Out"),
        OVERDUE("Overdue");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        // Helper method to convert string to enum
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

        public LibraryItem(String id, String title, String isbn, String publisher,
                           int numberOfCopies, Author author) {
            this.id = id;
            this.title = title;
            this.isbn = isbn;
            this.publisher = publisher;
            this.numberOfCopies = numberOfCopies;
            this.author = author;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public int getNumberOfCopies() {
            return numberOfCopies;
        }

        public void setNumberOfCopies(int numberOfCopies) {
            this.numberOfCopies = numberOfCopies;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String getStatus() {
            return status.getValue();
        }

        public void setStatus(Status status) {
            this.status = status;
    }
}