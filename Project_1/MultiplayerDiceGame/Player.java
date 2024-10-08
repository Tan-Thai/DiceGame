package Project_1.MultiplayerDiceGame;
import java.util.ArrayList;

public class Player {
    String name;
    int score = 0; 
    ArrayList<Die> dice = new ArrayList<Die>();
    
    public String getName() {return name;}
    public int getScore() {return score;}
    public void setScore(int score) {
        this.score = score;
    }

    public Player(String name) {
        this.name = name;
    }

    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }

    public int getTotalDiceValue() {
        int totalDiceValue = 0;
        for (Die die : dice) {
            totalDiceValue += die.getCurrentValue();
        }
        return totalDiceValue;
    }

    public void increaseScore(int i) {
        this.score += i;
    }
    
    public void addDie() { //temp set to 6 to avoid a long string of setups for each die.
        Die die = new Die(6);
        dice.add(die);
    }
    
}
