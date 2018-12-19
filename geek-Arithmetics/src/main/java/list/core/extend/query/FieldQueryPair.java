package list.core.extend.query;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-20
 */
public class FieldQueryPair implements QueryPair {

	private String queryField;
	
	private Object queryValue;

	public FieldQueryPair(String queryField, Object queryValue) {
		super();
		this.queryField = queryField;
		this.queryValue = queryValue;
	}

	@Override
	public String getField() {
		return queryField;
	}
	@Override
	public Object getValue() {
		return queryValue;
	}
}
