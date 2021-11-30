/*
Course:         TCSS 142 - Introduction to object oriented programming
File Name:      Project.java
Assignment:     1
Due Date:       10/19/2021
Instructor:     Mr. Schuessler
 */

/**
 *  This program draws a picture of the space needle at different
 *  scales using ASCII characters
 *
 * @author Parker Johnson ptj7@uw.edu
 * @version 2021/10/19
 *
 */



public class Project1 {
    // constants (static final fields)
    /*This variable changes the size of the space needle */
    public static final int SIZE = 4;


    /**
     * Driver method for drawing the space needle
     *
     * @param theArgs
     */
    public static void main(String[] theArgs) {

        flagPole();
        roofAndBase();
        lowerHalf();
        flagPole();
        body();
        roofAndBase();

    }

    /**
     * This method will build the base and the roof of the space needele
     *
     */



    public static void roofAndBase() {
        for(int i = 1; i <= SIZE ; i++) { // building the base and roof
            for(int spaces = 1; spaces <= 3*SIZE - 3*i; spaces++) {
               System.out.print(" ");
            }

            for(int ltEdges = 1; ltEdges <= 1; ltEdges++) {
                //this loop builds the jagged edges on the right
                System.out.print("__/");
            }
            for(int colons = 1; colons <= i - 1; colons++) {
                // builds the body of the roof to the right of the roof/base
                System.out.print(":::");
            }

            System.out.print("||");

            for( int colons = 1; colons <= i - 1; colons++){
                // builds the body of the roof to the left of the roof/base
                System.out.print(":::");
            }
            for (int rtEdges = 1; rtEdges <= 1; rtEdges++) {
                // builds the jagged edges on the right of the roof/base
                System.out.print("\\__");
            }
            System.out.println();

         }
        System.out.print("|");
            for(int border = 1; border <=6*SIZE; border++) {
                // builds the bottom of the roof/base
                System.out.print("\"");
            }
        System.out.print("|");
        System.out.println();
    }


    /**
     * This method draws the tip/flag pole at the top of the needle
     *
     */
    public static void flagPole() {
        for (int tip = 1; tip <= SIZE; tip++) {
        // this loops prints out the spaces between center pole
            for (int spaces = 1; spaces <= 3 * SIZE; spaces++) {
                System.out.print(" ");
            }
            System.out.println("||");
        }
    }
    
    /** 
     * this method builds the lower half of the head of the building
     *
     */
    
    public static void lowerHalf() {

        for (int i = 1; i <= SIZE; i++) {
        // prints out the spaces 
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  ");
            }
            System.out.print("\\_");
            for (int seats = 3 * SIZE - i; seats >= i; seats--) {
            // prints out the body of the lower half of the top of the needle
                System.out.print("/\\");
            }
            System.out.println("_/");
        }
    }


    /**
     *
     * This method builds the body of the needle,
     * this gives the building its heighth
     *
     */
    public static void body() {
        for(int i = 1; i <= SIZE*4; i++) {
            for ( int spaces = 1; spaces <= 3*SIZE - 3; spaces++ ) {
            // prints the spaces that align the body
                System.out.print(" ");
            }
           System.out.println("|%%||%%|");
        }



    }


}

