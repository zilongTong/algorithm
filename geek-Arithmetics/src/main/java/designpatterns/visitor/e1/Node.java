package designpatterns.visitor.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public interface Node {

	public boolean accept(Visitor visitor);
}
