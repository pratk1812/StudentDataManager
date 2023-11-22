package com.finan.ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.finan.entity.Format;
import com.finan.entity.Student;
import com.finan.entity.StudentList;

public class Tester {
	
	private static final String InputFilePath = "src\\main\\java\\com\\finan\\resources\\student.json";
	private static final String OutputFilePath = "src\\main\\java\\com\\finan\\resources\\student.txt";
	
	private static void prepJson() {
		List<Student> students2 = new ArrayList<>();
		//id, name, class, division, address, fee
		students2.add(new Student("101", "Marshall Erikson","10" , "A", "Vikhroli, 400079", "5000000"));
		students2.add(new Student("102", "Lily Aldrin","9" , "B", "Ghansoli,40070-1572", "100000"));
		students2.add(new Student("103", "Joy Stinson","8" , "C", "Thane,40008-0122", "75000"));
		students2.add(new Student("104", "Ted Mosby","4" , "A", "Airoli,34125", "82000"));
		students2.add(new Student("105", "Nancy Wheeler","5" , "D", "Nashik,29520-2335", "52000"));
		StudentList studentList = new StudentList();
		studentList.setStudents(students2);
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			mapper.writeValue(new File(InputFilePath), studentList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static List<Student> readStudents(){
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        
        try {
        	StudentList studentList = mapper.readValue(new File(InputFilePath), StudentList.class);
        	System.out.println("-----");
        	studentList.getStudents().forEach(System.out::println);
			return studentList.getStudents();
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void writeStudents(List<Student> students) {
		try(
				FileWriter fileWriter = new FileWriter(new File(OutputFilePath))){
			students.forEach(student->{
				try {
					fileWriter.write(Format.entityString(student));
					fileWriter.write(System.lineSeparator());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
		List<Student> students = readStudents();
		
		writeStudents(students);
		
	}

}
