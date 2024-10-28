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
    public void returnLibraryItem() {
        while (true) {
            System.out.println("\nReturn Library Item");
            System.out.println("Enter patron name (or 'exit' to return to main menu): ");

            String patronName = scanner.nextLine().trim();

            if (patronName.equalsIgnoreCase("exit")) {
                return;
            }

            // Find the patron
            Patron foundPatron = null;
            for (Patron patron : dataInitializer.getPatrons()) {
                if (patron.getName().equalsIgnoreCase(patronName)) {
                    foundPatron = patron;
                    break;
                }
            }

            if (foundPatron == null) {
                System.out.println("Patron not found: " + patronName);
                System.out.println("Available patrons:");
                for (Patron patron : dataInitializer.getPatrons()) {
                    System.out.println("- " + patron.getName());
                }
                continue;
            }

            // Check if patron has any borrowed items
            ArrayList<LibraryItem> borrowedItems = foundPatron.getBorrowedItems();
            if (borrowedItems.isEmpty()) {
                System.out.println("This patron has no items to return.");
                return;
            }

            // Display borrowed items
            System.out.println("\nBorrowed items by " + foundPatron.getName() + ":");
            for (LibraryItem item : borrowedItems) {
                System.out.println("- " + item.getTitle() + " (ID: " + item.getId() + ")");
            }

            // Get item to return
            System.out.println("\nEnter item ID to return (or 'cancel' to go back): ");
            String itemId = scanner.nextLine().trim();

            if (itemId.equalsIgnoreCase("cancel")) {
                continue;
            }

            // Find the item to return
            LibraryItem itemToReturn = null;
            for (LibraryItem item : borrowedItems) {
                if (item.getId().equalsIgnoreCase(itemId)) {
                    itemToReturn = item;
                    break;
                }
            }

            if (itemToReturn != null) {
                foundPatron.returnItem(itemToReturn);
                itemToReturn.setNumberOfCopies(itemToReturn.getNumberOfCopies() + 1);
                System.out.println("Successfully returned: " + itemToReturn.getTitle());
                return;
            } else {
                System.out.println("Invalid item ID. Please try again.");
            }
        }
    }

    public void deleteLibraryItem() {
        while (true) {
            System.out.println("\nDelete Library Item");
            System.out.println("Enter item ID to delete (or 'exit' to return to main menu): ");

            String itemId = scanner.nextLine().trim();

            if (itemId.equalsIgnoreCase("exit")) {
                return;
            }

            // Find the item to delete
            LibraryItem itemToDelete = null;
            List<LibraryItem> items = dataInitializer.getItems();

            for (LibraryItem item : items) {
                if (item.getId().equalsIgnoreCase(itemId)) {
                    itemToDelete = item;
                    break;
                }
            }

            if (itemToDelete == null) {
                System.out.println("Item not found: " + itemId);
                System.out.println("Available items:");
                for (LibraryItem item : items) {
                    System.out.println("- " + item.getTitle() + " (ID: " + item.getId() + ")");
                }
                continue;
            }

            // Check if the item borrowed
            boolean isBorrowed = false;
            Patron borrowingPatron = null;

            for (Patron patron : dataInitializer.getPatrons()) {
                if (patron.getBorrowedItems().contains(itemToDelete)) {
                    isBorrowed = true;
                    borrowingPatron = patron;
                    break;
                }
            }

            if (isBorrowed) {
                System.out.println("Cannot delete item: Currently borrowed by " + borrowingPatron.getName());
                return;
            }

            // Remove item from author's works
            itemToDelete.getAuthor().removeWork(itemToDelete);

            // Remove item from library
            items.remove(itemToDelete);

            System.out.println("Successfully deleted: " + itemToDelete.getTitle());
            return;
        }
    }
}