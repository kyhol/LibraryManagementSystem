package edu.keyin.library.model.person;

import edu.keyin.library.model.item.LibraryItem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Author {
    private String name;
    private LocalDate birthdate;
    private final ArrayList<LibraryItem> listOfWorks;

    // Constructor
    public Author(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.listOfWorks = new ArrayList<>();
    }

    public void addWork(LibraryItem item) {
        if (!listOfWorks.contains(item)) {
            listOfWorks.add(item);
        }
    }

    public void removeWork(LibraryItem item) {
        listOfWorks.remove(item);
    }

    public ArrayList<LibraryItem> getListOfWorks() {
        return new ArrayList<>(listOfWorks);
    }

    // New search methods
    public List<LibraryItem> searchWorksByTitle(String title) {
        return listOfWorks.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public LibraryItem searchWorkByIsbn(String isbn) {
        return listOfWorks.stream()
                .filter(item -> item.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    // Method to create an Author from user input
    public static Author createAuthorFromUserInput(Scanner scanner) {
        String name = readName(scanner);
        LocalDate birthdate = readBirthdate(scanner);
        return new Author(name, birthdate);
    }

    // Helper method to read name
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

    // Helper method to read birthdate (uses LocalDate)
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

    // Method to edit an author's info
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
                    String newName = readName(scanner);  // Using your existing readName method
                    this.setName(newName);
                    System.out.println("Name updated successfully.");
                    break;

                case "2":
                    System.out.println("Current birthdate: " + this.birthdate);
                    LocalDate newDate = readBirthdate(scanner);  // Using your existing readBirthdate method
                    this.setBirthdate(newDate);
                    System.out.println("Birthdate updated successfully.");
                    break;

                case "3":
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    // toString method to represent the Author object
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", number of works=" + listOfWorks.size() +
                '}';
    }
}