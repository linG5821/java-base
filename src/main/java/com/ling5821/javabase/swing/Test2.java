package com.ling5821.javabase.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

/**
 * @author lsj
 * @date 2023-03-22 13:56
 */
public class Test2 implements MouseMotionListener {
    private JFrame frame;

    private JLabel tf;

    public static void main(String[] args) {
//        Test2 test2 = new Test2();
//        test2.go();
        Vector<String> b = new Vector<>();

        int[][] a = {{1,2,3}, {4,5,6}};
        System.out.println(Arrays.deepToString(transposeArray(a)));
        System.out.print(1);
        System.out.print(2);
    }
    public static int[][] transposeArray(int[][] arr) {
        int[][] arr2 = new int[arr[0].length][arr.length];
        for(int i = 0; i < arr[0].length; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr2[i][j] = arr[j][i];
            }
        }
        return arr2;
    }

    public void go() {
        frame = new JFrame("MouseControl");
        Container containerPane = frame.getContentPane();
        containerPane.add(new JLabel("get mouse event"), BorderLayout.NORTH);
        tf = new JLabel();
        containerPane.add(tf, BorderLayout.SOUTH);
        frame.addMouseMotionListener(this);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        tf.setText("Mouse dragging: X = " + e.getX() + " Y = " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        tf.setText("Mouse dragging: X = " + e.getX() + " Y = " + e.getY());
    }
}
