package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public class Periodical extends LibraryItem {
    // Existing enum definition
    public enum PeriodicalType {
        PRINTED("Printed"),
        ELECTRONIC("Electronic");

        private final String value;

        PeriodicalType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

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

    public Periodical(String id, String title, String isbn, String publisher,
                      int numberOfCopies, Author author, String type) {
        super(id, title, isbn, publisher, numberOfCopies, author);
        setType(type);
    }

    public String getType() {
        return type.getValue();
    }

    public void setType(String type) {
        this.type = PeriodicalType.fromString(type);
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
        return "Periodical{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", type=" + type +
                ", copies available=" + getNumberOfCopies() +
                '}';
    }
}