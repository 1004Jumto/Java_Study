package Chap13;

import javax.swing.*;
import java.awt.*;

public class BubbleGameThread extends Thread{
    private JLabel label;
    private Container c;
    int x, y;

    public BubbleGameThread(Container con, JLabel la, int x, int y){
        this.c = con;
        this.label = la;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        label.setLocation(x,y);
        c.add(label);

        while(true){
            try {
                if(y >= -100){
                    y -= 5;
                    label.setLocation(x,y);
                    sleep(20);
                }
                else if(y < -100){
                    c.remove(label);
                }
            } catch (InterruptedException e) {
                System.out.println("Sorry! Error is occurred");
            }
        }
    }
}
