package Project_1.PigGame;
import java.util.Random;

public class Die {
    private int numberOfSides;
    private int currentValue;
    private Random random  = new Random();
    

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
        this.currentValue = random.nextInt(1, numberOfSides + 1);
    }

}
