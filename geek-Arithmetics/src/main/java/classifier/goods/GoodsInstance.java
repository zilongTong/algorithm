package classifier.goods;

import java.util.Map;

import classifier.core.BaseConcept;
import classifier.core.BaseInstance;
import classifier.core.StringAttribute;
import classifier.goods.data.Goods;
import classifier.itf.Attribute;
import classifier.util.AnalyzerUtil;

public class GoodsInstance extends BaseInstance {
	
	private static int DEFAULT_TOP_N = 20;

	private String id;

	public GoodsInstance(String goodsCategory, Goods goods) {
		this(goodsCategory, goods, DEFAULT_TOP_N);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 概念对应实例的初始化
	 * @param goodsCategory
	 * @param goods
	 * @param topNum
	 */
	public GoodsInstance(String goodsCategory, Goods goods, int topNum) {
		super();
		//实例的唯一标识符
		this.id = goods.getGoodsSn();
		
		this.setConcept(new BaseConcept(goodsCategory));
		String text = goods.getTitle() + " " 
		+ goods.getCate() 
//		+ "" + goods.getAttr()
		;
		
		/*
		 * 实例主要信息的分词结果，
		 * 取出现次数最多的前topNum个
		 */
		Map<String, Integer> tfMap = AnalyzerUtil.getTermCount(text, topNum);
		
		attributes = new StringAttribute[1];
		
		String attrName = "Goods_Title";
		StringBuilder sb = new StringBuilder("");
		for(Map.Entry<String, Integer> entry : tfMap.entrySet()) {
			sb.append(entry.getKey()).append(" ");
		}
		attributes[0] = new StringAttribute(attrName, sb.toString());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Attribute a : attributes) {
			sb.append(a.getValue()).append(" ");
		}
		return sb.toString();
	}
}
