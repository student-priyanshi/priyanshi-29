import java.util.Scanner;

class BankAccount {
    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        } else {
            System.out.println("Invalid amount for deposit");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            return true;
        } else {
            System.out.println("Insufficient amount");
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)){
            System.out.println("Withdrawal Successful !! Current Amount:" + account.checkBalance());
        } else {
            System.out.println("Sorry!!!!! Try Again.");
        }
    }

    public void deposit(double amount) {
        if (account.deposit(amount)){
            System.out.println("Deposit Successfully.Current Amount:" + account.checkBalance());
        } else {
            System.out.println("Sorry!!!!! Try Again.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance:" + account.checkBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        double initialBalance = 1000;
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
