package br.com.reflection.cap3;

import java.lang.reflect.Constructor;
import java.util.Map;

public class MapaClasses {
	
	private Map<String, String> mapa;

	public Class<?> getClass(String chave) throws Exception {
		String valor = mapa.get(chave);
		if (valor != null) {
			return Class.forName(valor);
		} else {
			throw new RuntimeException("Chave inv�lida");
		}
	}
	
	/*
	 * Considere a classe MapaDeClasses criada no exerc�cio da ultima aula. 
	 * Adicione um m�todo Object getObject(String) que cria e retorna um 
	 * objeto da classe relativa a chave passada como valor no mapa.
	 */
	
	public Object getObject(String chave) throws Exception {
		return getClass(chave).newInstance();
	}
	
	
	/*
	 * Considere a classe MapaDeClasses criada no exerc�cio anterior. 
	 * Adicione um m�todo Object getObject(String, Object[]) que cria e 
	 * retorna um objeto da classe relativa a chave passada como valor no 
	 * mapa utilizando um construtor compat�vel com os par�metros.
	 */
	
	public Object getObject(String chave, Object... parametros) throws Exception {
		Class<?>[] tiposDoConstrutor = new Class<?>[parametros.length];
		
		for (int i = 0; i < tiposDoConstrutor.length; i++) {
			tiposDoConstrutor[i] = parametros[i].getClass();
		}
		
		return getClass(chave).getConstructor(tiposDoConstrutor).newInstance(parametros);
	}
}
