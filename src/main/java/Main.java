import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("Fred", 500, 100569379);
        bankAccount1.deposit(100);
        bankAccount1.print();

        //Bank Transfer
        BankAccount bankAccount2 = new BankAccount("John", 5000, 997834758);
        bankAccount2.withdraw(100);
        bankAccount2.print();

        BankAccount bankAccount3 = new BankAccount("Jane", 300, 303);
        bankAccount3.deposit(100);
        bankAccount3.print();
        //end Bank Transfer

        //Assignment continued. Use an arrayList to keep track of accounts
        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);
        bankAccounts.add(bankAccount3);
        BankAccount bankAccount4 = new BankAccount();
        bankAccounts.add(bankAccount4);

        BankAccount bankAccount5 = new BankAccount();
        bankAccounts.add(bankAccount5);

        for (BankAccount bankAccount : bankAccounts) {
            bankAccount.print();
        }
        mainMenu(bankAccounts);

    }
    //Create a Main Menu
    public static void mainMenu(ArrayList<BankAccount> bankAccounts) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + bankAccounts.get(2).getName());
        System.out.println("Welcome to the Main Menu, what would you like to do today?");
        while (true) {
            System.out.println("1. Check account balance.");
            System.out.println("2. Make a withdrawal.");
            System.out.println("3. Make a deposit.");
            System.out.println("4. Make a transfer to another account.");
            System.out.println("0. Exit");

            switch (in.nextInt()) {
                case 1:
                    System.out.println("Your account balance is: " + bankAccounts.get(2).getBalance());
                    break;
                case 2:
                    System.out.println("How much would you like to withdraw?");
                    double withdrawAmount = in.nextDouble();
                    in.nextLine(); //consume the 'enter' key
                    bankAccounts.get(2).withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("How much would you like to deposit?");
                    double depositAmount = in.nextDouble();
                    in.nextLine();
                    bankAccounts.get(2).deposit(depositAmount);
                    break;
                case 4:
                    transferMenu(bankAccounts);
                    break;
                case 0:
                    System.out.println("Goodbye.");
                    System.exit(0);
                    break;
            }
        }
    }
    public static void transferMenu(ArrayList<BankAccount> bankAccounts) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the account number to transfer to?");
        int accountNumber = in.nextInt();
        in.nextLine();
        //compare given accountnumber to each account Number in arrayList and get matching
        BankAccount destination = null;
        for (BankAccount bankAccount : bankAccounts)
        {
            if (accountNumber == bankAccount.getAccountNumber())
            {
                destination =  bankAccount;
            }
        }
        System.out.println("How much would you like to transfer?");
        double amount = in.nextDouble();
        in.nextLine();
        if (destination != null) {
            bankAccounts.get(2).transfer(destination, amount);
        } else {
            System.out.println("Bank account does not exist.");
        }

    }


}
