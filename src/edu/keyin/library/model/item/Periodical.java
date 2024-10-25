package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public class Periodical extends LibraryItem {
    // Define enum for valid periodical types
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

        // Helper method to convert string to enum
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
}