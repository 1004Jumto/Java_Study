package Chap12;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// import java.util.*;

public class ImageDragging extends JFrame{
    
    Mypanel panel = new Mypanel();

    public ImageDragging(){
        setTitle("이미지 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);      //내가 생성한 패널을 컨텐트 팬으로 사용

        setSize(500,500);
        setVisible(true);
    }
    
    //사용자 정의 패널
    private class Mypanel extends JPanel{      //이미지를 마우스 드래그에 따라 옮김
        private ImageIcon icon = new ImageIcon("C:\\Users\\이예진\\Pictures\\apple.gif");   //이미지로딩
        private Image img = icon.getImage();                                                        //이미지객체
        int x, y;

        public void paintComponent(Graphics g){
            super.paintComponent(g);    //패널 내에 이전에 그려진 잔상을 지우기 위해 호출
           
            Container c = getContentPane();
            c.setLayout(null);
           
            c.addMouseMotionListener(new MouseAdapter(){   //mouseadapter을 익명클래스 활용하여 구현
                public void mouseDragged(MouseEvent e){
                    x = e.getX();
                    y = e.getY();
                    repaint();      //마우스 좌표를 얻어 repaint
                    /*repaint는 컴포넌트에 변화가 일어났을 경우 이를 반영해주기 위한 것으로, paintComponent() 함수를 
                    직접 호출 할 수 없기 때문에 repaint()를 통해 강제로 컴포넌트의 모양을 변경해줌 */
                }
            });

            g.drawImage(img, x, y, 250, 250, this);
        }
    }
}
