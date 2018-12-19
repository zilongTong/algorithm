package dm.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import classifier.goods.data.Goods;

/**
 *
 * @author Smile.Wu
 * @version 2015-9-25
 */
public class Prototype implements Cloneable, Serializable {

	private static final long serialVersionUID = 8320792693865019733L;

	private String name;
	
	private Goods goods;
	
	public Prototype(String name, Goods g) {
		this.name = name;
		goods = g;
	}
	
	public Prototype clone() throws CloneNotSupportedException {
		Prototype prototype = (Prototype) super.clone();
		return prototype;
	}
	
	public Prototype deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		return (Prototype) ois.readObject();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public String toString() {
		return name + "[" + goods.getTitle() + "(" + goods.getGoodsSn() + ") : " + goods.getCate() + "]";
	}
}
