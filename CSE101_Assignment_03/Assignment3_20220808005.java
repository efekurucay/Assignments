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

      if (isWeightValid(weight)==false ){System.out.println("ERROR: Invalid weight entered");}
      else if (isQuantityValid(quantity)==false){System.out.println("ERROR: Invalid quantity entered");}

      else{ System.out.println("Welcome to our university grade system.");
                  System.out.println("Please enter a choice below:");
                    Scanner scan = new Scanner(System.in);
                    String[] liste={"Enter all grades",
                    "Display grade information","Change a single grade"};
                    int choice = menu(scan, liste);
                    int uzunluk=0; // grades lenght
                              for(int i=0; i< quantity.length;i++){

                                uzunluk += quantity[i];
                              }
                                int [] grade = new int[uzunluk];
                    //0 - Enter all grades
                    if(choice==0){

                                

                                int m = 0; // counter
                             for(int i=0; i< category.length;i++){
                                        
                                          for(int j = 1 ;  j<= quantity[i];j++){
                                              System.out.print("Please enter the grade for "+formatCategoryName(category[i])+" "+j+" >>");
                                            grade[m++]=scan.nextInt(); 
                                            }
                                 

}      

}  
        

                    //1 - Display grade information
                    else if(choice==1){
                      
                      System.out.println("Category Information:");


                      // calculate average of category[0]:
                     // int sonterim =0;
                      //int ilkterim=0;
                      int sum=0;
                      int average=0;

                      for (String catString : category) {
                        System.out.print(catString+ " - ");
                        
                      }

                      for(int i = 0 ; i<quantity.length; i++){


                        for(int j=1; j<quantity[i];j++){

                            sum+=grade[j];
                            average= sum/quantity[i];
                            System.out.println(average);

                        }


                        //sonterim+= quantity[i] -1 ;
                         // ilkterim+= sonterim - quantity[i];

                      //  int sum = grade[0]+grade[1]........grade[quantity[0]-1]    ----- cat(i) 0   i=0 
                       // int sum = grade[quantity[0]]+ ........ + grade[quantity[0]+ quantity[1] -1]    ----- cat1  i=1 
                       // int sum = grade[quantity[0]+ quantity[1]]...........+ grade[quantity[0]+ quantity[1] + quantity[2] -1]   ----- cat2  i=2


                      }



                      
                      




                    }


                    //2 - Change a single grade
                    else if(choice==2){}


                    //Q - to Quit
                    else if(choice==-1){}



                    else{}
                    formatCategoryName(category);
                    int [] catitems;
                    int[] catweights;
                   // for (int a : grade) {System.out.println(a); }
                      
                   
  
}}


else{System.out.println("ERROR: Array lengths are not all the same");}






    }


public static void main(String[] args) {
    String[] category = {"quIz", "homeWork","MidTerM exAm", "fiNal exaM"};
    int[]quantity={2,3,2,2};
    int[]weight={10,20,30,40};
   calculateGrade(category, quantity, weight);

  
   
}


}