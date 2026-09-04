public class BankAccount {
  
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        setAccountNumber(accountNumber);
        setAccountHolderName(accountHolderName);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && !accountNumber.trim().isEmpty()
                && accountNumber.trim().length() >= 5) {
            this.accountNumber = accountNumber.trim();
        } else {
            this.accountNumber = "00000";
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName != null && !accountHolderName.trim().isEmpty()
                && accountHolderName.trim().length() >= 3) {
            this.accountHolderName = accountHolderName.trim();
        } else {
            this.accountHolderName = "Unknown";
        }
    }
  
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Insufficient Balance");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Available Balance: " + balance);
    }
  
    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("12345", "Ashu", 12000);

        account.displayAccountDetails();

        System.out.println("\nAfter Deposit:");
        account.deposit(3000);
        account.displayAccountDetails();

        System.out.println("\nAfter Withdrawal:");
        account.withdraw(2000);
        account.displayAccountDetails();
    }
}
