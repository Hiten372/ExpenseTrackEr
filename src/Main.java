import java.time.temporal.WeekFields;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.util.stream.Collectors;
class Expense {
    private double amount;
    private String category;
    private String description;
    private LocalDate date;

    public Expense(double amount, String category, String description, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + " | " + amount + " | " + category + " | " + description;
    }
}
      class ExpenseManager{

    private List<Expense> Expenses;
    private static final String FILE_NAME = "expenses.txt";

    public ExpenseManager(){
        Expenses = new ArrayList<>();
        loadExpensesFromFile();
    }
    public void addExpense(double amount,String category,String description,LocalDate date){
        Expense expense = new Expense(amount,category,description,date);
        Expenses.add(expense);
        saveExpensesToFile(expense);
    }
    public double getTotalExpensesForDay(LocalDate date) {
        return Expenses.stream()
                .filter(e -> e.getDate().equals(date))
                .mapToDouble(Expense::getAmount)
                .sum();
    }
    public double getTotalExpensesForWeek(LocalDate date) {
        int targetWeek = date.get(WeekFields.of(Locale.getDefault()).weekOfYear());
        return Expenses.stream()
                .filter(e -> e.getDate().get(WeekFields.of(Locale.getDefault()).weekOfYear()) == targetWeek)
                        .mapToDouble(Expense::getAmount)
                        .sum();
    }
          public double getTotalExpensesForMonth(int month, int year) {
        return Expenses.stream()
                .filter(e -> e.getDate().getMonthValue()== month && e.getDate().getYear()==year)
                        .mapToDouble(Expense::getAmount)
                        .sum();
    }
    public void displayAllExpenses(){
        if(Expenses.isEmpty()){
            System.out.println("No expenses recorded.");
        }else{
            Expenses.forEach(System.out::println);
        }
    }
    private void saveExpensesToFile(Expense expense){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true))){
            writer.write(expense.getDate()+ ","+ expense.getCategory()+","+
                    expense.getAmount()+ "," + expense.getDescription());
        writer.newLine();
        }catch(IOException e){
            System.out.println("Error saving expense: " + e.getMessage());
        }
    }
    private void loadExpensesFromFile(){
        File file = new File(FILE_NAME);
        if(!file.exists())return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                String[]data = line.split(",");
                LocalDate date = LocalDate.parse(data[0]);
                String category = data[1];
                double amount = Double.parseDouble(data[2]);
                String description = data[3];
                Expenses.add(new Expense(amount, category, description,date));

            }
        }catch (IOException e ){
            System.out.println("Error loading expenses:" + e.getMessage());
            
        }
      }
    }
    public class Main {
    public static void main(String[]args){
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nDaily Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. view Daily Summary");
            System.out.println("3. view Weekly Summary");
            System.out.println("4. View Monthly Summary");
            System.out.println("5. View All Expenses");
            System.out.println("6. Exit");
            System.out.println("choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.print("enter amount:");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("enter category:");
                    String category = scanner.nextLine();
                    System.out.print("enter description:");
                    String description = scanner.nextLine();
                    manager.addExpense(amount, category, description, LocalDate.now());
                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    System.out.println("total for today: rupee " + manager.getTotalExpensesForDay(LocalDate.now()));
                    break;

                case 3:
                    System.out.println("Total for this week: rupee " + manager.getTotalExpensesForWeek(LocalDate.now()));
                    break;

                case 4:
                    System.out.println("Enter month (1-12):");
                    int month = scanner.nextInt();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    System.out.println("Total for " + "/" + year + ":rupee " + manager.getTotalExpensesForMonth(month, year));
                    break;

                case 5:
                    manager.displayAllExpenses();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");

            }

        }

    }

}



