package application;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int accountNumber = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String accountHolder = sc.nextLine();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(accountNumber, accountHolder, initialBalance, withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double withdrawAmount = sc.nextDouble();

        try{
            account.withdraw(withdrawAmount);
            System.out.printf("New balance: %.2f%n", account.getBalance());
        }
         catch (BusinessException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }

        sc.close();

    }
}
