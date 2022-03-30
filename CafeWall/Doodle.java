//<Qiancheng Li>
//<10/16/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #3>
//
//<This program will produce a sword-like figure.>

import java.awt.*;
public class Doodle {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(500, 500);
        panel.setBackground(Color.WHITE);
        Graphics brush = panel.getGraphics(); 
        drawSword(brush, 250, 0, 200, Color.CYAN, Color.RED);   
    }
    
    //Produce a sword-like figure
    //Parameters:
    //    Graphics brush: the brush to draw the picture
    //    int x: the x coordinate of the start point where this picture is drawn
    //    int y: the y coordinate of the start point where this picture is drawn
    //    int length: the length of the body of this sword
    //    Color A: the color of the sword guard
    //    Color B: the color of the hilt of this sword
    public static void drawSword(Graphics brush, int x, int y, int length, Color A, Color B) {
        brush.drawLine(x, y, x - 50, y + 50);
        brush.drawLine(x, y, x + 50, y + 50);
        brush.drawLine(x - 50, y + 50, x - 50, y + 50 + length);
        brush.drawLine(x + 50, y + 50, x + 50, y + 50 + length);
        brush.setColor(A);
        brush.fillRect(x - 100, y + 50 + length, 200, 20);
        brush.setColor(B);
        brush.fillRect(x - 25, y + 70 + length, 50, 70);
        brush.setColor(Color.BLACK);
        brush.drawOval(x - 15, y + 140 + length, 30, 30);
    }
        
}
