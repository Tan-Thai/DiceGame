package InheritencesAndInterfaces;

abstract class Food {}

//meat extends food--------------------------------
class Meat extends Food {}

//meat specific food that extends meat--------------------------------
class PreyAnimal extends Meat {}


//Plant extends food--------------------------------
class Plant extends Food {}

//plant specific food that extends plant--------------------------------
class Grass extends Plant {}
class Leaves extends Plant {}

class Carnivore {
    public void eat(Meat meat) {
        System.out.println("Carnivore eats meat.");
    }
}

class Herbivore {
    public void eat(Plant plant) {
        System.out.println("Herbivore eats plants.");
    }
}

class Omnivore {
    public void eat(Food food) {
        System.out.println("Omnivore eats everything.");
    }
}

public class inheritance {
    public static void main(String[] args) { 
        // vi kan köra dinosaurier här!
        Carnivore carnivore = new Carnivore();
        Herbivore herbivore = new Herbivore();
        Omnivore omnivore = new Omnivore();

        PreyAnimal preyAnimal = new PreyAnimal();
        Grass grass = new Grass();
        Leaves leaves = new Leaves();

        carnivore.eat(preyAnimal);  
        herbivore.eat(grass);  
        omnivore.eat(preyAnimal);
        omnivore.eat(leaves);
    }
}