package com.pojodoc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public class SolrAnotationTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, SecurityException, NoSuchMethodException {
		TestPojo pojo = new TestPojo();
		
		Class<?> clazz = pojo.getClass();
		
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			SolrInputDocumentField documentField = field.getAnnotation(SolrInputDocumentField.class);
			if(documentField != null) {
				boolean fieldAccess = field.isAccessible();
				field.setAccessible(true);
				String docField = documentField.field();

				Object value = field.get(pojo);
				float boost = documentField.boost();

				Class<?> fieldClass = field.getType();
				
				System.out.println(fieldClass);
				
				String simpleName = fieldClass.getSimpleName();
				if(simpleName.endsWith("List") || simpleName.endsWith("Set")) {
					@SuppressWarnings("unchecked")
					Collection<Object> list = (Collection<Object>) value;
					for(Object o : list) {
						System.out.println(docField + " : " + o + " " + boost);
					}
				} else {
					System.out.println(docField + " : " + value + " " + boost);
				}
				
				System.out.println();
				field.setAccessible(fieldAccess);
			}
		}
	}
}
