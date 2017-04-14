package com.Pattern.Creational;

import org.junit.Assert;
import org.junit.Test;
import com.Pattern.Creational.Singleton.Singleton;



public class SingletonTest  {
	
	@Test
	public void testSuccess(){
		
		Person p =  (Person) Singleton.getInstance(Person.class);
		Assert.assertEquals("Im Person", p.say() );
	}
	
	public void testIsSingleton(){
		
	}
	
}
