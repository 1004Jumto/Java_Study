package Chap13;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BubbleGame extends JFrame {
    
    ImageIcon icon = new ImageIcon("C://Users//이예진//Pictures//professor.gif");
    Image img = icon.getImage();
    Image resizeImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon resizIcon = new ImageIcon(resizeImage);

    JLabel imgLabel[] = new JLabel[100];
    BubbleGameThread th[] = new BubbleGameThread[100];
    int i=0;

    public BubbleGame(String msg){
        setTitle(msg);
        setVisible(true);
        setSize(500,500);
        
        Container c = getContentPane();
        c.setLayout(null);
        c.setSize(500,500);

        for(int i=0; i<100; i++){
            imgLabel[i] = new JLabel();
            imgLabel[i].setIcon(resizIcon);
            imgLabel[i].setSize(100,100);
        }

        c.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                th[i] = new BubbleGameThread(c, imgLabel[i], e.getX(), e.getY());
                th[i].start();
            }
        });
        c.requestFocus();   
    }
    public static void main(String[] args) {
        new BubbleGame("BubbleGame :: LYJ");
    }

}
