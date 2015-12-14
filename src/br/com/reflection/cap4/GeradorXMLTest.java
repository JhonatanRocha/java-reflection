package br.com.reflection.cap4;

public class GeradorXMLTest {
	public static void main(String[] args) throws Exception {
		Usuario user = new Usuario("Root", "a1b2c3d4", "dev@developer.com" , "developer", true);
	
		String xml = GeradorXML.getXML(user);
		
		System.out.println(xml);
	}
}
