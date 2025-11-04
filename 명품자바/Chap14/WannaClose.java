package Chap14;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WannaClose extends JFrame {
    JToolBar bar;
    private Container contentPane;

    public WannaClose(){
        //프레임 설정
        setTitle("ToolBar/optionPane Prac");
        setSize(500,500);
        setVisible(true);

        createToolBar();
    }

    private void createToolBar() {
        JButton btn = new JButton("종료");
        
        bar = new JToolBar("It is ToolBar");
        bar.add(btn);

        //버튼 이벤트 처리하기
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int returnValue = JOptionPane.showConfirmDialog(null, 
                    "종료하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
                    /*확인 다이얼로그, parentComponent는 다이얼로그의 부모 컴포넌트로 다이얼로그가 출력되는 영역의 범위 지정
                     YES_NO_OPTION은 예 아니오 두 개의 버튼만 가짐. yes = 0*/

                if(returnValue == JOptionPane.YES_OPTION){
                    System.exit(0);     
                    /* 0을exit()함수에 전달하여 오류없이 성공적으로 종료되었음을 나타냄.
                       1 및 -1과 같은 0이 아닌 상태는 컴파일러에게 오류 또는 메시지와 함께 
                       프로그램을 종료하도록 지시함.*/
                }
            }
        });

        contentPane = getContentPane();
        contentPane.add(bar, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new WannaClose();
    }
}
