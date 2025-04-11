import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpenseManager {
    private List<Expense> expenses;
    private final File file;

    public ExpenseManager(String username) {
        this.expenses = new ArrayList<>();
        this.file = new File(username + "_expenses.dat");
        loadExpenses();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }

    public Map<String, Double> getCategoryWiseTotal() {
        return expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getAmount)));
    }

    private void saveExpenses() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(expenses);
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    private void loadExpenses() {
        if (!file.exists()) return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            expenses = (List<Expense>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }
}
