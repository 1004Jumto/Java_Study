package Chap12;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class ImageQuarter extends JFrame {

    Mypanel panel = new Mypanel();

    public ImageQuarter(){
        setTitle("이미지 4등분");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        setSize(500,500);
        setVisible(true);
    }

    private class Mypanel extends JPanel{
        
        int w, h;
        int x, y;
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Container c = getContentPane();
            ImageIcon icon = new ImageIcon("C:\\Users\\이예진\\Pictures\\cat.gif");
            Image img = icon.getImage();

            w = c.getWidth();
            h = c.getHeight();
            x = img.getWidth(this);
            y = img.getHeight(this);

            g.drawImage(img, 0, 0, w/2-5, h/2-5, 0, 0, x/2, y/2, this);
            g.drawImage(img, w/2+5, 0, w, h/2-5, x/2, 0, x, y/2, this);
            g.drawImage(img, 0, h/2+5, w/2-5, h, 0, y/2, x/2, y, this);
            g.drawImage(img, w/2+5, h/2+5, w, h, x/2, y/2, x, y, this);
        }
    }

    public static void main(String[] args) {
        new ImageQuarter();
    }

}