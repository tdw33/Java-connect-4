import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;

public class MyConnectFour {
	
  public MyConnectFour(){
		playGame();
	}

	private void playGame(){
    startMessage();
    Board board = new Board(6);
    //view used to show the board in command prompt
    View view = new CLView();
    view.display(board.toString());
    // creates a list of players to which you can multiple
    ArrayList<Player> players = new ArrayList<>();
    players.add(new HumanPlayer('r'));
    players.add(new ComputerPlayer('y'));
    int currentPlayer = 0;
		boolean win = false;
    // this is the main game loop based on win being false
		while(!win){
      boolean hasWon = false;
      // check to see if the board is full of counters
      board.boardFull();
      //below takes the counter and column value from player
      int move = players.get(currentPlayer).getMove();
      char counter = players.get(currentPlayer).getCounter();
      int newMove = checkMove(move, counter);
      //checks if the player is computer or human to direct to correct check column method
      // found here:https://stackoverflow.com/questions/22948234/checking-classes-with-if-statement-in-java
      if(players.get(currentPlayer) instanceof HumanPlayer){
      board.placeCounter(counter,checkCol(newMove,board.getBoard(),counter));
      }
      else{
        board.placeCounter(counter,checkColCom(newMove,board.getBoard(),counter));
      }
      System.out.println(newMove);
			// check if the player has won
      hasWon = board.hasWon(counter);
      view.display(board.toString());
      //switches to the next player
      currentPlayer = (currentPlayer+1)%players.size();
      //check if there is a win condtion
			if(hasWon){
        System.out.println(counter +" has won");
				win = true;
			}
		}
	}
  //this will see if the column is full
  public int checkCol(int move, char[][] board, char counter){
      Player playerHolder = new HumanPlayer(counter);
      while(board[move-1][0] == 'r' || board[move-1][0] == 'y'){
        System.out.println("column is full, enter another column");
        move = playerHolder.getMove();
      }
      return move;
    }
  // see of column is full for the computer 
  public int checkColCom(int random, char[][] board, char counter){
      Player playerHolder = new ComputerPlayer(counter);
      while(board[random-1][0] == 'r' || board[random-1][0] == 'y'){
        random = playerHolder.getMove();
      }
      return random;
    }
  //check if the move is valid 
  public int checkMove(int move, char counter){
    Player playerHolder = new HumanPlayer(counter);
    while(move < 1 || move > 6){
        System.out.println("invalid input, enter bewteen 1 and 6");
			  move = playerHolder.getMove();
    }
    return move;
  }
  // can print any start message you want
  private static void startMessage(){
    System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
  }
}