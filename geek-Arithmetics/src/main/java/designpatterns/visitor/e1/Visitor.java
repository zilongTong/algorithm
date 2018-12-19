package designpatterns.visitor.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public interface Visitor {

	public boolean visit(NodeA node);
	
	public boolean visit(NodeB node);
}
