import java.util.Scanner;
public class ATM {
    private Account account;
    private Scanner scanner;

    public ATM(Account account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();
            if (account.validatePin(pin)) {
                loggedIn = true;
                System.out.println("Login successful!");
                menu();
            } else {
                System.out.println("Incorrect PIN. Try again.");
            }
        }
    }

    public void menu(){
        int choice;
        do{
            System.out.println("\nATM Menu:");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Transfer money");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's account number: ");
                    // For simplicity, assume it's the same account (to be expanded later)
                
                    Account recipient = new Account(1234, 5000);  // Simulate recipient account
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(recipient, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }while(choice!=5);
    }
    public static void main(String[] args) {
        // Sample account with pin 1234 and balance $5000
        Account account = new Account(1234, 5000);
        ATM atm = new ATM(account);
        atm.start();
    }
    
}
