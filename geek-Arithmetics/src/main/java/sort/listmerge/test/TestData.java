package sort.listmerge.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import sort.listmerge.GoodsInverseChain;
import sort.listmerge.GoodsSimilarity;
import util.resource.ResourceReader;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-26 下午2:13:08 
 */
public class TestData {

	public static final String path = "F:/kingyp/Arithmetics/src/sort/listmerge/Test/data/";
	
	public static GoodsSimilarity[] getGoods(String fileName) {
		ResourceReader reader = new ResourceReader(new File(path + fileName));
		List<GoodsSimilarity> rs = new ArrayList<GoodsSimilarity>();
		try {
			reader.load();
			String line = null;
			while((line = reader.readLine()) != null) {
				String[] vals = line.split(",");
				int gsn = Integer.parseInt(vals[0]);
				float simil = Float.parseFloat(vals[1]);
				rs.add(new GoodsSimilarity(gsn, simil));
			}
			
			return rs.toArray(new GoodsSimilarity[]{});
		} catch (Exception e) {
			return new GoodsSimilarity[1];
		}
	}
	
	public static GoodsInverseChain getBuy() {
		return new GoodsInverseChain(getGoods("buy.txt"), 0.4f, "buy");
	}
	
	public static GoodsInverseChain getCommon() {
		return new GoodsInverseChain(getGoods("common.txt"), 0.3f, "common");
	}
	
	public static GoodsInverseChain getLove() {
		return new GoodsInverseChain(getGoods("love.txt"), 0.2f, "love");
	}
	
	public static GoodsInverseChain getView() {
		return new GoodsInverseChain(getGoods("view.txt"), 0.1f, "view");
	}
}
