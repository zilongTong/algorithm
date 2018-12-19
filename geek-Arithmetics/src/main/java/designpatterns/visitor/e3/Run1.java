package designpatterns.visitor.e3;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class Run1 {

	public void t(String t) {
		System.out.println("String : " + t);
	}
	public void t(int t) {
		System.out.println("Integer : " + t);
	}
	public void t(Object t) {
		System.out.println("Object : " + t);
	}
}
