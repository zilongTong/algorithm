package designpatterns.visitor.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class VisitorA extends AbstractVisitor implements Visitor {

	@Override
	public boolean visit(NodeA node) {
		System.out.println("visitor-A vist Node-A");
		return super.visit(node);
	}

	@Override
	public boolean visit(NodeB node) {
		System.out.println("visitor-A vist Node-B");
		return super.visit(node);
	}

}
