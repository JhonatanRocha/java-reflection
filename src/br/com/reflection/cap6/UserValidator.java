package br.com.reflection.cap6;

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
	 * No exerc�cio 4 da aula anterior, onde foi criado um m�todo 
	 * que invoca em um objeto todos os m�todos come�ados com �test�, 
	 * que retornam void e n�o possuem par�metros, modifique o c�digo 
	 * para que uma exce��o lan�ada pelo m�todo do objeto invocado com 
	 * reflex�o seja lan�ada tamb�m pelo m�todo criado.
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
