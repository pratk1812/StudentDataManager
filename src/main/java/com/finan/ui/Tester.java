package com.finan.ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.finan.entity.Student;
import com.finan.entity.StudentList;
import com.finan.myutil.Format;

public class Tester {
	
	private static final Logger logger = LogManager.getLogger(Tester.class);
	
	private static final String InputFilePath = "src\\main\\java\\com\\finan\\resources\\student.json";
	private static final String OutputFilePath = "src\\main\\java\\com\\finan\\ui\\student.txt";
	
	@SuppressWarnings("unused")
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
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private static List<Student> readStudents(){
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        
        try {
        	StudentList studentList = mapper.readValue(new File(InputFilePath), StudentList.class);
        	studentList.getStudents().forEach(x->logger.info(x));
			return studentList.getStudents();
		} catch (IOException e) {
			logger.error(e);		
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
					logger.error(e);
				}
			});
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public static void main(String[] args) throws IOException {
		
		List<Student> students = readStudents();
		
		writeStudents(students);
		
	}

}
