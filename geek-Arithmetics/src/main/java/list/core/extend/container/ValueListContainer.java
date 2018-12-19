package list.core.extend.container;

import java.util.List;

import list.conbain.itfc.IDataArray;
import list.core.extend.field.FieldDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-20
 */
public class ValueListContainer extends AbstractContainer {
	
	private Long[] array;

	public ValueListContainer(List<Long> ids) {
		array = ids.toArray(new Long[ids.size()]);
	}

	@Override
	public IDataArray createDataArray() {
		
		return new FieldDataArray(array);
	}

}
