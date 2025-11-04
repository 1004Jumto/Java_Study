package Chap10;

import java.awt.*;
import java.awt.event.*;

public class LoveJava {

    public LoveJava(){
        
        Frame f = new Frame("마우스 휠을 굴려 폰트 크기 조정");
        Label la = new Label("Love Java");
       
        f.setLayout(new FlowLayout());
        f.setSize(500,500);
        f.setVisible(true);

        la.setSize(300,300);
        
        la.setFont(new Font("Arial", Font.PLAIN, 30));
        Font font = la.getFont();
        int size = font.getSize();
        
        la.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e){
                int n = e.getWheelRotation();
                if(n < 0) {
					if(size - 5 > 0) {
						la.setFont(new Font("Arial",Font.PLAIN,size-5));
					}
				}
				else {
					la.setFont(new Font("Arial",Font.PLAIN,size+5));
				}
            }
        });

        la.setFocusable(true);
        la.requestFocus();
        f.add(la);
    }

    public static void main(String[] args) {
        new LoveJava();
    }
}
