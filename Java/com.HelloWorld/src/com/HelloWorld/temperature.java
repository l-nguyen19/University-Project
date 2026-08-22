package com.HelloWorld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class temperature {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Geben Sie eine Temperatur in Celsius an: ");
		try (Scanner scan = new Scanner(System.in)) {
			double c = scan.nextDouble();
			double f = (1.8*c)+32;
			System.out.println("Temperatur in Celsius: " + c);
			System.out.print("Temperatur in Fahrenheit: " + f);
		} catch (InputMismatchException e) {
			System.err.println("Keine gültige Zahl eingegeben!");
		}
		
		
	}
}
