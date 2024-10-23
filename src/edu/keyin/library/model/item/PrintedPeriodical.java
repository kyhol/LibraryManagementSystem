package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public class PrintedPeriodical extends Periodical {
    public PrintedPeriodical(String id, String title, String isbn, String publisher,
                             int numberOfCopies, Author author) {
        super(id, title, isbn, publisher, numberOfCopies, author);
    }

    @Override
    public String getItemType() {
        return "Printed Periodical";
    }
}
