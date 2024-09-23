import java.util.Random;

public class Die {
    private int numberOfSides;
    private int currentValue;
    private Random random = new Random();

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

    // Methods
    public void roll() {
        currentValue = random.nextInt(1, numberOfSides);
    }

}