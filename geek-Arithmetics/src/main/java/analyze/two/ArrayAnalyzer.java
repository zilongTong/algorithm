package analyze.two;

import java.util.List;

public class ArrayAnalyzer {
	//基础词库路径
	public static final String DICT_PATH = "/wj/one/dic.txt";
	private List<Integer> _baseList;
	private List<Integer> _checkList;
	
	
	
	
	public List<Integer> get_baseList() {
		return _baseList;
	}
	public void set_baseList(List<Integer> list) {
		_baseList = list;
	}
	public List<Integer> get_checkList() {
		return _checkList;
	}
	public void set_checkList(List<Integer> list) {
		_checkList = list;
	}
	
}
