//<Qiancheng Li>
//<12/04/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #8>
//
//A class to represent a hippo——a kind of 
//critter that has its own way of eating and moving, etc.
import java.util.*;
import java.awt.*;


public class Hippo extends Critter {
    private int hunger;
    private int moveCount;
    private Random rand;
    private Direction directionChosen;
    
    //Constructs a new hippo.
    //Parameter:
    //    hunger-the times needed to eat to be full
    public Hippo(int hunger) {
        this.hunger = hunger;
        moveCount = 5;
        rand = new Random();
        directionChosen = Direction.NORTH;
    }

    //Return the direction of this movement:
    //will move to the selected direction 5 times, and then choose another direction
    public Direction getMove() {
        moveCount++;
        if (moveCount > 5) {
            moveCount = 1;
        }
        if (moveCount == 1) {
            directionChosen = chooseDirection();
        }
        return directionChosen;
    }

    //Return whether to eat.
    //will eat if hungry
    public boolean eat() {
        if (hunger > 0) {
            hunger--;
            return true;
        } else {
            return false;
        }
    }

    //Return the attack strategy for the fight.
    //will SCRATCH if hungry, POUNCE otherwise
    //    opponent-the String representing the opponent critter
    public Attack fight(String opponent) {
        if (hunger > 0) {
            return Attack.SCRATCH;
        } else {
            return Attack.POUNCE;
        }
    }

    //Return hippo's color.
    //will return GRAY if hungry, WHITE otherwise
    public Color getColor() {
        if (hunger > 0) {
            return Color.GRAY;
        } else {
            return Color.WHITE;
        }
    }
    
    //Return the string representation of hippo.
    //will return the times needed to eat
    public String toString() {
        return "" + hunger;
    }

    //Return the direction for the next five movements.
    public Direction chooseDirection() {
        int directionChoice = rand.nextInt(4);
        if (directionChoice == 0) {
            return Direction.NORTH;
        } else if (directionChoice == 1) {
            return Direction.SOUTH;
        } else if (directionChoice == 2) {
            return Direction.EAST;
        } else { //directionChoice == 3
            return Direction.WEST;
        }
    }
}
