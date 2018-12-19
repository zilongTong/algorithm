package com.hunteron.nb.test;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.hunteron.nb.core.ExposureCaculator;
import com.hunteron.nb.core.sort.ExposureBean;

/**
 *
 * @author Smile.Wu
 * @version 2015-8-1
 */
public class ExposureRateTest {
	public static long seed = 1;
	
	/*
	 * 随机生成一定数量的职位信息；模拟某一次搜索返回的结果集
	 * 
	 * 一次返回 50 ~ 1050 条职位信息
	 * 职位ID随机产生：1000 ~ 11000
	 */
	public static ExposureBean[] random() {
		ExposureBean[] rs = null;
		Random r = new Random(System.currentTimeMillis());
		int size = r.nextInt(300) + 50;
		rs = new ExposureBean[size];
		
		for(int i = 0; i < size; i ++) {
			Random rr = new Random(i + seed ++);
			long id = rr.nextInt(10000) + 1000;

			ExposureBean b = new ExposureBean(id, -1, i);
			
			Long t = ExposureCaculator.TEMP_TIME.get(id);
//			t = System.currentTimeMillis();
			if(t == null) {
				t = randomTimeMills();
				ExposureCaculator.TEMP_TIME.put(id, t);
			}
			t = System.currentTimeMillis();
			b.setUpdateTime(t);
			
			rs[i] = b;
		}
		
		return rs;
	}
	
	//随机给某个职位生成时间，模拟职位的最后更新时间，30天之内
	public static long randomTimeMills() {
		long current = System.currentTimeMillis();
		Random rr = new Random(UUID.randomUUID().getLeastSignificantBits() + seed);
		
		long delt = rr.nextInt(30);
		if(delt < 0) {
			delt *= -1;
		}
		return current - delt * 86400000;
	}
	
	public static void showLongArray(long[] r1) {
		for(Long id : r1) {
			System.out.print(id + ",");
		}
		System.out.println();
	}
	public static void main(String[] args) {

		Runtime currRuntime = Runtime.getRuntime ();

		int nTotalMemory = ( int ) (currRuntime.totalMemory() / 1024 / 1024);
		
		int max = 100000;
		ExposureCaculator caculator = new ExposureCaculator();
		double total = 0;
		
		ExposureBean[] tempBeans = random();
		for(int i = 0; i < max; i ++) {
			long b = System.currentTimeMillis();
			
			//将某一次搜索的结果集ID，得分，时间全部返回，通过曝光率补差系统，计算出本次返回的若干条值
			List<Long> temp = caculator.getDisplayIDs(tempBeans, 15);
			System.out.println(temp);
			total += (System.currentTimeMillis() - b);
		}

		int nFreeMemory = ( int ) (currRuntime.freeMemory() / 1024 / 1024);
		
		//安装曝光率降序排列，显示前若干条职位的ID，曝光数，命中数，曝光率，更新时间
//		caculator.showLog();
		
		System.out.println("cost pertime ：" + (total / max));

		System.out.println(nFreeMemory + "M/" + nTotalMemory +"M(free/total)");
		
	}
}
