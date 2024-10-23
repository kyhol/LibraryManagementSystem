package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public class AudioBook extends Book {
    public AudioBook(String id, String title, String isbn, String publisher,
                     int numberOfCopies, Author author) {
        super(id, title, isbn, publisher, numberOfCopies, author);
    }

    @Override
    public String getItemType() {
        return "Audio Book";
    }
}