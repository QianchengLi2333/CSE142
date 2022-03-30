//<Qiancheng Li>
//<12/04/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #8>
//
//A class to represent an ant——a kind of 
//critter that has its own way of eating and moving, etc.
import java.util.*;
import java.awt.*;

public class Ant extends Critter {
    private boolean walkSouth;
    private int moveCount;

    //Constructs a new hippo.
    //Parameter:
    //    walkSouth-whether walk to the south or not
    public Ant(boolean walkSouth) {
        moveCount = 0;
        this.walkSouth = walkSouth;
    }

    //Return the direction of this movement:
    //will move to the SOUTH if walkSouth is true, NORTH otherwise, 
    //then move the EAST, and repeat
    public Direction getMove() {
        moveCount++;
        if (moveCount % 2 == 1) {
            if (walkSouth) {
                return Direction.SOUTH;
            } else {
                return Direction.NORTH;
            }
        } else {
            return Direction.EAST;
        }
    }

    //Return whether to eat.
    //will always return true
    public boolean eat() {
        return true;
    }

    //Return the attack strategy for the fight.
    //will alyaws SCRATCH
    //    opponent-the String representing the opponent critter
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

    //Return ant's color.
    //will always return RED
    public Color getColor() {
        return Color.RED;
    }

    //Return the string representation of hippo.
    //will always return %
    public String toString() {
        return "%";
    }
}
