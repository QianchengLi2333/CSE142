//<Qiancheng Li>
//<10/16/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #3>
//
//<This program will produce rows and grids 
//in the required pattern.>

import java.awt.*;
public class CafeWall {
    //Set the value of class constant MORTAR
    public static final int MORTAR = 2;

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics brush = panel.getGraphics();
        drawRow(brush, 0, 0, 20, 4);
        drawRow(brush, 50, 70, 30, 5);
        drawGrid(brush, 400, 20, 35, 2, 35);
        drawGrid(brush, 10, 150, 25, 4, 0);
        drawGrid(brush, 250, 200, 25, 3, 10);
        drawGrid(brush, 425, 180, 20, 5, 10);
    }

    //Draw a row according to the required pattern
    //Parameters:
    //    Graphics brush: the brush to draw the picture
    //    int x: the x coordinate of the start point where this row is drawn
    //    int y: the y coordinate of the start point where this row is drawn
    //    int size: the length of each square box
    //    int pair: the number of pairs of black and white boxes
    public static void drawRow(Graphics brush, int x, int y, int size, int pair) {
        for (int blocks = 0; blocks < pair; blocks++) { 
            brush.setColor(Color.BLACK);
            brush.fillRect(x + 2 * blocks * size, y, size, size);
            brush.setColor(Color.BLUE);
            brush.drawLine(x + 2 * blocks * size, y, x + (2 * blocks + 1) * size, y + size);
            brush.drawLine(x + 2 * blocks * size, y + size, x + (2 * blocks + 1) * size, y);
            brush.setColor(Color.WHITE);
            brush.fillRect(x + (2 * blocks + 1) * size, y, size, size);
        }
    }

    //Draw grids according to the required pattern
    //Parameters:
    //    Graphics brush: the brush to draw the picture
    //    int x: the x coordinate of the start point where this grid is drawn
    //    int y: the y coordinate of the start point where this grid is drawn
    //    int size: the length of each square box
    //    int pair: the number of pairs of boxes in each row and the pairs of rows in the grid
    //    int offset: the distance that even rows need to be moved towards the right 
    public static void drawGrid(Graphics brush, int x, int y, int size, int pair, int offset) {
        for (int lines = 0; lines < pair; lines++) {
            drawRow(brush, x, y + 2 * lines * (size + MORTAR), size, pair);
            drawRow(brush, x + offset, y + (2 * lines + 1) * (size + MORTAR), size, pair);
        }   
    }
}
