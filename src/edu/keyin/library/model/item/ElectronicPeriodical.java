package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public class ElectronicPeriodical extends Periodical {
    private String format;

    public ElectronicPeriodical(String id, String title, String isbn, String publisher,
                                int numberOfCopies, Author author, String format) {
        super(id, title, isbn, publisher, numberOfCopies, author);
        this.format = format;
    }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    @Override
    public String getItemType() {
        return "Electronic Book";
    }
}