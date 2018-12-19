package classifier.goods.trainsform;

import classifier.goods.data.Goods;
import classifier.goods.trainsform.itf.IProcessLineString;

public class ProcessOne implements IProcessLineString {

	public Goods process(String src) {
		if(src == null) {
			return null;
		}
		String[] params = src.split(",");
		String sn = params[0];
		String title = params[1];
		String oldCate = params[3];
		String attr = "";
		if(params.length >= 6) {
			attr = params[4] + " " + params[5];
		}
		Goods g = new Goods();
		g.setGoodsSn(sn);
		g.setCate(CateConverter.convertCateName(oldCate));
		g.setAttr(attr);
		g.setTitle(title);
		
		return g;
	}

}
