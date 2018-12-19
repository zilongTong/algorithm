package designpatterns.visitor.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class NodeA extends AbstractNode implements Node {

	@Override
	public boolean accept(Visitor visitor) {
		System.out.println("\t every visitor must buy ticket befor visiting NodeA!");
		visitor.visit(this);
		System.out.println("\t every visitor must return ticket after visiting NodeA!");
		return true;
	}
	
}
