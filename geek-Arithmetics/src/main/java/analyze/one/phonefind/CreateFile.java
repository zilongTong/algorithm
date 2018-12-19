/*
package analyze.one.phonefind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import analyze.also.exp.NullPathException;
import analyze.one.Analyzer;

import util.resource.ResourceReader;
import util.resource.ResourceWriter;

import junit.framework.TestCase;

*/
/**
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-12-28 上午8:36:44 
 *//*

public class CreateFile extends TestCase {
	public static final String PHONE_NEED_FIND = "D:/phonefind/find.txt";
	public static final String PHONE_SRC_ALL = "D:/phonefind/all.txt";
	
	public static long randomLong(long seed) {
		Random random = new Random(seed);
		return (long)random.nextInt() + 15111111111l;
	}
	
	public void testCreateAll() throws IOException {
		File f = new File(PHONE_SRC_ALL);
		
		ResourceWriter resourceWriter = new ResourceWriter(f);
		for(long i = 13599999999l; i > 13589999999l; i --) {
//			resourceWriter.write(randomLong(i));
			resourceWriter.write(i);
		}
		resourceWriter.close();
	}
	

	public void testCreateNeedFind() throws IOException {
		File f = new File(PHONE_NEED_FIND);
		
		ResourceWriter resourceWriter = new ResourceWriter(f);
		for(long i = 13589949999l; i < 13589999999l; i ++) {
//			resourceWriter.write(randomLong(i));
			resourceWriter.write(i);
		}
		resourceWriter.close();
	}
	
	public static String readAll() throws IOException {
		InputStream is = null;
        InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try {
			is = new FileInputStream(new File(PHONE_SRC_ALL));
	        isr = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(isr, 512);
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line+" ");
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if(br != null) {
				br.close();
			}
			if(isr != null) {
				isr.close();
			}
			if(is != null) {
				is.close();
			}
		}
		return sb.toString();
	}
	public void testFindInAll() throws NullPathException, IOException {
		Analyzer analyzer = new Analyzer();
		ResourceReader reader = new ResourceReader(new File(PHONE_NEED_FIND));
		reader.load();
		
		String line = null;
		while((line = reader.readLine()) != null) {
			analyzer.loadExternal(line);
		}
		reader.close();
		
		String t = readAll();
		long b = System.currentTimeMillis();
//		List<String> rs = analyzer.analyze(t, true);
		Map<String, Integer> maps = analyzer.analyzeCount(t, false);
		System.out.println("分词耗时：" + (System.currentTimeMillis() - b));
		b = System.currentTimeMillis();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(maps.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				if(o1.getValue() > o2.getValue()) {
					return -1;
					
				}
				return 1;
			}
		});
		System.out.println("topN耗时：" + (System.currentTimeMillis() - b));
		System.out.println("文章长度：" + t.length());
		System.out.println("总词数：" + list.size());
		System.out.println();
		System.out.println("top20 结果如下：");
		
		int c = 0;
		for(Map.Entry<String, Integer> en : list) {
			if(c ++ > 20) {
				break;
			}
			System.out.println(en.getKey() + " : " + en.getValue());
		}
	}
}
*/
