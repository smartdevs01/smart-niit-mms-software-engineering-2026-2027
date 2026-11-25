/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.boyleslaw;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Boyleslaw {

    public static void main(String[] args) {
        double p1, v1, v2, p2;
        
        Scanner input = new Scanner (System.in);
        System.out.println("THIS SOFTWARE CALCULATE BOYLE'S LAW");
        
        System.out.println("ENTER INITIAL PRESSURE: ");
        p1 = input.nextDouble();
        
        System.out.println("ENTER INITIAL VOLUME: ");
        v1 = input.nextDouble();
       
        
         System.out.println("ENTER FINAL VOLUME: ");
        v2 = input.nextDouble();
        
        p2 = (p1 * v1) / v2;
        
        System.out.println("FINAL PRESSURE = " + p2);
      
        
        
        
        
        
        
        
        
      
    }
}
