package Chap09;

import java.awt.*;

public class BorderLayoutFrame {
    public static void main(String[] args) {
        
        Frame f = new Frame("BorderLayout Practice");
        f.setSize(500,500);
        f.setLayout(new BorderLayout(5,7));

        Button north = new Button("North");
        Button south = new Button("South");
        Button center = new Button("Center");
        Button west = new Button("West");
        Button east = new Button("East");

        f.add(north, BorderLayout.NORTH);
        f.add(south, BorderLayout.SOUTH);
        f.add(center, BorderLayout.CENTER);
        f.add(east, BorderLayout.EAST);
        f.add(west, BorderLayout.WEST);
        
        f.setVisible(true);
    
    }    
}
