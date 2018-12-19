package list.cloud.test;

import list.cloud.IDataQuery;
import list.conbain.test.DataCreator;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-20
 */
public class IdQueryTest1 implements IDataQuery {

	@Override
	public Long[] query() {
		
		try {
			Thread.sleep(4500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DataCreator.createLongArray(250);
	}

}
