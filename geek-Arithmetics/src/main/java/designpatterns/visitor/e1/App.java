package designpatterns.visitor.e1;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class App {

	public static void main(String[] args) {
		Visitor visitorA = new VisitorA();
		Visitor visitorB = new VisitorB();
		
		Node nodeA = new NodeA();
		Node nodeB = new NodeB();
		
		ObjectStructrue structrue = new ObjectStructrue();
		
		structrue.addNode(nodeA);
		structrue.addNode(nodeB);
		
		structrue.executeVisitor(visitorA);
		System.out.println();
		structrue.executeVisitor(visitorB);
		System.out.println();
		structrue.executeVisitor(new VisitorC());
		
		System.out.println(Long.toBinaryString(Long.MAX_VALUE).length());
	}
}
