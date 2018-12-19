package sort.listmerge;

import java.util.Arrays;
import java.util.Comparator;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-26 上午11:19:25 
 */
public class GoodsInverseChain extends GoodsSet {
	private String type = "";
	private float weight;
	private GoodsSimilarity[] list;
	private int size;
	private int index = -1;
	public GoodsInverseChain(GoodsSimilarity[] goods, float weight, String type) {
		this.weight = weight;
		list = goods;
		index = -1;
		size = goods.length;
		this.type = type;
		sort();
	}
	
	public int currentGoodsID() {
		if(index <= size - 1) {
			return list[index].ID();
		}
		return NO_MORE_GOODS;
	}
	
	public GoodsSimilarity currentGoods() {
		if(index <= size - 1) {
			return list[index];
		}
		return null;
	}
	
	@Override
	public int advance(int id) {
		index ++;
		while(index <= size - 1) {
			if(list[index].ID() > id) {
				break;
			}
			index ++;
		}
		return list[index].ID();
	}
	@Override
	public int nextGoodsId() {
		index ++;
		if(index <= size - 1) {
			return list[index].ID();
		}
		return NO_MORE_GOODS;
	}

	public void sort() {
		if(list.length < 2) {
			return;
		}
		Arrays.sort(list, new Comparator<GoodsSimilarity>() {
			public int compare(GoodsSimilarity o1, GoodsSimilarity o2) {
				if(o1.ID() < o2.ID()) {
					return -1;
				}
				return 1;
			}
		});
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}
	
	public String toString() {
		return type;
	}
	
	public String info() {
		StringBuilder sb = new StringBuilder("[");
		for(GoodsSimilarity g : list) {
			sb.append(g.ID()).append(",");
		}
		if(sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}
}
