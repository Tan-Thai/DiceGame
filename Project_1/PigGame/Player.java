package Project_1.PigGame;

public class Player {
    String name;
    int score = 0; 
    Die die;
    
    public String getName() {return name;}
    public int getScore() {return score;}
    public void setScore(int score) {
        this.score = score;
    }

    public Player(String name) {
        this.name = name;
        addDie(6);
    }

    public void rollDice() {
        this.die.roll();
    }

    public int getDieValue() {
        return this.die.getCurrentValue();
    }

    public void increaseScore(int i) {
        this.score += i;
    }
    
    public void addDie(int numberOfSides) {
        this.die = new Die(numberOfSides);
    }
    
}
