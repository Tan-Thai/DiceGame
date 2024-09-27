package Project_1.DiceGame;

public class Player {
    String name;
    int score = 0; 
    Die die;
    
    //getters, setters
    public String getName() {return name;}

    public int getScore() {return score;}
    public void setScore(int score) {
        this.score = score;
    }

    //constructors 
    public Player(String name) {
        this.name = name;
    }

    //methods
    public void rollDice() {
        this.die.roll();
    }

    public int getDieValue() {
        return this.die.getCurrentValue();
    }

    public void increaseScore() {
        this.score++;
    }

    public void addDie(int numberOfSides) {
        this.die = new Die(numberOfSides);
    }
    
}
