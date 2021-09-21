import java.util.Random;
// this use the Player abstarct class
public class ComputerPlayer extends Player{

  private Random rand;

  public ComputerPlayer(char counter){
    super(counter);
    rand = new Random();
  }
  // gives the getMove in Player a mehtod 
  public int getMove(){
		return rand.nextInt(6)+1;
		}
	

}