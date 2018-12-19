package classifier.goods.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classifier.TrainingSet;
import classifier.goods.GoodsInstance;
/**
 * 分类器数据集
 * @author HQ01U8435
 *
 */
public class GoodsDataSet {

	/**
	 * 商品号和商品实体信息的映射map
	 */
	private Map<String, Goods> goods;
	
	public GoodsDataSet(List<Goods> goods) {
		this.goods = new HashMap<String, Goods>(goods.size());
		for(Goods g : goods) {
			this.goods.put(g.getGoodsSn(), g);
		}
	}
	
	public List<Goods> getGoods() {
		return new ArrayList<Goods>(goods.values());
	}
	
	public Goods findGoodsBySn(String gsn) {
		return goods.get(gsn);
	}
	
	public int getSize() {
		return goods.size();
	}
	/**
	 * 获取训练集
	 * @param topNum
	 * @return
	 */
	public TrainingSet getTrainingSet(int topNum) {
		List<GoodsInstance> goodsInstances = createGoodsInstances(topNum);
		GoodsInstance[] goodsInstancesArray = goodsInstances.toArray(new GoodsInstance[goodsInstances.size()]);
		return new TrainingSet(goodsInstancesArray);
	}
	/**
	 * 将所有的商品实体，都转换成实例信息，并已列表的形式返回
	 * @param topNum
	 * @return
	 */
	public List<GoodsInstance> createGoodsInstances(int topNum) {
		List<GoodsInstance> goodsInstances = new ArrayList<GoodsInstance>(getGoods().size());
		for(Goods g : getGoods()) {
			GoodsInstance goodsInstance = toGoodsInstance(g, topNum);
			goodsInstances.add(goodsInstance);
		}
		return goodsInstances;
	}
	/**
	 * 将商品实体信息转换成 商品实例（该实例是与分类器概念对应的，表示分类器某个概念的实例）信息
	 * @param goods
	 * @param topNum
	 * @return
	 */
	public GoodsInstance toGoodsInstance(Goods goods, int topNum) {
		String goodsCate = getGoodsCate(goods);
		return new GoodsInstance(goodsCate, goods, topNum);
	}
	
	public String getGoodsCate(Goods g) {
		return g.getCate();
	}
}
