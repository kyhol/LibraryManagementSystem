package edu.keyin.library.model.item;

import edu.keyin.library.model.Author;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for anything that can be stored in the library.
 * All different types of items (books, periodicals, etc.) will extend this class.
 */
public abstract class LibraryItem {
    private String id;
    private String title;
    private List<Author> authors;
    private String publisher;
    private int numberOfCopies;
    private int availableCopies;
    private String status;  // Can be either AVAILABLE or CHECKED_OUT

    /**
     * Sets up a new library item with its basic info.
     * @param id Unique identifier for the item
     * @param title Title of the item
     * @param publisher Publisher of the item
     * @param numberOfCopies Total number of copies
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public LibraryItem(String id, String title, String publisher, int numberOfCopies) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be null or empty");
        }
        if (numberOfCopies < 0) {
            throw new IllegalArgumentException("Number of copies cannot be negative");
        }

        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.availableCopies = numberOfCopies;
        this.status = "AVAILABLE";
        this.authors = new ArrayList<>();
    }

    /**
     * Gets the item's unique ID.
     * @return The ID of this item
     */
    public String getId() {
        return id;
    }

    /**
     * Updates the item's ID.
     * @param id The new ID to set
     * @throws IllegalArgumentException if ID is null or empty
     */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        this.id = id;
    }

    /**
     * Gets the title of this item.
     * @return The item's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the item's title.
     * @param title The new title to set
     * @throws IllegalArgumentException if title is null or empty
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    /**
     * Gets a copy of the authors list so it can't be modified from outside.
     * @return List of authors for this item
     */
    public List<Author> getAuthors() {
        return new ArrayList<>(authors);
    }

    /**
     * Adds a new author to this item if they're not already listed.
     * @param author The author to add
     * @throws IllegalArgumentException if author is null
     */
    public void addAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }

    /**
     * Removes an author from this item's author list.
     * @param author The author to remove
     */
    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    /**
     * Gets the publisher of this item.
     * @return The publisher's name
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Updates the publisher of this item.
     * @param publisher The new publisher name
     * @throws IllegalArgumentException if publisher is null or empty
     */
    public void setPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be null or empty");
        }
        this.publisher = publisher;
    }

    /**
     * Gets the total number of copies of this item.
     * @return Total number of copies
     */
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * Updates the total number of copies and adjusts available copies if needed.
     * @param numberOfCopies New total number of copies
     * @throws IllegalArgumentException if numberOfCopies is negative
     */
    public void setNumberOfCopies(int numberOfCopies) {
        if (numberOfCopies < 0) {
            throw new IllegalArgumentException("Number of copies cannot be negative");
        }
        this.numberOfCopies = numberOfCopies;
        if (this.availableCopies > numberOfCopies) {
            this.availableCopies = numberOfCopies;
        }
        updateStatus();
    }

    /**
     * Gets the number of copies currently available to borrow.
     * @return Number of available copies
     */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * Updates available copies. Only subclasses can use this method.
     * @param availableCopies New number of available copies
     * @throws IllegalArgumentException if the number is invalid
     */
    protected void setAvailableCopies(int availableCopies) {
        if (availableCopies < 0 || availableCopies > numberOfCopies) {
            throw new IllegalArgumentException("Available copies must be between 0 and total copies");
        }
        this.availableCopies = availableCopies;
        updateStatus();
    }

    /**
     * Gets the current status of this item.
     * @return Current status (AVAILABLE or CHECKED_OUT)
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status based on whether any copies are available.
     * Sets to AVAILABLE if there are copies, CHECKED_OUT if none are left.
     */
    private void updateStatus() {
        status = (availableCopies > 0) ? "AVAILABLE" : "CHECKED_OUT";
    }

    /**
     * Quick check if the item can be borrowed.
     * @return true if there are copies available, false if not
     */
    public boolean isAvailable() {
        return availableCopies > 0;
    }

    /**
     * Handles the borrowing process for this item. Each type of item
     * will implement its own borrowing rules.
     * @return true if successfully borrowed, false if not
     */
    public abstract boolean borrow();

    /**
     * Handles the return process for this item. Each type of item
     * will implement its own return rules.
     * @return true if successfully returned, false if not
     */
    public abstract boolean returnItem();

    /**
     * Gets what kind of item this is (book, periodical, etc).
     * @return The type of this item as a string
     */
    public abstract String getItemType();

    /**
     * Creates a string with all the basic info about this item.
     * @return String containing item details
     */
    @Override
    public String toString() {
        return "LibraryItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                ", availableCopies=" + availableCopies +
                ", status='" + status + '\'' +
                '}';
    }
}