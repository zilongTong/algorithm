package sim.selftest.user;

public class Item {

	private long id;
	private double pref;
	public Item() {	}
	public Item(long id, double pref) {	
		this.id = id;
		this.pref = pref;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPref() {
		return pref;
	}
	public void setPref(double pref) {
		this.pref = pref;
	}
}
