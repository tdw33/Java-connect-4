import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public abstract class Player{

  private char counter;

  public Player(char counter){
    this.counter = counter;
  }
  // allows for HumanPlayer and ComputerPlayer to setup their getMove method
  abstract int getMove();

  public char getCounter(){
    return counter;
  }


}