package edu.keyin.library.model.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import edu.keyin.library.model.item.*;

public class Author {
    private String name;
    private Date birthdate;
    private final ArrayList<edu.keyin.library.model.item.Book> listOfWorks;

    // Constructor
    public Author(String name, Date birthdate, ArrayList listOfWorks) {
        this.name = name;
        this.birthdate = birthdate;
        this.listOfWorks = listOfWorks;
    }

    public static Author createAuthorFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        String name = readName(scanner);
        Date birthdate = readBirthdate(scanner);
        ArrayList listOfWorks = ;
        scanner.close();
        return new Author(name, birthdate, listOfWorks);
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

    private static ArrayList readListOfWorks(Scanner scanner) {
        while (true) {

        }
    }

    // Getters and setters
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
}