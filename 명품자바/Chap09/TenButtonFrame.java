package Chap09;

import java.awt.*;

public class TenButtonFrame {
    Frame f;
    Button[] btn;

    public TenButtonFrame(){
        
        //프레임 생성 및 레이아웃 설정
        f = new Frame();
        f.setLayout(new GridLayout(0,10));
        f.setSize(900, 400);
        
        //버튼 배열 생성
        btn = new Button[10];

        //버튼 생성 및 프레임 부착
        for(int i=0; i<10; i++){
            btn[i] = new Button(String.valueOf(i));
            f.add(btn[i]);
        }

        f.setVisible(true);
    }
}
