package classifier.core;

import classifier.AttributeValue;
import classifier.itf.Concept;
import classifier.itf.Interfere;

public class BaseInterfere implements Interfere {

	public double helpInterfere(AttributeValue attributeValue, Concept c) {
		return 1;
	}

}
