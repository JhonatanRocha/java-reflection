package br.com.reflection.cap5;

public class UsuarioTest {
	public static void main(String[] args) throws Exception {
		Usuario user = new Usuario("RootToomuchBig", "a1b2c3d4e5", "dev@developer.com" , "developer", true);
		
		boolean isValidObject = UserValidator.validarObjeto(user);
		if(isValidObject)
			System.out.println("O objecto do usuário é valido.");
		else
			System.out.println("O objecto do usuário não é valido!");
		
		/*
		 * Crie um programa que invoque em um 
		 * objeto todos os métodos começados com “test”, 
		 * que retornam void e não possuem parâmetros.
		 */
		
		Usuario user2 = new Usuario();
		String isEmptyObject = UserValidator.validarEmptyObjeto(user2);
		if(isEmptyObject == null)
			System.out.println("O bean foi criado vazio.");
		else
			System.out.println("O bean não está vazio!");
		
	}
}
