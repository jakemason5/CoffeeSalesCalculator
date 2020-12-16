/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeesalescalculator;
import java.util.Scanner;
/*Java Coffee Sales Calculator
 *By: Jacob Mason
 Version 1.1.1
 */
public class CoffeeSalesCalculator {

    //class Mainclass
    //{
    public static void main(String[] args) {
    
        //Welcoming user and describing the program
    System.out.println("Welcome to the Java Coffee Sales Calculator");
    System.out.println("\nThis program will calculate the amount owed for "
            + "a coffee sales transaction.");
    

    //Setting up static variables
     char repeat = 'Y';
    while (repeat == 'Y')
    {
    
        //Accepting user input for sale information
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nNumber of bags sold: ");
        int numberOfBags = input.nextInt();
    
        Scanner input2 = new Scanner(System.in);
        System.out.print("Weight per bag: ");
        int bagWeight = input2.nextInt();
    
        //Setting up acceptance of variables from other class
        SimpleCalculations calc1 = new SimpleCalculations();
    
        //Printing out list
        System.out.printf("\n\n%-16s %d\n", "Number of Bags:", numberOfBags);
        System.out.printf("%-16s %d %s\n", "Weight per bag:", bagWeight, "pounds");
        System.out.printf("%-16s $%.2f\n", "Price per pound:", calc1.getPrice());
        System.out.printf("%-16s %.2f%%\n", "Sales tax:", calc1.getTaxRate());
        System.out.printf("%-16s $%.2f\n", "Sales sub-total:",calc1.getSale(bagWeight, numberOfBags));
        System.out.printf("%-16s $%.2f\n", "Total tax:", (calc1.getSaleTax(bagWeight, numberOfBags)));
        System.out.printf("%-16s $%.2f\n", "Total Sale:", calc1.getTotalPrice(bagWeight, numberOfBags));
    
    
        System.out.print("\nDo you want to calculate another sale?(Y/N) ");
        Scanner input3 = new Scanner(System.in);
        repeat = input3.next().charAt(0);
    
    
    }
    System.out.println("Thank you for using the Java Sales Calculator. Goodbye.");
    
    }
}

class SimpleCalculations
{
    double taxRate = 0.0725;
    double pricePerLB = 5.99;
    double totalPrice;
    double getSale(int bagWeight, int numberOfBags)
    {
        return bagWeight * numberOfBags * pricePerLB;
    }

    double getSaleTax(int bagWeight, int numberOfBags)
    {
        return taxRate * bagWeight * numberOfBags * pricePerLB;
    }

    double getTotalPrice(int bagWeight,int numberOfBags)
    {
        return (taxRate * bagWeight * numberOfBags * pricePerLB) 
            + (bagWeight * numberOfBags * pricePerLB);
    }

    double getPrice()
    {
        return pricePerLB;
    }

    double getTaxRate()
    {
        return taxRate * 100;
    }   
}
