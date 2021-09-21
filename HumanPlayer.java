import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// this use the Player abstarct class
public class HumanPlayer extends Player{

  private BufferedReader input;

  public HumanPlayer(char counter){
    super(counter);
    input = new BufferedReader(new InputStreamReader(System.in));
  }
  // gives the getMove in Player a mehtod 
  public int getMove(){
		try{		
			return Integer.parseInt(input.readLine());
		}
		catch(IOException e){	
      return -1;
		}
	}


}