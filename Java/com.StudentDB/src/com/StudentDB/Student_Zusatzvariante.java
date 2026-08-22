/**
 * 
 */
package com.StudentDB;

import java.util.ArrayList;

/**
 * 
 */
public class Student_Zusatzvariante extends Person {
	private int matnr;
	private StudyProgram studiengang;
	
	private Grade gesamtnote_zusatz = new Grade(0.0f);
	private ArrayList<Grade> einzelnoten_zusatz = new ArrayList<>();

	Student_Zusatzvariante(String fn, String n, int m, StudyProgram s) {
		super(fn, n);
		if((m < 1000000) && (m > 99999)) {
			this.matnr = m;
			this.studiengang = s;
		}
		else {
			System.err.println("Matrikelnummer ist nicht gültig!");
		}
	}
	
	public Grade getFinalGrade_Zusatz(ArrayList<Grade> g) {
		Float tmp = 0.0f;
		if(g.size() > 0) {
			for (Grade f : g) {
				tmp += f.getGrade();
			}
			tmp = tmp/g.size();
			return new Grade(tmp);
		}
		return new Grade(tmp);
	}
	
	public boolean isGradeValid_Zusatz(float f) {
		if (f < 1.0f || f > 5.0f) {
			return false;
		} else {
			return true;
		}
	}
	
	public void addGrade_Zusatz(float f) {
		if(isGradeValid_Zusatz(f)) {
			this.einzelnoten_zusatz.add(new Grade(f));
			this.gesamtnote_zusatz = getFinalGrade_Zusatz(this.einzelnoten_zusatz);
		}
	}
	
	public void print() {
		super.print();
		System.out.println("Matrikelnummer: " + matnr);
		System.out.println("Studiengang: " + studiengang.toString());
		if(Float.compare(gesamtnote_zusatz.getGrade().floatValue(), 0.0f) != 0) {
			System.out.printf("Gesamtnote: %.2f\n", gesamtnote_zusatz.getGrade());
		} else {
			System.out.println("Gesamtnote: -");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//Person person1 = new Person("Max", "Mustermann");

	    Student Eins = new Student("Erster", "Student", 123456, StudyProgram.Computational_Science);
	    Eins.addGrade(1.4f);
	    Eins.addGrade(1.9f);
	    Eins.addGrade(2.0f);
	    Eins.addGrade(1.3f);
	    Eins.addGrade(2.7f);
	    Eins.addGrade(1.6f);
	    Eins.addGrade(3.0f);
	    Eins.print();
	    
	    Eins.addGrade(1.0f);
	    Eins.addGrade(1.0f);
	    Eins.print();
	    
	    Student Zwei = new Student("Karl", "Ernst", 123999, StudyProgram.Mathematics);
	    Zwei.print();
	    
	    Student_Zusatzvariante Drei = new Student_Zusatzvariante("Marcus", "Prinz", 987654, StudyProgram.Physics);
	    Drei.addGrade_Zusatz(1.6f);
	    Drei.addGrade_Zusatz(2.5f);
	    Drei.addGrade_Zusatz(3.1f);
	    Drei.addGrade_Zusatz(1.2f);
	    Drei.addGrade_Zusatz(1.3f);
	    Drei.addGrade_Zusatz(1.1f);
	    Drei.print();
	    
	    Student_Zusatzvariante Vier = new Student_Zusatzvariante("Max", "Mustermann", 111111, StudyProgram.Computational_Science);
	    Vier.print();
	}
}
