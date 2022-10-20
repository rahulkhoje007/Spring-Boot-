package com.amva.restapiclient.entity;

public class ClientEntity {
	
	private String name;
	private String salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "ClientEntity [name=" + name + ", salary=" + salary + "]";
	}
	
	

}
