package Chap13;

import javax.swing.JFrame;
import java.awt.event.*;

/* 
      패널 -> 랜덤으로 원 그리기, 이벤트 구현
    프레임 -> 패널 추가
    스레드 -> 5초 지연    
*/
public class CircleMovingMain extends JFrame{

    //create mypanel
    CircleMoving mypanel = new CircleMoving();
    MyThread th = new MyThread(mypanel);

    public CircleMovingMain(String msg){
        //set frame
        setTitle(msg);
        setSize(500,500);
        setContentPane(mypanel);
        //add(mypanel); 

        mypanel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
               th.start();
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new CircleMovingMain("Circle Moving at 0.5 seconds Intervals :: LYJ");

    }
}
