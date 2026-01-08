public class BankAccount {
    private String accountHolder;
    private double balance;
    private int pin; // NEW: account PIN

    // Updated constructor
    public BankAccount(String accountHolder, double balance, int pin) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
    }

    // NEW: Verify PIN
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

//deposit method
public void deposit(double amount) {
    if(amount > 0){
        balance += amount;
        System.out.println("Deposit Successful. ");
    }else{
        System.out.println("Invalid deposit amount.");
    }
}

//withdraw method
public void withdraw(double amount) {
    if(amount > 0 && amount <= balance){
        balance -= amount;
        System.out.println("Withdrawal Successful. ");
        System.out.println("Remaining balance: "+ balance);
    }else{
        System.out.println("Insufficient funds.");
    }
}

// returns the balance of the account
public double getBalance() {
        return balance;
    }

// returns the name of the account holder
    public String getAccountHolder() {
        return accountHolder;
    }
}

