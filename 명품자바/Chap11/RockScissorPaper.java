package Chap11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RockScissorPaper {
    
    JFrame f;
    JButton rock, scissors, paper;
    ImageIcon img[] = {new ImageIcon("C:\\Users\\이예진\\Pictures\\scissor.gif"), new ImageIcon("C:\\Users\\이예진\\Pictures\\바위.gif"), new ImageIcon("C:\\Users\\이예진\\Pictures\\paper.gif")};
    JLabel me, com, res;
    int mePick, comPick;
    JPanel one, two;

    public RockScissorPaper(){

        //프레임 생성 및 레이아웃 설정
        f = new JFrame("가위 바위 보 게임");
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = f.getContentPane();
        c.setLayout(new BorderLayout());

        //패널에 냅다 붙이기
        //one 위에 올라갈 것
        scissors = new JButton(img[0]);
        rock = new JButton(img[1]);
        paper = new JButton(img[2]);

        one = new JPanel(new FlowLayout());
        one.setBackground(Color.GRAY);

        one.add(rock);
        one.add(scissors);
        one.add(paper);

        //two
        me = new JLabel("me");
        com = new JLabel("com");
        res = new JLabel();

        two = new JPanel(new FlowLayout());
        two.setBackground(Color.YELLOW);

        two.add(me);
        two.add(com);
        two.add(res);

        //패널 프레임에 붙이기
        c.add(one, BorderLayout.NORTH);
        c.add(two, BorderLayout.CENTER);

        //버튼에 이벤트를 넣어줍시다
        scissors.addActionListener(new action(0));
        rock.addActionListener(new action(1));
        paper.addActionListener(new action(2));
    }

    class action implements ActionListener{
        int num;
        
        public action(int i) {
            num = i;
        }

        public void actionPerformed(ActionEvent e){
            mePick = num;
            comPick = (int)(Math.random()*3);

            //고른 사진을 two패널에 붙여야함
            me.setIcon(img[mePick]);
            com.setIcon(img[comPick]);

            //승부를 가려봅시다
            //0 = 가위  1 = 바위  2 = 보
            if(mePick - comPick == 0){      //비긴경우
                res.setText("Same!!!");
            }
            else if(mePick - comPick == -2 || mePick - comPick == 1){   //내가 이긴경우 --> 내가 가위(0) 컴터 보(2) --> -2
                res.setText("Me!!!!!");                           //내가 바위(1) 컴터 가위(0), 내가 보(2) 컴터 바위(1) --> 1
            }
            else
                res.setText("Com!!!!!!");

        }
    
    }
}

