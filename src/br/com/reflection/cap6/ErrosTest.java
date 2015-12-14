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
		 * Irá gerar NoSuchMethodException,
		 * pois não existe o método com o nome "metodo"
		 * com a assinatura vazia, precisa passar o tipo
		 * do parâmetro, que no caso é uma String
		 * 
		 * Method method = clazz.getMethod("metodo");
		 * 
		 * 
		 * Irá gerar o IllegalArgumentException,
		 * pois para invocarmos o método através
		 * do objeto passado, precisamos passar um
		 * valor do tipo que o método tem na sua
		 * assinatura
		 * 
		 * method.invoke(objeto);
		 * 
		 * 
		 * Irá gerar o IllegalAccessException,
		 * pois o método tem o modificador como "private".
		 * "getDeclaredMethod" só funciona para os todos os
		 * modificadores quando é chamado na propria classe.
		 * 
		 * Method method = clazz.getDeclaredMethod("metodo", String.class);
		 * 
		 * 
		 * InvocationTargetException, é uma exception onde
		 * genérica que encapsula a exception original que
		 * pode ter sido causada na classe onde foi chamada.
		 * Para pegar a exception "verdadeira", devemos pegar
		 * ela atraves do método getTargetException().
		 */
	}
}
