/*
 * Course: TCSS142 – Introduction to Object-Oriented Programming
 * File Name: Project2.java
 * Assignment: 2
 * Due Date: 11/09/2021
 * Instructor: Mr. Schuessler

 */


import java.util.Scanner;

/**
 * This program receives employee information for a given pay period including
 * pay, hours worked, and gross pay. After all employees are processed
 * a congratulatory message is displayed based on the employee with
 * the most worked hours.
 *
 * @author Parker Johnson
 * @version 11/9/2021
 */

public class Project2 {

   
     *
     * @param theArgs is used for command line input
     */


    public static void main(String[] theArgs) {
        
        Scanner input = new Scanner(System.in);
        int employeeCnt = getEmployeeCnt(input);
        processEmployeePay(input, employeeCnt);




    }

    /**
     * Recieves input from the keyboard that determines the number of employees
     * 
     * @param theConsole a Scanner that receives the number of employees
     * @return Returns the value given to the console by the user
     */

    public static int getEmployeeCnt(Scanner theConsole) {

        System.out.print("How many employees are there? ");
        int count = theConsole.nextInt();
        return count;
    }

    /**
     * Asks the user for number of employees and prints the information
     * to the console in a nice formatted way.
     *
     * @param theConsole A Scanner that takes in pay, hours worked, 
     * and employee name
     * @param theCount the number of employees worked - decides how many times
     * information gathering question is asked
     */

    public static void processEmployeePay(Scanner theConsole, int theCount) {
        String name = "";
        String topName = "";
        double hoursWorked = 0.0;
        double payRate = 0.0;
        double grossPay = 0.0;
        double topWorked = 1.0;

        

        for (int i = 1; i <= theCount; i++) {
            System.out.print("Enter Hours Worked, Pay Rate," + 
            " and Employee name " + "separated by a space: ");
            hoursWorked = theConsole.nextInt();
            payRate = theConsole.nextDouble();
            name = theConsole.nextLine();



            grossPay = getGrossPay(hoursWorked, payRate);
            displayEmployeePay(name, payRate, hoursWorked, grossPay);


            if (hoursWorked > topWorked) {
                topWorked = hoursWorked;
                topName = name;
            }

        }

        displayTopEmployee(topName, topWorked);
    }

    /**
     * Generates the Gross pay of the employee
     *
     * @param theHours Number of hours the employee works
     * @param theRate  The hourly rate the employee gets paid
     * @return Returns the gross pay of the Employee
     */
    public static double getGrossPay(double theHours, double theRate) {
        double pay = 0;
        if (theHours > 48.0) {
            pay = 2 * theRate * (theHours - 48) + 48 * theRate;
            theHours = 48.0;
        } else if (theHours > 40.0){
            pay = 1.5 * theRate * (theHours - 40.0) + 40 * theRate;
            theHours = 40.0;
            
        } else pay = theHours * theRate;
        return pay;
    }

    /**
     * Displays the info that is given to the console as employee info
     * that is formated
     * 
     * @param theName The name of the employee
     * @param theRate The hourly rate the employee gets paid
     * @param theHours The number of hours the employee works
     * @param theGrossPay The product of theRate and theHours
     */

    public static void displayEmployeePay(String theName, double theRate,
                                     double theHours, double theGrossPay) 
                                          {
        System.out.printf("%20s Employee Name: %20s\n", " ", theName);
        System.out.printf("%21s Hours Worked: %20.2f\n", " ",  theHours);
        System.out.printf("%25s Pay Rate: %20s\n", " ", 
                           String.format("$%,.2f", theRate));
        System.out.printf("%24s Gross Pay: %20s\n", " ", 
                           String.format("$%,.2f", theGrossPay));
        System.out.println();


    }

    /**
     * Displays the a message based on hours worked to the employee who worked
     * the most
     *
     * @param theTopName The employee who has worked the most hours
     * @param theTopHours The number of hours theTopName has worked
     */

    public static void displayTopEmployee(String theTopName,
                                          double theTopHours) {

        if (theTopHours >= 56) {
            System.out.print("WOW!!!! \t What a dynamo! " + theTopName +
                    " worked " + theTopHours + " hours this WEEK!");
        } else if (theTopHours >= 48) {
            System.out.print(theTopName + " is such a workhorse! Looks like " +
                    "you worked for " + theTopHours + " Hours this WEEK!");
        } else if (theTopHours >= 40) {
            System.out.print("Well, good for YOU " + theTopName + ", Who"
                    + " worked " + theTopHours + " hours this WEEK!");
        } else {
            System.out.print( theTopName + " worked " + theTopHours +
                    " hours this WEEK!" );
        }

    }


}