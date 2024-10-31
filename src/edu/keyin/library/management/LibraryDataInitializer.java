package edu.keyin.library.management;

import edu.keyin.library.model.item.Book;
import edu.keyin.library.model.item.LibraryItem;
import edu.keyin.library.model.item.Periodical;
import edu.keyin.library.model.person.Author;
import edu.keyin.library.model.person.Employee;
import edu.keyin.library.model.person.Patron;
import edu.keyin.library.model.person.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryDataInitializer {
    private List<Author> authors;
    private List<LibraryItem> items;
    private List<Patron> patrons;

    public LibraryDataInitializer() {
        authors = new ArrayList<>();
        items = new ArrayList<>();
        patrons = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        // Create Authors
        Author author1 = new Author("J.K. Rowling", LocalDate.of(1965, 7, 31));
        Author author2 = new Author("George R.R. Martin", LocalDate.of(1948, 9, 20));
        Author author3 = new Author("Stephen King", LocalDate.of(1947, 9, 21));
        Author author4 = new Author("Neil Gaiman", LocalDate.of(1960, 11, 10));
        Author author5 = new Author("Margaret Atwood", LocalDate.of(1939, 11, 18));

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);

        // Create Books
        Book book1 = new Book("B001", "Harry Potter and the Philosopher's Stone", "9780747532699",
                "Bloomsbury", 5, author1, "Printed");
        Book book2 = new Book("B002", "A Game of Thrones", "9780553103540",
                "Bantam Books", 3, author2, "Electronic");
        Book book3 = new Book("B003", "The Shining", "9780385121675",
                "Doubleday", 4, author3, "Audio");
        Book book4 = new Book("B004", "American Gods", "9780380973651",
                "William Morrow", 2, author4, "Printed");
        Book book5 = new Book("B005", "The Handmaid's Tale", "9780771008139",
                "McClelland & Stewart", 6, author5, "Electronic");
        Book book6 = new Book("B006", "Harry Potter and the Philosopher's Stone", "9780747532699",
                "Bloomsbury", 5, author1, "Printed");

        // Create Periodicals
        Periodical periodical1 = new Periodical("P001", "Scientific American", "0036-8733",
                "Springer Nature", 10, author1, "Electronic");
        Periodical periodical2 = new Periodical("P002", "National Geographic", "0027-9358",
                "National Geographic Partners", 8, author2, "Printed");
        Periodical periodical3 = new Periodical("P003", "The New Yorker", "0028-792X",
                "Condé Nast", 15, author3, "Electronic");

        // Add works to authors
        author1.addWork(book1);
        author2.addWork(book2);
        author3.addWork(book3);
        author4.addWork(book4);
        author5.addWork(book5);
        author1.addWork(periodical1);
        author2.addWork(periodical2);
        author3.addWork(periodical3);

        items.add(book1);
        items.add(book2);
        items.add(book3);
        items.add(book4);
        items.add(book5);
        items.add(periodical1);
        items.add(periodical2);
        items.add(periodical3);

        // Create Patrons
        Student student1 = new Student("John Smith", "123 College St", "555-0101", "S001");
        Student student2 = new Student("Emma Wilson", "456 University Ave", "555-0102", "S002");
        Student student3 = new Student("Michael Brown", "789 Campus Dr", "555-0103", "S003");

        Employee employee1 = new Employee("Sarah Johnson", "321 Staff Rd", "555-0201", "E001");
        Employee employee2 = new Employee("David Lee", "654 Faculty Lane", "555-0202", "E002");

        // Add some borrowed items
        student1.borrowItem(book1);
        student2.borrowItem(book2);
        employee1.borrowItem(periodical1);

        patrons.add(student1);
        patrons.add(student2);
        patrons.add(student3);
        patrons.add(employee1);
        patrons.add(employee2);
    }

    // Getters for the initialized data
    public List<Author> getAuthors() {
        return this.authors;
    }

    public List<LibraryItem> getItems() {
        return this.items;
    }

    public List<Patron> getPatrons() {
        return this.patrons;
    }
}