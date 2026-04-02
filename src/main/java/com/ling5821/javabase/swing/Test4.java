package com.ling5821.javabase.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author linG
 * @date 2023-04-03 23:13
 */
public class Test4 extends JFrame implements ItemListener {

    JTextArea text;
    JCheckBox[] box;
    String[] boxName = {"张三", "李四", "王五"};

    public static void main(String[] args) {
        new Test4("Hello");
    }

    public Test4(String title) throws HeadlessException {
        super(title);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));
        setLocation(100, 100);
        JPanel panel = new JPanel();
        text = new JTextArea();
        int len = boxName.length;
        panel.setLayout(new GridLayout(len, 1));
        box = new JCheckBox[len];
        for (int i = 0; i < len; i++) {
            box[i] = new JCheckBox(boxName[i], false);
            box[i].addItemListener(this);
            panel.add(box[i]);
        }
        contentPane.add(panel);
        contentPane.add(text);
        pack();
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < box.length; i++) {
            if (box[i].isSelected()) {
                text.append(boxName[i] + "被选中\n");
            } else {
                text.append(boxName[i] + "没有被选中\n");
            }
        }
    }
}
