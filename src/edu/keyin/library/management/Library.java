package edu.keyin.library.management;

import edu.keyin.library.model.item.LibraryItem;
import edu.keyin.library.model.person.Author;
import edu.keyin.library.model.person.Patron;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final LibraryDataInitializer dataInitializer;
    private final Scanner scanner;

    public Library() {
        this.dataInitializer = new LibraryDataInitializer();
        this.scanner = new Scanner(System.in);
    }

    public ArrayList<LibraryItem> worksByAuthor() {
        while (true) {
            System.out.println("\nSearch for author's works");
            System.out.println("Enter author's name (or 'exit' to return to main menu): ");

            String searchName = scanner.nextLine().trim();

            if (searchName.equalsIgnoreCase("exit")) {
                return new ArrayList<>();
            }

            if (searchName.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid author's name.");
                continue;
            }

            // compares input against list (case insensitive but still watch for typos)
            Author foundAuthor = null;
            for (Author author : dataInitializer.getAuthors()) {
                if (author.getName().equalsIgnoreCase(searchName)) {
                    foundAuthor = author;
                    break;
                }
            }

            if (foundAuthor != null) {
                ArrayList<LibraryItem> works = foundAuthor.getListOfWorks();
                if (works.isEmpty()) {
                    System.out.println("No works found for author: " + foundAuthor.getName());
                } else {
                    System.out.println("\nWorks by " + foundAuthor.getName() + ":");
                    for (LibraryItem item : works) {
                        System.out.println("- " + item.getTitle() + " (" + item.getId() + ")");
                    }
                }
                return works;
            } else {
                System.out.println("Author not found: " + searchName);
                System.out.println("Available authors:");
                for (Author author : dataInitializer.getAuthors()) {
                    System.out.println("- " + author.getName());
                }
            }
        }
    }

    public void addItem(Patron patron, LibraryItem libraryItem) {
        patron.borrowItem(libraryItem);
    }

    //Need to move to Demo.java
    public static void main(String[] args) {
        Library library = new Library();
        library.worksByAuthor();
    }
}