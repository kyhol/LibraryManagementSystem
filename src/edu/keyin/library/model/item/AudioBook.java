package edu.keyin.library.model.item;

/**
 * Represents an audio book in our library.
 * A type of Book that can be listened to.
 */
public class AudioBook extends Book {
    private String format;    // MP3, AAC, etc.
    private int duration;     // in minutes

    /**
     * Sets up a new audio book.
     * @param id Unique ID for this audio book
     * @param title The book's title
     * @param publisher Who published it
     * @param numberOfCopies How many copies we have
     * @param isbn The book's ISBN
     */
    public AudioBook(String id, String title, String publisher, int numberOfCopies, String isbn) {
        super(id, title, publisher, numberOfCopies, isbn);
    }

    /**
     * Gets what format this audio book uses.
     * @return The audio format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the audio format.
     * @param format The audio format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Gets the length of this audio book.
     * @return Duration in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets how long this audio book is.
     * @param duration The duration in minutes
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Handles borrowing this audio book.
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
     * Handles returning this audio book.
     * @return true when successfully returned
     */
    @Override
    public boolean returnItem() {
        setAvailableCopies(getAvailableCopies() + 1);
        return true;
    }

    /**
     * Gets the type of this item.
     * @return "AudioBook" as the type
     */
    @Override
    public String getItemType() {
        return "AudioBook";
    }

    /**
     * Creates a string with this audio book's details.
     * @return String with the book's information
     */
    @Override
    public String toString() {
        return "AudioBook{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", format='" + format + '\'' +
                ", duration=" + duration +
                ", copies=" + getNumberOfCopies() +
                ", available=" + getAvailableCopies() +
                ", status=" + getStatus() +    // Changed from status='" + getStatus() + '\''
                '}';
    }
}