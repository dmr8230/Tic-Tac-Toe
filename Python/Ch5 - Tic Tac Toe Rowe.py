#==========================================================================
# PROGRAM PURPOSE:... Ch5 Tic Tac Toe Board
# AUTHOR:............ Rowe, Dani
# COURSE:............ CSC 131-006
# TERM:.............. Spring 2019
# COLLABORATION:..... Stack overload and caffine
# WORK TIME(h:mm):... 4:30
#==========================================================================


def startboard(): 
    print("Board Positions: ")
    print(" 0 1 2")
    print(" 3 4 5")
    print(" 6 7 8")



#  Setup Array of values for board
board = [["-", "-", "-"], ["-", "-","-"], ["-","-","-"]]
#  Setup Global Variables
Current_Player = 'X'
Attempts = 0



def printboard():
    print(board[0][0], "   ",board[0][1],"   ",board[0][2]+ "\n" +
          board[1][0], "   ", board[1][1], "   ", board[1][2] + "\n" +
          board[2][0], "   ", board[2][1], "   ", board[2][2] + "\n") 
    
#  Function to set the array passing named values.  Add values to Board

def getfromuser():
    userinput = int(input("Please enter 0-8 based on the board above "))
    while(userinput > 8 or userinput<0):
        userinput = int(input("You entered a number out of range, please enter 0-8 based on the board above "))
    addtoboard(userinput, Current_Player)
  
def addtoboard(userinput, Current_Player):
    if(userinput <= 2):
        vertical = 0
    if(userinput <= 5 and userinput > 2):
        vertical = 1
    if(userinput <= 8 and userinput > 5):
        vertical = 2
    if(userinput == 0 or userinput == 3 or userinput == 6):
        horizontal = 0
    if(userinput == 1 or userinput == 4 or userinput == 7):
        horizontal = 1
    if(userinput == 2 or userinput == 5 or userinput == 8):
        horizontal = 2
    if(board[vertical][horizontal] == '-'):
        board[vertical][horizontal] = Current_Player
    else:
        userinput = int(input("spot is already taken, please enter a new one "))
        addtoboard(userinput, Current_Player)


    
        
    
    
#  Function Print out the board based on the values of the array
#      Print should have 3 for loops 1 for each line in the board
#      Print line 1:  Array [[0][0], "   ",[0],[1]," ",[0],[2] /n
#      Print line 2:  Array [[0],[3],"   ",[0],[4], "  ",[0],[5] /n
#      Print line 3:  Array [[0],[6],"   ",[0],[7], "  ",[0],[8] /n


#  Function to decide if a winnter has happen each time an imput happens
#       - Variable for 9 times only and show message of "Too many attempts, increment + 1 each time
#       - Check 7 winner scenarios to detemine X or Y is winner
#          Increment # of attempts counter by 1
#          IF statement 1 Accross line 1: Postion 1,2,3 are all X's or O's  Set winner variable to X or X
#          IF statement 2 Across line 2: Postion 3,4,5 are all X's or O's  Set winner variable to X or X#
#          IF statement 3 Across line 3: Postion 5,6,9 are all X's or O's  Set winner variable to X or X
#          IF statement 4 Down LIne 1: Postion 1,2,3 are all X's or O's  Set winner variable to X or X
#          IF statement 5 Down line 2: Postion 3,4,5 are all X's or O's  Set winner variable to X or X#
#          IF statement 6 Down line 3: Postion 5,6,9 are all X's or O's  Set winner variable to X or X
#          IF statement 7 Cross Top Right to left bottom: Postion 3,4,5 are all X's or O's  Set winner variable to X or X#
#          IF statement 8 Cross top left to bottom right: Postion 5,6,9 are all X's or O's  Set winner variable to X or X#  Call Function to print starting board
#          Set varialbe for winner_name and # of attempts
#          

#  While loop - winner_name <> null or # of attempts = 10
#     IF current_user - "Y" then set to X
#         else set current_user = "X"
#     Input from user.
#     Call Function to Update the array from the input
#     Call Functionto Print updated board
#     Call Function to question winner, and if won, print "win"
#   
#   ENd while loop
#  If winner <> Null then
#     Print "Great game player ",winner_name,"won the game in ",# of attemps," turns"
#  If #_of_attempts = 10 then
#     Print "No winner after 10 tries game is over. Have a great day!"


print("Welcome to tic tac toe, here is how the board is layed out") 
print(startboard())
printboard()
winnername = ""
while(Attempts < 9 and winnername != "Winner"):
    winnername = ""
    if(Attempts % 2 == 0):
        Current_Player = "X"
    else:
        Current_Player = "O" 
    getfromuser()
    printboard()
    if(board[0][0] == Current_Player and board[0][1] == Current_Player and board[0][2] == Current_Player):
        winnername = "Winner"
    # across line 1 
    if(board[1][0] == Current_Player and board[1][1] == Current_Player and board[1][2] == Current_Player):
        winnername = "Winner"
    #across line 2
    if(board[2][0] == Current_Player and board[2][1] == Current_Player and board[2][2] == Current_Player):
        winnername = "Winner"
    # across line 3
    if(board[0][0] == Current_Player and board[1][0] == Current_Player and board[2][0] == Current_Player):
        winnername = "Winner"
    # vertical line 1 
    if(board[0][1] == Current_Player and board[1][1] == Current_Player and board[2][1] == Current_Player):
        winnername = "Winner"
    # vertical line 2 
    if(board[0][2] == Current_Player and board[1][2] == Current_Player and board[2][2] == Current_Player):
        winnername = "Winner"
    # vertical line 3 
    if(board[0][0] == Current_Player and board[1][1] == Current_Player and board[2][2] == Current_Player):
        winnername = "Winner"
    # diagonal line 1 
    if(board[0][2] == Current_Player and board[1][1] == Current_Player and board[2][0] == Current_Player):
        winnername = "Winner"
    # diagonal line 2 
        
    Attempts += 1
if(Attempts == 9):
    print("Cats game, you both lost you should probably try a new sport")
if(winnername != ""):
    print("Game over! WE HAVEEE A WINNER. Winner winner chicken dinner") 

