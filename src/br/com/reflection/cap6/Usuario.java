package br.com.reflection.cap6;

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
	 * No exerc�cio 4 da aula anterior, onde foi criado um m�todo 
	 * que invoca em um objeto todos os m�todos come�ados com �test�, 
	 * que retornam void e n�o possuem par�metros, modifique o c�digo 
	 * para que uma exce��o lan�ada pelo m�todo do objeto invocado com 
	 * reflex�o seja lan�ada tamb�m pelo m�todo criado.
	 */
	
	public void testLogin(){
		throw new RuntimeException("Erro no Teste Login");
	}
	
	public void testSenha(){
		throw new RuntimeException("Erro no Teste Senha");
	}
	
	public void testEmail(){
		throw new RuntimeException("Erro no Teste Email");
	}
	
	public void testPapel(){
		throw new RuntimeException("Erro no Teste Papel");
	}
	
	public void testAtivo(){
		throw new RuntimeException("Erro no Teste Ativo");
	}
}
