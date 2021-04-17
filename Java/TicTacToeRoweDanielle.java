// Name: Danielle Rowe 
// Date: March 1st, 2021
// Class/Section: CSC 131-802
// Project: TicTacToe

import java.util.Scanner;
import java.util.Random;

public class TicTacToeRoweDanielle{
	public static void main(String[]args) {
		//create an instance of the game 
		TicTacToe newBoard = new TicTacToe();
		
		//create scanner for user input 
		Scanner input = new Scanner(System.in);
		
		//create a new Random for computer input 
		Random rand = new Random();
		
		//variable to see whose turn it is 
		String playersTurn = "X";
		
		//print example board
		System.out.println("|                     |                     |                     |");
		System.out.println("|  " + "Row: 0, Column: 0" + "  |  " + "Row: 0, Column: 1" + "  |  " + "Row: 0, Column: 2" + "  |");
		System.out.println("|- - - - - - - - - - -|- - - - - - - - - - -|- - - - - - - - - - -|");
		System.out.println("|  " + "Row: 1, Column: 0" + "  |  " + "Row: 1, Column: 1" + "  |  " + "Row: 1, Column: 2" + "  |");
		System.out.println("|- - - - - - - - - - -|- - - - - - - - - - -|- - - - - - - - - - -|");
		System.out.println("|  " + "Row: 2, Column: 0" + "  |  " + "Row: 2, Column: 1" + "  |  " + "Row: 2, Column: 2" + "  |");
		System.out.println("|                     |                     |                     |");
		
		
		//ask if the user wants to play against a human or computer? 
		System.out.println("Would you like to play against a human or computer? (type human or computer- case sensitive): ");
		String against = input.nextLine();
		//make sure that they choose a correct answer 
		while (!((against.equals("human")||(against.equals("computer"))))) {
			System.out.println("Please enter either human or computer: ");
			against = input.nextLine();
		}
		
		//default value 
		int firstp =0; 
		//this checks to see which player goes first the computer or person 
		if (against.equals("computer")) {
			System.out.println("Print 0 if you want to be X (X goes first), or 1 if you want to be O: ");
			firstp = input.nextInt();
			//make sure the input is either 1 or 0 
			while(firstp != 0 && firstp != 1) {
				System.out.println("Please enter either 0 or 1: ");
				firstp = input.nextInt();
			}
		}
		
		// a while statement that doesn't finish until a player has won the game
		while(newBoard.result() == "Not done") {
		
			//have the computer choose a random spot 
			//this is if the computer goes first they are X 
			if (firstp == 1) {
				if (against.equals("computer")) {
					//choose a random location for the computer
					int comprow = rand.nextInt(3);
					int compcolumn = rand.nextInt(3); 
					//check to see if the spot has already been taken, if it has choose a new one
					while (newBoard.checkSpot(comprow, compcolumn) == "full") {
						comprow = rand.nextInt(3);
						compcolumn = rand.nextInt(3); 
					}
					//set the values equal to the location on the board 
					newBoard.setValues("X", comprow, compcolumn);
				}
				//set the other player to player O 
				playersTurn = "O";
				
				//these print statements are to make sure that the computers turn is easy to read
				System.out.println();
				System.out.println("------------------------------------");
				System.out.println("Here is the computers turn: ");
				System.out.println();
				
				//print the board 
				newBoard.printBoard();
				
				//print statements to clean up the looks of the code 
				System.out.println();
				System.out.println("------------------------------------");
				System.out.println();
				
				//check to see if there's a winner 
				newBoard.result(); 
			}
			
			//this is where we do the user input 
			//get input from the user for where they want to put their pieces
			System.out.println("Enter a row (0,1,2) and a column (0,1,2) player " + playersTurn + " for where you wish to go below");
			System.out.println("Row: ");
			int row = input.nextInt();
			

			//if they did not enter a valid number ask them again
			while (row != 0 && row != 1 && row != 2) {
				System.out.print("Please enter a row number between 0-2");
				row = input.nextInt();
			}
			//user enters column 
			System.out.println("Column: ");
			int column = input.nextInt();
			
			
			//if they did not enter a valid number ask them again
			while (column != 0 && column != 1 && column != 2) {
				System.out.print("Please enter a column number between 0-2");
				column = input.nextInt();

			}
			
			//check to make sure the spot has not been taken yet 
			//if the spot is taken ask for new input 
			while (newBoard.checkSpot(row, column) == "full"){
				System.out.println("This spot has already been filled, please choose another!");
				//to choose a new row 
				System.out.println("Row: ");
				row = input.nextInt();
				
				//if they did not enter a valid number ask them again
				while (row != 0 && row != 1 && row != 2) {
					System.out.print("Please enter a row number between 0-2");
					row = input.nextInt();
				}
				//choose a new column
				System.out.println("Column: ");
				column = input.nextInt();
				
				//if they did not enter a valid number ask them again
				while (column != 0 && column != 1 && column != 2) {
					System.out.print("Please enter a column number between 0-2");
					column = input.nextInt();
				}
				
			}
			
			//set the values equal to the location on the board 
			newBoard.setValues(playersTurn, row, column);
			
			//print the board 
			newBoard.printBoard();
			
			//check to see if there's a winner 
			newBoard.result(); 
			
			
			//switch the player at the end of the turn if you are playing against another person 
			if (against.equals("human")) {
				if (playersTurn.equals("X")) {
					playersTurn = "O"; 
				}
				else {
					playersTurn = "X";
				}
			}
			
			//have the computer choose a random spot 
			//check to see if the computer is player X or O 
			if (firstp == 0) {
				if (against.equals("computer")) {
					//the computer chooses a random location 
					int comprow = rand.nextInt(3);
					int compcolumn = rand.nextInt(3); 
					//check to see if the spot has already been taken, if it has choose a new one
					while (newBoard.checkSpot(comprow, compcolumn) == "full") {
						comprow = rand.nextInt(3);
						compcolumn = rand.nextInt(3); 
					}
					//set the values equal to the location on the board 
					newBoard.setValues("O", comprow, compcolumn);
				}
				//these print statements are to make sure that the computers turn is easy to read
				System.out.println();
				System.out.println("------------------------------------");
				System.out.println("Here is the computers turn: ");
				System.out.println();
				
				//print the board 
				newBoard.printBoard();
				
				//here is the clean up how the code looks
				System.out.println();
				System.out.println("------------------------------------");
				System.out.println();
				
				//check to see if there's a winner 
				newBoard.result(); 
			}
				

		}
		//print the winner
		if (newBoard.result() == "X" || newBoard.result() == "O") {
			System.out.print(newBoard.result() + " is the Winner!");
		}
		else {
			System.out.print(newBoard.result());
		}

	}
}