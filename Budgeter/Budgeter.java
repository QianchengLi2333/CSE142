//<Qiancheng Li>
//<10/22/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #4>
//
//This program calculate the user's daily and total
//income and expense amount and evaluate the user.

import java.util.*;
public class Budgeter {
    //Set the number of days in this month 
    public static final int DAYS_IN_MONTH = 31;

    public static void main(String[] args) {
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
        Scanner console = new Scanner(System.in);
        double sumInc =count(console, "income");
        double sumExp = expense(console);
        total(sumInc, sumExp);
        conclusion(sumInc, sumExp);
    }

    //Read categories of user input and calculate the sum of user input
    //Return the sum of user input
    //Parameters:
    //    Scanner console: the scanner to read user input
    //    String type: the type of the amount—— either income or expense 
    public static double count(Scanner console, String type) {
        double sum = 0.0;
        System.out.print("How many categories of " + type + "? ");
        int numInt = console.nextInt();
        for (int category = 0; category < numInt; category++) {
            System.out.print("    Next " + type + " amount? $");
            double amount = console.nextDouble();
            sum += amount;        
        }
        System.out.println();
        return sum;
    }

    //Read the expense is monthly or daily and calculate the expense this month
    //Return the total expense of this month
    //Parameter:
    //    Scanner console: the scanner to read user input
    public static double expense(Scanner console) {
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        int choice = console.nextInt();
        double total = count(console, "expense");
        if (choice == 2) {
            total = total * DAYS_IN_MONTH;
        }
        return total;
    }

    //Calculate total and daily income and expense
    //Parameters:
    //    double sumInc: the amount of income this month
    //    double sumExp: the amount of expense this month
    public static void total(double sumInc, double sumExp) {
        System.out.print("Total income = $" + decimal2(sumInc) + " ");
        System.out.println("($" + decimal2(sumInc / DAYS_IN_MONTH) + "/day)");
        System.out.print("Total expenses = $" + decimal2(sumExp) + " ");
        System.out.println("($" + decimal2(sumExp / DAYS_IN_MONTH) + "/day)");
        System.out.println();
    }

    //Evaluate and comment on the user by his or her income and expense
    //Parameters:
    //    double sumInc: the amount of income this month
    //    double sumExp: the amount of expense this month
    public static void conclusion(double sumInc, double sumExp) {
        double budget = decimal2(sumInc - sumExp);
        if (budget > 0) {
            System.out.println("You earned $" + budget + " more than you spent this month.");
            if (budget > 250) {
                System.out.println("You're a big saver.");
                System.out.println("Buy something you want!");
            } else {// 0 < budget <= 250
                System.out.println("You're a saver.");
                System.out.println("Maybe you can buy something you like.");
            }    
        } else {
            System.out.println("You spent $" + Math.abs(budget) 
                               + " more than you earned this month.");
            if (budget <= -250) {
                System.out.println("You're a big spender.");
                System.out.println("Please save some money.");
            } else {// -250 < budget <= 0          
                System.out.println("You're a spender.");
                System.out.println("Maybe you should save some money.");
            }
        }    
    }

    //Round the number to its two decimal places
    //Retern the rounded number
    //Parameter:
    //    double num: the number to be rounded
    public static double decimal2(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
