package sim.largetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class User {

	private long userMobile;
	private List<Goods> goods = new ArrayList<Goods>(0);
	private Map<Long, Goods> _goods = new HashMap<Long, Goods>(2, 0.95f);
	public User() {
	}
	public User(long um, Goods g) {
		userMobile = um;
		_goods.put(g.getGoodsSn(), g);
	}
	public void addGoods(Goods g) {
		Long gsn = g.getGoodsSn();
		if(_goods.get(gsn) != null) {
			Goods oldG = _goods.get(gsn);
			oldG.setPref((oldG.getPref() + g.getPref()) / 2);
		}else{
			_goods.put(gsn, g);
		}
	}
	public long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(long userMobile) {
		this.userMobile = userMobile;
	}
	public List<Goods> getGoods() {
		if(goods.size() < 1) {
			Iterator<Entry<Long, Goods>> us = _goods.entrySet().iterator();
			while(us.hasNext()) {
				goods.add(us.next().getValue());
			}
			
		}
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	public double getSimilarity(User u) {
		double sim = 0d;
		int commonItems = 0;
		for(Goods g1 : this.getGoods()) {
			for(Goods g2 : u.getGoods()) {
				if(g1.getGoodsSn() == g2.getGoodsSn()) {
					commonItems ++;
					sim += Math.pow(g1.getPref() - g2.getPref(), 2);
				}
			}
		}

		if(commonItems > 0) {
			sim = Math.sqrt(sim / (double)commonItems);
			
			sim = 1.0d - Math.tanh(sim);
			
			int maxCommonItems = Math.min(this.goods.size(), u.goods.size());

			sim = sim * ((double)commonItems / (double)maxCommonItems);
		}
		
		return sim;
	}
}
