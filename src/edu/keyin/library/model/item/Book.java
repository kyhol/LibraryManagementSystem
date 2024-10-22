package edu.keyin.library.model.item;

/**
 * Represents a book in our library.
 * Parent class for printed, electronic, and audio books.
 */
public class Book extends LibraryItem {
    private String isbn;

    /**
     * Sets up a new book.
     * @param id Unique ID for this book
     * @param title The book's title
     * @param publisher Who published it
     * @param numberOfCopies How many copies we have
     * @param isbn The book's ISBN
     */
    public Book(String id, String title, String publisher, int numberOfCopies, String isbn) {
        super(id, title, publisher, numberOfCopies);
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        this.isbn = isbn;
    }

    /**
     * Gets this book's ISBN.
     * @return The ISBN number
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Updates this book's ISBN.
     * @param isbn The new ISBN
     * @throws IllegalArgumentException if ISBN is empty
     */
    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        this.isbn = isbn;
    }

    /**
     * Handles borrowing this book.
     * @return true if successfully borrowed, false if not available
     */
    @Override
    public boolean borrow() {
        if (isAvailable()) {
            setAvailableCopies(getAvailableCopies() - 1);
            return true;
        }
        return false;
    }

    /**
     * Handles returning this book.
     * @return true when successfully returned
     */
    @Override
    public boolean returnItem() {
        setAvailableCopies(getAvailableCopies() + 1);
        return true;
    }

    /**
     * Gets the type of this item.
     * @return "Book" as the type
     */
    @Override
    public String getItemType() {
        return "Book";
    }

    /**
     * Creates a string with this book's details.
     * @return String with the book's information
     */
    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", isbn='" + isbn + '\'' +
                ", copies=" + getNumberOfCopies() +
                ", available=" + getAvailableCopies() +
                ", status=" + getStatus() +    // Changed from status='" + getStatus() + '\''
                '}';
    }

}