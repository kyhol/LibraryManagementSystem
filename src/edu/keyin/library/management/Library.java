package edu.keyin.library.management;

import edu.keyin.library.model.item.LibraryItem;
import edu.keyin.library.model.item.Book;
import edu.keyin.library.model.item.Periodical;
import edu.keyin.library.model.person.Author;
import edu.keyin.library.model.person.Patron;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Manages the core functionality of a library system including item management,
 * patron management, and circulation operations.
 */
public class Library {
    private final LibraryDataInitializer dataInitializer;
    private final Scanner scanner;

    public Library() {
        this.dataInitializer = new LibraryDataInitializer();
        this.scanner = new Scanner(System.in);
    }


    /**
     * Searches for a library item by ISBN.
     * @return The found LibraryItem or null if not found
     */
    public LibraryItem searchByIsbn() {
        System.out.println("\nSearch by ISBN");
        System.out.println("Enter ISBN (or 'exit' to return to main menu): ");

        String searchIsbn = scanner.nextLine().trim();

        if (searchIsbn.equalsIgnoreCase("exit")) {
            return null;
        }

        // Search through the data items for matching ISBN
        for (LibraryItem item : dataInitializer.getItems()) {
            if (item.getIsbn().equalsIgnoreCase(searchIsbn)) {
                System.out.println("\nFound item:");
                System.out.println("- " + item.getTitle() + " (ID: " + item.getId() + ")");
                return item;
            }
        }

        System.out.println("No item found with ISBN: " + searchIsbn);
        System.out.println("\nAvailable items and their ISBNs:");
        for (LibraryItem item : dataInitializer.getItems()) {
            System.out.println("- " + item.getTitle() + " (ISBN: " + item.getIsbn() + ")");
        }

        return null;
    }
    /**
     * Searches for all works by a specific author.
     * @return ArrayList of LibraryItems by the specified author
     */
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

    /**
     * Adds a library item to a patron's borrowed items.
     * @param patron The patron borrowing the item
     * @param libraryItem The item to be borrowed
     */

    public void addItem(Patron patron, LibraryItem libraryItem) {
        patron.borrowItem(libraryItem);
    }
    /**
     * Processes the return of a library item from a patron.
     * Updates the item's availability and removes it from patron's borrowed items.
     */
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

    /**
     * Deletes a library item from the system.
     * Checks if item is currently borrowed before deletion.
     */
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

    /**
     * Searches for library items by title.
     * @return ArrayList of LibraryItems matching the search criteria
     */
    public ArrayList<LibraryItem> searchByTitle() {
        System.out.println("\nSearch by Title");
        System.out.println("Enter title (or 'exit' to return to main menu): ");

        String searchTitle = scanner.nextLine().trim();

        if (searchTitle.equalsIgnoreCase("exit")) {
            return new ArrayList<>();
        }

        ArrayList<LibraryItem> foundItems = new ArrayList<>();
        for (LibraryItem item : dataInitializer.getItems()) {
            if (item.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                foundItems.add(item);
            }
        }

        if (foundItems.isEmpty()) {
            System.out.println("No items found containing: " + searchTitle);
        } else {
            System.out.println("\nFound items:");
            for (LibraryItem item : foundItems) {
                System.out.println("- " + item.getTitle() + " (ID: " + item.getId() + ")");
            }
        }

        return foundItems;
    }

