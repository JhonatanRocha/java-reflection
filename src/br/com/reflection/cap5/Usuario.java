package br.com.reflection.cap5;

public class Usuario {

	private String login;
	private String senha;
	private String email;
	private String papel;
	private Boolean ativo;
	
	public Usuario() {

	}

	public Usuario(String login, String senha, String email, String papel,
			Boolean ativo) {
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.papel = papel;
		this.ativo = ativo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean isValidEmail(){
		return this.email.contains("@");
	}
	
	public boolean isValidPassword() {
		return this.senha.length() > 8;
	}
	
	public boolean isValidLogin() {
		return this.login.length() > 5 && this.login.length() < 10 ;
	}
	
	/*
	 * Crie um programa que invoque em um 
	 * objeto todos os métodos começados com “test”, 
	 * que retornam void e não possuem parâmetros.
	 */
	public void testLogin(){

	}
	
	public void testSenha(){

	}
	
	public void testEmail(){

	}
	
	public void testPapel(){

	}
	
	public void testAtivo(){

	}
}
