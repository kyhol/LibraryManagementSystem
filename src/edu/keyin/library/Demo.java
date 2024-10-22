package edu.keyin.library;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the Library Management System");
            // there are more options needed for the project.
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding a new library item...");
                    // Add logic to add a library item
//                    System.out.println("Enter the type of Library item?: ");
//                    String itemType = scanner.nextLine();
//
//                    System.out.print("Enter Title: ");
//                    String title = scanner.nextLine();
//                    System.out.print("Enter ISBN: ");
//                    String ISBN = scanner.nextLine();
//                    System.out.print("Enter publisher: ");
//                    String publisher = scanner.nextLine();
//                    System.out.print("Enter total copies: ");
//                    int totalCopies = scanner.nextInt();
//                    System.out.print("Enter available copies: ");
//                    int availableCopies = scanner.nextInt();
//                    scanner.nextLine();
//                    LibraryItem libraryItem = new LibraryItem(title,ISBN,publisher,availableCopies)

                    break;
                case 2:
                    System.out.println("Editing an existing library item...");
                    // Add logic to edit a library item
                    break;
                case 3:
                    System.out.println("Deleting a library item...");
                    // Add logic to delete a library item
                    break;
                case 4:
                    System.out.println("Borrowing a library item...");
                    // Add logic to borrow a library item
                    break;
                case 5:
                    System.out.println("Returning a library item...");
                    // Add logic to return a library item
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

