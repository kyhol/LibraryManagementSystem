package edu.keyin.library.model.item;

/**
 * Represents magazines and journals in our library.
 * Can be either printed or electronic.
 */
public class Periodical extends LibraryItem {
    private String issueNumber;

    /**
     * Sets up a new periodical.
     * @param id Unique ID for this periodical
     * @param title The periodical's title
     * @param publisher Who published it
     * @param numberOfCopies How many copies we have
     * @param issueNumber Which issue this is
     */
    public Periodical(String id, String title, String publisher, int numberOfCopies, String issueNumber) {
        super(id, title, publisher, numberOfCopies);
        if (issueNumber == null || issueNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Issue number cannot be empty");
        }
        this.issueNumber = issueNumber;
    }

    /**
     * Gets this issue's number.
     * @return The issue number
     */
    public String getIssueNumber() {
        return issueNumber;
    }

    /**
     * Updates the issue number.
     * @param issueNumber The new issue number
     * @throws IllegalArgumentException if issue number is empty
     */
    public void setIssueNumber(String issueNumber) {
        if (issueNumber == null || issueNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Issue number cannot be empty");
        }
        this.issueNumber = issueNumber;
    }

    /**
     * Handles borrowing this periodical.
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
     * Handles returning this periodical.
     * @return true when successfully returned
     */
    @Override
    public boolean returnItem() {
        setAvailableCopies(getAvailableCopies() + 1);
        return true;
    }

    /**
     * Gets the type of this item.
     * @return "Periodical" as the type
     */
    @Override
    public String getItemType() {
        return "Periodical";
    }

    /**
     * Creates a string with this periodical's details.
     * @return String with the periodical's information
     */
    @Override
    public String toString() {
        return "Periodical{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", issueNumber='" + issueNumber + '\'' +
                ", copies=" + getNumberOfCopies() +
                ", available=" + getAvailableCopies() +
                ", status=" + getStatus() +    // Changed from status='" + getStatus() + '\''
                '}';
    }

}