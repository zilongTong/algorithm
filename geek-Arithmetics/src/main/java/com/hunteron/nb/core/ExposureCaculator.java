package com.hunteron.nb.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import analyze.one.topn.ITopNBean;
import analyze.one.topn.TopNCreator;

import com.hunteron.nb.core.sort.ExposureBean;
import com.hunteron.nb.core.sort.TopNExposureCreator;
import com.hunteron.nb.test.TestBean;

/**
 *
 */
public class ExposureCaculator {
	private int arraySize = 1000;
	//记录命中次数
	private Map<Long, Long> hitMap;
	//记录曝光次数
	private Map<Long, Long> displayMap;
	//每次返回记录数，pageNum
	private int limit= 10;
	//曝光次数的缩小倍率（命中数相同的两个id，曝光数差值在base以上，才会产生不同的排序值）
	//即，允许两个id之间曝光数的差值
	private int base = 30;
	public ExposureCaculator(int size) {
		init(size);
	}
	public ExposureCaculator() {
		init(arraySize);
	}
	public void init(int s) {
		this.arraySize = s;
		hitMap = new HashMap<Long, Long>(arraySize);
		displayMap = new HashMap<Long, Long>(arraySize);
	}
	public List<Long> getDisplayIDs(ExposureBean[] beans) {
		return getDisplayIDs(beans, limit);
	}
	private long addHitCount(Long id, long c) {
		synchronized (hitMap) {
			Long old = hitMap.get(id);
			if(old != null) {
				old += c;
				hitMap.put(id, old);
				return old;
			} else {
				hitMap.put(id, c);
				return c;
			}
		}
	}
	private long addDisplayCount(Long id, long c) {
		synchronized (displayMap) {
			Long old = displayMap.get(id);
			if(old != null) {
				old += c;
				displayMap.put(id, old);
				return old;
			} else {
				displayMap.put(id, c);
				return c;
			}
		}
	}
	private long getDisplayCount(Long id) {
		Long old = displayMap.get(id);
		return old != null ? old : 0L;
	}

	/**
	 * 根据曝光次数，命中次数，动态计算返回值
	 * @param ExposureBean[] beans
	 * @return
	 */
	public List<Long> getDisplayIDs(ExposureBean[] beans, int limit) {
		List<Long> result = new ArrayList<>();
		
		TopNExposureCreator topNCreator = new TopNExposureCreator(limit);
		for(ExposureBean bean : beans) {
			long id = bean.getId();
			
			//命中率加一
			long hitNum = addHitCount(id, 1);
			long displayNum = getDisplayCount(id);
			
			long deltDisplay = displayNum / base;
			
			//伪曝光率
			double rate = deltDisplay/ (double) hitNum;
			
			//补曝光率，排序值
			double reverseRate = 1 - rate;
			
			//将职位的最后更新时间距离当前时间的差值计算入补曝光率
			double deltRate = getDeltDayRateMinus(bean.getUpdateTime());
			if(deltRate > 0) {
				reverseRate -= deltRate;
				if(reverseRate < 0) {
					reverseRate = 0.000001D;
				}
			}
			
			bean.setRate(reverseRate);
			//将曝光数缩小
			topNCreator.insert(bean);
		}
		
		ExposureBean node = null;
		while((node = topNCreator.pop()) != null && node.isNotNull()) {
			long id = node.getId();
			//曝光率加一
			addDisplayCount(id, 1);
			result.add(id);
		}		
		return result;
	}
	private static long[] SEPRATE = new long[]{0, 1, 5};
	//更新时间对补曝光频率的影响
	public static double getDeltDayRateMinus(long t) {
		double delt = deltDays(t);
		double base = 100D;
		if(delt == SEPRATE[0]) {
			return 0;
		}
		if(delt <= SEPRATE[1]) {
			return 1 / base;
		}
		if(delt < SEPRATE[2]) {
			return delt / base;
		}
		double v = (delt / base) * 2;
		return v;
	}
	//计算职位最后更新时间与当前时间的差值
	public static int deltDays(long t) {
		long delt = System.currentTimeMillis() - t;
		return (int) (delt / 86400000);
	}
	
	public static Map<Long, Long> TEMP_TIME = new HashMap<>();
	
	public void showLog() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		TopNCreator creator = new TopNCreator(500);
		for(Map.Entry<Long, Long> en : hitMap.entrySet()) {
			long hits = hitMap.get(en.getKey());
			Long displays = displayMap.get(en.getKey());
			if(displays != null && hits > 0 && displays > 0) {
//				System.out.println(en.getKey() + ":" + hits + " " + displays);
				double rate = displays / (double)hits;
				creator.insert(new TestBean(en.getKey(), rate));
			}
		}
		System.out.println();
		ITopNBean node = null;
		
		List<TestBean> list = new ArrayList<>();
		while((node = creator.pop()) != null && node.value() > 0) {
			TestBean tb = (TestBean) node;
			list.add(tb);
		}
		
		Collections.reverse(list);
		
		for(TestBean tb : list) {
			long id = tb.getId();
			Long time = TEMP_TIME.get(id);
			if(time == null) {
				time = System.currentTimeMillis();
			}
			long hits = hitMap.get(id);
			Long displays = displayMap.get(id);
			System.out.println(id + "[" + displays + " / " + hits +"] : "+tb.getRate()+" : "+format.format(new Date(time)));
		}
	}
	
	public static void main(String[] args) {
//		long b = 59;
//		int base = 50;
//		
//		for(int i = 100; i < 200; i ++) {
//			double rs = (b / base) / (double)i;
//			System.out.println(i + " : " + rs);
//		}
		
//		long t = System.currentTimeMillis();
//
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(format.format(new Date(t)));
		

		long displayNum = 41;
		long hitNum = 123;
		int base = 20;
		
		long deltDisplay = displayNum / base;
		
		//伪曝光率
		double rate = deltDisplay/ (double) hitNum;
		
		System.out.println(deltDisplay + " - " + rate);
	}
}
