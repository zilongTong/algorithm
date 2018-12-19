package classifier.goods.trainsform;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import util.resource.ResourceReader;
import util.resource.ResourceWriter;
import classifier.goods.data.Goods;
import classifier.goods.trainsform.itf.IProcessLineString;

public class TransformData {

	private static final String TRAINING_DATA_SRC_FILE_NAME = "/classifier/goods/trainsform/training_data_src.csv";
	private static final String TRAINING_DATA_DIS_FILE_NAME = "D:/快盘/Java Design Model/Arithmetics/src/classifier/goods/data/training_data.csv";
	private IProcessLineString processer;
	private ResourceReader reader;
	private ResourceWriter writer;
	
	public TransformData(IProcessLineString processer) {
		this.processer = processer;
		this.reader = new ResourceReader(TRAINING_DATA_SRC_FILE_NAME);
		writer = new ResourceWriter(TRAINING_DATA_DIS_FILE_NAME);
	}
	
	public void transform() {
		try {
			reader.load();
			String line = null;
			Map<String, Goods> goodsMap = new HashMap<String, Goods>();
			while((line = reader.readLine()) != null) {
				Goods g = processer.process(line);
				if(g == null || g.getCate() == null) {
					continue;
				}
				if(goodsMap.get(g.getGoodsSn()) != null) {
				} else {
					goodsMap.put(g.getGoodsSn(), g);
				}
			}
			
			for(Map.Entry<String, Goods> g : goodsMap.entrySet()) {
				writer.write(g.getValue().toString());
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TransformData transformData = new TransformData(new ProcessOne());
		transformData.transform();
	}
}
