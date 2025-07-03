package hierarchicalInhertance;

class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayAccountInfo();
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    int maturityPeriod; // in months

    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayAccountInfo();
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}
public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA1001", 15000.0, 4.5);
        CheckingAccount checking = new CheckingAccount("CA2001", 10000.0, 5000.0);
        FixedDepositAccount fixed = new FixedDepositAccount("FD3001", 50000.0, 12);

        System.out.println("---- SAVINGS ACCOUNT ----");
        savings.displayAccountType();

        System.out.println("\n---- CHECKING ACCOUNT ----");
        checking.displayAccountType();

        System.out.println("\n---- FIXED DEPOSIT ACCOUNT ----");
        fixed.displayAccountType();
    }
}

