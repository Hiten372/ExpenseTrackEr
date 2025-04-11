import java.util.*;

public class Main {
    private static final Map<String, User> users = new HashMap<>();
    private static User currentUser;
    private static ExpenseManager manager;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("User already exists!");
        } else {
            users.put(username, new User(username, password));
            System.out.println("User registered successfully.");
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = users.get(username);

        if (user != null && user.checkPassword(password)) {
            currentUser = user;
            manager = new ExpenseManager(username);
            runApp();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void runApp() {
        while (true) {
            System.out.println("\n1. Add Expense\n2. View All Expenses\n3. Category-wise Total\n4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> viewExpenses();
                case 3 -> viewCategoryTotals();
                case 4 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        manager.addExpense(new Expense(category, amount));

        System.out.println("Expense added.");
    }

    private static void viewExpenses() {
        System.out.println("\n--- All Expenses ---");
        for (Expense e : manager.getAllExpenses()) {
            System.out.println(e);
        }
    }

    private static void viewCategoryTotals() {
        System.out.println("\n--- Category-wise Totals ---");
        Map<String, Double> totals = manager.getCategoryWiseTotal();
        for (Map.Entry<String, Double> entry : totals.entrySet()) {
            System.out.println(entry.getKey() + ": Rs." + entry.getValue());
        }
    }
}
