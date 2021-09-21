
public class Board{
  private char[][] board;

  public Board(int size) {
    board = new char[size][size+1]; //alows to have board of any size
  }

  public char[][] getBoard(){
    return board;
  }
  //method to check if board is full
  public void boardFull(){
    int count = 0;
    for(int i=0; i  < board.length-1; i++){
      for(int j=0; j < board[i].length-1; j++){
        if(board[i][j] == 'r' || board[i][j] == 'y'){
          count = count + 1;
        }
        if(count >= 25){
          System.out.println("the match is a draw");
          System.exit(0); //found exit code here: https://stackoverflow.com/questions/22452930/terminating-a-java-program
        }
      }
    }
  }
  //method to place counter on the board
  public void placeCounter(char player, int position){
    boolean placed = false;
		if(player == 'r'){
			for(int i=board.length-2; i>=0; i--){
				if(!placed){
					if(board[position-1][i] == 'y'){
						// skip
					}
					else if(board[position-1][i] != 'r'){
						board[position-1][i] = 'r';
						placed = true;
           
					}
				}
			}
		}
		else{
			for(int i=board.length-2; i>=0; i--){
				if(!placed){
					if(board[position-1][i] == 'r'){
						// skip
					}
					else if(board[position-1][i] != 'y'){
						board[position-1][i] = 'y';
						placed = true;
					} 
				}
			}
		}
  }
  // this will print a board when called
  public String toString(){
    String toReturn = "";
    for(int i=0; i  < board.length-1; i++){
      for(int j=0; j < board[i].length-1; j++){
				if(board[j][i] == 'r'){
					toReturn += ("| r ");
				}
				else if(board[j][i] == 'y'){
					toReturn += ("| y ");
				}
				else{
					toReturn += ("|   ");
				}
			}
			toReturn += ("|\n");
		}
		toReturn += ("  1   2   3   4   5   6");
    return toReturn;
  }
  //this will check if the player has a winning condition on the board
  public boolean hasWon(char player){
    //check vertical
    int count = 0;
    for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){
					if(board[i][j] == player){
						count = count + 1;
						if(count >= 4){
							return true;
						}
					}
					else{
						count = 0;
					}
				}	
			}
      //check horizontal
      count = 0;
      for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board.length; j++){
					if(board[j][i] == player){
						count = count + 1;
						if(count >= 4){
							return true;
						}
					}
					else{
						count = 0;
					}
				}		
			}
      //check diangonal up
      count = 0;
      for(int i=0; i<board.length-3; i++){
				for(int j=3; j<board[i].length; j++){
          if(board[i][j] == player 
          && board[i+1][j-1] == player
          && board[i+2][j-2] == player
          && board[i+3][j-3] == player){
            count = count + 4;
            if(count >=4){
              return true;
            }
          }
          else{
            count = 0;
          }
        }  
      }
      // check diangonal down
      count = 0;
      for(int i=0; i<board.length-3; i++){
        for(int j=0; j<board[i].length-3; j++){
          if(board[i][j] == player
          && board[i+1][j+1] == player
          && board[i+2][j+2] == player
          && board[i+3][j+3] == player){
            count = count + 4;
            if(count >=4){
              return true;
            }
          }
          else{
            count = 0;
          }
        }
      }   
    return false;
  }
}