package Chap14;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class AudioFilePlay extends JFrame{
    JMenuBar bar;
    JMenu menu;
    JMenuItem play, stop;
    JLabel label;
    JFileChooser fileChooser;
    Container c;
    Clip clip;

    public AudioFilePlay(){
        setTitle("Find AudioFile and Control Playing");
        setSize(500,400);
        setVisible(true);

        //메뉴바, 메뉴, 라벨 생성
        label = new JLabel("오디오 파일을 선택하세요");
        label.setHorizontalAlignment(JLabel.CENTER);

        bar = new JMenuBar();
        menu = new JMenu("Audio");
        play = new JMenuItem("Play");
        stop = new JMenuItem("Stop");

        menu.add(play);
        menu.add(stop);
        bar.add(menu);

        c = getContentPane();
        c.add(bar, BorderLayout.NORTH);
        c.add(label, BorderLayout.CENTER);
        
        play.addActionListener(new MyActionListener());
        stop.addActionListener(new MyActionListener());
    }
    private void playAudio() {
        try {
            //audiosystem 클래스의 static 메소드 getClip()
            clip = AudioSystem.getClip();                   //오디오 재생 전에 데이터를 미리 로딩해두고 제어
            File audioFile = new File(fileChooser.getSelectedFile().getPath());                //오디오 파일 경로명
           
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);      //스트림 객체 생성
            clip.open(audioStream);                         //재생할 오디오 스트림 열기
            } 
        catch (LineUnavailableException e){ e.printStackTrace();}
        catch (UnsupportedAudioFileException e) { e.printStackTrace(); } 
        catch (IOException e) { e.printStackTrace(); }
    }
    
    //play버튼 누르면 파일 다이얼로그 띄우고 선택된 파일 재생
    //종료 누르면 노래 중단
    class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == play){
                fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = 
                        new FileNameExtensionFilter("AudioFiles(wav,au,mid,rmf)", "wav");
                fileChooser.setFileFilter(filter);

                int ret = fileChooser.showOpenDialog(null);
                if(ret == JFileChooser.APPROVE_OPTION){
                    playAudio();        //오디오 재생 준비
                    clip.start();
                    
                    String filePath = fileChooser.getSelectedFile().getPath().toString();
                    label.setText(filePath + "를 연주하고 있습니다");
        
                }
            }
            else{
                clip.stop();
                label.setText("연주가 중단되었습니다.");
            }
        }

        
        
    }
    public static void main(String[] args) {
        new AudioFilePlay();
    }
}

