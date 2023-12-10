import java.util.Scanner;

/**
 * Assignment3_20220808005
 */
public class Assignment3_20220808005 {
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

  //a. A method to verify the quantity is valid
  //b. Takes an array type parameter for the current quantity
  //c. Returns a boolean
  //i. True if quantity is positive
  //ii. False for all other values  
          for(int i=0; i<quantity.length; i++){

            if(quantity[i] < 0){return false;}
            else{return true;}
          }
          return true;
        }

public static boolean isWeightValid(int []weight){

    int totalWeight=0;
          for(int i=0; i< weight.length ; i++){
            totalWeight+=weight[i];
          }

          return totalWeight > 0;
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
  
public static double gpaPoints(double grade){
            if (grade >= 88 && grade <= 100){
              return 4.0;
            }        
            else if (grade >= 81 && grade < 88){
              return 3.5;
            }
            else if (grade >= 74 && grade < 81){
              return 3.0;
            }
            else if (grade >= 67 && grade < 74){
                return 2.5;
          }
          else if (grade >= 60 && grade < 67){
              return 2.0;
          }
          else if (grade >= 53 && grade < 60){
              return 1.5;
          }
          else if (grade >= 46 && grade < 53){
              return 1.0;
          }
          else if (grade >= 35 && grade < 46){
              return 0.5;
          }
          else {
              return 0.0;
              }
  
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
         System.out.println(i +" - "+ list[i]);
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

public static void calculateGrade(String[]category, int[] quantity,int[] weight){
    

if (category.length == quantity.length && quantity.length == weight.length){

if (isWeightValid(weight)==true){System.out.println("calisiyor");}


  System.out.println("Welcome to our university grade system.");
 System.out.println("Please enter a choice below:");
    Scanner scan = new Scanner(System.in);
    String[] liste={"Enter all grades",
    "Display grade information","Change a single grade"};
    int choice = menu(scan, liste);
    //0 - Enter all grades
    if(choice==0){

 // BURASI SADECE QUİZ İÇİN MESELA YANİ CATEGORY INDEX 0 İÇİN 
     /*   int [] grade0 = new int[quantity[0]] ; 
        for(int cat0 = 1; cat0<= quantity[0];cat0++){
            System.out.print("Please enter the grade for "+formatCategoryName(category[0])+" "+cat0+" >>");
            grade0[cat0-1]=scan.nextInt(); }
*/
for(int i=0; i< category.length;i++){

 int [] grade0 = new int[quantity[i]] ; 
        for(int cat = 1; cat<= quantity[i];cat++){
            System.out.print("Please enter the grade for "+formatCategoryName(category[i])+" "+cat+" >>");
            grade0[cat-1]=scan.nextInt(); }

}
}
        
    //1 - Display grade information
    else if(choice==1){}
    //2 - Change a single grade
    else if(choice==2){}
    //Q - to Quit
    else if(choice==-1){}
    formatCategoryName(category);
    int [] catitems;
    int[] catweights;

  
}



else{System.out.println("ERROR: Array lengths are not all the same");}






    }


public static void main(String[] args) {
    String[] category = {"quIz", "homeWork","MidTerM exAm", "fiNal exaM"};
    int[]quantity={4,3,1,1};
    int[]weight={10,20,30,423};
   calculateGrade(category, quantity, weight);
}


}