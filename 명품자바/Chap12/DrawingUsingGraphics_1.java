package Chap12;

import java.awt.*;
import javax.swing.*;
// import java.awt.event.*;

public class DrawingUsingGraphics_1 extends JFrame {
    private Mypanel panel = new Mypanel();

    public DrawingUsingGraphics_1(){
        setTitle("10*10 격자 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        setSize(500,500);
        setVisible(true);
    }

    private class Mypanel extends JPanel{
        int width, height;
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Container c = getContentPane();
           
            width = c.getWidth();
            height = c.getHeight();
        
            for(int i=1; i<10; i++){
                g.drawLine(width/10*i, 0, width/10*i, height);      //세로줄
                g.drawLine(0, height/10*i, width, height/10*i);     //가로줄
            }

        }
    }
    public static void main(String[] args) {
        new DrawingUsingGraphics_1();
    }
}
