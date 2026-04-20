import java.util.Scanner;

class ATM {
    double balance = 1000; // initial balance

    // Check Balance
    void checkBalance() {
        System.out.println(" Current Balance: " + balance);
    }

    // Deposit
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Deposited: " + amount);
        } else {
            System.out.println(" Invalid amount");
        }
    }

    // Withdraw
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(" Insufficient Balance");
        } else if (amount <= 0) {
            System.out.println(" Invalid amount");
        } else {
            balance -= amount;
            System.out.println(" Withdrawn: " + amount);
        }
    }
}

public class ATM_management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    atm.deposit(dep);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wit = sc.nextDouble();
                    atm.withdraw(wit);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
