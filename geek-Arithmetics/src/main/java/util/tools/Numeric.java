package util.tools;

import java.util.regex.Pattern;

public class Numeric {
	private static final Pattern NUMERIC_PATTERN = Pattern.compile("[\\d]+[\\.]{0,1}[\\d]*");
	
	public static boolean is(Object value) {
		return NUMERIC_PATTERN.matcher((String)value).matches();
	}
	
	public static void main(String[] args) {
		
		System.out.println(is("324.02."));
	}
}
