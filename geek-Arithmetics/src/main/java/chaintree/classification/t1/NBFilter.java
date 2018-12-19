package chaintree.classification.t1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import analyze.one.Analyzer;
import chaintree.classification.CateInfo;
import chaintree.classification.CateRate;
import chaintree.classification.Keyword;
import chaintree.classification.t1.knowledge.CateKeyKnowledge;
import chaintree.classification.t1.knowledge.IKnowledge;

/**
 * 
 * @author wjyuian
 * 一个分类器的雏形
 * 每条学习数据包括两个部分 
 * 		1、商品的详细描述信息
 * 		2、已指定的分类
 * 分类器根据预先指定的学习数据，学习分类规则
 * 
 * 学习过程将用到分词器
 */
public class NBFilter {

	/**
	 * 分词器
	 */
	private Analyzer analyzer = null;
	/**
	 * 知识学习
	 */
	private IKnowledge knowledge = null;
	/**
	 * 分词方式
	 */
	private boolean isAnalyzeMaxLength = true;
	
	/**
	 * 分析出分类概率的排序器
	 */
	private Comparator<CateRate> comparator = null;
	
	/**
	 * <b>人工干预分类器设定</b> <br /><br />
	 * key : 关键字 <br />
	 * value : 关键字属于各个分类的概率加成CR <br />
	 * 			CR.key : 分类标识 <br />
	 * 			CR.value : 概率加成 <br />
	 */
	private Map<String, Map<String, Double>> keywordCateRateDefined = null;
	
	/**
	 * 消极关键字
	 * 即使出现，其对分类器学习知识加深印象贡献小
	 */
	private Map<String, Double> negativeWordRateDefined = null;
	/**
	 * 积极关键字
	 * 出现，对分类器学习知识加深印象贡献很大
	 */
	private Map<String, Double> positiveWordRateDefined = null;
	/**
	 * 消极关键字默认权重
	 */
	private double negativeDefaultRate = 0.001f;
	/**
	 * 积极关键字默认权重
	 */
	private double positiveDefaultRate = 1.0f;
	
	public NBFilter() {
		//默认采用分类到关键字映射的知识类
		knowledge = new CateKeyKnowledge();
		loadAndInit();
		isAnalyzeMaxLength = true;
	}
	
	public NBFilter(IKnowledge knowledge) {
		this.knowledge = knowledge;
		loadAndInit();
	}
	
	/**
	 * 加载一些用户定义的关键字、分类权重信息，初始化分类器
	 */
	private void loadAndInit() {
		loadWordRate();
		
		loadManufactureRate();
		
		initFilter();
	}
	/**
	 * 载入人工干预关键字分类加成数值定义
	 */
	private void loadManufactureRate() {
		keywordCateRateDefined = new HashMap<String, Map<String,Double>>();
//		addKeywordCateRate("腰带", "腰带", 24.5d);
//		addKeywordCateRate("短袖", "短袖衬衫", 4.8d);
//		addKeywordCateRate("短袖衬衫", "短袖衬衫", 4.8d);
//		addKeywordCateRate("长袖毛衫", "长袖毛衫", 4.8d);
//		addKeywordCateRate("帆布", "时装鞋", 14.8d);
//		addKeywordCateRate("方巾", "毛巾", 10.8d);
		addKeywordCateRate("针织", "针织衫", 6.8d);
		addKeywordCateRate("针织", "针织恤", 2.6d);
	}
	
	/**
	 * 载入积极关键字、消极关键字
	 */
	private void loadWordRate() {
		negativeWordRateDefined = new HashMap<String, Double>();
		positiveWordRateDefined = new HashMap<String, Double>();
		
	}
	
