package br.com.reflection.cap1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ValidadorAtributosNulosTest {
	
	@Test
	public void testProduto(){
		Produto produto = new Produto();
		produto.codigo = "a1b2c3d4";
		produto.preco = 323.35f;
		produto.fornecedor = "Fábrica";
		
		List<String> listaDeAtributos = ValidadorDeAtributosNulos.getAtributosNulos(produto);
		String buscarAtributo = ValidadorDeAtributosNulos.buscaAtributosString("Fábrica", produto);
		String buscarAtributo2 = ValidadorDeAtributosNulos.buscaAtributosString("a1b2c3d4", produto);

		
		assertEquals(2, listaDeAtributos.size());
		assertEquals("Fábrica", buscarAtributo);
		assertEquals("a1b2c3d4", buscarAtributo2);
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
		String buscarAtributo = ValidadorDeAtributosNulos.buscaAtributosString("user@provedor.com", usuario);
		String buscarAtributo2 = ValidadorDeAtributosNulos.buscaAtributosString("admin", usuario);
		String buscarAtributo3 = ValidadorDeAtributosNulos.buscaAtributosString("root", usuario);
		
		assertEquals("user@provedor.com", buscarAtributo);
		assertEquals("admin", buscarAtributo2);
		assertEquals("root", buscarAtributo3);
		assertEquals(1, listaDeAtributos.size());
		assertTrue(listaDeAtributos.contains("senha"));
	}
	
	@Test
	public void testNotaFiscal(){
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.talao = 4;
		notaFiscal.sequencia = 3321;
		
		List<String> listaDeAtributos = ValidadorDeAtributosNulos.getAtributosNulos(notaFiscal);
		String buscarAtributo = ValidadorDeAtributosNulos.buscaAtributosString("4", notaFiscal);

		assertEquals("4", buscarAtributo);
		assertEquals(3, listaDeAtributos.size());
		assertTrue(listaDeAtributos.contains("cnpj"));
		assertTrue(listaDeAtributos.contains("data"));
		assertTrue(listaDeAtributos.contains("endereco"));
	}
}
