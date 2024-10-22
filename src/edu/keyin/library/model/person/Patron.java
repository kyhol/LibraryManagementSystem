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
}