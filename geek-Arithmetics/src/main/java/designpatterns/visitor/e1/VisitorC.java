package designpatterns.visitor.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class VisitorC extends AbstractVisitor implements Visitor {

	@Override
	public boolean visit(NodeA node) {
		System.out.println("visitor-C vist Node-A");
		return super.visit(node);
	}
}
