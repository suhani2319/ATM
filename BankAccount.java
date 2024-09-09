import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", account.getBalance()));
        } else {
            System.out.println("Insufficient balance or invalid amount. Please try again.");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("Deposit successful. New balance: $" + String.format("%.2f", account.getBalance()));
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + String.format("%.2f", account.getBalance()));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String args[]) {
        BankAccount account = new BankAccount(500);  // Initial balance of $500
        ATM atm = new ATM(account);
        atm.run();
    }
}