package br.com.reflection.cap5;

public class UsuarioTest {
	public static void main(String[] args) throws Exception {
		Usuario user = new Usuario("RootToomuchBig", "a1b2c3d4e5", "dev@developer.com" , "developer", true);
		
		boolean isValidObject = UserValidator.validarObjeto(user);
		if(isValidObject)
			System.out.println("O objecto do usu�rio � valido.");
		else
			System.out.println("O objecto do usu�rio n�o � valido!");
		
		/*
		 * Crie um programa que invoque em um 
		 * objeto todos os m�todos come�ados com �test�, 
		 * que retornam void e n�o possuem par�metros.
		 */
		
		Usuario user2 = new Usuario();
		String isEmptyObject = UserValidator.validarEmptyObjeto(user2);
		if(isEmptyObject == null)
			System.out.println("O bean foi criado vazio.");
		else
			System.out.println("O bean n�o est� vazio!");
		
	}
}
