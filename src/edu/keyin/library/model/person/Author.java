package edu.keyin.library.model.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import edu.keyin.library.model.item.LibraryItem;

public class Author {
    private String name;
    private Date birthdate;
    private final ArrayList<LibraryItem> listOfWorks;

    public Author(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.listOfWorks = new ArrayList<>();
    }

    public void addWork(LibraryItem item) {
        if (!listOfWorks.contains(item)) {
            listOfWorks.add(item);
        }
    }

    public void removeWork(LibraryItem item) {
        listOfWorks.remove(item);
    }

    public ArrayList<LibraryItem> getListOfWorks() {
        return new ArrayList<>(listOfWorks);
    }

    public static Author createAuthorFromUserInput(Scanner scanner) {
        String name = readName(scanner);
        Date birthdate = readBirthdate(scanner);
        return new Author(name, birthdate);
    }

    private static String readName(Scanner scanner) {
        String name;
        while (true) {
            System.out.println("Please enter the Author's name: ");
            if (scanner.hasNextLine()) {
                name = scanner.nextLine().trim();
                if (!name.isEmpty()) {
                    return name;
                }
            }
            System.out.println("Invalid input. Please enter a valid author's name.");
        }
    }

    private static Date readBirthdate(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        while (true) {
            System.out.println("Please enter the author's birthdate (DD-MM-YYYY): ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                try {
                    Date date = dateFormat.parse(input);
                    Date currentDate = new Date();
                    if (date.after(currentDate)) {
                        System.out.println("Birthdate cannot be in the future. Please try again.");
                        continue;
                    }
                    return date;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please use DD-MM-YYYY format.");
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", number of works=" + listOfWorks.size() +
                '}';
    }
}