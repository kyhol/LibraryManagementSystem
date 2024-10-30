package edu.keyin.library.model.person;

import java.util.Scanner;

/**
 * Represents an employee patron in the library system.
 * Extends the base Patron class with employee-specific attributes.
 */
public class Employee extends Patron {
    private String employeeId;

    /**
     * Constructs a new Employee with specified attributes.
     * @param name Employee's name
     * @param address Employee's address
     * @param phoneNumber Employee's phone number
     * @param employeeId Unique employee identifier
     */
    public Employee(String name, String address, String phoneNumber, String employeeId) {
        super(name, address, phoneNumber);
        this.employeeId = employeeId;
    }

    /**
     * @return Employee's ID
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId New employee ID
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return String representation of Employee object
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", borrowed items=" + getBorrowedItems().size() +
                '}';
    }

    /**
     * Handles editing of employee-specific information.
     * @param scanner Scanner for reading user input
     */
    @Override
    public void editPatronSpecificInfo(Scanner scanner) {
        System.out.println("Current employee ID: " + this.getEmployeeId());
        System.out.println("Enter new employee ID: ");
        String newEmployeeId = scanner.nextLine().trim();
        if (!newEmployeeId.isEmpty()) {
            this.setEmployeeId(newEmployeeId);
            System.out.println("Employee ID updated successfully.");
        }
    }
}