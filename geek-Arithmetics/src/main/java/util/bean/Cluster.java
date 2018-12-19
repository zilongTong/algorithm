package util.bean;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Cluster {

	private String _label;
	
	private Set<DataCell> _elements;
	
	public Cluster() {
		init("");
	}
	
	public Cluster(String label) {
		init(label);
	}
	
	public Cluster(String label, Collection<DataCell> cells) {
		init(label);
		for(DataCell cell : cells) {
			add(cell);
		}
	}
	
	public Cluster(Collection<DataCell> cells) {
		init("");
		for(DataCell cell : cells) {
			add(cell);
		}
	}
	
	public Cluster(Cluster c1, Cluster c2) {
		init("");
		add(c1);
		add(c2);
	}
	
	public Cluster(DataCell cell) {
		init("");
		add(cell);
	}
	
	private void init(String label) {
		_label = label;
		_elements = new LinkedHashSet<DataCell>();
	}

	public void add(DataCell cell) {
		_elements.add(cell);
	}
	
	public void add(Cluster cluster) {
		for(DataCell cell : cluster._elements) {
			add(cell);
		}
	}
	
	public int size() {
		return _elements.size();
	}

    public int getDimensionCount() {
        if( _elements == null || _elements.isEmpty() ) {
            return 0;
        }
        
        return _elements.iterator().next().getAttributesCount();
    }
    
    public Cluster copy() {
        Cluster copy = new Cluster();
        for(DataCell e : this.get_elements()) {
            copy.add(e);
        }
        return copy;
    }
    
    public boolean contain(DataCell cell) {
    	return _elements.contains(cell);
    }
    
    public boolean contain(Cluster cluster) {
    	for(DataCell cell : cluster.get_elements()) {
    		if(!contain(cell)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public Set<DataCell> getElements() {
    	return new LinkedHashSet<DataCell>(_elements);
    }
    
	public String get_label() {
		return _label;
	}
	public void set_label(String _label) {
		this._label = _label;
	}
	public Set<DataCell> get_elements() {
		return _elements;
	}
	public void set_elements(Set<DataCell> _elements) {
		this._elements = _elements;
	}
    
    public String getElementsAsString() {
        StringBuffer buf = new StringBuffer();
        for(DataCell c : _elements) {
            if( buf.length() > 0 ) {
                buf.append(", ");
            }
            buf.append(c.get_labelId());
        }

        return "{" + buf.toString() + "}";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_elements == null) ? 0 : _elements.hashCode());
		result = prime * result + ((_label == null) ? 0 : _label.hashCode());
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
		final Cluster other = (Cluster) obj;
		if (_elements == null) {
			if (other._elements != null)
				return false;
		} else if (!_elements.equals(other._elements))
			return false;
		if (_label == null) {
			if (other._label != null)
				return false;
		} else if (!_label.equals(other._label))
			return false;
		return true;
	}
	
}
