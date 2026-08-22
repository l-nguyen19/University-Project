/**
 * 
 */
package com.HelloWorld;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 */
public class Button3 implements ActionListener{

	JFrame frame = null;
	JButton buttonOne = new JButton("Red");
	JButton buttonTwo = new JButton("Blue");
	JButton buttonThree = new JButton("Green");
	
	public static void main(String[] args) {
		Button3 gui = new Button3();
		gui.los();
		

	}

	private void los() {
		frame = new JFrame("Fenster");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		frame.getContentPane().setBackground(Color.white);
		buttonOne.addActionListener(this);
		buttonTwo.addActionListener(this);
		buttonThree.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(buttonOne);
		panel.add(buttonTwo);
		panel.add(buttonThree);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == buttonOne) {
			frame.getContentPane().setBackground(Color.red);
		}
		if (e.getSource() == buttonTwo) {
			frame.getContentPane().setBackground(Color.blue);
		}
		if (e.getSource() == buttonThree) {
			frame.getContentPane().setBackground(Color.green);
		}
		
		
	}

}
