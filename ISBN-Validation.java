

import java.util.Arrays;
import java.util.Scanner;
import static lab9.stringvalidation.Validation2.emailCheck;

/*
Prompts for input, then verifies whether the input is a legitimate ISBN number
according to basic requirements 
*/
public class Validation {

    public static void main(String[] args) {
        boolean tryAgain = true;
        
        while (tryAgain == true){           

            String input;    
            Scanner isbnIN = new Scanner(System.in);
            System.out.println("Enter your ISBN or Student Email to check its validity.");
            input = isbnIN.nextLine();

            boolean valid = validate(input);

            System.out.println("This ISBN number is: " + valid);
              
            System.out.println("***************************");
            String again;        
            
            Scanner playagain = new Scanner(System.in);         //taking ISBN input for later processing
            System.out.println("Do you want to play again?");
            again = playagain.nextLine();
            if (again.equalsIgnoreCase("no")){
                tryAgain = false;
            }
        }
    }

    public static boolean validate(String input) {
        System.out.println("***************************");
        System.out.println("Your number: " + input)
        
        boolean valid = false;
        String fourLetters = "ISBN";
        
        if(input.length() == 22){         
            if (  (input.startsWith(fourLetters) )  ){          //test for ISBN start 
                    
                String [] splitINtwo = input.split(" ");        // create array of 2, first element ISBN, second element the rest

                String numbersDash = splitINtwo[1];             //Create numberDash String with second part of input
       
                String[] isbnSplit = numbersDash.split("-");    //Take array and split where '-', to create new array
    
                String strTest = String.join("" , isbnSplit);   // join Arrays to create one continuous string
                
                
                boolean allNumbers; 
                int [] intArray = new int[13]; 
                
                try{                                             //try parse strTest string in array of single digits integers
                    for (int i = 0 ; i < intArray.length ; i++){
                        intArray[i] = Integer.parseInt(strTest.substring(i, i+1));                     
                    }
                    allNumbers = true;
                }
                catch(NumberFormatException e){     // exception for parseInt not working                       // catch if all elements of strTest string was not an integer
                    allNumbers = false;
                }
  
                    if(allNumbers == true){                           
                        if (isbnSplit.length == 5){                     //test for correct length of each number parts
                            if (isbnSplit[0].length() == 3){
                                if (isbnSplit[1].length() == 1){
                                    if (isbnSplit[2].length() == 3){
                                        if (isbnSplit[3].length() == 5){
                                            if (isbnSplit[4].length() == 1){
                                                valid = true;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                
                
            }
        }

        return valid;
    }

}
