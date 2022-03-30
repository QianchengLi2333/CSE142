//<Qiancheng Li>
//<10/9/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #2>
//
//<This program will produce the ASCII art 
//made by myself.>

public class AsciiArt {
    //Declare the value of class constant SIZE
    public static final int SIZE = 3;

    //Draw the upper cover of the hexagon
    public static void drawCover() {
        for (int space = 0; space < SIZE; space++) {
            System.out.print(" ");
        }

        for (int cover = 0; cover < SIZE; cover++) {
            System.out.print("_");
        }
        System.out.println();
    }

    //Draw the upper part of the hexagon-like figure
    public static void upperPart() {
        for (int line = 0; line < SIZE; line++) {
            for (int space = 0; space < SIZE - line - 1; space++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int middle = 0; middle < 2 * line + SIZE; middle++) {
                System.out.print(" ");
            }
            System.out.println("\\");
        }    
    }

    //Draw the lower part of the hexagon-like figure
    public static void bottomPart() {
        for (int line = SIZE - 1; line > -1; line--) {
            for (int space = 0; space < SIZE - line - 1; space++) {
                System.out.print(" ");
            }
            System.out.print("\\");
            for (int middle = 0; middle < 2 * line + SIZE; middle++) {
                System.out.print(" ");
            }
            System.out.println("/");
        }
    }

    //Draw the lower cover of the hexagon
    public static void drawBottom() {
        for (int space = 0; space < SIZE; space++) {
            System.out.print(" ");
        }

        for (int bottom = 0; bottom < SIZE; bottom++) {
            System.out.print("¯");
        }
    }

    //Draw the whole picture of my figure. 
    //The number of hexagons in it depends on its SIZE.
    public static void body() {
        drawCover();
        for (int times = 0; times < SIZE; times++) {
            upperPart();
            bottomPart();
        }
        drawBottom();
    }

    public static void main(String[] args) {
        body();
    }
}
