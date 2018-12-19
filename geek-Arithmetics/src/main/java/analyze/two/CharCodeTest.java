package analyze.two;

public class CharCodeTest {
	
	public static void main(String[] args) {
		Character ch = "中".charAt(0);
		System.out.println(String.valueOf(ch).codePointAt(0));
	}
}
