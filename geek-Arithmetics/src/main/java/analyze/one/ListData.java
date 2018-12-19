package analyze.one;

import java.util.ArrayList;
import java.util.List;

public class ListData implements IData<List<String>> {

	private List<String> _data ;
	
	public ListData() {
		_data = new ArrayList<String>(0);
	}
	
	public List<String> value() {
		return _data;
	}

	public void process(String data) {
		_data.add(data);
	}

	public List<String> get_data() {
		return _data;
	}

}
