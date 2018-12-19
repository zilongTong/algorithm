package com.hunteron.nb.core;

import analyze.one.topn.ITopNBean;

/**
 *
 * @author Smile.Wu
 * @version 2015-8-1
 */
public class RateBean implements ITopNBean {

	private long id;
	private long hitNum;
	private long displayNum;
	private double sortValue = 1;
	
	public RateBean(long id, long hitNum, long displayNum) {
		super();
		this.id = id;
		this.hitNum = hitNum;
		this.displayNum = displayNum;
		
		this.sortValue = 1 - (this.displayNum / (double) this.hitNum);
	}

	@Override
	public double value() {
		return sortValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getHitNum() {
		return hitNum;
	}

	public void setHitNum(long hitNum) {
		this.hitNum = hitNum;
	}

	public long getDisplayNum() {
		return displayNum;
	}

	public void setDisplayNum(long displayNum) {
		this.displayNum = displayNum;
	}

	public void setDisplayNum(int displayNum) {
		this.displayNum = displayNum;
	}
}
