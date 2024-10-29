package edu.keyin.library.model.person;

import java.util.Scanner;

public class Student extends Patron {
    private String studentId;

    public Student(String name, String address, String phoneNumber, String studentId) {
        super(name, address, phoneNumber);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Student edit method
    @Override
    public void editPatronSpecificInfo(Scanner scanner) {
        System.out.println("Current student ID: " + this.getStudentId());
        System.out.println("Enter new student ID: ");
        String newStudentId = scanner.nextLine().trim();
        if (!newStudentId.isEmpty()) {
            this.setStudentId(newStudentId);
            System.out.println("Student ID updated successfully.");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", studentId='" + studentId + '\'' +
                ", borrowed items=" + getBorrowedItems().size() +
                '}';
    }
}
