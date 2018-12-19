package list.cloud;
/**
 *
 * @author Smile.Wu
 * @version 2015-7-20
 */
public class QueryRunnable implements Runnable {

	private IDataQuery dataQuery;
	
	//标记此线程是否执行结束
	private boolean ok = false;
	//数据是否已经获取
	private boolean isGot = false;
	
	//结果
	private Long[] array = new Long[0];
	
	public QueryRunnable(IDataQuery dataQuery) {
		super();
		this.dataQuery = dataQuery;
	}

	@Override
	public void run() {
		if(dataQuery != null) {
			array = dataQuery.query();
			ok = true;
		}
	}
	
	public Long[] getArray() {
		isGot = true;
		return array;
	}
	
	public boolean isOk() {
		return ok;
	}

	public boolean isGot() {
		return isGot;
	}
}
