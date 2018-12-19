package sim.largetest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IndexMapper {

	private long _index = 0;
	private Map<Long, Long> _indexToMobile = new HashMap<Long, Long>(16, 0.95f);
	private Set<Long> _mobiles = new HashSet<Long>();
	public long get_index() {
		return _index;
	}
	public void set_index(long _index) {
		this._index = _index;
	}
	public Map<Long, Long> get_indexToMobile() {
		return _indexToMobile;
	}
	public void set_indexToMobile(Map<Long, Long> toMobile) {
		_indexToMobile = toMobile;
	}
	public long getObjectIdFrom(long index) {
		return _indexToMobile.get(index);
	}
	public void getIndex(long mobile) {
		if(!_mobiles.contains(mobile)) {
			_indexToMobile.put(_index, mobile);
			_mobiles.add(mobile);
			_index ++;
		}
	}
}
