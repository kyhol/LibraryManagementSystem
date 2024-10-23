package edu.keyin.library.model.item;

import edu.keyin.library.model.person.Author;

public abstract class Book extends LibraryItem {
    public Book(String id, String title, String isbn, String publisher,
                int numberOfCopies, Author author) {
        super(id, title, isbn, publisher, numberOfCopies, author);
    }
}