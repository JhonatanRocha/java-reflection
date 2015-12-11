package br.com.reflection.cap3;

import java.util.List;
import java.util.Map;

public class MapperTest {
	public static void main(String[] args) throws Exception{
		Mapper mapper = new Mapper();
		mapper.load("classes.prop");
		String clazz = "java.util.ArrayList";
		Class<?> randomClass = mapper.getClass(clazz);
		
		List lista = (List) mapper.instancia(List.class);
		List lista2 = mapper.instanciaSemCasting(List.class);
		InterfaceExemplo interfaceExemplo = mapper.instanciaSemCasting(InterfaceExemplo.class, "test");
			
		System.out.println(interfaceExemplo.getClass());
		System.out.println(lista.getClass());
		System.out.println(mapper.getImplementacao(List.class));
		System.out.println(mapper.getImplementacao(Map.class));		
		System.out.println("Classe que passamos no método: " + clazz + " | Classe retornada: " + randomClass.getName());
	}
}
