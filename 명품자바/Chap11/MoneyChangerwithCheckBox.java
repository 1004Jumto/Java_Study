package Chap11;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MoneyChangerwithCheckBox {

    JFrame f;       //프레임
    JPanel one, two;        //one은 인풋, two는 변환되는 결과
    JPanel panel[];
    JButton cal;            //계산 버튼
	JTextField input;       //금액 입력받음
    JLabel total;
	JLabel money[] = new JLabel[8];       //금액 라벨
	String moneytag[] = {"오만원","만원","천원","500원","100원","50원","10원","1원"};
	int money_[] = {50000,10000,1000,500,100,50,10,1};   
	JTextField result[] = new JTextField[8];  //금액 반환되는 곳
	JCheckBox check[] = new JCheckBox[7];     

    public MoneyChangerwithCheckBox(){
        
        //프레임 레이아웃 설정
        f = new JFrame("Money Changer with CheckBox");
        f.setSize(300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = f.getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(Color.PINK);

        //패널 one
        one = new JPanel(new FlowLayout());
        one.setBackground(Color.PINK);

        total = new JLabel("금액");
        input = new JTextField(10);
        cal = new JButton("계산");

        one.add(total);
        one.add(input);
        one.add(cal);

        //패널 two
        two = new JPanel(new GridLayout(8,0));  //8행 패널 생성
		two.setBackground(Color.pink);

        panel = new JPanel[8];
		for(int i = 0; i < 8; i++) {    //반복문으로 금액라벨과 반환결과 텍스트필드, 체크박스 부착
			money[i] = new JLabel(moneytag[i]);
			result[i] = new JTextField(10);
            panel[i] = new JPanel(new FlowLayout());
            panel[i].setBackground(Color.PINK);

			panel[i].add(money[i]);
			panel[i].add(result[i]);

			if(i < 7) {     //오만원에서 십원까지 체크박스
				check[i] = new JCheckBox();
				check[i].setBackground(Color.pink);
				panel[i].add(check[i]);
			}
            two.add(panel[i]);
		}
        
        //패널 컨테이너에 부착
        c.add(one, BorderLayout.NORTH);
        c.add(two, BorderLayout.CENTER);


        //이벤트를 넣어줍시다
        //버튼누르면 계산, 체크박스 고려
        cal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                int user_input = Integer.valueOf(input.getText());  //입력된 텍스트필드 값을 가져옴

                //체크박스 상태 보기
                for(int i=0; i<7; i++){
                    if(check[i].isSelected()){  //체크되어 있으면 입력된 값을 금액단위로 나눠주고 나머지는 다음으로 넘김
                        int ans;
                        ans = user_input / money_[i];
                        result[i].setText(String.valueOf(ans));
                        user_input = user_input % money_[i];
                    }
                    else{       //체크안되어 있으면 0을 돌려줌
                        result[i].setText("0");
                    }
                }
                result[7].setText(Integer.toString(user_input));    //나머지는 1원 텍스트필드에 돌려줌
            }
        });
        
    }
}
