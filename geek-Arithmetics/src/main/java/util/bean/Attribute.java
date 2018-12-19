package util.bean;

import util.tools.Numeric;

public class Attribute {
	
	private String _name;
	
	private Object _value;

	public Attribute(String name, String value) {
		init(name, value);
	}
	public Attribute(String name, Double value) {
		init(name, value);
	}
	
	public void init(String name, Object value) {
		_name = name;
		_value = value;
	}
	
	public boolean isValueText() {
		if(_value instanceof String) {
			return true;
		}
		return false;
	}
	public String getTextValue() {
		return _value.toString();
	}

	public boolean isValueNumeric () {
		if(_value instanceof Double) {
			return true;
		}else if(Numeric.is(_value)){
			return true;
		}
		return false;
	}
	public double getNumericValue() {
		return Double.parseDouble(_value.toString());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		result = prime * result + ((_value == null) ? 0 : _value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Attribute other = (Attribute) obj;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		if (_value == null) {
			if (other._value != null)
				return false;
		} else if (!_value.equals(other._value))
			return false;
		return true;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public Object get_value() {
		return _value;
	}
	public void set_value(Object _value) {
		this._value = _value;
	}
	
    @Override
	public String toString() {
        return "[name="+this._name + 
            ", value=" + _value + 
            ", isText=" + this.isValueText() + 
            ", isNumeric=" + this.isValueNumeric() + "]";
    }
}
