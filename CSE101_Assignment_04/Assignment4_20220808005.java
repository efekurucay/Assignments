import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *-----------------------------------------------------
* Akdeniz University CSE101T Assignments
* Name: Yahya Efe Kurucay
* Date: 26.12.2023
* Description: Assignment4
* Website: https://efekurucay.com
*-----------------------------------------------------
*Requirements: Write a program that will read files for both the category information and 
student grades for a list of students. It will then write two files to show the results of 
calculating the student grades.

Design: 
When your main method is called, your program should display nothing. All interaction 
with the program should be done through reading and writing files. 

The expected file formats are as follows: 
    1. Course Details 
            a. Category name, quantity, weight separated by spaces 
            b. Each category on a new line 
    2. Student Scores 
            a. Student name followed by all scores in order separated by spaces 
            b. Scores are in order based on category and quantity 
            c. Each student on a new line 
    3. Student Grades 
            a. Student name, score, grade letter, GPA points, status separated by spaces 
            b. Each student on a new line 
    4. Error log 
            a. Each error on a new line beginning with “ERROR: “ 

 */
public class Assignment4_20220808005 {
public static void main(String[] args) throws  FileNotFoundException{
/*Description

4. main(args) - You will have a main method in this program
    a. We will pass the base filename(s) as command line arguments
        i. If one argument is passed, it will
            1. Read the category information from a file called {base 
            filename} + “_CourseDetails.txt”
            2. Read the student information from a file called {base 
            filename} + “_StudentScores.txt”
            3. Write the student grades to a file called {base filename} + 
            “_StudentGrades.txt”
            4. Write any errors to a file called {base filename} + 
            “_Errors.log”
        ii. If four arguments are passed, it will
            1. Read the category information from a file called {first 
            argument} + “.txt”
            2. Read the student information from a file called {second 
            argument} + “.txt”
            3. Write student grades to a file named {third argument} + 
            “.txt”
            4. Write any errors to a file called {fourth argument} + “.log”
        iii. If any number of arguments other than one or four are passed, it 
        will display an error message and exit
    b. Returns none
 */
test3("CSE101_StudentScores.txt");
}   

public static int countCategory(String filename) throws FileNotFoundException{ /*DONE*/
/*Description
1. countCategory(filename)
    a. A new method to determine how many categories are in the category list
    b. Takes a String representing the entire filename as a parameter
    c. Returns an integer for the number of lines (categories) in the file
 */  
    File file = new File(filename);
    int count = 0;
    Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if (!line.trim().isEmpty()) {
                count++;
            }
        }
        
    //try catch statement can be added for the case of nonexistence of the file.
    scanner.close();


     return count;
}

public static void getCategory(String[]category,int []quantity,int []weight,String filename) throws FileNotFoundException{ /*DONE */

/*Description
2. getCategory(category, quantity, weight, filename)
    a. New method to read the file and fill arrays with the category information
    b. The file will have the format of category name, quantity, weight separated 
    by spaces
        i. Note: the category name will NOT have spaces in it
    c. It will take four parameters
        i. String array for names of each category
        ii. Integer array for quantity of each category
        iii. Integer array for weight of each category
        iv. String for the filename
    d. Returns None

 */

    
      File file = new File(filename);
      Scanner scanner = new Scanner(file);

      int index = 0; 

      while (scanner.hasNext()) {
          String line = scanner.nextLine();
          // Separate the information in the line according to spaces
          String[] parts = line.split(" ");

        // Place into arrays related to reserved information
          category[index]  = parts[0];
          quantity[index]  = Integer.parseInt(parts[1]);
          weight[index]= Integer.parseInt(parts[2]);
          index++;
      }
      scanner.close();
}

public static void writeGrades(String []student, double[]grade, String studentGrades,String errorLog) throws FileNotFoundException{

/*Description
3. writeGrades(student, grade, studentGrades, errorLog)
    a. A new method to write an output file with student grade information
    b. The file will have the format of student name, grade value,
    grade letter,GPA points, and status separated by spaces
    c. It will take three (3) parameters
        i. String array for names of the students
        ii. Decimal array for grade of each student
        iii. String for the student grades filename
        iv. String for the error log filename
            1. You will need to determine a way using the arrays passed 
            to represent students with error conditions
    d. Returns None
 */


//Read and place students name from studentGrades text file to student array.

      File file = new File(studentGrades);
      Scanner scanner = new Scanner(file);
      int index = 0; 
      int countGrade=0;
      int countGrade2=0;

      while (scanner.hasNext()) {
          String line = scanner.nextLine();
          // Separate the information in the line according to spaces
          String[] parts = line.split(" ");



        // Place into arrays related to reserved information

          student[index]  = parts[0];
      

            for(int i=1; i<=2;i++){
              
              grade[countGrade2 + i-1]  = Double.parseDouble(parts[i]);

              countGrade++;
              
             
            }
        
            countGrade2+=countGrade;

    
          index++;

      }
      
      for(int i=0;i<student.length;i++){

          System.out.print("Grades of student "+ student[i] + ": ");
          for(int j=0; j<grade.length;j++){
              System.out.print(grade[j]+" ");

          }
          System.out.println("");
      }
    


      scanner.close();









//Read and place students grades from studentGrades text file to grade array. (then change the array according to quantities).








        // WRITING
        // String filename="a.txt";
        // File file = new File(filename);
        // PrintWriter write = new PrintWriter(file);
        // for(int i = 0; i < student.length; i++){
        //     write.println(student[i]+" " +  student[i]+" " + grade[i]);
        // }

        // write.close();


}


  



