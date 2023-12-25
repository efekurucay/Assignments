
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

 */
public class Assignment4_20220808005 {

public static void main(String[] args) {
/*
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
    
}   

public static int[]countCategory(String filename){
/*Description
1. countCategory(filename)
    a. A new method to determine how many categories are in the category list
    b. Takes a String representing the entire filename as a parameter
    c. Returns an integer for the number of lines (categories) in the file
 */  
int[]a={};
return a;
}

public static void getCategory(String category,int quantity,int weight,String filename){

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

}//CLASS