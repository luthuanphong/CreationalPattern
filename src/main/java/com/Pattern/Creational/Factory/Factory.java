package com.Pattern.Creational.Factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.reflections.Reflections;

public class Factory {
	
	private static final HashMap<Class<?>, Set<?>> factoryPool = 
			new HashMap<Class<?>, Set<?>>();
	
	static{
		
		Reflections reflections = new Reflections();
		Set<Class<?>> registryClasses = 
				reflections.getTypesAnnotatedWith(RegistryFactory.class);
		for( Class<?> c : registryClasses ){
			Set<?> childClassessOfRegistryClass = 
					reflections.getSubTypesOf(c);
			factoryPool.put(c, childClassessOfRegistryClass);			
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T get(Class<T> factory , Class<?> product ){
		Set<?> products = factoryPool.get(factory);
		for( Iterator<?> childClass = products.iterator() ; childClass.hasNext(); ){
			Class<?> c = (Class<?>) childClass.next();			
			if( c == product ){
				try {
					return (T) c.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return null;
	}
	
}
