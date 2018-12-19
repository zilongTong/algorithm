package analyze.four;

public class Analyzer {

	//词库树根节点
	private Node _root;
	
	public Analyzer() {
		_root = new Node();
	}
	public Node get_root() {
		return _root;
	}

	public void set_root(Node _root) {
		this._root = _root;
	}

	public void loadExternal(String word) {
		String sameWord = word.split(":")[1];
		word = word.split(":")[0];
		loadExternalWord(word, sameWord);
	}
	public void loadExternalWord(String word, String sameWord) {
		Node temp = null;
		temp = _root;
		for(int i = 0; i < word.length(); i ++) {
			Character ch = word.charAt(i);
			//添加词库单字
			temp = temp.push(ch);
		}
		temp.set_allowEnd(true);
		temp.setWord(sameWord);
	}
	
	public String replace(String test, boolean isMax) {
		int index = 0;
		int len = test.length();
		StringBuilder afterReplace = new StringBuilder("");
		String sameWord = "";
		
		//匹配词库单字过程中，当前匹配点
		Node current = null;
		
		//最后跳出时的node节点是否是词尾
		boolean lastAllow = false;
		while(index < len) {
			String _temp = "";
			//当前单字
			Character ch = test.charAt(index);
			//每次重新匹配都从根节点开始
			current = _root.get(ch);
			if(current == null) {
				afterReplace.append(String.valueOf(ch));
			}
			for(;current != null;) {
				//若匹配到，则保存当前单字
				_temp += current.get_selfChar();
				lastAllow = current.is_allowEnd();
				//如果是词尾，而且 不是最大分词，则保存结果，继续分词
				if(lastAllow) {
					sameWord = current.getWord();
					if(!isMax) {
						afterReplace.append(" " + sameWord + " ");
					}
				}
				index ++;
				if(index >= len){
					//超出边界
					break;
				}
				//移动到下一个单字节点
				ch = test.charAt(index);
				current = current.get(ch);
				//若为空，则回退
				if(current == null) {
					index --;
					break;
				}
			}
			//最短匹配词长度必须大于一
			if(_temp.length() > 1){
				//如果 是最大分词，而且是词尾，则保存结果
				//非最大分词，结果在上面保存
				if(isMax && lastAllow){
					afterReplace.append(" " + sameWord + " ");
				}else{
					//如果不是词尾，则回退
					index = index - (_temp.length() - 1);
				}
			} else {
				afterReplace.append(_temp);
			}
			index ++;
		}
		return afterReplace.toString();
	}
}
