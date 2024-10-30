package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

/**
 * Represents a periodical in the library system, extending the base LibraryItem class.
 * Handles periodical-specific attributes and functionality.
 */
public class Periodical extends LibraryItem {
    /**
     * Enumeration of valid periodical types with string representation.
     */
    public enum PeriodicalType {
        PRINTED("Printed"),
        ELECTRONIC("Electronic");

        private final String value;

        /**
         * @param value String representation of the periodical type
         */
        PeriodicalType(String value) {
            this.value = value;
        }

        /**
         * @return String representation of the type
         */
        public String getValue() {
            return value;
        }

        /**
         * Converts string to PeriodicalType enum value.
         * @param text Type string to convert
         * @return Corresponding PeriodicalType enum value
         * @throws IllegalArgumentException if text doesn't match any valid type
         */
        public static PeriodicalType fromString(String text) {
            for (PeriodicalType type : PeriodicalType.values()) {
                if (type.value.equalsIgnoreCase(text)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid periodical type: " + text + ". Must be either 'Printed' or 'Electronic'");
        }
    }

    private PeriodicalType type;

    /**
     * Constructs a new Periodical with specified attributes.
     * @param id Unique identifier
     * @param title Periodical title
     * @param isbn ISBN number
     * @param publisher Publisher name
     * @param numberOfCopies Number of available copies
     * @param author Periodical's author
     * @param type Type of periodical (Printed/Electronic)
     */
    public Periodical(String id, String title, String isbn, String publisher,
                      int numberOfCopies, Author author, String type) {
        super(id, title, isbn, publisher, numberOfCopies, author);
        setType(type);
    }

    /**
     * @return Periodical type as string
     */
    public String getType() {
        return type.getValue();
    }

    /**
     * @param type New periodical type
     * @throws IllegalArgumentException if type is invalid
     */
    public void setType(String type) {
        this.type = PeriodicalType.fromString(type);
    }

    /**
     * Checks if the periodical is available for borrowing.
     * @return true if copies available, false otherwise
     */
    public boolean isAvailable() {
        return getNumberOfCopies() > 0;
    }

    /**
     * Processes checking out a copy of the periodical.
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
     * Processes returning a copy of the periodical.
     * Increments the number of available copies.
     */
    public void returnCopy() {
        setNumberOfCopies(getNumberOfCopies() + 1);
    }

    /**
     * @return String representation of the Periodical object
     */
    @Override
    public String toString() {
        return "Periodical{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", type=" + type +
                ", copies available=" + getNumberOfCopies() +
                '}';
    }
}