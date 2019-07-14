package sending;
/*Package Name: Assessment
 * Author: G Murie
 * Date: 08/12/14
 */


import  java.io.*;


public class Assessment {
	
	private static BufferedReader bufRead;
    private static int choice;
    private static String userinputStr, fullName, surname, combined, engineSizeStr, milesStr;
    private static double rateValue, amount, rate, engineSize, miles;
	
	 public static void main(String[] args) {	
	
		 
	      //Declare the input so that inputs are placed in bufRead
	  InputStreamReader istream = new InputStreamReader(System.in) ;
	  bufRead = new BufferedReader(istream);
      
          // start of loop
	  do{
		  
		  // displaying menu
		   displayMenu();
		  
		   //will allow the user to input into the console 
		   try {
			userinputStr = bufRead.readLine();
			choice = Integer.parseInt(userinputStr);
			} catch (IOException e) {
			e.printStackTrace();
			}
		  
		   // if user input is less than zero it asks them to input a valid number
		   if (choice <0)
			   System.out.println("User Input Invalid Please Enter Another Number.");
		  
		   // if user input is less than zero it asks them to input a valid number
		   if (choice > 2)
			   System.out.println("User Input Invalid Please Enter Another Number.");
	      
		   // If user input is 1, it jumps to sub switchSting to execute users name.  
		   if (choice == 1){
			 combined = switchString();
		   }
			 //If user input is 2, it jumps to expenses where it calculates the expenses of the employee.
		   if (choice == 2){
			   expenses();
		   }
		 
	    
	  
		//end of loop and program is user inputs 02
		}while (choice !=0);
      	  System.out.println("Program Terminted By User.");  
	   
 }
	    // is a void as it does not need a return
	          public static void displayMenu(){ 
	    // Displaying menu layout
			  System.out.println("    Menu ");
			  System.out.println("    ==== ");
			  System.out.println("         ");
			  System.out.println("1. Re-Arrange Name");
			  System.out.println("         ");
			  System.out.println("2. Calculate Expenses");
			  System.out.println("         ");
			  System.out.println("0. Exit");
			  System.out.println("         ");
			  System.out.println("Enter either 1,2 or 0.");
	          }
		
	          
	          static String switchString(){
	       
	        
	      //Asking the user to input their name and placing it in fullName. 
		  System.out.println("Enter your full name:");
		  try {
				fullName = bufRead.readLine();
				} catch (IOException e) {
				e.printStackTrace();
				}
		
		
	   // This is spitting the name up where the space was was typed in by user input, by using "" as a 'target' area to split the name. 
		int space = fullName.indexOf(" ");
		
		
		// The car spits the name up into letters, the .charAt is basically asking what you are looking for. The 0 represents the first letter in the name.
		char initial = fullName.charAt(0);   
		 
	   //The surname is extracted from the fullName
	   surname = fullName.substring(space);
	    
	//Displays initial of first name followed by the surname.
        System.out.println(initial + "." + surname);
        
		
	//Returns so that fullName is passed onto the next step. 
				  return combined; 

		 }
	          
	 
	        
       public static void expenses(){
	// Asking user the engine size and placing it in engineSize
	        System.out.println("What is the size of the engine (CC)?");
	        try {
	 			engineSizeStr = bufRead.readLine();
	 			engineSize = Integer.parseInt(engineSizeStr);
	 			} catch (IOException e) {
	 			e.printStackTrace();
	 			}
            //Looping the miles input
	        do{
	        // if the input is less than 0 it prompts them to input the miles again
	        if (miles <0)
	        	//Asking how many miles done.
	        	System.out.println("The number of miles is invalid please try again.");
	        System.out.println("Input the miles traveled.");
	            try{
 				milesStr = bufRead.readLine();
 				miles = Double.parseDouble(milesStr);
 				} catch (IOException e){
 				e.printStackTrace();
                }
	        	
	        }while (miles < 0);
	       
	        	//Switches to the calculateRate part. 
	        	 calculateRate();
	        	
	     // Receiving claculateRate and placing it in rate
	        rate = calculateRate();
	        //calculating amount by multiplying rate by miles. 
	        amount = rate * miles;
	        //Displaying all the input data
	        System.out.println("Employee name " + fullName + " the size of the engine is " + engineSizeStr + "cc you traveled " +  milesStr + " miles at a rate of " + rate + "p per mile which is a total expense of \u00A3" + amount);
       }
			
       
            
			 public static double calculateRate(){
		
		// if the user was to put in an engine size less than 1100 then the rate value would equal too .64
        if (engineSize < 1100){
        	rateValue = .64;
        }
       // if the user was to put in an engine size less than 2000 then the rate value would equal too .72
        else if (engineSize < 2000){
        	rateValue = .72;
        }
      //If the user was to input greater than 200 the rate value would equal too .79
        else if (engineSize > 2000){
        	rateValue = .79;
        }
		//Returning rateValue to expenses()
		return rateValue;
	
			 }   
}