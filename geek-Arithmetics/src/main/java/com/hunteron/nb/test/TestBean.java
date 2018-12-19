package com.hunteron.nb.test;

import analyze.one.topn.ITopNBean;

/**
 *
 * @author Smile.Wu
 * @version 2015-8-4
 */
public class TestBean implements ITopNBean {
	
	private long id;
	
	private double rate;
	
	public TestBean(long id, double rate) {
		super();
		this.id = id;
		this.rate = rate;
	}

	@Override
	public double value() {
		return rate;
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
	
}
