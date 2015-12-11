package br.com.reflection.cap2;

import java.util.List;
import java.util.Map;

public class MapperTest {
	public static void main(String[] args) throws Exception{
		Mapper mapper = new Mapper();
		mapper.load("classes.prop");
		String clazz = "java.util.ArrayList";
		Class<?> randomClass = mapper.getClass(clazz);
		
		System.out.println(mapper.getImplementacao(List.class));
		System.out.println(mapper.getImplementacao(Map.class));		
		System.out.println("Classe que passamos no método: " + clazz + " | Classe retornada: " + randomClass.getName());
	}
}
