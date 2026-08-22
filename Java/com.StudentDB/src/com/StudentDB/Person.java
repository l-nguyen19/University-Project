package com.StudentDB;

public class Person {
	private String firstName;
	private String name;
	
	Person(String fn, String n){
		this.firstName = fn;
		this.name = n;
	}
	
	public void print() {
		System.out.println("Name: " + this.firstName + " " + this.name);
	}
}
