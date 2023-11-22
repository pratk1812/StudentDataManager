package com.finan.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentList {

	@JsonProperty("StudentList")
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