//Method tester for countCategory, getCategory, writeGrades
public static void test1(String filename) throws FileNotFoundException{System.out.println(countCategory(filename));}

public static void test2(String filename) throws FileNotFoundException{
      // Test için kullanılacak dizileri oluşturun
   String[] category= new String[10];
   int[] quantity = new int[10];
   int[] weight = new int[10];

   // Dosyadan bilgileri okuyun
   getCategory(category, quantity, weight, filename);

   // Okunan bilgileri ekrana yazdırın (test amaçlı)
   System.out.println(category[1]);
}

public static void test3(String filename) throws FileNotFoundException{


String []student = new String [4];
double []grade = new double [36];
String studentsGrade = filename;


writeGrades(student, grade, studentsGrade, studentsGrade);

 

}
























//ASSIGNMENT 3 METHODS

public static void formatCategoryName(String []name){

    for(int i=0; i<name.length ; i++){
        name[i]=formatCategoryName(name[i]);
    }
}

public static String formatCategoryName(String name) {
        // a. Format name with the first letter uppercase; 
        // all other letters lowercase
        // b. Takes one String type parameter
        //c. Returns a String
  name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
          return name;
        }
      
public static boolean isQuantityValid(int[] quantity){

  boolean control= true;

          for(int i=0; i<quantity.length; i++){

            if(quantity[i] <= 0){return false;}
            else{control= true;}
          }


          return control;
        }

public static boolean isWeightValid(int []weight){

    int totalWeight=0;
          for(int i=0; i< weight.length ; i++){
            totalWeight+=weight[i];
          }

          return totalWeight == 100 ;
        }
  
public static String gradeLetter(double grade){
  /*a. A method to determine the grade letter based on the grade calculated
  b. Takes one decimal parameter for the grade earned
  c. Returns a String for the grade letter(refer to assignment 1 for details)*/
       
          String gradeString="";
          if(grade >= 0 && grade <=34){
            gradeString="FF";
            }
            else if (grade >34 && grade <=45){
              gradeString="FD";
              }
            else if (grade >45 && grade <=52){
              gradeString="DD";
              }
            else if (grade >52&& grade <=59){
             gradeString="DC";
              }
            else if (grade >59 && grade <=66){
               gradeString="CC";
              }
            else if (grade >66&& grade <=73){
               gradeString="CB";
              }
            else if (grade >73 && grade <=80){
              gradeString="BB";
              }
             else if (grade >80 && grade <=87){
              gradeString="BA";
              }
             else if (grade >87&& grade <=100){
             gradeString="AA";
              }
              else {
              }
          return gradeString ;
          
      }
  
public static double gpaPoints(double grade) {
        double gpa_points;
        if(grade<=34) {gpa_points=0.0;}
        else if(grade<=45) {gpa_points=0.5;}
        else if(grade<=52) {gpa_points=1.0;}
        else if(grade<=59) {gpa_points=1.5;}
        else if(grade<=66) {gpa_points=2.0;}
        else if(grade<=73) {gpa_points=2.5;}
        else if(grade<=80) {gpa_points=3.0;}
        else if(grade<=87) {gpa_points=3.5;}
        else {gpa_points=4.0;}
        return gpa_points;
      
  
  /*a. A method to determine the gpaPoints based on the grade calculated
  b. Takes one decimal parameter for the grade earned
  c. Returns a decimal for the GPA points(refer to assignment 1 for details)*/
      }
  
public static String status(double grade){
   /*a. A method to determine if the student passed based on the grade
  b. Takes one decimal parameter for the grade earned
  c.Returns a String containing the status of “passed”,“conditionally passed”,
  or “failed” (refer to assignment 1 for details) */
            String statusString="";
          
  if(grade >= 0 && grade <=45){statusString="Failed";}
  else if (grade >45 && grade <=59){statusString="Conditionally Passed";}
  else {statusString="Passed";}
  return statusString; }
  
public static int menu(Scanner inp,String[]list){
        for(int i =0 ; i<list.length; i++){
         System.out.println(i +" - "+ formatCategoryName(list[i]));
        }
        System.out.println("Q - to Quit");
        String input = inp.nextLine().toUpperCase();
        
        if(input.equalsIgnoreCase("Q")){
System.out.println("Thank you for using our system. Have a nice day.");
            return -1;}
        else{
            int inputint = Integer.parseInt(input);
            if(inputint >=0 && inputint < list.length){
            return inputint; }
            else{
              System.out.println("Invalid choice.");
              return menu(inp, list);}
        }
        


    }

