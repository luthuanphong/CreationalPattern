package com.Pattern.Creational.Singleton;

import java.util.HashMap;
import java.util.Set;
import org.reflections.Reflections;


public class Singleton {
	
	private static final HashMap<Class<?>,Object> objectPool = new HashMap<Class<?>, Object>();
	
	static{
		
		Reflections reflections = new Reflections();
		Set<Class< ? extends SingletonRegister >> registerClasses = 
				reflections.getSubTypesOf(SingletonRegister.class);
		
		for( Class<? extends SingletonRegister> c : registerClasses ){
			try {
				SingletonRegister register = c.newInstance(); 
				Class<?> []singletonClasses = register.register();
				for( Class<?> singletonClass : singletonClasses){
					objectPool.put(singletonClass, singletonClass.newInstance());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static Object getInstance(Class<?> c){
		return objectPool.get(c);
	}
	
}
