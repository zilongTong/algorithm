package chaintree.classification.t1;

import java.util.ArrayList;
import java.util.List;

import chaintree.classification.CateRate;

/**
 * 分类器分析结果
 * @author HQ01U8435
 *
 */
public class AnalyzeResult {

	/**
	 * 待分析的描述字符串
	 */
	private String brief;
	/**
	 * 分析出的可能分类列表，按照概率由高到低排序
	 */
	private List<CateRate> cateRates = new ArrayList<CateRate>(0);
	/**
	 * 概率最大的分类
	 */
	private CateRate mostProbable = null;
	
	public AnalyzeResult(String brief, List<CateRate> cateRates) {
		this.brief = brief;
		this.cateRates = cateRates;
		if(cateRates != null && !cateRates.isEmpty()) {
			mostProbable = cateRates.get(0);
		}
	}
	public List<CateRate> getCateRates() {
		return cateRates;
	}
	public void setCateRates(List<CateRate> cateRates) {
		this.cateRates = cateRates;
	}
	public CateRate getMostProbable() {
		return mostProbable;
	}
	public void setMostProbable(CateRate mostProbable) {
		this.mostProbable = mostProbable;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String toString() {
		StringBuilder info = new StringBuilder("");
		info.append("对描述性信息 [" + brief + "] 的分析结果如下：\n");
		for(CateRate cr : cateRates) {
			info.append("\t").append(" [" + cr.getName()).append(":" + cr.getRate() + "]\n");
		}
		info.append("最有可能的分类结果是：" + mostProbable.getName());
		return info.toString();
	}
}
