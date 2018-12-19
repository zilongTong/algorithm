package analyze.four;

import java.util.HashMap;
import java.util.Map;

public class Node {

	private Character _selfChar;
	
	private boolean _allowEnd = false;
	
	private Map<Character, Node> _subNodes = new HashMap<Character, Node>(16, 0.95f);

	private String word;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Node() {
	}
	public Node(Character ch) {
		this._selfChar = ch;
	}

	public Character get_selfChar() {
		return _selfChar;
	}
	public void set_selfChar(Character char1) {
		_selfChar = char1;
	}
	public Map<Character, Node> get_subNodes() {
		return _subNodes;
	}
	public void set_subNodes(Map<Character, Node> nodes) {
		_subNodes = nodes;
	}
	public Node push(Character ch) {
		if(_subNodes.get(ch) == null) {
			_subNodes.put(ch, new Node(ch));
		}
		return _subNodes.get(ch);
	}
	
	public Node get(Character ch) {
		return _subNodes.get(ch);
	}
	public boolean is_allowEnd() {
		return _allowEnd;
	}
	public void set_allowEnd(boolean end) {
		_allowEnd = end;
	}
}
