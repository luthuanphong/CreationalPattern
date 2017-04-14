package com.Pattern.Creational;

import com.Pattern.Creational.Singleton.SingletonRegister;

public class Register extends SingletonRegister  {

	@Override
	protected Class<?>[] register() {
		// TODO Auto-generated method stub
		return new Class[]{ Person.class };
	}
	
	
	
}
