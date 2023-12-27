import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    System.out.println(countCategory("CSE101_CourseDetails.txt"));

    
   getCategory(args, null, null, "CSE101_CourseDetails.txt");
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

public static void getCategory(String[]category,int []quantity,int []weight,String filename) throws FileNotFoundException{

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
Scanner reader = new Scanner(file);
// for(int i = 0; i < category.length; i++) {

//     category[i] = reader.next();
//     weight[i] = reader.nextInt();
//     quantity[i] = reader.nextInt();}

    String line;
    // Okuma işlemi satır satır yapılır
    while ((line = reader.nextLine()) != null) {
        // Separate the information in the line according to spaces
        String[] parts = line.split(" ");

        // Place into arrays related to reserved information

        if (parts.length == 3) { //category name, quantity, weight

            for(int i =0 ; i<category.length;i++){

           category[i] = parts[0];
            quantity[i] = Integer.parseInt(parts[1]);
            weight[i] = Integer.parseInt(parts[2]);

            }
        
            // Dizilere bilileri ekle
        } else {
            System.out.println("Wrong format line: " + line);
        }
   
    
}
reader.close();
}

public static void writeGrades(String []student, double[]grade, String studentGrades,String errorLog){

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
}

//5. Any other methods you feel helpful can be created.

}//CLASS//#endregion