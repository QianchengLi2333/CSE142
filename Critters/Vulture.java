//<Qiancheng Li>
//<12/04/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #8>
//
//A class to represent a vulture——a kind of 
//bird that has its own way of eating and moving, etc.
import java.util.*;
import java.awt.*;

public class Vulture extends Bird {
    private boolean hungry;

    //Constructs a new vulture.
    public Vulture() {
        hungry = true;
    }

    //Return whether to eat.
    //will eat if hungry
    public boolean eat() {
        if (hungry) {
            hungry = !hungry;
            return true;
        } else {
            return false;
        }
    }

    //Return the attack strategy for the fight.
    //will ROAR if the opponent is an ant, POUNCE otherwise
    //become hungry after one fight 
    //    opponent-the String representing the opponent critter
    public Attack fight(String opponent) {
        hungry = true;
        return super.fight(opponent);
    }

    //Return vulture's color.
    //will always return BLACK
    public Color getColor() {
        return Color.BLACK;
    }
}
