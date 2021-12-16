
 
 /**
  * This program uses a built instaiable class to get the 
  * averege of test scores from a file;
  *
  * @author Parker Johnson
  * @version 12/7/2021
  */
  


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;




public class GradeDriver {
  
   /**
    * This is the driver method of the program
    *
    * @params theArgs
    */
   public static void main(String[] theArgs) {

      
       Scanner input = null;
       PrintStream output = null;
      
       try {
       input = new Scanner(new File("in4.txt")); 
       output = new PrintStream(new File("out4.txt")); 
      
       TestGrades grades[] = readFile(input); 
       writeFile(output, grades); 
      
       
       input.close();
       output.close();
      
       }
       catch (FileNotFoundException e) {
       System.out.println("Error opening file: " + e);
       }
   }
   
   
   
   /**
    * This method returns the students name and test scores
    *
    *
    *
    * @param theIn - a scanner object that reads from a file
    * @return grades - A TestGrades object that contains the students first
    * and last name, and their test scores
    * 
    */
   
   
   
   public static TestGrades[] readFile(Scanner theIn) {
       String firstName;
       String lastName;
       int scores[] = new int[4];
       int numStudents = 0;
       numStudents = theIn.nextInt();
       TestGrades grades[] = new TestGrades[numStudents];
       int count = 0;
       
       while((theIn.hasNext()) && (count < numStudents)) {
           firstName = theIn.next();
           lastName = theIn.next();
          
           for(int i = 0; i < scores.length; i++) {
               scores[i] = theIn.nextInt();
           }
          
          
           grades[count] = new TestGrades(firstName, lastName, scores);
           count++;
       }
      
       return grades;
   }
  
   /**
    * This method prints the TestGrades contents to an output file
    * 
    * @param theOut - a print stream object
    * @param theGrades - a test grade object
    *
    */
   public static void writeFile(PrintStream theOut, TestGrades theGrades[]) {
       int classAvg = 0;
       int minAvg = theGrades[0].getTestsAverage();
       int maxAvg = minAvg;
       theOut.print("Total number of students: " + 
                     theGrades[0].getStudentCount() + "\n\n");
       for(int i = 0; i < theGrades.length; i++) {
           
           theOut.print(theGrades[i].toString()+"\n");
           classAvg += theGrades[i].getTestsAverage();
          
           if(theGrades[i].getTestsAverage() > maxAvg)
               maxAvg = theGrades[i].getTestsAverage();
          
           if(theGrades[i].getTestsAverage() < minAvg)
               minAvg = theGrades[i].getTestsAverage();
       }
      
       classAvg = classAvg/theGrades[0].getStudentCount();
      
       theOut.print("\nHighest Student Average = "+ maxAvg);
       theOut.print("\nLowest Student Average = "+ minAvg);
       theOut.print("\nOverall class Average = "+ classAvg);
   }

   

}