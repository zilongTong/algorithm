package designpatterns.visitor.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class NodeB extends AbstractNode implements Node {

	@Override
	public boolean accept(Visitor visitor) {
		visitor.visit(this);
		return true;
	}

}
