import java.util.Scanner;

class Account {

    private String accNumber;
    private String accHolder;
    private double balance;

    
    public Account(String accNumber, String accHolder, double balance) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    
    public void display() {

        System.out.println("Account Number: " + accNumber);
        System.out.println("Account Holder: " + accHolder);
        System.out.println("Balance: " + balance);
    }
}

public class MiniBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter account holder name: ");
        String accHolder = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(accNo, accHolder, balance);

       
        int choice;
        do {
            System.out.println("\n--- MiniBank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                }
                case 2 -> {
                    System.out.print("Enter withdraw amount: ");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                }
                case 3 -> acc.display();
                case 4 -> System.out.println("Exiting MiniBank...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
class Customer {
    private String name, email, mobile;
    private final String customerId;
    private static long customerCounter = 100;

    private static String generateCustomerId() {
        return "CUST" + (++customerCounter);
    }

    public Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.customerId = generateCustomerId();
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getCustomerId() { return customerId; }
}
