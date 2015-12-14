package br.com.reflection.cap6;

import java.lang.reflect.InvocationTargetException;

public class UsuarioTest {
	public static void main(String[] args) throws Exception {
		
		/* 
		 * No exercício 4 da aula anterior, onde foi criado um método 
		 * que invoca em um objeto todos os métodos começados com “test”, 
		 * que retornam void e não possuem parâmetros, modifique o código 
		 * para que uma exceção lançada pelo método do objeto invocado com 
		 * reflexão seja lançada também pelo método criado.
		 */
		
		Usuario user2 = new Usuario();
		String isEmptyObject;
		
		try {
			isEmptyObject = UserValidator.validarEmptyObjeto(user2);
			
			if(isEmptyObject == null)
				System.out.println("O bean foi criado vazio.");
			else
				System.out.println("O bean não está vazio!");
		} catch (InvocationTargetException ite) {
			ite.getTargetException().printStackTrace();
		}
	}
}
