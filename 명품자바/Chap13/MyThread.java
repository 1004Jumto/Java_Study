package Chap13;

public class MyThread extends Thread{
    
    CircleMoving panel;
    
    MyThread(CircleMoving p){
        panel = p;
    }

    @Override
    public void run() {
        while(true){
            try {
                sleep(500);
                panel.repaint();
            } catch (InterruptedException e) {
                return;
            }

        }

    }
}


