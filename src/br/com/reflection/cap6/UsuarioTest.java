package br.com.reflection.cap6;

import java.lang.reflect.InvocationTargetException;

public class UsuarioTest {
	public static void main(String[] args) throws Exception {
		
		/* 
		 * No exerc�cio 4 da aula anterior, onde foi criado um m�todo 
		 * que invoca em um objeto todos os m�todos come�ados com �test�, 
		 * que retornam void e n�o possuem par�metros, modifique o c�digo 
		 * para que uma exce��o lan�ada pelo m�todo do objeto invocado com 
		 * reflex�o seja lan�ada tamb�m pelo m�todo criado.
		 */
		
		Usuario user2 = new Usuario();
		String isEmptyObject;
		
		try {
			isEmptyObject = UserValidator.validarEmptyObjeto(user2);
			
			if(isEmptyObject == null)
				System.out.println("O bean foi criado vazio.");
			else
				System.out.println("O bean n�o est� vazio!");
		} catch (InvocationTargetException ite) {
			ite.getTargetException().printStackTrace();
		}
	}
}
