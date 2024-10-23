package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public abstract class Periodical extends LibraryItem {
    public Periodical(String id, String title, String isbn, String publisher,
                      int numberOfCopies, Author author) {
        super(id, title, isbn, publisher, numberOfCopies, author);
    }

    @Override
    public abstract String getItemType();
}