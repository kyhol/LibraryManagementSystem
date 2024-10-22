package edu.keyin.library.model.item;

/**
 * Represents physical items in our library.
 * Base class for printed books and magazines.
 */
public class PrintedItem extends LibraryItem {
    private String condition;  // New, Good, Fair, Poor
    private String location;   // Where to find it in the library

    /**
     * Sets up a new printed item.
     * @param id Unique ID for this item
     * @param title The item's title
     * @param publisher Who published it
     * @param numberOfCopies How many copies we have
     * @param condition What condition it's in
     */
    public PrintedItem(String id, String title, String publisher, int numberOfCopies, String condition) {
        super(id, title, publisher, numberOfCopies);
        if (condition == null || condition.trim().isEmpty()) {
            throw new IllegalArgumentException("Condition cannot be empty");
        }
        this.condition = condition;
    }

    /**
     * Gets what condition this item is in.
     * @return The current condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Updates the item's condition.
     * @param condition New condition
     * @throws IllegalArgumentException if condition is empty
     */
    public void setCondition(String condition) {
        if (condition == null || condition.trim().isEmpty()) {
            throw new IllegalArgumentException("Condition cannot be empty");
        }
        this.condition = condition;
    }

    /**
     * Gets where this item is kept.
     * @return The shelf location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Updates where this item is kept.
     * @param location New shelf location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Handles borrowing this printed item.
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
     * Handles returning this printed item.
     * @return true when successfully returned
     */
    @Override
    public boolean returnItem() {
        setAvailableCopies(getAvailableCopies() + 1);
        return true;
    }

    /**
     * Gets the type of this item.
     * @return "PrintedItem" as the type
     */
    @Override
    public String getItemType() {
        return "PrintedItem";
    }

    /**
     * Creates a string with this item's details.
     * @return String with the item's information
     */
    @Override
    public String toString() {
        return "PrintedItem{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", condition='" + condition + '\'' +
                ", location='" + location + '\'' +
                ", copies=" + getNumberOfCopies() +
                ", available=" + getAvailableCopies() +
                ", status=" + getStatus() +    // Changed from status='" + getStatus() + '\''
                '}';
    }
}