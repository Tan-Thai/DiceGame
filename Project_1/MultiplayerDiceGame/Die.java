package Project_1.MultiplayerDiceGame;
import java.util.Random;

public class Die {
    private int numberOfSides;
    private int currentValue;
    private Random random;
    

    public int getNumberOfSides() {
        return numberOfSides;
    }
    public int getCurrentValue() {
        return currentValue;
    }

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public void roll() {
        random = new Random(); 
        this.currentValue = random.nextInt(1, numberOfSides);
    }

}