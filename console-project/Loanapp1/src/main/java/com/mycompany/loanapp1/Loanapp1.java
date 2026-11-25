/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.loanapp1;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Loanapp1 {

    public static void main(String[] args) {
        double loan, rate, principal, totalInterest, balance, totalPayment, monthlyPrincipal, interest, payment;
        int months;

        System.out.println("LOAN APP");

        Scanner input = new Scanner(System.in);
        try {

            System.out.print("Enter loan amount: ");
            loan = input.nextDouble();

            System.out.print("Enter duration in months: ");
            months = input.nextInt();

            System.out.print("Enter monthly interest rate (%): ");
            rate = input.nextDouble();

            if (loan <= 0 || months <= 0 || rate < 0 || rate > 100) {
                System.out.println("Invalid input. Please try again.");
                input.close();
                return;
            }

            principal = loan / months;
            balance = loan;
            totalInterest = 0;
            totalPayment = 0;

            System.out.println("\nMONTHLY REPAYMENT BREAKDOWN");
            System.out.println("-----------------------------------------------");
            System.out.printf("%-7s %-12s %-12s %-12s%n",
                    "Month", "Principal", "Interest", "Payment");

            for (int month = 1; month <= months; month++) {

                if (month == months) {
                    monthlyPrincipal = balance;
                } else {
                    monthlyPrincipal = principal;
                }

                interest = balance * rate / 100;
                payment = monthlyPrincipal + interest;

                balance = balance - monthlyPrincipal;
                totalInterest = totalInterest + interest;
                totalPayment = totalPayment + payment;

                System.out.printf("%-7d %-12.0f %-12.0f %-12.0f%n",
                        month, monthlyPrincipal, interest, payment);
            }

            System.out.println("-----------------------------------------------");
            System.out.printf("Loan Amount:     %.0f%n", loan);
            System.out.printf("Total Interest:  %.0f%n", totalInterest);
            System.out.printf("Total Repayment: %.0f%n", totalPayment);

        } catch (Exception e) {

            System.out.println("Invalid input! Please enter numbers only.");
        }
    }
}
