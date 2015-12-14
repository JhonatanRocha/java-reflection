package br.com.reflection.cap5;

import java.lang.reflect.Method;

public class UserValidator {
	
	public static boolean validarObjeto(Object obj) throws Exception {
		boolean resultado = true;
		Class<?> clazz = obj.getClass();
		
		for(Method method : clazz.getMethods()){
			if(method.getName().startsWith("isValid") && 
					method.getReturnType() == boolean.class &&
					method.getParameterTypes().length == 0){
				
				Boolean returnValue = (Boolean) method.invoke(obj); 
				resultado = resultado && returnValue.booleanValue();
			}
		}
		return resultado;
	}
	
	/*
	 * Crie um programa que invoque em um 
	 * objeto todos os métodos começados com “test”, 
	 * que retornam void e não possuem parâmetros.
	 */
	
	public static String validarEmptyObjeto(Object obj) throws Exception {
		String returnValue = "";
		Class<?> clazz = obj.getClass();
		
		for(Method method : clazz.getMethods()){
			if(method.getName().startsWith("test") && 
					method.getReturnType() == void.class &&
					method.getParameterTypes().length == 0){
				
				returnValue = (String) method.invoke(obj);
			}
		}
		return returnValue;
	}
}
