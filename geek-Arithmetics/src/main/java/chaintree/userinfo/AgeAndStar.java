package chaintree.userinfo;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-5-30 上午11:22:49 
 */
public 
class AgeAndStar {
	private int age;
	private int star;
	private String starName;
	public AgeAndStar() { }
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age > 60 || age < 10) {
			age = 0;
		}
		this.age = age;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getStarName() {
		return starName;
	}
	public void setStarName(String starName) {
		this.starName = starName;
	}
	public String toString() {
		return age + "," + star;
	}
}
