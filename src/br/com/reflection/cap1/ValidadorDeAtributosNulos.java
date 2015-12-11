package br.com.reflection.cap1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidadorDeAtributosNulos {
	/*
	public static List<String> getAtributosNulos(Produto produto){
		List<String> listaAtributos = new ArrayList<String>();
		
		if(produto.codigo == null)
			listaAtributos.add("codigo");
		if(produto.nome == null)
			listaAtributos.add("nome");
		if(produto.fornecedor == null)
			listaAtributos.add("fornecedor");
		if(produto.preco == null)
			listaAtributos.add("preco");
		if(produto.descricao == null)
			listaAtributos.add("descricao");
		return listaAtributos;
	}

	public static List<String> getAtributosNulos(Usuario user){
		List<String> listaAtributos = new ArrayList<String>();
		
		if(user.login == null)
			listaAtributos.add("login");
		if(user.senha == null)
			listaAtributos.add("senha");
		if(user.email == null)
			listaAtributos.add("email");
		if(user.papel == null)
			listaAtributos.add("papel");
		if(user.ativo == null)
			listaAtributos.add("ativo");
		return listaAtributos;
	}
	
	public static List<String> getAtributosNulos(NotaFiscal notaFiscal){
		List<String> listaAtributos = new ArrayList<String>();
		
		if(notaFiscal.talao == null)
			listaAtributos.add("talao");
		if(notaFiscal.sequencia == null)
			listaAtributos.add("sequencia");
		if(notaFiscal.data == null)
			listaAtributos.add("data");
		if(notaFiscal.cnpj == null)
			listaAtributos.add("cnpj");
		if(notaFiscal.endereco == null)
			listaAtributos.add("endereco");
		return listaAtributos;
	}*/
	
	/*Buscando campos em 2 classes onde há herança.
	 * A busca é feita na classe pai e na claase filha.
	 * 
	 * public List<Field> findCPMarketingEnriquecidaFields() {
		List<Field> result = new ArrayList<Field>();
		Class<? extends ClassePai> cpClazz = ClasseFilha.class;
		List<Class<? extends ClassePai>> classes = new ArrayList<Class<? extends ClassePai>>();
		
		classes.add(cpClazz);
		
		while(!classes.get(classes.size()-1).equals(ClassePai.class))
			classes.add((Class<? extends ClassePai>) classes.get(classes.size()-1).getSuperclass());
		
		for (int i= classes.size()-1; i >=0; i--) {
			Class<? extends ClassePai> clazz = classes.get(i);
			Field classFields[] = clazz.getDeclaredFields();
			
			for (Field field : classFields){
				result.add(field);
			}
		}
		return result;
	}
	 */
	
	/* Modifique o programa feito para buscar valores nulos, para 
	 * fazer a busca de uma String nos atributos públicos de uma classe.
	 */
	
	public static List<String> getAtributosNulos(Object object) {
		try {
			List<String> listaAtributos = new ArrayList<String>();
			Class<?> classe = object.getClass();
			for (Field field : classe.getFields()) {
				Object value = field.get(object);
				if(value == null)
					listaAtributos.add(field.getName());
			}			
			return listaAtributos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	
	public static String buscaAtributosString(String busca, Object object) {
		try {
			Class<?> classe = object.getClass();
			for (Field field : classe.getFields()) {
				Object value = field.get(object);
				if(value != null){
					if(busca.equals(value.toString())){
						busca = value.toString();
					}
				}
			}			
			return busca;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 	
	}
}
