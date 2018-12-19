package chaintree.classification;
/**
 * 特定关键字在该分类中出现的信息
 * @author wjyuian
 *
 */
public class CateInfo {
	/**
	 * 分类名称
	 */
	private String catName;
	/**
	 * 关键在在该分类中出现的次数
	 */
	private Integer wordCount;
	/**
	 * 关键字出现总次数中，其中属于该分类的概率
	 */
	private double rate;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public CateInfo(String cn, Integer wc) {
		catName = cn;
		wordCount = wc;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	@Override
	public String toString() {
		return catName + " : " + wordCount + " [" + rate + "]";
	}
}
