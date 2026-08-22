package com.StudentDB;

public class Grade {
	private Float grade;
	
	Grade(float f){
		if ((f*10) <= 50 && (f*10 >= 10)) {
			grade = uniRound(f);
		} else if (f == 0.0f) {
			grade = f;
		} else {
			System.err.println("ung+ötige Eingave für Grade : " + f);
			grade = null;
		}
	}
	
	public Float getGrade() {
		return grade;
	}
	
	public void setGrade(float f) {
		if ((f*10) <= 50 && (f*10 >=10)){
			this.grade = uniRound(f);
		} else {
			this.grade = null;
			System.err.println("(setGrade) Ungültige Eingave für Grade : " + f);
		}
	}
	
	public float uniRound(float f) {
		if (f <= 1.0f) {
			return 0.0f;
		} else if ((f >= 1.0f) && (f <= 1.15f)) {
			return 1.0f;
		} else if ((f > 1.15f) && (f <= 1.5f)) {
			return 1.3f;
		} else if ((f > 1.5f) && (f <= 1.85f)) {
			return 1.7f;
		} else if ((f > 1.85f) && (f <= 2.15f)) {
			return 2.0f;
		} else if ((f > 2.15f) && (f <= 2.5f)) {
			return 2.3f;
		} else if ((f > 2.5f) && (f <= 2.85f)) {
			return 2.7f;
		} else if ((f > 2.85f) && (f <= 3.15f)) {
			return 3.0f;
		} else if ((f > 3.15f) && (f <= 3.5f)) {
			return 3.3f;
		} else if ((f > 3.5f) && (f <= 3.85f)) {
			return 3.7f;
		} else if ((f > 3.85f) && (f <= 4.5f)) {
			return 4.0f;
		} else if (f > 4.5f) {
			return 5.0f;
		} else {
			return 0.0f;
		}
	}
	
}
