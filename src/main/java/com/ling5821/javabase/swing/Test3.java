package com.ling5821.javabase.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author lsj
 * @date 2023-03-22 15:22
 */
public class Test3 {
    public static void main(String[] args) {
        MyWin myWin = new MyWin();
        myWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MyWin extends JFrame {
    String[] buttonTxt = {"ADD", "SUBTRACT", "MULTIPLY", "DIVIDE"};
    JButton[] bList = new JButton[buttonTxt.length];
    JRadioButton rb1, rb2;
    ButtonGroup bg;
    MyWin() {
        setTitle("Test31");
        Container con = getContentPane();
        con.setPreferredSize(new Dimension(600,200));
        con.setLayout(new GridLayout(0,4));
        for(int i=0;i<bList.length;i++){
            bList[i] = new JButton(buttonTxt[i]);
            con.add(bList[i]);
        }
        rb1 =  new JRadioButton("DEC");
        rb2 = new JRadioButton("HEX");
        bg =  new ButtonGroup() ;bg.add(rb1);bg.add(rb2);
        con.add(rb1);con.add(rb2);
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.setMessage("Hello");
        con.add(jOptionPane);
        JDialog jDialog = new JDialog(this, "Hello");
        jDialog.setVisible(true);
        pack();
        setVisible(true);

    }
}
