package com.Pattern.Creational;

import org.junit.Assert;
import org.junit.Test;
import com.Pattern.Creational.Singleton.Singleton;



public class SingletonTest  {
	
	@Test
	public void testCase1(){
		
		Person p =  (Person) Singleton.getInstance(Person.class);
		Assert.assertEquals(false , p == null );
	}
	
	@Test
	public void testCase2(){
		Person person1 = (Person) Singleton.getInstance(Person.class);
		Person person2 = (Person) Singleton.getInstance(Person.class);
		Assert.assertEquals(true, person1 == person2 );
	}
	
	@Test
	public void testCase3(){
		Human human1 = (Human) Singleton.getInstance(Human.class);
		Assert.assertEquals(true,human1 == null);
	}
	
	@Test
	public void testCase4(){
		People people = (People) Singleton.getInstance(People.class);
		Assert.assertEquals(false, people == null);
	}
}
