public class BankAccount {
    private double balance;
    private String name;

//constructor
public BankAccount(String name, double balance ) {
    this.balance = balance;
    this.name = name;
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

public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return name;
    }
}

