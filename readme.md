# 📚 Book Finder System

### Object Oriented Programming using Java (CO5 Project)

---

## 👥 Team Members

* **Ashwin Thomas Mathew**
* **Kevin Varghese Roy**
* Course: 244SECUBC201 – Object Oriented Programming using Java

---

## 📌 Problem Statement

Searching for books manually in a library or large collection is time-consuming and inefficient. There is a need for a digital system that allows users to quickly search for books and manage book records efficiently.

The Book Finder System provides a GUI-based solution to search and add books using Java and MySQL database connectivity.

---

## 🎯 Objective

* To develop a Java Swing-based GUI application.
* To implement Object-Oriented Programming concepts.
* To integrate MySQL database using JDBC.
* To allow users to search books by title or author.
* To allow insertion of new book records.
* To implement exception handling for system reliability.

---

## ✨ Features

* 🔍 Search books by title or author
* ➕ Add new books to the database
* 📄 Display book details (ID, Title, Author, Category, Availability)
* 🗄 MySQL database integration
* ⚠ Exception handling using try-catch
* 🖥 User-friendly Java Swing GUI

---

## 🛠 Technologies Used

* Java (JDK 8 or above)
* Java Swing (GUI Components)
* MySQL Database
* JDBC (Java Database Connectivity)
* Apache NetBeans IDE

---

## ▶ Steps to Run the Program

1. Install Java JDK (8 or above).

2. Install MySQL Server.

3. Create a database named:

   ```
   library
   ```

4. Create a table named:

   ```
   books
   ```

   With fields:

   * id (INT, Primary Key, Auto Increment)
   * title (VARCHAR)
   * author (VARCHAR)
   * category (VARCHAR)
   * availability (VARCHAR)

5. Open the project in NetBeans IDE.

6. Update database username and password inside `DBConnection.java`.

7. Run `BookSearchGUI.java`.

8. The application window will open.

---

## 📷 Screenshots of the GUI

(Add your images inside a folder named `screenshots`)

### 🔹 Main Interface

![Main GUI](screenshots/main_gui.png)

### 🔹 Search Result

![Search Result](screenshots/search_result.png)

### 🔹 Add Book Section

![Add Book](screenshots/add_book.png)

### 🔹 Database Records

![Database](screenshots/database.png)

---

## 🧪 Sample Inputs and Outputs

### 🔎 Test Case 1 – Search Book

**Input:**
Search Keyword: `1984`

**Output:**

* ID: 15
* Title: 1984
* Author: George Orwell
* Category: Dystopian Novel
* Availability: Available

---

### ➕ Test Case 2 – Add New Book

**Input:**

* Title: The Secret of the Nagas
* Author: Amish Tripati
* Category: Mythology
* Availability: Available

**Output:**
Message Displayed:
`Book Added Successfully!`

Record successfully inserted into MySQL database.

---

## 📚 OOP Concepts Implemented

* **Encapsulation** – Private variables with getters/setters
* **Inheritance** – TextBook and ReferenceBook extend Book class
* **Polymorphism** – Method overriding
* **Abstraction** – Base class structure
* **Exception Handling** – Try-catch blocks for SQL and input errors
* **JDBC Connectivity** – Real-time database interaction

---

## ✅ Conclusion

The Book Finder System successfully demonstrates Java Swing GUI development, OOP concepts, exception handling, and JDBC database connectivity. The system provides an efficient and user-friendly way to search and manage book records.


