import java.io.Serializable;
import java.time.LocalDate;

public class Expense implements Serializable {
    private LocalDate date;
    private String category;
    private double amount;

    public Expense(String category, double amount) {
        this.date = LocalDate.now();
        this.category = category;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | Rs." + amount;
    }
}
