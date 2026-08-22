package com.HelloWorld;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NumClicks implements ActionListener {

    JFrame frame1 = null;
    JButton b = new JButton("anklicken zum zählen");
    JTextArea textArea;
    int num = 0;

    public static void main(String[] args) {
        NumClicks gui = new NumClicks();
        gui.los1();
    }

    private void los1() {
        frame1 = new JFrame("NumClicks");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 400);

        b.addActionListener(this);

        textArea = new JTextArea(15, 25);
        textArea.setLocation(80,80);
        
        JPanel panel = new JPanel();

        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(
        		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(
        		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame1.getContentPane().add(BorderLayout.CENTER, panel);
        frame1.getContentPane().add(BorderLayout.SOUTH, b);
        
        panel.add(scroller);
        frame1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == b) {
    		num++;
    		textArea.append("Button wurde angeklickt: " + num + "\n");
		}
        
    }
}
