package edu.keyin.library.model.person;

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
}