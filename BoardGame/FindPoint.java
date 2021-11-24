package BoardGame;
import java.util.*;
/**
 * 
 * @author Selena Zheng
 * This project is a game that hides an X in a 8 by 8 board. The user will have 3 tries 
 * to guess where to X is.
 *
 */
public class FindPoint {
	
	static Scanner scnr = new Scanner(System.in);
	static Random rand = new Random();
	static int xCoord = rand.nextInt(8)+1;
	static int yCoord = rand.nextInt(8)+1;

public static void gameStart() {

System.out.println("Welcome to the game\nInstructions: "+
		"You will have 3 tries to guess where the X is on the board\n"
		+ "You will be asked to enter coordinate points x and y. You have 3 chances.\n");
}

public static String gameBoard(){
    //Declare new array 8 x 8
    String theGame[][] = new String[8][8];

    //Print board with the answer marked but not shown
	
    for (int row = 8; row >= 1; row--){
    	
    	System.out.print(row);
    	
        for (int column = 1; column <= theGame.length; column++){
        	
        	if (row == yCoord && column == xCoord) {
        		System.out.print(" . ") ; //actually an X
        		
        	}
        	else {
        		System.out.print(" . ");    		
        	}
        }
        System.out.println("");
    }
   	
   	System.out.println("0 1  2  3  4  5  6  7  8");
   	
   	return theGame.toString();

   	 	
}
public static void hiddengameBoard(){
// Board with the actual answer marked
	
    String theGame[][] = new String[8][8];

	
    for (int row = 8; row >= 1; row--){
    	
    	System.out.print(row);
    	
        for (int column = 1; column <= theGame.length; column++){
        	
        	if (row == yCoord && column == xCoord) {
        		System.out.print(" X ") ; 
        		
        	}
        	else {
        		System.out.print(" . ");    		
        	}
        }
        System.out.println("");
    }
   	
   	System.out.println("0 1  2  3  4  5  6  7  8");  	

}

public static void playingGame() {
	
	int numChances = 3;
	
   	while (numChances > 0) {
   		
 // The user inputs  		
   		
   	System.out.print("What is the x-coordinate?: ");
	Integer yourX = scnr.nextInt();
	System.out.print("What is the y-coordinate?: ");
	Integer yourY = scnr.nextInt();	
	
   		if (yourX == xCoord && yourY == yCoord) {
   			hiddengameBoard();
   			System.out.println("Game over. You won!"); 
   			System.out.println("The X was at " + yourX + "," + yourY);
   			numChances = 0;
   		}

   	
   		else {
   			numChances = numChances - 1 ;
   			
   			if (numChances == 0 ) {
   				hiddengameBoard();
   				System.out.println("Game over. No more chances left");
   				System.out.println("The X was at " + xCoord + "," + yCoord);
   			}
   			else if (numChances == 1) {
   				System.out.println("Incorrect " + numChances + " try left");   				
   				System.out.println("Enter another choice");
   			}
   			else {
   				System.out.println("Incorrect " + numChances + " tries left");
   				System.out.println("Enter another choice");
   			}
   			
    	if (numChances != 0) {
    		if (yourX < xCoord) {
   			System.out.print("Move more to the right, ");
    		}
    		if (yourX > xCoord) {
   			System.out.print("Move more to the left, ");
    		}
    		if (yourX == xCoord) {
   			System.out.print("Your x coordinate is correct, ");
    		}   
   		
    		if (yourY < yCoord) {
   			System.out.println("Move up more");
    		}
    		if (yourY > yCoord) {
   			System.out.println("Move down more");
    		}
    		if (yourY== yCoord) {
   			System.out.println("Your y coordinate is correct");
    		}  		
    	}  			

   	}
   	} 
}

public static void playAgain() {
	// Looping the game
	
	boolean play = true;
	int userPlay;
	xCoord = rand.nextInt(8)+1;
	yCoord = rand.nextInt(8)+1;
	while (play == true) {
		System.out.print("Do you want to play again?\n1 - Yes  2 - No\n");
		userPlay = scnr.nextInt();
		if (userPlay == 1) {
			gameStart();
			gameBoard();
			playingGame();	
			play = true;
		}
		else if (userPlay == 2) {
			System.out.println("Goodbye");
			play = false;
		}
		else {
			System.out.println("Not a valid choice. Choose again.");
			play = true;
		}
	}
}


public static void main(String[] args) {	
	gameStart();
	gameBoard();
	playingGame();
	playAgain();
}
}

