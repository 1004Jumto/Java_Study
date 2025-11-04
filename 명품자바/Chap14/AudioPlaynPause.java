package Chap14;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;   //디지털 오디오를 다루는 자바 클래스와 인터페이스 제공

public class AudioPlaynPause extends JFrame {
    private Container c;
    private Clip clip;  //오디오를 원할때 재생하거나 중단할 수 있음
    private JLabel label;

    public AudioPlaynPause() {
        setTitle("오디오 재생 중단 연습");
        setSize(300,200);
        setVisible(true);

        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.CENTER);

        c = getContentPane();
        c.add(label, BorderLayout.CENTER);
        c.addMouseListener(new MyMouseAdapter());   //화면에 마우스 올라가면 재생되는 이벤트

        //오디오 재생 준비
        audio("C:\\Users\\이예진\\Downloads\\과제곡 (online-audio-converter.com).wav");
    }
    
    private void audio(String path) {

        try {
            //audiosystem 클래스의 static 메소드 getClip()
            clip = AudioSystem.getClip();                   //오디오 재생 전에 데이터를 미리 로딩해두고 제어
            File audioFile = new File(path);                //오디오 파일 경로명
            
            //오디오 입력 스트림은 오디오의 형식 및 길이가 가리키는 입력 스트림
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);      //스트림 객체 생성
            clip.open(audioStream);                         //오디오 클립과 스트림 연결(재생할 오디오 스트림 열기)
            } 
        catch (LineUnavailableException e){ e.printStackTrace();}
        catch (UnsupportedAudioFileException e) { e.printStackTrace(); } 
        catch (IOException e) { e.printStackTrace(); }
    }

    //화면에 마우스 올라가면 재생되는 이벤트
    private class MyMouseAdapter extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            clip.start();
            label.setText("노래 재생");
            
        }
        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            clip.stop();
            label.setText("노래 일시 중지");
        }
    }

    public static void main(String[] args) {
        new AudioPlaynPause();
    }
}
