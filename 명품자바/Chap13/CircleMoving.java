package Chap13;

import java.awt.*;
import javax.swing.*;
// import java.awt.event.*;

/*My Panel*/
public class CircleMoving extends JPanel {

    public CircleMoving(){
        setSize(getPreferredSize());
        setLayout(null);
    }

    //for drawing circle randomly located
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int x = (int)(Math.random()*getHeight());
        int y = (int)(Math.random()*getWidth());
        
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 50, 50);
    }
}
