package classifier.goods.data;

import java.io.Serializable;

/**
 * 商品信息数据实体
 * @author HQ01U8435
 *
 */
public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1553612191281740414L;

	private String goodsSn;
	
	private String title;
	
	private String cate;
	
	private String attr;
	
	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public Goods() {
	}

	public String getGoodsSn() {
		return goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}
	
	public void appendAttr(String a) {
		this.attr += " " + a;
	}
	
	public String toString() {
		return goodsSn + "," + cate + "," + title + "," + attr;
	}
}
