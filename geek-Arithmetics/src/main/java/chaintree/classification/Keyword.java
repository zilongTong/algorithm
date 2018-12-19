package chaintree.classification;

import java.util.ArrayList;
import java.util.List;

/**
 * 关键字、分类详细信息
 * @author wjyuian
 *
 */
public class Keyword {
	/**
	 * 关键字内容
	 */
	private String word;
	/**
	 * 关键字出现的次数
	 */
	private Integer count = 0;
	/**
	 * 关键字曾经出现在这些分类中
	 */
	private List<CateInfo> cates = new ArrayList<CateInfo>(0);
	/**
	 * 关键字出现过的总次数
	 */
	private float total = 0;
	public Keyword(String word, Integer c) {
		this.word = word;
		count = c;
	}
	
	public void addCate(String cn, Integer wc) {
		total += wc;
		cates.add(new CateInfo(cn, wc));
	}
	
	/**
	 * 计算某个关键字出现的时候
	 * 属于各个分类的概率
	 * count表示关键字在当前描述信息中出现的次数，越大代表越重要，相应其在 分类决定 方面的作用更大
	 */
	public void calculate() {
		int totalNum = cates.size();
		for(CateInfo ci : cates) {
			//该关键字在该分类商品中出现次数 除以 关键字出现总次数  再除以  该关键字所属分类数
			double r = (ci.getWordCount() / total / (double)totalNum) * count;
			if(word.length() > 1 && word.equalsIgnoreCase(ci.getCatName())) {
				ci.setRate(r * 1);
			} else {
				ci.setRate(r);
			}
		}
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public List<CateInfo> getCates() {
		return cates;
	}
	public void setCates(List<CateInfo> cates) {
		this.cates = cates;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
