package Chap09;

import java.awt.*;

public class FramewithPanels {
    
    Frame f;
    Button open, close, exit, in;
    TextField input;
    Panel nrt, sth, ctr;
    Label[] labels;

    public FramewithPanels(){

        f = new Frame("여러 개의 패널을 가진 프레임");
        f.setSize(500,500);
        f.setLayout(new BorderLayout());
        
        open = new Button("열기");
        close = new Button("닫기");
        exit = new Button("나가기");
        
        nrt = new Panel();
        nrt.setBackground(Color.LIGHT_GRAY);
        nrt.add(open);
        nrt.add(close);
        nrt.add(exit);
        
        in = new Button("Word Input");
        input = new TextField(40);
        sth = new Panel();
        sth.setBackground(Color.YELLOW);
        sth.add(in);
        sth.add(input);
        
        //center 패널 생성 레이아웃은 없애줌
        ctr = new Panel();
        ctr.setLayout(null);
        
        labels = new Label[10];
        for(int i=0; i<10; i++){
            int x = (int)(Math.random()*400)+50;
            int y = (int)(Math.random()*400)+50;
            labels[i] = new Label("*");
            labels[i].setSize(20,20);
            labels[i].setForeground(Color.RED);
            labels[i].setBackground(Color.GREEN);
            labels[i].setLocation(x,y);
            ctr.add(labels[i]);
        }
        
        f.add(nrt, BorderLayout.NORTH);
        f.add(ctr, BorderLayout.CENTER);
        f.add(sth, BorderLayout.SOUTH);
        
        f.setVisible(true);
    }
}
