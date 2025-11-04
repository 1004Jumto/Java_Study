package Chap09;

import java.awt.*;

public class TenColorFrame {
    
    Frame f;
    Button[] btn;

    public TenColorFrame(){
        
        //프레임 생성 및 레이아웃 설정
        f = new Frame();
        f.setLayout(new GridLayout(0,10));
        f.setSize(900, 400);
        
        //버튼 배열 생성
        btn = new Button[10];

        //버튼 생성
        for(int i=0; i<10; i++){
            btn[i] = new Button(String.valueOf(i));
        }
      
        btn[0].setBackground(Color.RED);
        btn[1].setBackground(Color.ORANGE);
        btn[2].setBackground(Color.YELLOW);
        btn[3].setBackground(Color.GREEN);
        btn[4].setBackground(Color.CYAN);
        btn[5].setBackground(Color.BLUE);
        btn[6].setBackground(Color.MAGENTA);
        btn[7].setBackground(Color.GRAY);
        btn[8].setBackground(Color.PINK);
        btn[9].setBackground(Color.LIGHT_GRAY);

        //프레임에 버튼 부착
        for(int i=0; i<10; i++){
            f.add(btn[i]);
        }

        f.setVisible(true);
    }
    
}
