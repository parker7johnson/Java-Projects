
 /**
  * This module contains the Array operations of 
  * add, subtract, multiply, and checks if the dimensions
  * of arrays are equal for the add and sub methods
  *
  * @author Parker Johnson 
  * @version 11/30/2021
  */



public class ArrayMath {

    /**
     * This method takes in two 2d arrays and retursn the sum of them
     *
     *
     * @param theA a given 2d array of integers
     * @param theB a given 2d array of integers
     * @return Returns a 2d array of integers that is the sum of
     * theA and theB
     */
    public static int[][] addArrays(int[][] theA, int[][] theB) {
        int [][] result = null;
        if(sameDimensions(theA, theB)) {
            result = new int[theA.length][theA[0].length];
            for (int row = 0; row < theA.length; row++) {
                for (int col = 0; col < theA[row].length; col++) {
                    result[row][col] = theA[row][col] + theB[row][col];
                }
            }
        }
        return result;
    }

    /**
     * This method takes in two 2d arrays returns the difference of them
     *
     *
     * @param theA a given 2d array of integers
     * @param theB a given 2d array of integers
     * @return Returns a 2d array of integers that is the difference of
     * theA and theB
     */

    public static int[][] subArrays(int[][] theA, int[][] theB) {
        int [][] result = null;
        if(sameDimensions(theA, theB)) {
            result = new int[theA.length][theA[0].length];
            for (int row = 0; row < theA.length; row++) {
                for (int col = 0; col < theA[row].length; col++) {
                    result[row][col] = theA[row][col] - theB[row][col];
                }
            }
        }
        return result;
    }
    
    /**
     * This method takes in two 2d arrays and returns the product of them
     *
     * @params theA a 2d array of ints
     * @params theB a 2d array of ints
     * @return a 2d array of ints that is the product of the theA and theB
     *
     */
    
    public static int[][] multiplyArrays(int[][] theA, int[][] theB) {
       
       int[][] result = null;
       if(theA[0].length == theB.length) {
          result = new int[theA.length][theB[0].length];
          for (int row = 0; row < theA.length; row++) {
            for(int col = 0; col < theB[0].length; col++) {
               int sum = 0;
               for(int prod = 0; prod < theB.length; prod++) {
                  sum += theA[row][prod] * theB[prod][col];
               }
               result[row][col] = sum;
            }
          }
       }
       return result;
    }

      
    /**
     * This method determines if 2 arrays have the same dimensions
     * which determines whether or not they can be added or subtracted
     *
     *
     * @params theA a 2d array of ints
     * @params theB a 2d array of ints
     * @return a boolean value that determines if the 2 arrays have the same
     * dimensions
     */
     

    public static boolean sameDimensions(int[][] theA, int[][] theB) {
        boolean result = theA != null && theB != null;
        if(result) {
            result = theA.length == theB.length;
            for (int row = 0; row < theA.length && result; row++) {
                result = theA[row].length == theB[row].length;
            }
        }
        return result;
    }
    
   
}

