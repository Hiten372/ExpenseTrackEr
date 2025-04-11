Expense Tracker 

This is a simple, user-friendly Expense Tracker application built using Java. It allows users to register, log in, add expenses, view all expenses, and generate category-wise summaries. All data is stored locally and persists between sessions.

## Features

- User Registration & Login  
  Secure login system that stores user credentials during runtime.

- Add Expenses  
  Users can input expenses with a category and amount. The current date is automatically recorded.

- View All Expenses  
  Display all previously recorded expenses in a structured format.

- Category-wise Totals  
  Calculate and display the total amount spent per category.

- Data Persistence  
  Expenses are stored in a `.dat` file for each user to retain data across sessions.

## Technologies Used

- Java
- Java Collections Framework
- File I/O
- Object Serialization
- Command-Line Interface (CLI)

## How to Run

1. Clone the repository:
   git clonehttps://github.com/Hiten372/ExpenseTrackEr.git

2. Compile the program:
   javac *.java

3. Run the application:
   java Main

## Project Structure

ExpenseTracker/
├── Expense.java
├── User.java
├── ExpenseManager.java
└── Main.java
