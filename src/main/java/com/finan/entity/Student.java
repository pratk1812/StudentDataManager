package com.finan.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"Name","Class","Division","Id","Address","Fee"})
public class Student {

	@JsonProperty(value = "Id")
	private String id;
	@JsonProperty(value = "Name")
	private String name;
	@JsonProperty(value = "Class")
	private String classString;
	@JsonProperty(value = "Division")
	private String division;
	@JsonProperty(value = "Address")
	private String address;
	@JsonProperty(value = "Fee")
	private String fee;
	
	public Student() {
		super();
	}

	public Student(String id, String name, String classString, String division, String address, String fee) {
		super();
		this.id = id;
		this.name = name;
		this.classString = classString;
		this.division = division;
		this.address = address;
		this.fee = fee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassString() {
		return classString;
	}

	public void setClassString(String classString) {
		this.classString = classString;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classString=" + classString + ", division=" + division
				+ ", address=" + address + ", fee=" + fee + "]";
	}
}
