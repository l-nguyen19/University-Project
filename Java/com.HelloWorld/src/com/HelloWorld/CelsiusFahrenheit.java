/**
 * 
 */
package com.HelloWorld;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 */
public class CelsiusFahrenheit {

	JFrame frame2 = null;
	JButton b1;
	JButton b2;
	JTextField tf1;
	JTextField tf2;
	
	public static void main(String[] args) {
		CelsiusFahrenheit gui = new CelsiusFahrenheit();
		gui.window();
		
	}
	
	private void window() {
		frame2 = new JFrame("Temperature calculation");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setBackground(Color.white);
		frame2.setSize(300,200);
		frame2.setLayout(new GridLayout(3, 2, 10, 10));
		
		b1 = new JButton("°C to °F");
		b2 = new JButton("°F to °C");

		
		JLabel cLabel =	new	JLabel("Temperature in °C");
		JLabel fLabel =	new	JLabel("Temperature in °F");
		
		
        tf1 = new JTextField("20", 10);
        tf2 = new JTextField("68", 10);
		
		frame2.getContentPane().add(cLabel);
		frame2.getContentPane().add(tf1);
		frame2.getContentPane().add(fLabel);
		frame2.getContentPane().add(tf2);
		frame2.getContentPane().add(b1);
		frame2.getContentPane().add(b2);
		frame2.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            double celsius = Double.parseDouble(tf1.getText().trim());
		            double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
		            tf2.setText(String.format("%.2f", fahrenheit));
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(frame2,
		                "Bitte eine gültige Zahl eingeben.",
		                "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		b2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            double fahrenheit = Double.parseDouble(tf2.getText().trim());
		            double celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
		            tf1.setText(String.format("%.2f", celsius));
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(frame2,
		                "Bitte eine gültige Zahl eingeben.",
		                "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
	}


}
