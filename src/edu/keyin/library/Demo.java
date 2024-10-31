package edu.keyin.library;

import edu.keyin.library.management.Library;
import edu.keyin.library.management.LibraryDataInitializer;
import edu.keyin.library.model.person.Author;
import edu.keyin.library.model.person.Patron;

import java.util.Scanner;

public class Demo {
    private final Library library;
    private final Scanner scanner;

    public Demo() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Enter as Patron");
            System.out.println("2. Enter as Librarian");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    patronMenu();
                    break;
                case "2":
                    librarianMenu();
                    break;
                case "3":
                    System.out.println("Thank you for using the Library Management System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void patronMenu() {
        while (true) {
            System.out.println("\n=== Patron Menu ===");
            System.out.println("1. Search by Author");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by ISBN");
            System.out.println("4. List all Authors");
            System.out.println("5. List all Items");
            System.out.println("6. Borrow Item");
            System.out.println("7. Return Item");
            System.out.println("8. Return to Main Menu");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    library.worksByAuthor();
                    break;
                case "2":
                    library.searchByTitle();
                    break;
                case "3":
                    library.searchByIsbn();
                    break;
                case "4":
                    library.authorList();
                    break;
                case "5":
                    library.itemList();
                    break;
                case "6":
                    library.borrowLibraryItem();
                    break;
                case "7":
                    library.returnLibraryItem();
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void librarianMenu() {
        while (true) {
            System.out.println("\n=== Librarian Menu ===");
            System.out.println("1. Search Operations");
            System.out.println("2. Author Management");
            System.out.println("3. Item Management");
            System.out.println("4. Patron Management");
            System.out.println("5. List all Authors");
            System.out.println("6. List all Items");
            System.out.println("7. List all Patrons");
            System.out.println("8. Return to Main Menu");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    searchMenu();
                    break;
                case "2":
                    authorMenu();
                    break;
                case "3":
                    itemMenu();
                    break;
                case "4":
                    patronMgmtMenu();
                    break;
                case "5":
                    library.authorList();
                    break;
                case "6":
                    library.itemList();
                    break;
                case "7":
                    library.patronList();
                case "8":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void searchMenu() {
        while (true) {
            System.out.println("\n=== Search Menu ===");
            System.out.println("1. Search by Author");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by ISBN");
            System.out.println("4. Return to Librarian Menu");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    library.worksByAuthor();
                    break;
                case "2":
                    library.searchByTitle();
                    break;
                case "3":
                    library.searchByIsbn();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void authorMenu() {
        while (true) {
            System.out.println("\n=== Author Management ===");
            System.out.println("1. Add Author");
            System.out.println("2. Edit Author");
            System.out.println("3. Delete Author");
            System.out.println("4. Return to Librarian Menu");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    library.addAuthor();
                    break;
                case "2":
                    library.editAuthor();
                    break;
                case "3":
                    library.deleteAuthor();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void itemMenu() {
        while (true) {
            System.out.println("\n=== Item Management ===");
            System.out.println("1. Add Item");
            System.out.println("2. Edit Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Return to Librarian Menu");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    library.addItem();
                    break;
                case "2":
                    library.editItem();
                    break;
                case "3":
                    library.deleteLibraryItem();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void patronMgmtMenu() {
        while (true) {
            System.out.println("\n=== Patron Management ===");
            System.out.println("1. Add Patron");
            System.out.println("2. Edit Patron");
            System.out.println("3. Delete Patron");
            System.out.println("4. Return to Librarian Menu");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    library.addPatron();
                    break;
                case "2":
                    library.editPatron();
                    break;
                case "3":
                    library.deletePatron();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.start();
    }
}