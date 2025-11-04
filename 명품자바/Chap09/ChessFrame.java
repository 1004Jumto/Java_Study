package Chap09;

import java.awt.*;

public class ChessFrame {
    
    Frame f;
    Label[] label;

    public ChessFrame(){

        //프레임 생성 및 설정
        f = new Frame();
        f.setSize(900,500);
        f.setLayout(new GridLayout(4,4));

        //라벨 생성
        label = new Label[16];
        for(int i=0; i<16; i++){
            label[i] = new Label(String.valueOf(i));
            f.add(label[i]);
        }

        //버튼 색 설정
        label[0].setBackground(Color.RED);
        label[1].setBackground(Color.ORANGE);
        label[2].setBackground(Color.YELLOW);
        label[3].setBackground(Color.GREEN);
        label[4].setBackground(Color.CYAN);
        label[5].setBackground(Color.BLUE);
        label[6].setBackground(Color.MAGENTA);
        label[7].setBackground(Color.GRAY);
        label[8].setBackground(Color.PINK);
        label[9].setBackground(Color.LIGHT_GRAY);
        label[10].setBackground(Color.WHITE);
        label[11].setBackground(Color.DARK_GRAY);
        label[12].setBackground(Color.BLACK);
        label[13].setBackground(Color.YELLOW);
        label[14].setBackground(Color.BLUE);
        label[15].setBackground(Color.MAGENTA);
        //이게 맞나요..?

        f.setVisible(true);

    }    
}
