package edu.keyin.library.model.person;

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", studentId='" + studentId + '\'' +
                ", borrowed items=" + getBorrowedItems().size() +
                '}';
    }
}
