package list.core.extend.field;

import java.util.HashMap;
import java.util.Map;

import list.conbain.itfc.IDataArray;
import list.core.extend.container.Container;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-20
 */
public class LongFieldKeyValue implements FieldKeyValue {

	private String key;
	
	private Map<Long, Container> valueMap = new HashMap<Long, Container>();

	public LongFieldKeyValue(String key) {
		super();
		this.key = key;
	}
	
	@Override
	public IDataArray getValueList(Object value) {
		if(value == null) {
			return null;
		}
		Long valueLong = Long.parseLong(value.toString());
		Container container = valueMap.get(valueLong);
		if(container != null) {
			return container.createDataArray();
		}
		return null;
	}
	
	public String toString() {
		return key;
	}
}
