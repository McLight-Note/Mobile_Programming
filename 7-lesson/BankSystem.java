class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber);
            System.out.println("New balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
            System.out.println("New balance: $" + String.format("%.2f", balance));
        } else if (amount > balance) {
            System.out.println("Insufficient funds! Current balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("Withdrawal amount must be positive");
        }
    }

    public void transfer(BankAccount other, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            other.balance += amount;
            System.out.println("Transferred $" + amount + " from account " + this.accountNumber + " to account " + other.accountNumber);
            System.out.println(this.accountNumber + " new balance: $" + String.format("%.2f", this.balance));
            System.out.println(other.accountNumber + " new balance: $" + String.format("%.2f", other.balance));
        } else if (amount > balance) {
            System.out.println("Insufficient funds for transfer! Current balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("Transfer amount must be positive");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + String.format("%.2f", balance));
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + String.format("%.2f", balance) +
                '}';
    }
}

public class BankSystem {
    public static void main(String[] args) {
        // Create two bank accounts
        BankAccount account1 = new BankAccount("ACC001", 1000.00);
        BankAccount account2 = new BankAccount("ACC002", 500.00);

        System.out.println("=== Initial Account Information ===");
        account1.displayAccountInfo();
        account2.displayAccountInfo();

        System.out.println("\n=== Testing Deposit ===");
        account1.deposit(250.00);

        System.out.println("\n=== Testing Withdrawal ===");
        account2.withdraw(100.00);

        System.out.println("\n=== Testing Insufficient Balance ===");
        account2.withdraw(500.00);

        System.out.println("\n=== Testing Transfer ===");
        account1.transfer(account2, 300.00);

        System.out.println("\n=== Final Account Information ===");
        account1.displayAccountInfo();
        account2.displayAccountInfo();

        System.out.println("\n=== Testing Transfer with Insufficient Funds ===");
        account2.transfer(account1, 1000.00);
    }
}
