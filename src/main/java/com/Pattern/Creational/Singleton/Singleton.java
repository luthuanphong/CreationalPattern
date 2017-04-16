package com.Pattern.Creational.Singleton;

import java.util.HashMap;
import java.util.Set;
import org.reflections.Reflections;


public class Singleton {
	
	private static final HashMap<Class<?>,Object> objectPool = new HashMap<Class<?>, Object>();
	//Initialize Singleton Classes from register class
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
				e.printStackTrace();
			}
		}
		
	}
	
	//Initialize Singleton Classes from annotation
	static{
		Reflections reflections = new Reflections();
		Set<Class<?>> annotationRegisterClasses = 
				reflections.getTypesAnnotatedWith(RegistySingleton.class);
		for( Class<?> c : annotationRegisterClasses ){
			try {
				objectPool.put(c, c.newInstance());
			} catch ( Exception e) {				
				e.printStackTrace();
			}
		}
	}
	
	
	public static Object getInstance(Class<?> c){
		try{
			if( !objectPool.containsKey(c)){
				throw new Exception("Class no registe Singleton.");
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return objectPool.get(c);
	}
	
}