	/**
	 * 初始化分类器
	 */
	private void initFilter() {
		comparator = new CateRateComparator();
		//初始化分词器
		analyzer = new Analyzer();
		//载入预定义分词词典
		analyzer.initDictMap();
		analyzer.loadExternal("女");
		analyzer.loadExternal("高帮");
		analyzer.loadExternal("男");
		analyzer.loadExternal("梭织褛");
		analyzer.loadExternal("立领");
		analyzer.loadExternal("辑线");
		analyzer.loadExternal("棉褛");
		analyzer.loadExternal("短袖");
		analyzer.loadExternal("短袖衬衫");
		analyzer.loadExternal("牛仔长裤");
		analyzer.loadExternal("长袖毛衫");
		analyzer.loadExternal("帆布");
		analyzer.loadExternal("方巾");
		analyzer.loadExternal("领带");
		analyzer.loadExternal("腰带");
		analyzer.loadExternal("针织");
		analyzer.loadExternal("针织衫");
		analyzer.loadExternal("便装");
		analyzer.loadExternal("连帽");
		analyzer.loadExternal("卫衣");
		analyzer.loadExternal("开衫");
	}
	
	/**
	 * 学习知识
	 * @param cate	指定分类
	 * @param brief	描述信息
	 */
	public void learn(String cate, String brief) {
		//通过分词器，获得描述信息中的关键字信息，包括包含分词，数量
		Map<String, Integer> wordsCount = analyzer.analyzeCount(brief, isAnalyzeMaxLength);
		learn(cate, wordsCount);
	}
	/**
	 * 分类器学习知识
	 * @param cate	分类
	 * @param wordCountForCates	与该分类对应的关键字和数量
	 * 							即，该分类出现了哪些关键字以及出现的数量，进一步说就是某一关键字出现，属于该分类的概率
	 */
	public void learn(String cate, Map<String, Integer> wordCountForCates) {
		knowledge.learn(cate, wordCountForCates);
	}
	/**
	 * 分类器学习单个关键字的信息
	 * @param cate
	 * @param word
	 * @param wordCount
	 */
	public void learn(String cate, String word, Integer wordCount) {
		knowledge.learn(cate, word, wordCount);
	}
	
	/**
	 * 根据已有的知识，分析某一字符串描述信息，判断出可能的分类
	 * @param brief
	 * @return	分析结果
	 */
	public AnalyzeResult analyzeFromBrief(String brief) {
		
		/*
		 * 分析描述信息，得到关键字
		 * 然后找出这些关键字曾经在哪些分类中出现过以及次数
		 * 以及在所有出现过的分类中的出现次数总和
		 */
		List<Keyword> keywords = getKeywords(brief);
		
		/*
		 * 该描述信息属于各个分类的概率
		 */
		List<CateRate> cateRates = calculateRates(keywords);
		
		try {
			Collections.sort(cateRates, comparator);
		} catch (Exception e) {
			System.out.println(brief + "\t:"+cateRates.size()+"\t" + e);
			for(CateRate cr : cateRates) {
				System.out.println(cr.getName()+""+cr.getRate());
			}
		}
		
		if(cateRates.size() > 5) {
			cateRates = cateRates.subList(0, 4);
		}
		
		AnalyzeResult analyzeResult = new AnalyzeResult(brief, cateRates);
		
		return analyzeResult;
		
	}
	/**
	 * 针对此次分析对象 brief
	 * 计算关键字、分类概率
	 * 将描述信息中关键字属于各个分类的概率信息 转换成 描述信息所属各个分类的概率 
	 * @param keywords brief的分词结果
	 * @return
	 */
	private List<CateRate> calculateRates(List<Keyword> keywords) {
		/*
		 * 针对这一次分析对象 ：brief
		 * brief属于各个分类的概率信息
		 * key ：分类标识
		 * value ：catRate 分类信息
		 */
		Map<String, CateRate> catRates = new HashMap<String, CateRate>();
		
		//遍历待分析字符串中分析出的关键字
		for(Keyword kw : keywords) {
			//计算分类概率
			kw.calculate();
			//关键字出现过的分类
			List<CateInfo> cis = kw.getCates();
			for(CateInfo ci : cis) {
				//关键字出现过的分类的名称
				String cateName = ci.getCatName();
				//概率
				double cateRate = ci.getRate() * calculateDefinedRateWeighing(kw.getWord(), cateName);
				//描述信息属于该分类的概率信息
				CateRate oldRate = catRates.get(cateName);
				if(oldRate == null) {
					//为空，则新生成一条描述信息于分类的概率信息
					catRates.put(cateName, new CateRate(cateName, cateRate));
				} else {
					//否则叠加概率
					catRates.put(cateName, oldRate.addRate(cateRate));
				}
			}
		}
		
		Iterator<String> catnames = catRates.keySet().iterator();
		List<CateRate> crs = new ArrayList<CateRate>(0);
		while(catnames.hasNext()) {
			crs.add(catRates.get(catnames.next()));
		}
		
		return crs;
	}
	/**
	 * 分析描述信息，得到包含的关键字
	 * 进一步得到关键字曾经出现在哪些分类、次数，总数
	 * @param brief
	 * @return
	 */
	private List<Keyword> getKeywords(String brief) {
		//分词
		Map<String, Integer> getInfos = analyzer.analyzeCount(brief, isAnalyzeMaxLength);
		
		return knowledge.getKeywords(getInfos);
	}
	
