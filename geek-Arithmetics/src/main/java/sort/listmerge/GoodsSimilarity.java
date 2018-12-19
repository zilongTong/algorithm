package sort.listmerge;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-26 上午11:15:26 
 */
public class GoodsSimilarity {
	private int id;
	private float simil;
	public GoodsSimilarity() { }
	public GoodsSimilarity(int id, float s) { 
		this.id = id;
		simil = s;
	}
	
	public int ID() {
		return id;
	}
	public float getSimil() {
		return simil;
	}
	public void setSimil(float simil) {
		this.simil = simil;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "GoodsSimilarity [id=" + id + ", simil=" + simil + "]";
	}
}
