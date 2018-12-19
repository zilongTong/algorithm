package clustering.kmeans.line;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
	private List<Integer> _list;
	private boolean _isChanged = true;
	private double _avg = -1;
	
	public Cluster(Integer firstValue) {
		_list = new ArrayList<Integer>(0);
		_list.add(firstValue);
	}
	
	public void push(Integer tar) {
		_isChanged = true;
		_list.add(tar);
		calculateAvg();
	}
	
	public double distance(Integer tar) {
		calculateAvg();
		return Math.abs(_avg - tar);
	}
	
	public void calculateAvg() {
		if(_isChanged) {
			_avg = Util.average(_list);
			_isChanged = false;
		}
	}

	public List<Integer> get_list() {
		return _list;
	}
}
