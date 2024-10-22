package edu.keyin.library.model.item;

/**
 * Represents electronic versions of items in our library.
 * Base class for e-books and digital periodicals.
 */
public class ElectronicItem extends LibraryItem {
    private String format;  // PDF, EPUB, etc.

    /**
     * Sets up a new electronic item.
     * @param id Unique ID for this item
     * @param title The item's title
     * @param publisher Who published it
     * @param numberOfCopies How many digital copies we can lend
     * @param format What format the file is in
     */
    public ElectronicItem(String id, String title, String publisher, int numberOfCopies, String format) {
        super(id, title, publisher, numberOfCopies);
        if (format == null || format.trim().isEmpty()) {
            throw new IllegalArgumentException("Format cannot be empty");
        }
        this.format = format;
    }

    /**
     * Gets what format this item is in.
     * @return The file format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Updates the format.
     * @param format The new format
     * @throws IllegalArgumentException if format is empty
     */
    public void setFormat(String format) {
        if (format == null || format.trim().isEmpty()) {
            throw new IllegalArgumentException("Format cannot be empty");
        }
        this.format = format;
    }

    /**
     * Handles borrowing this electronic item.
     * @return true if successfully borrowed
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
     * Handles returning this electronic item.
     * @return true when successfully returned
     */
    @Override
    public boolean returnItem() {
        setAvailableCopies(getAvailableCopies() + 1);
        return true;
    }

    /**
     * Gets the type of this item.
     * @return "ElectronicItem" as the type
     */
    @Override
    public String getItemType() {
        return "ElectronicItem";
    }

    /**
     * Creates a string with this item's details.
     * @return String with the item's information
     */
    @Override
    public String toString() {
        return "ElectronicItem{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", format='" + format + '\'' +
                ", copies=" + getNumberOfCopies() +
                ", available=" + getAvailableCopies() +
                '}';
    }
}