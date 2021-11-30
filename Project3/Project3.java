


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * This program reads input from a given file and reads the values
 * into a 2D array and then using a module called ArrayMath
 * different matrix operations will be performed on the given arrays
 * and then those results will be sent to an outputl file.
 *
 * @author Parker Johnson
 * @version 11/30/2021
 */




public class Project3 {

    /**
     * This is the Driver method of the program that calls the methods
     * and runs the program
     *
     * @param theArgs
     */

    public static void main(String[] theArgs) {
        Scanner input = null;
        PrintStream output = null;

        try {
            input = new Scanner(new File("in3a.txt"));
            output = new PrintStream(new File("out.txt"));
        }  catch (FileNotFoundException e) {
            System.out.println("Can't find file!" + e);
            System.exit(0);
        }

        int[][] A = getArray(input);
        int[][] B = getArray(input);
        int[][] C = getArray(input);
        int[][] D = getArray(input);

        writeArray(A, "Array A:" , output);
        writeArray(B, "Array B:" , output);
        writeArray(C, "Array C:" , output);
        writeArray(D, "Array D:" , output);

        int[][] sum = ArrayMath.addArrays(A, B);
        int[][] diff = ArrayMath.subArrays(A, B);
        int[][] prod = ArrayMath.multiplyArrays(C, D);
        writeArray(sum, "A + B = ", output);
        writeArray(diff, "A - B = ", output);
        writeArray(prod, "C x D = ", output);
        
        

        input.close();
        output.close();

    }

    /**
     * This method reads an input file and creates 
     * an array using the integers in the file
     *
     * @params theIn - a scanner that reads a file
     * @return returns a 2d array of ints 
     */
    
    public static int[][] getArray(Scanner theIn) {

        int[][] a = new int[theIn.nextInt()][theIn.nextInt()];

        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                a[row][col] = theIn.nextInt();
            }
        }
        return a;
    }
    
    /**
     * This method format prints an array out sends it to an output file.
     *
     * @params theA is a 2d array 
     * @params theHead can be thought of as the title of the printed array
     * @params theOut printstream that outputs the information in an output file
     * 
     */

    public static void writeArray(int[][] theA, String theHead, 
                                 PrintStream theOut) {

        theOut.println(theHead);
        for (int row = 0; row < theA.length; row++) {
            for (int col = 0; col < theA[row].length; col++) {
                theOut.printf("%7d" , theA[row][col]) ;
            }
            theOut.println();
        }
        theOut.println();
    }
    
    

}

