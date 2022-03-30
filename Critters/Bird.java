//<Qiancheng Li>
//<12/04/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #8>
//
//A class to represent a bird——a kind of 
//critter that has its own way of eating and moving, etc.
import java.util.*;
import java.awt.*;

public class Bird extends Critter {
    private int moveCount;

    //Constructs a new bird.
    public Bird() {
        moveCount = 0;
    }

    //Return the direction of this movement:
    //will move in a clockwise manner, 3 times to each direction
    public Direction getMove() {
        moveCount++;
        if (moveCount > 12) {
            moveCount = 1;
        }
        if (moveCount <= 3) {
            return Direction.NORTH;
        } else if (moveCount <= 6) {
            return Direction.EAST;
        } else if (moveCount <= 9) {
            return Direction.SOUTH;
        } else { //moveCount > 9
            return Direction.WEST;
        }
    }

    //Return the attack strategy for the fight.
    //will ROAR if the opponent is an ant, POUNCE otherwise
    //    opponent-the String representing the opponent critter
    public Attack fight(String opponent) {
        if (opponent.equals("%")) {
            return Attack.ROAR;
        } else {
            return Attack.POUNCE;
        }
    }

    //Return bird's color.
    //will always return BLUE
    public Color getColor() {
        return Color.BLUE;
    }

    //Return the string representation of hippo.
    //will return an arrow pointing to the moving direction
    public String toString() {
        if (moveCount <= 3) {
            return "^";
        } else if (moveCount <= 6) {
            return ">";
        } else if (moveCount <= 9) {
            return "V";
        } else { //moveCount > 9
            return "<";
        }
    }
}
