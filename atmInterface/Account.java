public class Account{
    private int pin;
    private double balance;
    
    public Account(int pin,double balance){
        this.pin=pin;
        this.balance=balance;
    }
    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful! New balance: $" + balance);
    }
    public void transfer(Account toAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println("Transfer successful! New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}
