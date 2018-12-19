package sim.selftest.user;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String name;
	private Set<Item> items = new HashSet<Item>(5, 0.96f);
	
	public User() {	}
	
	public User(String name) {	
		this.name = name;
	}
	
	public User(String name, long itemId, double pref) {	
		this.name = name;
		addItem(itemId, pref);
	}
	
	public void addItem(long id, double pref) {
		items.add(new Item(id, pref));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public double getSimilarity(User u) {
		double sim = 0d;
		int commonItems = 0;
		for(Item i1 : this.items) {
			for(Item i2 : u.items) {
				if(i1.getId() == i2.getId()) {
					commonItems ++;
					sim += Math.pow(i1.getPref() - i2.getPref(), 2);
				}
			}
		}
		if(commonItems > 0) {
			sim = Math.sqrt(sim / (double)commonItems);
			
			sim = 1.0d - Math.tanh(sim);

			int maxCommonItems = Math.min(this.items.size(), u.items.size());
			
			sim = sim * ((double)commonItems / (double)maxCommonItems);
		}
		
		return sim;
	}
}
