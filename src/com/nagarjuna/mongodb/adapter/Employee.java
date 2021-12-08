package com.nagarjuna.mongodb.adapter;

public class Employee {
	
	private String _id;
	private String name;
	private String designation;
	
	public Employee(String _id, String name, String designation) {
		super();
		this.set_id(_id);
		this.name = name;
		this.designation = designation;
	}
	public Employee(){
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}

}
