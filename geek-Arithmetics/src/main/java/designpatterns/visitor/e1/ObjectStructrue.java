package designpatterns.visitor.e1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class ObjectStructrue {

	private List<Node> nodes = new ArrayList<>();
	
	public void addNode(Node node) {
		this.nodes.add(node);
	}
	
	public void executeVisitor(Visitor visitor) {
		for(Node node : nodes) {
			node.accept(visitor);
//			visitor.visit(node);
		}
	}
}
