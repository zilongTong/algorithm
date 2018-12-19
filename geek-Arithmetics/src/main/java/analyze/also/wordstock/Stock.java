package analyze.also.wordstock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import analyze.also.exp.NullPathException;

public class Stock {
	
	private Node _root;
	
	private String _dicPath = "";
	
	public Stock(String dicPath) {
		_root = new Node();
		_dicPath = dicPath;
	}
	public Node get_root() {
		return _root;
	}

	public void set_root(Node _root) {
		this._root = _root;
	}

	/**
	 * 初始化词库树
	 * @throws IOException
	 */
	public void initDictMap() throws IOException, NullPathException {
		if(_dicPath == null || _dicPath.isEmpty())
			throw new NullPathException();
		InputStream is = null;
        InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			is = Stock.class.getResourceAsStream(_dicPath);
	        isr = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(isr, 512);
			String line = null;
			while((line = br.readLine()) != null) {
				loadExternal(line);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if(br != null) {
				br.close();
			}
			if(isr != null) {
				isr.close();
			}
			if(is != null) {
				is.close();
			}
		}
	}
	
	public void loadExternal(String word) {
		Node temp = null;
		temp = _root;
		for(int i = 0; i < word.length(); i ++) {
			Character ch = word.charAt(i);
			//添加词库单字
			temp = temp.push(ch);
		}
		temp.set_allowEnd(true);
	}
	
	/**
	 * 匹配词库树
	 * @param test
	 * @param isMax
	 * @return
	 */
	public List<String> process(String test, boolean isMax) {
		List<String> rs = new ArrayList<String>(0);
		int index = 0;
		int len = test.length();
		
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
			for(;current != null;) {
				//若匹配到，则保存当前单字
				_temp += current.get_selfChar();
				lastAllow = current.is_allowEnd();
				//如果是词尾，而且 不是最大分词，则保存结果，继续分词
				if(lastAllow && !isMax) {
					rs.add(_temp);
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
			//最短匹配词长度必须大于0
			if(_temp.length() > 0){
				//如果 是最大分词，而且是词尾，则保存结果
				//非最大分词，结果在上面保存
				if(isMax && lastAllow){
					rs.add(_temp);
				}else{
					//如果不是词尾，则回退
					index = index - (_temp.length() - 1);
				}
			}
			index ++;
		}
		return rs;
	}
	
}
