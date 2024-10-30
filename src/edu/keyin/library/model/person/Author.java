package edu.keyin.library.model.person;

import edu.keyin.library.model.item.LibraryItem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Represents an author in the library system.
 * Manages author information and their works.
 */
public class Author {
    private String name;
    private LocalDate birthdate;
    private final ArrayList<LibraryItem> listOfWorks;

    /**
     * Constructs a new Author with name and birthdate.
     * @param name Author's name
     * @param birthdate Author's date of birth
     */
    public Author(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.listOfWorks = new ArrayList<>();
    }

    /**
     * Adds a work to author's list if not already present.
     * @param item Library item to add
     */
    public void addWork(LibraryItem item) {
        if (!listOfWorks.contains(item)) {
            listOfWorks.add(item);
        }
    }

    /**
     * Removes a work from author's list.
     * @param item Library item to remove
     */
    public void removeWork(LibraryItem item) {
        listOfWorks.remove(item);
    }

    /**
     * Returns a copy of author's works list.
     * @return ArrayList of author's works
     */
    public ArrayList<LibraryItem> getListOfWorks() {
        return new ArrayList<>(listOfWorks);
    }

    /**
     * Searches works by title (case-insensitive).
     * @param title Title to search for
     * @return List of matching works
     */
    public List<LibraryItem> searchWorksByTitle(String title) {
        return listOfWorks.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Searches works by ISBN.
     * @param isbn ISBN to search for
     * @return Matching work or null if not found
     */
    public LibraryItem searchWorkByIsbn(String isbn) {
        return listOfWorks.stream()
                .filter(item -> item.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    /**
     * Creates an Author instance from user input.
     * @param scanner Scanner for reading input
     * @return New Author instance
     */
    public static Author createAuthorFromUserInput(Scanner scanner) {
        String name = readName(scanner);
        LocalDate birthdate = readBirthdate(scanner);
        return new Author(name, birthdate);
    }

    /**
     * Reads and validates author name from input.
     * @param scanner Scanner for reading input
     * @return Valid author name
     */
    private static String readName(Scanner scanner) {
        String name;
        while (true) {
            System.out.println("Please enter the Author's name: ");
            if (scanner.hasNextLine()) {
                name = scanner.nextLine().trim();
                if (!name.isEmpty()) {
                    return name;
                }
            }
            System.out.println("Invalid input. Please enter a valid author's name.");
        }
    }

    /**
     * Reads and validates author birthdate from input.
     * @param scanner Scanner for reading input
     * @return Valid LocalDate for birthdate
     */
    private static LocalDate readBirthdate(Scanner scanner) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (true) {
            System.out.println("Please enter the author's birthdate (DD-MM-YYYY): ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                try {
                    LocalDate date = LocalDate.parse(input, dateFormat);
                    if (date.isAfter(LocalDate.now())) {
                        System.out.println("Birthdate cannot be in the future. Please try again.");
                        continue;
                    }
                    return date;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please use DD-MM-YYYY format.");
                }
            }
        }
    }

    /**
     * Interactive method to edit author information.
     * @param scanner Scanner for reading input
     */
    public void editAuthorInfo(Scanner scanner) {
        while (true) {
            System.out.println("\nEdit Author Information");
            System.out.println("1. Edit Name");
            System.out.println("2. Edit Birthdate");
            System.out.println("3. Exit");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Current name: " + this.name);
                    this.setName(readName(scanner));
                    System.out.println("Name updated successfully.");
                    break;
                case "2":
                    System.out.println("Current birthdate: " + this.birthdate);
                    this.setBirthdate(readBirthdate(scanner));
                    System.out.println("Birthdate updated successfully.");
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * @return Author's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name New author name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Author's birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate New author birthdate
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return String representation of Author object
     */
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", number of works=" + listOfWorks.size() +
                '}';
    }
}