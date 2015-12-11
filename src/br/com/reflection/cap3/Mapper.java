package br.com.reflection.cap3;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapper {
	
	private Map<Class<?>,Class<?>> mapa = new HashMap<>();
	
	public void load(String nomeArquivo) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream(nomeArquivo));
		
		for(Object key : properties.keySet()){
			Class<?> interf = Class.forName(key.toString());
			Class<?> implementacao = Class.forName(properties.get(key).toString());
			if(!interf.isInterface()){
				throw new RuntimeException("O tipo " + interf.getName() + " não é uma interface.");
			}
			if(!interf.isAssignableFrom(implementacao)){
				throw new RuntimeException("A classe " + implementacao.getName() + " não implementa " + interf.getName());
			}
			mapa.put(interf, implementacao);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf) {
		return mapa.get(interf);
	}
	
	public Class<?> getClass(String className) throws Exception {
		Class<?> clazz = Class.forName(className);
		return clazz;
	}
	
	public Object instancia(Class<?> interf) throws Exception {
		Class<?> implementacao = mapa.get(interf);
		return implementacao.newInstance();
	}
	
	public <E> E instanciaSemCasting(Class<E> interf) throws Exception {
		Class<?> implementacao = mapa.get(interf);
		return (E) implementacao.newInstance();
	}
	
	public <E> E instanciaSemCasting(Class<E> interf, Object... parametros) throws Exception {
		Class<?> implementacao = mapa.get(interf);
		Class<?>[] tiposDoConstrutor = new Class<?>[parametros.length];
		
		for (int i = 0; i < tiposDoConstrutor.length; i++) {
			tiposDoConstrutor[i] = parametros[i].getClass();
		}
		
		Constructor<?> constructor = implementacao.getConstructor(tiposDoConstrutor);
		return (E) constructor.newInstance(parametros);
	}
}
