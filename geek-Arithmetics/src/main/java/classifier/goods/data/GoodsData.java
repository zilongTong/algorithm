package classifier.goods.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.resource.ResourceReader;

/**
 * 商品数据加载
 * @author HQ01U8435
 *
 */
public class GoodsData {

	/**
	 * 训练集数据源路径
	 */
	private static final String TRAINNING_GOODS_INFO = "/classifier/goods/data/training_data.csv";
	/**
	 * 测试集数据源路径
	 */
	private static final String TEST_GOODS_INFO = "/classifier/goods/data/test_data.csv";
	
	/**
	 * 加载数据源路径指定的数据，并转换成相应的类型
	 * @param path 数据源路径
	 * @return
	 */
	public static List<Goods> loadGoods(String path) {
		List<Goods> goods = new ArrayList<Goods>();
		ResourceReader reader = null;
		try {
			reader = new ResourceReader(TRAINNING_GOODS_INFO);
			reader.load();
			String line = null;
			while( (line = reader.readLine()) != null ) {
				Goods g = new Goods();
				String[] infos = line.split(",");
				g.setGoodsSn(infos[0]);
				g.setCate(infos[1]);
				g.setTitle(infos[2]);
				g.setAttr("");
				goods.add(g);
			}
			
		} catch (Exception e) {
			
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return goods;
	}
	/**
	 * 生成分类器训练数据集
	 * @return
	 */
	public static GoodsDataSet createTrainingDataSet() {
		List<Goods> trainingGoods = loadGoods(TRAINNING_GOODS_INFO);
		return new GoodsDataSet(trainingGoods);
	}
	/**
	 * 生成分类器测试数据集
	 * @return
	 */
	public static GoodsDataSet createTestDataSet() {
		List<Goods> trainingGoods = loadGoods(TEST_GOODS_INFO);
		return new GoodsDataSet(trainingGoods);
	}
}
