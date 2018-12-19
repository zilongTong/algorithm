package chaintree.classification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import analyze.one.Analyzer;

import util.resource.ResourceReader;

/**
 * 自动分类算法
 * 
 * @author HQ01U8435
 *
 */
public class Reader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String p = "/chaintree/data/data1.csv";
		ResourceReader reader = new ResourceReader(p);
		Analyzer analyzer = new Analyzer();
		Map<String, Map<String, Integer>> info = new HashMap<String, Map<String,Integer>>(50, 0.95f);
		boolean isMax = true;
		try {
			analyzer.initDictMap();
			analyzer.loadExternal("女");
			analyzer.loadExternal("高帮");
			analyzer.loadExternal("男");
			analyzer.loadExternal("梭织褛");
			analyzer.loadExternal("立领");
			analyzer.loadExternal("辑线");
			analyzer.loadExternal("棉褛");
			analyzer.loadExternal("短");
			
			reader.load();
			List<String> line = null;
			while((line = reader.readLines()) != null) {
				String cn = line.get(2);
				String brief = line.toString();
				Map<String, Integer> in = analyzer.analyzeCount(brief, isMax);
				if(info.get(cn) == null) {
					info.put(cn, in);
				} else {
					Iterator<String> it = in.keySet().iterator();
					while(it.hasNext()) {
						String key = it.next();
						Integer count = in.get(key);
						
						//相应关键字的数量
						Integer oldCount = info.get(cn).get(key);
						if(oldCount == null) {
							info.get(cn).put(key, count);
						} else {
							info.get(cn).put(key, oldCount + count);
						}
					}
				}
			}
			
			System.out.println("共有 " + info.size() + " 个分类");
			Iterator<String> catKeys = info.keySet().iterator();
			List<String> catKeyList = new ArrayList<String>(0);
			while(catKeys.hasNext()) {
				String catKey = catKeys.next();
				catKeyList.add(catKey);
				Map<String, Integer> wordsInfo = info.get(catKey);
				Iterator<String> words = wordsInfo.keySet().iterator();
				System.out.println("\t分类：" + catKey);
				System.out.print("\t\t");
				while(words.hasNext()) {
					String word = words.next();
					Integer count = wordsInfo.get(word);
					System.out.print("[" + word + ":" + count + "]");
				}
				System.out.print("\n\n");
			}
			

			long b = System.currentTimeMillis();
			String title = "616020, 男条纹V领长袖毛衫 无";
			Map<String, Integer> getInfos = analyzer.analyzeCount(title, isMax);
			System.out.println(getInfos.size());
			List<Keyword> keywords = new ArrayList<Keyword>();
			
			Iterator<String> keys = getInfos.keySet().iterator();
			System.out.println("\n\n\n");
			System.out.println("当前商品描述信息：" + title);
			while(keys.hasNext()) {
				//关键字
				String key = keys.next();
				Integer count = getInfos.get(key);
				Keyword kw = new Keyword(key, count);
				System.out.println("\n\n[" + key + ":" + count + "]");
				for(String cat : catKeyList) {
					Map<String, Integer> catWordInfo = info.get(cat);

					Integer wordCount = catWordInfo.get(key);
					if(wordCount != null) {
						kw.addCate(cat, wordCount);
						System.out.format("\t%-14s%10d\n", cat, wordCount);
					}
				}
				
				keywords.add(kw);
			}
			
			System.out.println("耗时：" + (System.currentTimeMillis() - b));
			Map<String, CateRate> catRates = new HashMap<String, CateRate>();
			for(Keyword kw : keywords) {
				
				//计算分类概率
				kw.calculate();

				List<CateInfo> cis = kw.getCates();
				for(CateInfo ci : cis) {
					String cateName = ci.getCatName();
					double cateRate = ci.getRate();
					System.out.println(kw.getWord()+"\t: "+cateName+"\t:"+cateRate);
					CateRate oldRate = catRates.get(cateName);
					if(oldRate == null) {
						catRates.put(cateName, new CateRate(cateName, cateRate));
					} else {
						catRates.put(cateName, oldRate.addRate(cateRate));
					}
				}
			}
			
			Iterator<String> catnames = catRates.keySet().iterator();
			List<CateRate> crs = new ArrayList<CateRate>(0);
			while(catnames.hasNext()) {
				crs.add(catRates.get(catnames.next()));
			}
			System.out.println(crs.size());
			Collections.sort(crs, new Comparator<CateRate>() {
				public int compare(CateRate o1, CateRate o2) {
					if(o1.getRate() >= o2.getRate()) {
						return -1;
					} else {
						return 1;
					}
				}
				
			});
			
			int getNum = 5, index = 0;
			System.out.println("\n关于商品 “" + title + "” 的分类概率如下：");
			for(CateRate cr : crs) {
				index ++;
				System.out.println("\t\t" + cr.getName() + "\t\t -> " + cr.getRate());
				if(index >= getNum) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
