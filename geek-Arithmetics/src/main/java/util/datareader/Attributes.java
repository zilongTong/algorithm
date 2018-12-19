package util.datareader;

import util.bean.Attribute;

public class Attributes {
	public static boolean isAllValueNumeric(Attribute[] attributes) {
		for(Attribute attr : attributes) {
			if(!attr.isValueNumeric()) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isAllValueText(Attribute[] attributes) {
		for(Attribute attr : attributes) {
			if(!attr.isValueText()) {
				return false;
			}
		}
		return true;
	}
	
	public static String[] getNames(Attribute[] attributes) {
		int len = attributes.length;
		String[] names = new String[len];
		for(int i = 0; i < len; i ++) {
			names[i] = attributes[i].get_name();
		}
		return names;
	}
	
	public static String[] getTextValues(Attribute[] attributes) {
		int len = attributes.length;
		String[] textValues = new String[len];
		for(int i = 0; i < len; i ++) {
			Attribute attr = attributes[i];
			if(attr.isValueText()) {
				textValues[i] = attr.getTextValue();
			} else {
				throw new RuntimeException("error value. " + attr.toString());
			}
		}
		return textValues;
	}
	
	public static double[] getNumericValues(Attribute[] attributes) {
		int len = attributes.length;
		double[] numericValues = new double[len];
		for(int i = 0; i < len; i ++) {
			Attribute attr = attributes[i];
			if(attr.isValueNumeric()) {
				numericValues[i] = attr.getNumericValue();
			} else {
				throw new RuntimeException("error value. " + attr.toString());
			}
		}
		return numericValues;
	}
	
	public static Attribute[] createAttributes(String[] values) {
		int len = values.length;
		Attribute[] attributes = new Attribute[len];
		for(int i = 0; i < len; i ++) {
			String attrName = nameIt(i);
			attributes[i] = new Attribute(attrName, values[i]);
		}
		return attributes;
	}
	
	public static Attribute[] createAttributes(double[] values) {
		int len = values.length;
		Attribute[] attributes = new Attribute[len];
		for(int i = 0; i < len; i ++) {
			String attrName = nameIt(i);
			attributes[i] = new Attribute(attrName, values[i]);
		}
		return attributes;
	}
	
	private static String DEFAULT_ATTR_NAME = "attribute_";
	
	private static String nameIt(int i ) {
		return DEFAULT_ATTR_NAME + i;
	}

}
