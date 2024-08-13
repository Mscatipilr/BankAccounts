import java.util.Scanner;

public class BankAccount {
    //attributes
    private String name;
    private double balance;
    private int accountNumber;

    //Constructor updates for continued assignment.
    public BankAccount(String name, double balance, int accountNumber) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    //2nd constructor, no parameters
    public BankAccount() {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! Welcome to 'Yours Truly' Bank!");
        System.out.println("Are you an existing customer? (-1 to exit)");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = in.nextInt();
        in.nextLine(); //consume
        if (choice == -1) {
            System.exit(0);
        } else if (choice == 1) {
            System.out.println("Thanks for visiting!");
        } else {
            System.out.println("Let's make a new account!");
            System.out.println("What is the name for the account?");
            this.name = in.nextLine();
            System.out.println("What is the beginning balance for the account?");
            this.balance = in.nextDouble();
            in.nextLine(); //consume newline left-over
        }
    }


    //methods
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void print() {
        System.out.println(this.name + "'s account balance: " + this.balance);
        System.out.println(" ");
    }

    //getters
    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    //transfer method
    public void transfer(BankAccount destination, double amount) {
        this.withdraw(amount);
        destination.deposit(amount);
        System.out.println("Transfer from " + this.getName() + " to " + destination.getName() + " successful!");
    }

}