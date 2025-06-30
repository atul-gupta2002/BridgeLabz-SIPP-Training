package AssistedProblems;

import java.util.ArrayList;

// Account class
class Account {
    private static int accountCounter = 1000;
    private int accountNumber;
    private double balance;
    private Bank bank;

    public Account(Bank bank) {
        this.accountNumber = accountCounter++;
        this.balance = 0.0;
        this.bank = bank;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            System.out.println("Account No: " + account.getAccountNumber() +
                    ", Bank: " + account.getBank().getName() +
                    ", Balance: ₹" + account.getBalance());
        }
        System.out.println();
    }
}

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Customer customer) {
        Account account = new Account(this); // this refers to current Bank
        account.deposit(1000); // initial deposit
        customer.addAccount(account);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer + " at " + name);
    }

    public void listCustomers() {
        System.out.println("Customers at " + name + ":");
        for (Customer customer : customers) {
            customer.viewBalance();
        }
    }
}

// Main class
public class Main1 {
    public static void main(String[] args) {
        // Create banks
        Bank hdfc = new Bank("HDFC Bank");
        Bank sbi = new Bank("SBI Bank");

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts
        hdfc.openAccount(alice);
        sbi.openAccount(alice);
        hdfc.openAccount(bob);

        // View balances
        alice.viewBalance();
        bob.viewBalance();

        // List all customers of HDFC
        hdfc.listCustomers();
    }
}

