package analyze.one;

import java.util.HashMap;
import java.util.Map;

public class MapData implements IData<Map<String, Integer>> {
	
	private Map<String, Integer> _data;
	
	public MapData() {
		_data = new HashMap<String, Integer>(0);
	}

	public void process(String data) {
		Integer num = _data.get(data);
		if(num == null) {
			_data.put(data, 1);
		}else{
			_data.put(data, num + 1);
		}
	}

	public Map<String, Integer> value() {
		return _data;
	}

	public Map<String, Integer> get_data() {
		return _data;
	}

}
