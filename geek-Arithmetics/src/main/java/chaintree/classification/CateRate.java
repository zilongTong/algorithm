package chaintree.classification;
/**
 * 描述信息的分类概率
 * @author wjyuian
 *
 */
public class CateRate {
	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 概率
	 */
	private double rate;
	
	public CateRate(String name, double rate) {
		this.name = name;
		this.rate = rate;
	}
	
	public CateRate addRate(double d) {
		
		this.rate += d;
		return this;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}
