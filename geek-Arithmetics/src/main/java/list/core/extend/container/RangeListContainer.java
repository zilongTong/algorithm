package list.core.extend.container;

import list.conbain.itfc.IDataArray;
import list.core.extend.field.FieldDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-20
 */
public class RangeListContainer extends AbstractContainer {
	
	private Long[] array;

	@Override
	public IDataArray createDataArray() {
		
		return new FieldDataArray(array);
	}

}
