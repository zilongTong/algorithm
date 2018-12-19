package classifier.goods;

import classifier.AttributeValue;
import classifier.itf.Concept;
import classifier.itf.Interfere;

public class GoodsInterfere implements Interfere {

	public double helpInterfere(AttributeValue attributeValue, Concept c) {
		if(attributeValue.getValue().toString().indexOf("连身") > -1 &&
				c.getName().equalsIgnoreCase("裙")) {
			return 10;
		}
		return 1;
	}

}
