// Name: Danielle Rowe 
// Date: March 1st, 2021
// Class/Section: CSC 131-802
// Project: TicTacToe

//ask about why enum and array arn't working 
//ask about syntax for line 63 
//ask if a double while loop to check for open spot is the right way

//need a new page -- only the enum and array over there 

import java.util.Scanner;



public class TicTacToe{
			
			//create the three options of enum 
			private enum options {X,O,EMPTY};
			//create the array
			private options[][] board = new  options[3][3];
		
			

		//the constructor that initializes the board to empty 
		public TicTacToe() {
			//loop through the board to intialize each spot as empty 
			for (int x = 0; x <3; x++) {
				for (int y = 0; y<3; y++) {
					board[x][y] = options.EMPTY;
				}
			}
		}
		//create the board to play on with each array spot
		public void printBoard() {
			for(options[] row : board) {
				for(options element : row) {
					System.out.print("\t" + element);
				}
				System.out.println();
			}
		}
		
		//checks all cases of tic tac toe to see if there is a winner 
		public String result() {
			//checks ways to win 
			//this checks all horizontal options to win 
			for (int m =0; m <3; m++) {
					if(board[m][0] == board[m][1] && board[m][0] == board[m][2] && board[m][1] == board[m][2]) {
						//checks to see which player won
						if(board[m][0] == options.X) {
							return "X";
						}
						if(board[m][0] == options.O) {
							return "O";
						}
						
					}
			}
			//this checks all vertical ways to win 
			for (int n =0; n <3; n++) {
				if(board[0][n] == board[1][n] && board[0][n] == board[2][n] && board[1][n] == board[2][n]) {
					//checks to see which player won
					if(board[0][n] == options.X) {
						return "X";
					}
					if(board[0][n] == options.O) {
						return "O";
					}
				}
			}
			//this checks diagnols to see who won
			if((board[0][0] == board[1][1] & board[0][0] == board [2][2] && board [2][2] == board[1][1]) || board[0][2] == board[1][1] && board[0][2]== board[2][0] && board[1][1] == board[2][0]){
				//checks to see which player won
				if(board[1][1] == options.X) {
					return "X";
				}
				if(board[1][1] == options.O) {
					return "O";
				} 
			}
			//checks to see if all the spots are filled or if we should keep going
			for (int a = 0; a <3; a++) {
				for (int b = 0; b<3; b++) {
					if (board[a][b] == options.EMPTY) {
						return "Not done";
					}
				}
			}
			//if all the spots are filled and no one has won its a cats game 
			return "Cats game!";
			
		}
		
		//sets values depending on the user's input 
		public void setValues(String playersTurn, int row, int column) {
			//check which player it is to set the right piece 
			if (playersTurn == "X") {
				board[row][column] = options.X;
			}
			if (playersTurn == "O") {
				board[row][column] = options.O;
			}
		}
		
		//method to check if the spot has been used already
		public String checkSpot(int row, int column) {
			//make a while loop to make sure the spot has not already been taken
			if (board[row][column] != options.EMPTY) {
				//if it's full return full
				return "full";
				//check if their new input is valid 
				}
			return "empty";
		}
}
