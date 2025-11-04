package Chap12;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class DrawingUsingGraphics_2 extends JFrame {

    private Mypanel panel = new Mypanel();

    public DrawingUsingGraphics_2(){
        setTitle("꽉차는 마름모 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        setSize(500,500);
        setVisible(true);
    }

    private class Mypanel extends JPanel{

        int w, h;

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Container c = getContentPane();
            
            w = c.getWidth();
            h = c.getHeight();
            int[] x = {w/2, 0, w/2, w};
            int[] y = {0, h/2, h, h/2};

            for(int i=0; i<10; i++){
                g.drawPolygon(x, y, 4);
                y[0] += 10;
                x[1] += 10;
                y[2] -= 10;
                x[3] -= 10;

            }
        }
    }
    public static void main(String[] args) {
        new DrawingUsingGraphics_2();
    }
}
