import java.util.*;
import java.awt.*;

public class Husky extends Critter {
    private int moveCount;
    
    public Husky() {
        moveCount = 0;
    }

    public Direction getMove() {
        moveCount++;
        if (moveCount > 10) {
            moveCount = 1;
        }
        if (moveCount == 1) {
            return Direction.NORTH;
        } else if (moveCount <= 3) {
            return Direction.EAST;
        } else if (moveCount <= 6) {
            return Direction.SOUTH;
        } else { //moveCount > 9
            return Direction.WEST;
        }
    }

    public boolean eat() {
        return true;
    }

    public Attack fight(String opponent) {
        if (opponent.equals("%")) {
            return Attack.ROAR;
        } else if (opponent.equals("^") || opponent.equals(">")){
            return Attack.SCRATCH;
        } else {
            return Attack.POUNCE;
        }
    } 

    public Color getColor() {
        return Color.MAGENTA;
    }

    public String toString() {
        return "UW";
    }
}
