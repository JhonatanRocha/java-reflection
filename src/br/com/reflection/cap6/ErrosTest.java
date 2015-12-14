package br.com.reflection.cap6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ErrosTest {
	public static void main(String[] args) throws Exception {
		Erros objeto = new Erros();
		Class clazz = objeto.getClass();
		
		try {
			Method method = clazz.getDeclaredMethod("metodo", String.class);
			method.invoke(objeto, "teste");
		} catch (InvocationTargetException ite) {
			ite.getTargetException().printStackTrace();
		}
		
		/*
		 * Ir� gerar NoSuchMethodException,
		 * pois n�o existe o m�todo com o nome "metodo"
		 * com a assinatura vazia, precisa passar o tipo
		 * do par�metro, que no caso � uma String
		 * 
		 * Method method = clazz.getMethod("metodo");
		 * 
		 * 
		 * Ir� gerar o IllegalArgumentException,
		 * pois para invocarmos o m�todo atrav�s
		 * do objeto passado, precisamos passar um
		 * valor do tipo que o m�todo tem na sua
		 * assinatura
		 * 
		 * method.invoke(objeto);
		 * 
		 * 
		 * Ir� gerar o IllegalAccessException,
		 * pois o m�todo tem o modificador como "private".
		 * "getDeclaredMethod" s� funciona para os todos os
		 * modificadores quando � chamado na propria classe.
		 * 
		 * Method method = clazz.getDeclaredMethod("metodo", String.class);
		 * 
		 * 
		 * InvocationTargetException, � uma exception onde
		 * gen�rica que encapsula a exception original que
		 * pode ter sido causada na classe onde foi chamada.
		 * Para pegar a exception "verdadeira", devemos pegar
		 * ela atraves do m�todo getTargetException().
		 */
	}
}
