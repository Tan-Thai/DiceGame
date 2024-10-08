package Project_1.DiceGame;
import java.util.Random;

public class Die {
    private int numberOfSides;
    private int currentValue;
    private Random random;
    
    // getters, setters
    public int getNumberOfSides() {
        return numberOfSides;
    }
    public int getCurrentValue() {
        return currentValue;
    }

    // Constructors
    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    // Methods and misc
    public void roll() {
        random = new Random(); 
        //creating a new instance of random each time since random tends to have a seed based on when it gets created.
        // not sure if its the same with java but i recall C# being that way IIRC.
        this.currentValue = random.nextInt(1, numberOfSides + 1);
    }

}