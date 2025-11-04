package Chap09;

import java.awt.*;

public class CalculatorFrame {
    
    Frame f;
    Label in, out;
    TextField input, output;
    Button[] num;
    Button ce, ans, plus, minus, multi, divide;
    Panel nrt, cnt, sth;

    public CalculatorFrame(){

        f = new Frame("계산기 프레임");
        f.setSize(500,500);
        f.setLayout(new BorderLayout());
        
        in = new Label("수식입력");
        out = new Label("계산결과");

        input = new TextField(40);
        output = new TextField(40);

        nrt = new Panel();
        cnt = new Panel();
        sth = new Panel();

        //패널에 붙이기 north
        nrt.add(in);
        nrt.add(input);
        nrt.setBackground(Color.LIGHT_GRAY);
        //패널에 붙이기 south
        sth.add(out);
        sth.add(output);
        sth.setBackground(Color.YELLOW);

        cnt.setLayout(new GridLayout(4,4));

        num = new Button[10];
        for(int i=0; i<10; i++){
            num[i] = new Button(String.valueOf(i));
            cnt.add(num[i]);
        }
        
        ce = new Button("CE");
        cnt.add(ce);
        ans = new Button("계산");
        cnt.add(ans);

        plus = new Button("+");
        plus.setBackground(Color.PINK);
        cnt.add(plus);

        minus = new Button("-");
        minus.setBackground(Color.PINK);
        cnt.add(minus);

        multi = new Button("x");
        multi.setBackground(Color.PINK);
        cnt.add(multi);

        divide = new Button("/");
        divide.setBackground(Color.PINK);
        cnt.add(divide);

        f.add(nrt, BorderLayout.NORTH);
        f.add(cnt, BorderLayout.CENTER);
        f.add(sth, BorderLayout.SOUTH);

        f.setVisible(true);
    }
}