public static boolean gradeControl(double grade){return grade>=0 && grade<=100;}

public static void calculateGrade(String[]category, int[] quantity,int[] weight){

if (category.length == quantity.length && quantity.length == weight.length){

      if (isWeightValid(weight)==false ){System.out.println("ERROR: Invalid weight entered");}
      else if (isQuantityValid(quantity)==false){System.out.println("ERROR: Invalid quantity entered");}

      else{ System.out.println("Welcome to our university grade system.");
            int choice = 0; int cg=0;
            int uzunluk=0; // grades lenght
           for(int i=0; i< quantity.length;i++){uzunluk += quantity[i];}
                        double [] grade = new double[uzunluk]; 
                        int whichcat =3; 
                        
            while(choice!=-1 && cg !=-1 ) {System.out.println("Please enter a choice below:");
                    Scanner scan = new Scanner(System.in);
                      String[] liste={"Enter all grades",
                    "Display grade information","Change a single grade"};
                    choice = menu(scan,liste);  
                    //0 - Enter all grades
                    if(choice==0){
                                double gradetest=0;
                                int m = 0; // counter 
                             for(int i=0; i< category.length;i++){
                                        
                                          for(int j = 1 ;  j<= quantity[i];j++){

                                            do{System.out.print("Please enter the grade for "+formatCategoryName(category[i])+" "+j+" >>");
                                            gradetest =scan.nextInt(); 

                                            if(gradeControl(gradetest)==true){ grade[m++]= gradetest;}
                                            else{System.out.println("The grade must be between 0 and 100. Enter again.");}
                                            
                                           
                                          
                                          }
                                            
                                            while(gradeControl(gradetest)==false);
                                              


                                            }}System.out.print("\n");}  

                    //1 - Display grade information
                    else if(choice==1){
                    System.out.println("Category Information:");
                      double sum=0; double average=0;int counter=0;double weighttimesum=0;
                      double overallgrade = 0;
                      
                      for (int a =0; a<category.length;a++) {
                        
                        if(a-1<0){counter=0;}
                        else{counter += quantity[a-1];}
                            
                        for(int i=0;i<quantity[a];i++){

                          sum += grade[counter+i];
                
                        }
                        average= sum/quantity[a]; 
                          System.out.println(formatCategoryName(category[a])+ " - "+average);
                        weighttimesum+= average*weight[a];
                        sum=0; average=0;
                      }

                      overallgrade= weighttimesum/100;
                System.out.print("\n");
                System.out.println("Overall Grade - "+overallgrade);
                System.out.println("Grade Letter - "+gradeLetter(overallgrade));
                System.out.println("GPA Points - "+gpaPoints(overallgrade));   
                System.out.println("Status - "+status(overallgrade)+"\n");   
}//elseifchoice==1

                    //2 - Change a single grade
                    else if(choice==2){
                      
                      System.out.println("Please Enter the category");

                          cg = menu(scan, category);
                          if(cg == -1){return;}
                          int eqgrade= 0;
                          for(int i=0;i<=cg; i++){

                            eqgrade+=quantity[i];

                          }
                          eqgrade --;
                          double newval= 0;
                          //FOR CATEGORIES THAT HAVE 1 QUANTITIES
                          if(quantity[cg]==1){

                            System.out.println("The current grade for "+formatCategoryName(category[cg])+" is "+ grade[eqgrade]);
                            System.out.print("Please enter the new value >> ");
                              do{
                              newval= scan.nextInt();
                            if(gradeControl(newval)==false){System.out.println("The grade must be between 0 and 100. Enter again.");}
                            else{grade[eqgrade]= newval;}

                             }while(gradeControl(newval)==false);
                          
                          
                          
                          }

                          //FOR CATEGORIES THAT HAVE 2 OR MORE QUANTITIES
                          else{
                            System.out.print("Please enter which "+formatCategoryName(category[cg])+" you would like to change (1 - "+quantity[cg]+") >> ");
                             whichcat= scan.nextInt(); 
                             if(whichcat>quantity[cg]|| whichcat<=0){System.out.println("Invalid choice."); }
                             else{
                              System.out.println("The current grade for "+formatCategoryName(category[cg])+" "+whichcat+" is "+grade[eqgrade-1]);
                             System.out.print("Please enter the new grade value >> ");
                             do{
                              newval= scan.nextInt();
                            if(gradeControl(newval)==false){System.out.println("The grade must be between 0 and 100. Enter again.");}
                            else{grade[eqgrade-1]= newval;}

                             }while(gradeControl(newval)==false);}
                             
                             
                            
                          }

                          
                        
                    
                    }

                    //Q - to Quit
                     else if (choice == -1 || cg == -1) {return; }
                    else{}}

                   
                      
  
}











}

else{System.out.println("ERROR: Array lengths are not all the same");}}





}//CLASS