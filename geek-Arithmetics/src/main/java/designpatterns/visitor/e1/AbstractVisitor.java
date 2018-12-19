package designpatterns.visitor.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class AbstractVisitor implements Visitor {

	@Override
	public boolean visit(NodeA node) {
		return false;
	}

	@Override
	public boolean visit(NodeB node) {
		System.out.println("\t node-B must be clean after visited by all visitors");
		return false;
	}

}
