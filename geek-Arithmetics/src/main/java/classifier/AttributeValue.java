package classifier;

public class AttributeValue {
	
	private Object value;
	
	/**
	 * 属性值出现的次数
	 * 一个属性值只会在一个实例中出现一次
	 */
	private int count;

	public AttributeValue(Object value) {
		this.value = value;
		count = 1;
	}
	
	public void count() {
		count++;
	}

	public Object getValue() {
		return value;
	}

	public int getCount() {
		return count;
	}
	
	@Override
	public boolean equals(Object obj) {
        
        final AttributeValue other = (AttributeValue) obj;
        
        if (obj == null) {
            return false;
        }
        
		if (getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            return true;
        }
		        
        if (value == null) {
            
        	if (other.value != null) {
                return false;
            }
        
        } else if (!value.equals(other.value)) {
        	
            return false;
        }
        
        return true;
	}

	@Override
	public String toString() {
		return "Attribute value: "+value+" was found "+count+"times";
	}
}