	/**
	 * 添加关键字 分类概率 加成
	 */
	public void addKeywordCateRate(String keyword, String cateName, Double rateWeighing) {
		if(keywordCateRateDefined.get(keyword) == null) {
			Map<String, Double> cateRates = new HashMap<String, Double>();
			
			cateRates.put(cateName, rateWeighing);
			keywordCateRateDefined.put(keyword, cateRates);
		}
		keywordCateRateDefined.get(keyword).put(cateName, rateWeighing);
	}
	
	private double calculateDefinedRateWeighing(String keyword, String cateName) {
		double manuRate = getManufactureWeighing(keyword, cateName);
		double positiveRate = getPositive(keyword);
		double negativeRate = getNegative(keyword);
		return manuRate * positiveRate * negativeRate;
	}
	
	/**
	 * 获取人工干预，关键字属于分类加成值，累乘 </ br>
	 * 未定义，则默认1.0
	 * @return
	 */
	public double getManufactureWeighing(String keyword, String cateName) {
		if(keywordCateRateDefined.get(keyword) == null ||
				keywordCateRateDefined.get(keyword).get(cateName) == null) {
			return 1.0d;
		} else {
			return keywordCateRateDefined.get(keyword).get(cateName);
		}
	}
	public double getPositive(String k) {
		if(positiveWordRateDefined.get(k) == null) {
			return 1.0d;
		}
		return positiveWordRateDefined.get(k);
	}
	public double getNegative(String k) {
		if(negativeWordRateDefined.get(k) == null) {
			return 1.0d;
		}
		return negativeWordRateDefined.get(k);
	}

	public int cateSize() {
		return knowledge.cateSize();
	}
	
	public Analyzer getAnalyzer() {
		return analyzer;
	}
	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

	public Map<String, Map<String, Double>> getKeywordCateRateDefined() {
		return keywordCateRateDefined;
	}

	public void setKeywordCateRateDefined(
			Map<String, Map<String, Double>> keywordCateRateDefined) {
		this.keywordCateRateDefined = keywordCateRateDefined;
	}

	public Map<String, Double> getNegativeWordRateDefined() {
		return negativeWordRateDefined;
	}

	public void setNegativeWordRateDefined(
			Map<String, Double> negativeWordRateDefined) {
		this.negativeWordRateDefined = negativeWordRateDefined;
	}

	public Map<String, Double> getPositiveWordRateDefined() {
		return positiveWordRateDefined;
	}

	public void setPositiveWordRateDefined(
			Map<String, Double> positiveWordRateDefined) {
		this.positiveWordRateDefined = positiveWordRateDefined;
	}

	public double getNegativeDefaultRate() {
		return negativeDefaultRate;
	}

	public void setNegativeDefaultRate(double negativeDefaultRate) {
		this.negativeDefaultRate = negativeDefaultRate;
	}

	public double getPositiveDefaultRate() {
		return positiveDefaultRate;
	}

	public void setPositiveDefaultRate(double positiveDefaultRate) {
		this.positiveDefaultRate = positiveDefaultRate;
	}
	
}

class CateRateComparator implements Comparator<CateRate> {

	public int compare(CateRate o1, CateRate o2) {
		if(o1.getRate() >= o2.getRate()) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
