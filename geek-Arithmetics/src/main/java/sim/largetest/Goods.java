package sim.largetest;

public class Goods {
	private long goodsSn;
	
	private float pref;
	
	public Goods() {
	}
	public Goods(long gsn, float prf) {
		goodsSn = gsn;
		pref = prf;
	}
	
	public long getGoodsSn() {
		return goodsSn;
	}
	public void setGoodsSn(long goodsSn) {
		this.goodsSn = goodsSn;
	}
	public float getPref() {
		return pref;
	}
	public void setPref(float pref) {
		this.pref = pref;
	}
}
