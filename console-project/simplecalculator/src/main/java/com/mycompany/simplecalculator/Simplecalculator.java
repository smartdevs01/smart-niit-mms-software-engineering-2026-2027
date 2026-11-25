/*o
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Simplecalculator {

    public static void main(String[] args) {
        double firstNumber, secondNumber, result;
        int op;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("SIMPLE CALCULATOR");

        System.out.println("ENTER VALLUE FOR FIRST NUMBER");
        firstNumber = inputScanner.nextDouble();

        System.out.println("FOLLOW THE INSTRUCTION BELOW: ");
        System.out.println("PRESS 1 TO CALCULATE SUM (+) ");
        System.out.println("PRESS 2 TO CALCULATE DIFFERENCE (-) ");
        System.out.println("PRESS 3 TO CALCULATE PRODUCT (*) ");
        System.out.println("PRESS 4 TO CALCULATE FRACTION (/) ");
        op = inputScanner.nextInt();

        System.out.println("ENTER VALUE FOR SECOND NUMBER");
        secondNumber = inputScanner.nextDouble();

        if (op == 1) {
            result = firstNumber + secondNumber;
            System.out.println("Result for sum is " + result);
        } else if (op == 2) {
            result = firstNumber - secondNumber;
            System.out.println("Result for difference is " + result);
        } else if (op == 3) {
            result = firstNumber * secondNumber;
            System.out.println("Result for product is " + result);
        } else if (op == 4) {
            if (secondNumber == 0) {
                System.out.println("This number cannot be divided by zero.");
            } else {
                result = firstNumber / secondNumber;
                System.out.println("Result for fraction is " + result);
            }
        } else {
            System.out.println("ERROR! Invalid operator entered, kindly follow the instructions given.");
        }

    }
}
