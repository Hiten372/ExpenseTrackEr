

# Expense Tracker - Java

An expense tracker built using Java to help you manage your daily expenses, categorize them, and get insights into your spending habits.

## Features

- **Track Expenses**: Record daily expenses with categories (e.g., Food, Entertainment, Bills).
- **View Expense Summary**: Get a summary of all your expenses over a period.
- **Filter by Category**: View expenses filtered by category.
- **Save Data**: Expenses are saved in a file for persistent storage.
- **Delete/Edit Expenses**: Modify or delete previously entered expenses.

## Tech Stack

- **Java**: Core language for implementing the logic.
- **File I/O**: Used to store and retrieve data (expenses) from a file.
- **Simple Console Interface**: User interacts with the application through a terminal/command prompt.

## Requirements


- Text editor or IDE ( intelliJ IDEA)

## Getting Started

Follow these steps to set up the expense tracker:

### 1. Clone the Repository

```bash
https://github.com/Hiten372/ExpenseTrackEr.git
```

### 2. Compile the Code

Compile the Java files using `javac`:

```bash
javac ExpenseTracker.java
```

### 3. Run the Program

Run the program using `java`:

```bash
java ExpenseTracker
```

### 4. Interact with the Program

Once the program is running, you will see a menu with the following options:

1. **Add Expense**: Add a new expense.
2. **View Expenses**: View all expenses or filter by category.
3. **Delete Expense**: Remove an expense from the list.
4. **Exit**: Quit the program.

### 5. Data Storage

The expenses are saved in a file called `expenses.txt`. Every time you add an expense, the data is written to this file. When you view or delete expenses, the file is updated accordingly.

## Example Usage

1. Add an expense of $20 for "Food" category.
2. View all expenses.
3. Delete an expense.
4. View the summary of expenses by category.

## Code Structure

The project is structured as follows:

```
expense-tracker-java/
│
├── ExpenseTracker.java        # Main class with program logic
├── Expense.java               # Class representing individual expense
├── ExpenseManager.java        # Manages expenses (add, delete, list, etc.)
├── ExpenseUtils.java          # Utility methods (for file handling, etc.)
└── expenses.txt               # File for storing expenses (created automatically)
```

### Classes

- **ExpenseTracker.java**: The entry point for the program and handles user interaction.
- **Expense.java**: Represents the expense with details like amount, category, and description.
- **ExpenseManager.java**: Handles adding, deleting, and listing expenses.
- **ExpenseUtils.java**: Utility methods for file reading and writing.

