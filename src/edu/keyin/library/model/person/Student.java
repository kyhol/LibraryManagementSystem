package edu.keyin.library.model.person;

import java.util.Scanner;

/**
 * Represents a student patron in the library system.
 * Extends the base Patron class with student-specific attributes.
 */
public class Student extends Patron {
    private String studentId;

    /**
     * Constructs a new Student with specified attributes.
     * @param name Student's name
     * @param address Student's address
     * @param phoneNumber Student's phone number
     * @param studentId Unique student identifier
     */
    public Student(String name, String address, String phoneNumber, String studentId) {
        super(name, address, phoneNumber);
        this.studentId = studentId;
    }

    /**
     * @return Student's ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId New student ID
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Handles editing of student-specific information.
     * @param scanner Scanner for reading user input
     */
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

    /**
     * @return String representation of Student object
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", studentId='" + studentId + '\'' +
                ", borrowed items=" + getBorrowedItems().size() +
                '}';
    }
}