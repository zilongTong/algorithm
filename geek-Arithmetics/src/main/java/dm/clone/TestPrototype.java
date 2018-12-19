package dm.clone;

import java.io.IOException;

import classifier.goods.data.Goods;

/**
 *
 * @author Smile.Wu
 * @version 2015-9-25
 */
public class TestPrototype {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		
		Goods g = new Goods();
		g.setCate("cate1");
		g.setGoodsSn("10001");
		g.setTitle("title1");
		
		Prototype prototype = new Prototype("prototype", g);
		System.out.println(prototype);

		long b = System.currentTimeMillis();
		Prototype cloneObject = prototype.clone();
		System.out.println(System.currentTimeMillis() - b);
		b = System.currentTimeMillis();
		Prototype deepCloneObject = prototype.deepClone();
		System.out.println(System.currentTimeMillis() - b);
		
		System.out.println("prototype : " + prototype);
		System.out.println("cloneObject : " + cloneObject);
		System.out.println("deepCloneObject : " + deepCloneObject);
		
		System.out.println();
		System.out.println("change prototype name");
		prototype.setName("changedName");
		System.out.println("prototype : " + prototype);
		System.out.println("cloneObject : " + cloneObject);
		System.out.println("deepCloneObject : " + deepCloneObject);
		
		System.out.println();
		System.out.println("change goods.title");
		prototype.getGoods().setTitle("new title");
		System.out.println("prototype : " + prototype);
		System.out.println("cloneObject : " + cloneObject);
		System.out.println("deepCloneObject : " + deepCloneObject);

		System.out.println();
		System.out.println("set new goods");
		Goods g1 = new Goods();
		g1.setCate("cate1 g1");
		g1.setGoodsSn("10001g1");
		g1.setTitle("title1g1");
		prototype.setGoods(g1);
		System.out.println("prototype : " + prototype);
		System.out.println("cloneObject : " + cloneObject);
		System.out.println("deepCloneObject : " + deepCloneObject);
	}
}
