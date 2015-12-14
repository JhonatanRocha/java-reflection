package br.com.reflection.cap4;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GeradorXML {
	
	public static String getXML(Object obj) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		
		Class<?> clazz = obj.getClass();
		stringBuilder.append("<"+ clazz.getSimpleName() + ">\n");
		
		for (Field field : clazz.getDeclaredFields()) {
			stringBuilder.append("<"+ field.getName() + ">");
			/*
			 *Esta linha permite que os atributos 
			 * declarados como private, sejam
			 * acessado através da reflexão
			 */
			field.setAccessible(true);
			stringBuilder.append(field.get(obj));
			stringBuilder.append("</"+ field.getName() + ">\n");
		}
		stringBuilder.append("</"+ clazz.getSimpleName() + ">\n");
	
		return stringBuilder.toString();
	}

	public static Map<String,Object> getFieldMap(Object object) throws Exception{
        Map<String,Object> objectMap = new HashMap<>();
        Class<?> clazz = object.getClass();
        for(Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            objectMap.put(field.getName(), field.get(object));
        }
        return objectMap;
    }
}
