package classifier.core;

import classifier.itf.Attribute;
import classifier.itf.Concept;
import classifier.itf.Instance;

public class BaseInstance implements Instance {
	
	protected Concept concept;
	
	protected StringAttribute[] attributes;

	public BaseInstance() { }
	
	public BaseInstance(Concept concept, StringAttribute[] attrs) {
		this.concept = concept;
		attributes = attrs;
	}
	
	public Attribute getAttributeByName(String attrName) {
		Attribute matchAttr = null;
		if(attributes != null && attrName != null) {
			for(StringAttribute sa : attributes) {
				if(attrName.equalsIgnoreCase(sa.getName())) {
					return sa;
				}
			}
		}
		return matchAttr;
	}

	public Attribute[] getAttributes() {
		return attributes;
	}

	public Concept getConcept() {
		return concept;
	}

	public void print() {
		
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

}
