package br.com.reflection.cap1;

import java.util.ArrayList;
import java.util.List;

public class ValidadorDeAtributosNulos {
	
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
	}
}
