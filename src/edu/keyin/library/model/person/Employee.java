package edu.keyin.library.model.person;

import java.util.Scanner;

public class Employee extends Patron {
    private String employeeId;

    public Employee(String name, String address, String phoneNumber, String employeeId) {
        super(name, address, phoneNumber);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", borrowed items=" + getBorrowedItems().size() +
                '}';
    }

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