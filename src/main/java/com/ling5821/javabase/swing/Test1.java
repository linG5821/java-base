package com.ling5821.javabase.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author lsj
 * @date 2023-03-21 18:22
 */
public class Test1 {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}

class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("Test1");
        setSize(300, 200);
        getContentPane().add(new MyPanel());
        setVisible(true);
    }
}

class MyPanel extends JPanel {
    Image myImg;

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawLine(100, 50, 30, 50);
        g.setColor(Color.RED);
        g.drawRect(100, 50, 100, 46);
    }
}
