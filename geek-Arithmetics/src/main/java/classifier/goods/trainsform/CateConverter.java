package classifier.goods.trainsform;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import util.resource.ResourceReader;

public class CateConverter {

	private static final String CATE_CONVERT = "/classifier/goods/trainsform/cate.txt";
	
	private static Map<String, String> cate = initCateMap();
	
	private static Map<String, String> initCateMap() {
		Map<String, String> rs = new HashMap<String, String>();
		ResourceReader reader = null;
		try {
			reader = new ResourceReader(CATE_CONVERT);
			reader.load();
			String line = "";
			while((line = reader.readLine()) != null) {
				String nc = line.split(":")[0];
				String olds = line.split(":")[1];
				String[] ods = olds.split(",");
				for (int i = 0; i < ods.length; i++) {
					rs.put(ods[i], nc);
				}
			}
			
		} catch (Exception e) {
			
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return rs;
	}
	
	public static String convertCateName(String old) {
//		if(cate.get(old) != null) {
			return cate.get(old);
//		}
//		return old;
	}
	public static void main(String[] args) {
		
		CateConverter.initCateMap();
	}
}
