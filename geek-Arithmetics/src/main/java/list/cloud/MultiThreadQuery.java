package list.cloud;

import java.util.ArrayList;
import java.util.List;

import list.conbain.array.DataConjunction;
import list.conbain.array.DataDisjunction;
import list.conbain.array.LongDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-20
 * 多线程数据合并
 */
public class MultiThreadQuery {

	//线程计数器
	private Integer threadCount = -1;
	
	private List<QueryRunnable> querys = new ArrayList<>();
	
	public MultiThreadQuery() {
		threadCount = 0;
	}
	
	public void executeQuery(IDataQuery dataQuery) {
		QueryRunnable runnable = new QueryRunnable(dataQuery);
		querys.add(runnable);
		startRunnable(runnable);
	}
	
	private synchronized void startRunnable(QueryRunnable runnable) {
		threadCount ++;
		new Thread(runnable).start();
	}
	
	private LongDataArray[] waitForAllThread() throws InterruptedException {
		LongDataArray[] arrays = new LongDataArray[querys.size()];
		int index = 0;
		while(threadCount > 0) {
			for(QueryRunnable r : querys) {
				if(r.isOk() && !r.isGot()) {	//完成，未获得数据
					Long[] array = r.getArray();
					arrays[index] = new LongDataArray(array);
					index ++;
					threadCount --;
				}
			}
			Thread.sleep(10);
		}
		return arrays;
	}
	
	/**
	 * 交集
	 * @return
	 * @throws InterruptedException
	 */
	public DataConjunction waitAndProcess() throws InterruptedException {
		DataConjunction conjunction = null;
		conjunction = new DataConjunction(waitForAllThread());
		return conjunction;
	}

	/**
	 * 并集
	 * @param minMatch 最小满足条件数
	 * @return
	 * @throws InterruptedException
	 */
	public DataDisjunction waitAndProcess(int minMatch) throws InterruptedException {
		DataDisjunction conjunction = null;
		conjunction = new DataDisjunction(waitForAllThread(), minMatch);
		return conjunction;
	}

	public static String showArray(String tag, Long[] arr) {
		StringBuilder sb = new StringBuilder("");
		for(Long i : arr) {
			sb.append(i.longValue()).append(" ");
		}
		String value = sb.toString();
		return tag + " : " + value;
	}
}
