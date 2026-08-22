package com.StudentDB;

import java.util.ArrayList;

public interface TotalGrade {
	public ArrayList<Float> grades = new ArrayList<>();
	Float getFinalGrade(ArrayList<Float> g);
	void addGrade(float f);
	boolean isGradeValid(float f);
}