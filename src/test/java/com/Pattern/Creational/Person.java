package com.Pattern.Creational;

public class Person {
	
	private String name;
	
	public String say(){
		return "Im"+this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
