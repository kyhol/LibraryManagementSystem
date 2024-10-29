package edu.keyin.library.model.person;

import java.util.ArrayList;
import java.util.Scanner;
import edu.keyin.library.model.item.LibraryItem;

public abstract class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private final ArrayList<LibraryItem> borrowedItems;

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item) {
        if (!borrowedItems.contains(item)) {
            borrowedItems.add(item);
        }
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public ArrayList<LibraryItem> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Patron createPatronFromUserInput(Scanner scanner) {
        System.out.println("Enter patron type (1 for Student, 2 for Employee): ");
        int type = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Enter address: ");
        String address = scanner.nextLine().trim();

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine().trim();

        if (type == 1) {
            System.out.println("Enter student ID: ");
            String studentId = scanner.nextLine().trim();
            return new Student(name, address, phoneNumber, studentId);
        } else {
            System.out.println("Enter employee ID: ");
            String employeeId = scanner.nextLine().trim();
            return new Employee(name, address, phoneNumber, employeeId);
        }
    }

    // Method to edit a patron
    public abstract void editPatronSpecificInfo(Scanner scanner); // Abstract method for student/employee specific edits

    public void editPatronInfo(Scanner scanner) {
        while (true) {
            System.out.println("\nEdit Patron Information");
            System.out.println("1. Edit Name");
            System.out.println("2. Edit Address");
            System.out.println("3. Edit Phone Number");
            System.out.println("4. Edit Specific Information (ID)");
            System.out.println("5. Exit");

            try {
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        System.out.println("Current name: " + this.getName());
                        System.out.println("Enter new name: ");
                        String newName = scanner.nextLine().trim();
                        if (!newName.isEmpty()) {
                            this.setName(newName);
                            System.out.println("Name updated successfully.");
                        }
                        break;

                    case "2":
                        System.out.println("Current address: " + this.getAddress());
                        System.out.println("Enter new address: ");
                        String newAddress = scanner.nextLine().trim();
                        if (!newAddress.isEmpty()) {
                            this.setAddress(newAddress);
                            System.out.println("Address updated successfully.");
                        }
                        break;

                    case "3":
                        System.out.println("Current phone number: " + this.getPhoneNumber());
                        System.out.println("Enter new phone number: ");
                        String newPhone = scanner.nextLine().trim();
                        if (!newPhone.isEmpty()) {
                            this.setPhoneNumber(newPhone);
                            System.out.println("Phone number updated successfully.");
                        }
                        break;

                    case "4":
                        editPatronSpecificInfo(scanner);
                        break;

                    case "5":
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error processing input. Please try again.");
            }
        }
    }
}