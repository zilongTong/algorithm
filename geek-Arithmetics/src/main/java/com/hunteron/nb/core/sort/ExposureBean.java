package com.hunteron.nb.core.sort;
/**
 *
 * @author Smile.Wu
 * @version 2015-8-3
 */
public class ExposureBean {

	private long id;
	
	private double rate;
	
	private double score;
	
	//职位的更新时间
	private long updateTime;

	public ExposureBean(long id, double rate, double score) {
		super();
		this.id = id;
		this.rate = rate;
		this.score = score;
	}

	public ExposureBean(long id, double rate, double score, long t) {
		super();
		this.id = id;
		this.rate = rate;
		this.score = score;
		this.updateTime = t;
	}
	
	public int compareTo(ExposureBean bean) {
		if(bean == null) {
			return -1;
		}
		if(rate > bean.getRate()) {
			return 1;
		} else if(rate == bean.getRate()) {
			if(score > bean.getScore()) {
				return 1;
			} else {
				return score == bean.getScore() ? 0 : -1;
			}
		}
		return -1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public boolean isNotNull() {
		return id > 0 && rate >= 0 && score >= 0;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
}
