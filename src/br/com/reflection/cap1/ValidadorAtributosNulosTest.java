package br.com.reflection.cap1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ValidadorAtributosNulosTest {
	
	@Test
	public void testProduto(){
		Produto produto = new Produto();
		produto.codigo = "";
		produto.preco = 323.35f;
		produto.fornecedor = "Fábrica";
		
		List<String> listaDeAtributos = ValidadorDeAtributosNulos.getAtributosNulos(produto);
		
		assertEquals(2, listaDeAtributos.size());
		assertTrue(listaDeAtributos.contains("descricao"));
		assertTrue(listaDeAtributos.contains("nome"));
	}
	
	@Test
	public void testUsuario(){
		Usuario usuario = new Usuario();
		usuario.ativo = true;
		usuario.email = "user@provedor.com";
		usuario.papel = "admin";
		usuario.login = "root";
		
		List<String> listaDeAtributos = ValidadorDeAtributosNulos.getAtributosNulos(usuario);
		
		assertEquals(1, listaDeAtributos.size());
		assertTrue(listaDeAtributos.contains("senha"));
	}
	
	@Test
	public void testNotaFiscal(){
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.talao = 4;
		notaFiscal.sequencia = 3321;
		
		List<String> listaDeAtributos = ValidadorDeAtributosNulos.getAtributosNulos(notaFiscal);
		
		assertEquals(3, listaDeAtributos.size());
		assertTrue(listaDeAtributos.contains("cnpj"));
		assertTrue(listaDeAtributos.contains("data"));
		assertTrue(listaDeAtributos.contains("endereco"));
	}
}
