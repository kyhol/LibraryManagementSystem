Library Management System
By Brian Janes, Kyle Hollett, Brad Ayers

**--User Manual--**

Thank you for using the Library Management System. This program provides two main modes of access: Patron and Librarian. Each mode allows different functionalities to manage library items, authors, and patron actions.

1. Starting the Application
1. Run the application, which starts in the `Demo` class.
2. The main menu will display options to access the system as a Patron or Librarian, or to exit.

---

<img width="298" alt="Screenshot 2024-10-31 at 6 53 59 AM" src="https://github.com/user-attachments/assets/f1852d0c-816c-433c-95c1-8c88a506fdb0">

---

Option 1: Patron Mode

Patron Menu Options:
- 1. Search by Author: Allows patrons to search for items by entering an author's name.
- 2. Search by Title: Allows patrons to search for items by entering part or all of a title.
- 3. Search by ISBN: Allows patrons to search for items by entering an ISBN.
- 4. List all Authors
- 5. List all Items
- 6. Borrow Item: Patrons can borrow items if they are available.
- 7. Return Item: Patrons can return borrowed items to the library.
- 8. Return to Main Menu: Returns to the Main Menu.

Search Operations:

The first three options here are search operations. After choosing a search method, you will be prompted to enter the field chosen to search by:

<img width="386" alt="Screenshot 2024-10-31 at 7 01 16 AM" src="https://github.com/user-attachments/assets/59132830-cb69-4b2a-a098-aed6d01a3895">

Typing 'exit' here will also bring you back to the menu.

The list functions simply list each object in the chosen category.

Patrons also have the option to borrow and return items.

Borrow:

<img width="347" alt="Screenshot 2024-10-31 at 7 14 21 AM" src="https://github.com/user-attachments/assets/5d27e14e-51ba-4b41-9c24-997dede4cab5">

Return:

<img width="442" alt="Screenshot 2024-10-31 at 7 15 49 AM" src="https://github.com/user-attachments/assets/3626045d-7464-446e-befc-106587cd0168">

---

Option 2: Librarian Mode

Librarian Menu Options:
- 1. Search Operations: Directs the user to a Search Menu for more specific search functions (as outlined above in Patron Mode).
- 2. Author Management: Allows staff to add, edit, and delete authors.
- 3. Item Management: Allows staff to add, edit, and delete library items.
- 4. Patron Management: Allows staff to add, edit, and delete patrons.
- 5. List all Authors
- 6. List all Items
- 7. List all Patrons
- 8. Return to Main Menu: Returns to the Main Menu.

The search and list operations work exactly the same as those in Patron Mode. Librarians also have the option to add, edit, and delete authors, library items, and patrons.

<img width="246" alt="Screenshot 2024-10-31 at 7 21 25 AM" src="https://github.com/user-attachments/assets/067cfc7b-4813-46c2-84fa-9b8932fe6fd0">

**Add:**

-Author

<img width="405" alt="Screenshot 2024-10-31 at 7 25 42 AM" src="https://github.com/user-attachments/assets/9f2714e5-82f8-4611-8dfb-d80b90b8b44d">

-Item

<img width="363" alt="Screenshot 2024-10-31 at 7 31 27 AM" src="https://github.com/user-attachments/assets/515be300-f7e4-479b-a34d-2eac0ff6c768">

-Patron

<img width="421" alt="Screenshot 2024-10-31 at 7 34 29 AM" src="https://github.com/user-attachments/assets/cf181266-c24f-48d0-810b-b4071e6aeeba">

**Edit:**

--Author:

<img width="424" alt="Screenshot 2024-10-31 at 7 37 04 AM" src="https://github.com/user-attachments/assets/4e2408d4-4f3e-4b60-ad2c-41f03c038590">

--Item

<img width="304" alt="Screenshot 2024-10-31 at 7 39 24 AM" src="https://github.com/user-attachments/assets/94b91d0f-bfe6-4229-8681-f4a26b364fba">

--Patron

<img width="424" alt="Screenshot 2024-10-31 at 7 41 17 AM" src="https://github.com/user-attachments/assets/c4d4eafd-50f0-4f5c-b195-375cc4ca265e">

**Delete:**

--Author

<img width="451" alt="Screenshot 2024-10-31 at 7 46 24 AM" src="https://github.com/user-attachments/assets/8ccc2d66-b599-42c2-941a-3c880b7b7a9d">

--Item

<img width="483" alt="Screenshot 2024-10-31 at 7 47 56 AM" src="https://github.com/user-attachments/assets/7c476a03-6975-469c-8482-9b8e6f5ac36a">

--Patron

<img width="412" alt="Screenshot 2024-10-31 at 7 49 18 AM" src="https://github.com/user-attachments/assets/e634a518-ca25-4b81-878d-d1d790252610">

---

Exiting the Application
- Selecting 3: Exit from the Main Menu will end the program. The system will display a thank-you message and close the scanner to release resources.

Notes:
- If an invalid input is provided at any stage, the system will display an error message and prompt the user to try again. 
- Each submenu allows returning to the previous menu, helping users navigate back to the Main Menu easily.

**--Development Docs--**

Directory structure:

<img width="461" alt="Screenshot 2024-10-31 at 10 05 07 AM" src="https://github.com/user-attachments/assets/dcaebc77-c69e-477a-be65-8d6d08934da8">

Database Structure:

<img width="966" alt="Screenshot 2024-10-31 at 10 29 49 AM" src="https://github.com/user-attachments/assets/6d8d71f2-a524-4079-b94c-b3ed0250c61a">

Video Walkthrough:

https://keyincollege289-my.sharepoint.com/:v:/g/personal/brian_janes_keyin_com/ERrSBFPZWgFHq-GTNY0g5yYBi_PcaLyypHol93cwZMFakQ?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=mvmfgl
