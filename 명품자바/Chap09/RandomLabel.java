package Chap09;

import java.awt.*;

public class RandomLabel {
        Frame f;
        Label[] labels;

        public RandomLabel(){

            //프레임 생성 및 레이아웃 설정
            f = new Frame("Random Label Frame");
            labels = new Label[20];

            f.setSize(300,300);
            f.setLayout(null);

            //라벨 생성 및 위치, 크기, 색 설정
            for(int i=0; i<20; i++){
                int x = (int)(Math.random()*200)+50;
                int y = (int)(Math.random()*200)+50;
                labels[i] = new Label();
                labels[i].setLocation(x,y);
                labels[i].setSize(10,10);
                labels[i].setBackground(Color.BLUE);
                f.add(labels[i]);   //프레임에 라벨 부착
            }
        
            f.setVisible(true); //보여줘
        }
}
