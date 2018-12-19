package list.core.extend.query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-20
 */
public class RecommendQuery {

	private List<QueryPair> mustQuerys = new ArrayList<>();
	
	private List<QueryPair> shouldQuerys = new ArrayList<>();
	
	private List<QueryPair> notQuerys = new ArrayList<>();
	
	public RecommendQuery() {
	}
	public void addMustQuery(QueryPair qp) {
		mustQuerys.add(qp);
	}
	public void addNotQuery(QueryPair qp) {
		notQuerys.add(qp);
	}
	public void addShouldQuery(QueryPair qp) {
		shouldQuerys.add(qp);
	}
	public List<QueryPair> getMustQuerys() {
		return mustQuerys;
	}
	public List<QueryPair> getShouldQuerys() {
		return shouldQuerys;
	}
	public List<QueryPair> getNotQuerys() {
		return notQuerys;
	}
}
