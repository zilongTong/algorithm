package classifier.test;

import classifier.goods.GoodsClassifier;
import classifier.goods.data.Goods;
import classifier.goods.data.GoodsData;
import classifier.goods.data.GoodsDataSet;

public class TestGoodsClassifier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GoodsDataSet goodsDataSet = GoodsData.createTrainingDataSet();
		
		GoodsClassifier classifier = new GoodsClassifier(goodsDataSet, 30);
		classifier.setJaccardThreshold(0.45);
//		classifier.setInterfere(new GoodsInterfere());
		boolean isDebug = false;
		classifier.setVerbose(isDebug);
		classifier.train();
		
		GoodsDataSet testDataSet = GoodsData.createTestDataSet();
		
//		classifier.showConcepts();
		
		int i = 0, count = 8000, skip = 1;
		long max = 0, b = 0, dlt = 0;
		long totalB = System.currentTimeMillis();
		double same = 0;
		
//		if(totalB > 0) {
//			return;
//		}
		
		for(Goods g : testDataSet.getGoods()) {
			i ++;
			if(i < skip) {
				continue;
			}
			if(i > count) {
				break;
			}
			b = System.currentTimeMillis();
			String c = classifier.classify(g);
//			System.out.println( g.getCate() + "\t\t" + classifier.classify(g) + "\t" + g.getTitle());
			dlt = System.currentTimeMillis() - b;
			if(dlt > max) {
				max = dlt;
			}
			if(g.getCate().equalsIgnoreCase(c)) {
				same ++;
			}
//			if(isDebug)
//				System.out.println("=====old cate : " + g.getCate() + "\t\tclassify cate : " + c + "=====\n\n");
		}
		long total = System.currentTimeMillis() - totalB;
		int totalNum = (i - skip);
		System.out.println("分析量：" + totalNum + " 款。");
		System.out.println("总耗时：" + (total) + " 毫秒");
		System.out.println("平均耗时：" + total / (float)totalNum + " 毫秒/款");
		
		System.out.println("最大耗时：" + max + " 毫秒");
		System.out.println("相同：" + same + "，正确率：" + (same * 100/ (i - skip)) + "%");
		
	}

}
