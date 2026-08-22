/**
 * 
 */
package com.StudentDB;

import java.util.ArrayList;


public class Student extends Person implements TotalGrade {
	private int matnr;
	private StudyProgram studiengang;
	private Float totalGrade;
	private ArrayList<Float> grades = new ArrayList<>();
	
	Student(String fn, String n, int m, StudyProgram s){
		super(fn, n); //super: ruft parent Construktor mit einen Argumenten auf, hier Person()
		if((m < 1000000) && (m > 99999)) {
			this.matnr = m;
			this.studiengang = s;
		}
		else {
			System.err.println("Matrikelnummer ist nicht gültig!");
		}
	}
	
	public Float getFinalGrade(ArrayList<Float>g) {
		Float tmp = (float) 0;
		if(g.size() > 0) {
			for(Float f : g) {
				tmp += f;
			}
			tmp = tmp / g.size();
			return tmp;
		}
		return tmp;
	}
	
	public boolean isGradeValid(float f) {
		if (f < 1.0f || f > 5.0f ) {
			return false;
		} else {
			return true;
		}
	}
	
	public void addGrade(float f) {
		if (isGradeValid(f)) {
			this.grades.add((float)f);
			this.totalGrade = getFinalGrade(this.grades);
		}
	}
	
	public void print() {
		super.print(); // ruft Methode von Elternklasse Person auf
		System.out.println("Matrikelnummer: " + matnr);
		System.out.println("Studiengang: " + studiengang.toString());
		if(this.totalGrade == null) {
			System.out.println("Total Grade: -");
		}else if(Float.compare(totalGrade, 0.0f) != 0) {
			System.out.printf("Total grade: %.2f%n", totalGrade);
		}	
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
