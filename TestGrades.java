
 
 /**
  * This is an instatiable class containing constuctors and 
  * assisting methods
  *
  * @author Parker Johnson
  * @version 12/7/2021
  */


public class TestGrades {
   /** the first name of the student */
   private String myFirstName;
   /** the last name of the student */
   private String myLastName;
   /** an array of test scores */
   private int myScores[];
   /** a counter for the number of students */
   private static int myCount = 0;
  
   /**
    * Creates a new instance of TestGrades
    *
    */
   public TestGrades(String theFirst, String theLast, int theScores[]) {
       myCount++;
       myFirstName = theFirst;
       myLastName = theLast;
       myScores = new int[theScores.length];
       for(int i = 0; i < theScores.length; i++)
           myScores[i] = theScores[i];
   }
  
   /**
    * gets the number of students in the class
    * @return myCount - the number of students in the class
    */
   public int getStudentCount() {
       return myCount;
   }
  
   /**
    * gets the first name of the student
    * @return myFirstName - the last name of the student
    */
   public String getFirstName() {
       return myFirstName;
   }
  
   /**
    * gets the last name of the student
    * @return myLastName - the last name of the student
    */
   public String getLastName() {
       return myLastName;
   }
  
   /**
    * a setter method that sets the index of myScores to theScore
    *
    */
   public void setScore(int theIndex, int theScore) {
       
       if(theIndex > 0 && theIndex < 5 && theScore >= 0&& theScore <=100) {
           
           myScores[theIndex-1] = theScore;
       }
   }
  
   /**
    * this method gets the average of the 3 highest scores
    *
    * @return total/3 - the avergae of the 3 highest scores
    *
    *
    */
   public int getTestsAverage() {
       int total;
       int min;
      
       total = myScores[0];
       min = myScores[0];
       
       for(int i = 1 ;i < myScores.length; i++) {
           total += myScores[i];
           if(myScores[i] < min)
               min = myScores[i];
       }
      
       total -= min; 
      
       
       return total/3;
   }
  
   /**
    * This method converts the contents of a memory location
    * to a String
    *
    * @return output - a string containing the pertinent info
    *
    */
   public String toString() {
       String output= myFirstName + " " + myLastName + " [";
       for(int i = 0; i < myScores.length-1; i++)
           output += myScores[i] + ", ";
       output += myScores[myScores.length-1] + "] " + 
               "Average = " + getTestsAverage();
      
       return output;
   }
   

}