    /**
     * Adds a new item to the library collection.
     * Supports adding both books and periodicals.
     */
    public void addItem() {
        System.out.println("\nAdd New Library Item");
        System.out.println("Select item type:");
        System.out.println("1. Book");
        System.out.println("2. Periodical");
        System.out.println("3. Cancel");

        String choice = scanner.nextLine().trim();

        if (choice.equals("3")) {
            return;
        }

        // Get common details first
        System.out.println("Enter item ID: ");
        String id = scanner.nextLine().trim();

        System.out.println("Enter title: ");
        String title = scanner.nextLine().trim();

        System.out.println("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();

        System.out.println("Enter publisher: ");
        String publisher = scanner.nextLine().trim();

        System.out.println("Enter number of copies: ");
        int copies = Integer.parseInt(scanner.nextLine().trim());

        // Get author
        System.out.println("Enter author's name: ");
        String authorName = scanner.nextLine().trim();

        Author author = null;
        for (Author a : dataInitializer.getAuthors()) {
            if (a.getName().equalsIgnoreCase(authorName)) {
                author = a;
                break;
            }
        }

        if (author == null) {
            System.out.println("Author not found. Please add the author first.");
            return;
        }

        LibraryItem newItem = null;

        switch (choice) {
            case "1": // Book
                System.out.println("Enter book type (Printed/Electronic/Audio): ");
                String bookType = scanner.nextLine().trim();
                newItem = new Book(id, title, isbn, publisher, copies, author, bookType);
                break;

            case "2": // Periodical
                System.out.println("Enter periodical type (Printed/Electronic): ");
                String periodicalType = scanner.nextLine().trim();
                newItem = new Periodical(id, title, isbn, publisher, copies, author, periodicalType);
                break;

            default:
                System.out.println("Invalid choice");
                return;
        }

        dataInitializer.getItems().add(newItem);
        author.addWork(newItem);
        System.out.println("Item added successfully!");
    }

    /**
     * Allows editing of an existing library item's details.
     * Includes title, ISBN, publisher, copies, and type modifications.
     */
    public void editItem() {
        System.out.println("\nEdit Library Item");
        System.out.println("Enter item ID: ");
        String itemId = scanner.nextLine().trim();

        LibraryItem itemToEdit = null;
        for (LibraryItem item : dataInitializer.getItems()) {
            if (item.getId().equalsIgnoreCase(itemId)) {
                itemToEdit = item;
                break;
            }
        }

        if (itemToEdit == null) {
            System.out.println("Item not found: " + itemId);
            System.out.println("Available items:");
            for (LibraryItem item : dataInitializer.getItems()) {
                System.out.println("- " + item.getTitle() + " (ID: " + item.getId() + ")");
            }
            return;
        }

        while (true) {
            System.out.println("\nEditing: " + itemToEdit.getTitle());
            System.out.println("1. Edit Title");
            System.out.println("2. Edit ISBN");
            System.out.println("3. Edit Publisher");
            System.out.println("4. Edit Number of Copies");
            System.out.println("5. Edit Type");
            System.out.println("6. Return to Menu");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Current title: " + itemToEdit.getTitle());
                    System.out.println("Enter new title: ");
                    itemToEdit.setTitle(scanner.nextLine().trim());
                    break;

                case "2":
                    System.out.println("Current ISBN: " + itemToEdit.getIsbn());
                    System.out.println("Enter new ISBN: ");
                    itemToEdit.setIsbn(scanner.nextLine().trim());
                    break;

                case "3":
                    System.out.println("Current publisher: " + itemToEdit.getPublisher());
                    System.out.println("Enter new publisher: ");
                    itemToEdit.setPublisher(scanner.nextLine().trim());
                    break;

                case "4":
                    System.out.println("Current copies: " + itemToEdit.getNumberOfCopies());
                    System.out.println("Enter new number of copies: ");
                    try {
                        int newCopies = Integer.parseInt(scanner.nextLine().trim());
                        if (newCopies >= 0) {
                            itemToEdit.setNumberOfCopies(newCopies);
                        } else {
                            System.out.println("Number of copies must be non-negative.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;

                case "5":
                    if (itemToEdit instanceof Book) {
                        System.out.println("Current type: " + ((Book) itemToEdit).getType());
                        System.out.println("Enter new type (Printed/Electronic/Audio): ");
                        ((Book) itemToEdit).setType(scanner.nextLine().trim());
                    } else if (itemToEdit instanceof Periodical) {
                        System.out.println("Current type: " + ((Periodical) itemToEdit).getType());
                        System.out.println("Enter new type (Printed/Electronic): ");
                        ((Periodical) itemToEdit).setType(scanner.nextLine().trim());
                    }
                    break;

                case "6":
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    /**
     * Processes a patron's request to borrow a library item.
     * Checks item availability and updates inventory accordingly.
     */
    public void borrowLibraryItem() {
        System.out.println("\nBorrow Library Item");
        System.out.println("Enter patron name: ");
        String patronName = scanner.nextLine().trim();

        // Find patron
        Patron patron = null;
        for (Patron p : dataInitializer.getPatrons()) {
            if (p.getName().equalsIgnoreCase(patronName)) {
                patron = p;
                break;
            }
        }

        if (patron == null) {
            System.out.println("Patron not found: " + patronName);
            return;
        }

        // Search for item
        System.out.println("Enter item ID to borrow: ");
        String itemId = scanner.nextLine().trim();

        LibraryItem item = null;
        for (LibraryItem i : dataInitializer.getItems()) {
            if (i.getId().equalsIgnoreCase(itemId)) {
                item = i;
                break;
            }
        }

        if (item == null) {
            System.out.println("Item not found: " + itemId);
            return;
        }

        // Check availability
        if (item.getNumberOfCopies() > 0) {
            patron.borrowItem(item);
            item.setNumberOfCopies(item.getNumberOfCopies() - 1);
            System.out.println("Successfully borrowed: " + item.getTitle());
        } else {
            System.out.println("Item is currently unavailable: " + item.getTitle());
        }
    }


    /**
     * Adds a new author to the library system.
     * Creates author record with provided details.
     */
    public void addAuthor() {
        System.out.println("\nAdd New Author");
        Author newAuthor = Author.createAuthorFromUserInput(scanner);
        dataInitializer.getAuthors().add(newAuthor);
        System.out.println("Author added successfully: " + newAuthor.getName());
    }

    /**
     * Allows modification of an existing author's information.
     */
    public void editAuthor() {
        while (true) {
            System.out.println("\nEdit Author");
            System.out.println("Enter author's name (or 'exit' to return to menu): ");

            String searchName = scanner.nextLine().trim();

            if (searchName.equalsIgnoreCase("exit")) {
                return;
            }

            // Finding the author
            Author authorToEdit = null;
            for (Author author : dataInitializer.getAuthors()) {
                if (author.getName().equalsIgnoreCase(searchName)) {
                    authorToEdit = author;
                    break;
                }
            }

            if (authorToEdit != null) {
                authorToEdit.editAuthorInfo(scanner);
                return;
            } else {
                System.out.println("Author not found: " + searchName);
                System.out.println("Available authors:");
                for (Author author : dataInitializer.getAuthors()) {
                    System.out.println("- " + author.getName());
                }
            }
        }
    }

    /**
     * Deletes an author from the system.
     * Sets author reference to null for associated works instead of deleting them.
     */
    public void deleteAuthor() {
        while (true) {
            System.out.println("\nDelete Author");
            System.out.println("Enter author's name (or 'exit' to return to menu): ");

            String searchName = scanner.nextLine().trim();

            if (searchName.equalsIgnoreCase("exit")) {
                return;
            }

            // Find the author
            Author authorToDelete = null;
            for (Author author : dataInitializer.getAuthors()) {
                if (author.getName().equalsIgnoreCase(searchName)) {
                    authorToDelete = author;
                    break;
                }
            }

            if (authorToDelete != null) {
                // Get their works and set author to null
                ArrayList<LibraryItem> works = authorToDelete.getListOfWorks();
                if (!works.isEmpty()) {
                    System.out.println("The following works will have their author set to null:");
                    for (LibraryItem item : works) {
                        System.out.println("- " + item.getTitle());
                        item.setAuthor(null);
                    }
                }

                // Remove author from library
                dataInitializer.getAuthors().remove(authorToDelete);
                System.out.println("Author deleted successfully: " + authorToDelete.getName());
                return;
            } else {
                System.out.println("Author not found: " + searchName);
                System.out.println("Available authors:");
                for (Author author : dataInitializer.getAuthors()) {
                    System.out.println("- " + author.getName());
                }
            }
        }
    }
    /**
     * Adds a new patron to the library system.
     * Creates patron record with provided details.
     */
    public void addPatron() {
        System.out.println("\nAdd New Patron");
        Patron newPatron = Patron.createPatronFromUserInput(scanner);
        dataInitializer.getPatrons().add(newPatron);
        System.out.println("Patron added successfully: " + newPatron.getName());
    }


    /**
     * Allows modification of an existing patron's information.
     */
    public void editPatron() {
        while (true) {
            System.out.println("\nEdit Patron");
            System.out.println("Enter patron's name (or 'exit' to return to menu): ");

            String searchName = scanner.nextLine().trim();

            if (searchName.equalsIgnoreCase("exit")) {
                return;
            }

            // Finding the patron
            Patron patronToEdit = null;
            for (Patron patron : dataInitializer.getPatrons()) {
                if (patron.getName().equalsIgnoreCase(searchName)) {
                    patronToEdit = patron;
                    break;
                }
            }

            if (patronToEdit != null) {
                patronToEdit.editPatronInfo(scanner);
                return;
            } else {
                System.out.println("Patron not found: " + searchName);
                System.out.println("Available patrons:");
                for (Patron patron : dataInitializer.getPatrons()) {
                    System.out.println("- " + patron.getName());
                }
            }
        }
    }

    /**
     * Deletes a patron from the system.
     * Handles return of any borrowed items before deletion.
     */
    public void deletePatron() {
        while (true) {
            System.out.println("\nDelete Patron");
            System.out.println("Enter patron's name (or 'exit' to return to menu): ");

            String searchName = scanner.nextLine().trim();

            if (searchName.equalsIgnoreCase("exit")) {
                return;
            }

            // Find the patron
            Patron patronToDelete = null;
            for (Patron patron : dataInitializer.getPatrons()) {
                if (patron.getName().equalsIgnoreCase(searchName)) {
                    patronToDelete = patron;
                    break;
                }
            }
            //return leftover items
            if (patronToDelete != null) {
                ArrayList<LibraryItem> items = patronToDelete.getBorrowedItems();
                if (!items.isEmpty()) {
                    System.out.println("The following items will be returned:");
                    for (LibraryItem item : items) {
                        System.out.println("- " + item.getTitle());
                        patronToDelete.returnItem(item);
                    }
                }

                // Remove patron from library
                dataInitializer.getPatrons().remove(patronToDelete);
                System.out.println("Patron deleted successfully: " + patronToDelete.getName());
                return;
            } else {
                System.out.println("Patron not found: " + searchName);
                System.out.println("Available patrons:");
                for (Patron patron : dataInitializer.getPatrons()) {
                    System.out.println("- " + patron.getName());
                }
            }
        }
    }

    }