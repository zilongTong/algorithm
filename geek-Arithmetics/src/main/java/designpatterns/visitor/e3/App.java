package designpatterns.visitor.e3;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class App {

	public static void main(String[] args) {
		Run1 run1 = new Run1();
		
		Object s1 = new String("1234");
		Object i1 = 1234;
		run1.t(s1);
		run1.t(i1);
	}
}
