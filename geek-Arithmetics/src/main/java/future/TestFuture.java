package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-29
 */
public class TestFuture {
	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {//使用Callable接口作为构造参数   
		         public String call() {
					return "test";   
		           //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型   
		       }});
		executor.execute(futureTask);
		//在这里可以做别的任何事情   
		String result = null;
		try {   
		    result = futureTask.get(5000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果   
		} catch (InterruptedException e) {   
		    futureTask.cancel(true);   
		} catch (ExecutionException e) {   
		    futureTask.cancel(true);   
		} catch (TimeoutException e) {   
		    futureTask.cancel(true);   
		} finally {   
		    executor.shutdown();   
		} 
		System.out.println(result);
    }
}
