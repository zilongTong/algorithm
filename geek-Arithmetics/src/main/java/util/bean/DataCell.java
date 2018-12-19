package util.bean;

import java.util.Arrays;

import util.datareader.Attributes;

public class DataCell {

	private String _labelId;
	
	private Attribute[] _attributes = null;
	
	private String[] _attributeNames = null;
	
	private String[] _textAttributeValues = null;
	
	private double[] _numericAttributeValues = null;

	public DataCell(String label, String[] values) {
		init(label, Attributes.createAttributes(values));
	}
	
	public DataCell(String label, double[] values) {
		init(label, Attributes.createAttributes(values));
	}
	
	public DataCell(String label, Attribute[] attributes) {
		init(label, attributes);
	}
	
	public void init(String label, Attribute[] attributes) {
		_labelId = label;
		_attributes = attributes;
		_attributeNames = Attributes.getNames(attributes);
		
		if(Attributes.isAllValueNumeric(attributes)) {
			_numericAttributeValues = Attributes.getNumericValues(attributes);
		}
		
		if(Attributes.isAllValueText(attributes)) {
			_textAttributeValues = Attributes.getTextValues(attributes);
		}
	}
	
	public int getAttributesCount() {
		return _attributes.length;
	}

	public String get_labelId() {
		return _labelId;
	}
	public void set_labelId(String id) {
		_labelId = id;
	}
	public Attribute[] get_attributes() {
		return _attributes;
	}
	public void set_attributes(Attribute[] _attributes) {
		this._attributes = _attributes;
	}
	public String[] get_attributeNames() {
		return _attributeNames;
	}
	public void set_attributeNames(String[] names) {
		_attributeNames = names;
	}
	public String[] get_textAttributeValues() {
		return _textAttributeValues;
	}
	public void set_textAttributeValues(String[] attributeValues) {
		_textAttributeValues = attributeValues;
	}
	public double[] get_numericAttributeValues() {
		return _numericAttributeValues;
	}
	public void set_numericAttributeValues(double[] attributeValues) {
		_numericAttributeValues = attributeValues;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(_attributeNames);
		result = prime * result + Arrays.hashCode(_attributes);
		result = prime * result
				+ ((_labelId == null) ? 0 : _labelId.hashCode());
		result = prime * result + Arrays.hashCode(_numericAttributeValues);
		result = prime * result + Arrays.hashCode(_textAttributeValues);
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
		final DataCell other = (DataCell) obj;
		if (!Arrays.equals(_attributeNames, other._attributeNames))
			return false;
		if (!Arrays.equals(_attributes, other._attributes))
			return false;
		if (_labelId == null) {
			if (other._labelId != null)
				return false;
		} else if (!_labelId.equals(other._labelId))
			return false;
		if (!Arrays.equals(_numericAttributeValues,
				other._numericAttributeValues))
			return false;
		if (!Arrays.equals(_textAttributeValues, other._textAttributeValues))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return _labelId + "(" + Arrays.toString(_attributes) + ")";
	}
}
