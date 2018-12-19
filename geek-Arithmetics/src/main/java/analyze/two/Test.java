package analyze.two;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Test {

	public static int[] base = new int[1000000];
	public static int[] check = new int[1000000];

	
	public static List<String> initDicts() {
		List<String> dicts = new ArrayList<String>(0);
		String[] s = new String[]{	"中国心",
									"中国人",
									"中国情",
									"中央",
									"中央人民银行",
									"中心",
									"中间",
									"中间人",
									"中华",
									"中华人民共和国",
									"一丈",
									"一上",
									"一上去",
									"一上台",
									"一上场",
									"一上来",
									"一下",
									"一下下"};
		dicts.addAll(Arrays.asList(s));
		return dicts;
	}

	public static void setBaseK(Node node) {
		int k = 1;
		int code = String.valueOf(node.get_selfChar()).codePointAt(0);
		Map<Character, Node> sub = node.get_subNodes();
		if(sub.size() < 1){
			base[code] = 0;
			return;
		}
		for(;;k ++) {
			boolean isOk = true;
			Set<Character> subKey = sub.keySet();
			Iterator<Character> it = subKey.iterator();
			while(it.hasNext()) {
				Character c = it.next();
				int code1 = String.valueOf(c).codePointAt(0);
				int checkIndex = k + code1;
				if(check[checkIndex] != 0) {
					isOk = false;
				}
			}
			if(isOk) {
				break;
			}
		}
		base[code] = k;
		if(k == 1){
			System.out.println("\tbaseK="+node.get_selfChar());
		}
		if(sub != null){
			Set<Character> subKey = sub.keySet();
			Iterator<Character> it = subKey.iterator();
			while(it.hasNext()) {
				Node subNode = sub.get(it.next());
				if(node.get_selfChar() == "上海".charAt(0)&&subNode.get_selfChar() == "上海".charAt(1)){
					System.out.println("got it");
				}
				setCheckK(subNode, k, node);
			}
		}
	}
	public static void setCheckK(Node node, int prevK, Node p) {
		int k = 1;
		int checkCode = prevK + String.valueOf(node.get_selfChar()).codePointAt(0);
		if(checkCode == 38272){
			System.out.println(prevK +"\t char:"+node.get_selfChar()+"\t code:"+String.valueOf(node.get_selfChar()).codePointAt(0));
		}
		
		Map<Character, Node> sub = node.get_subNodes();
		if(sub.size() < 1){
			check[checkCode] = -1;
			return;
		}
		List<Integer> codes = new ArrayList<Integer>(0);
		Set<Character> subKey = sub.keySet();
		Iterator<Character> it = subKey.iterator();
		while(it.hasNext()) {
			codes.add(String.valueOf(it.next()).codePointAt(0));
		}
		
		for(;;k ++) {
			boolean isOk = true;
			for(Integer nodeCode : codes){
				if(check[k + nodeCode] != 0){
					isOk = false;
					break;
				}
			}

			if(isOk) {
				break;
			}
		}
		int yinzi = 1;
		if(node.is_allowEnd()){
			yinzi = -1;
		}

		check[checkCode] = k * yinzi;
		if(sub != null){
			subKey = sub.keySet();
			it = subKey.iterator();
			while(it.hasNext()) {
				Node subNode = sub.get(it.next());
				setCheckK(subNode, k, node);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		List<String> words = initDicts();
		Analyzer analyzer = new Analyzer();
		for(String w : words) {
			analyzer.loadExternal(w);
		}
		analyzer.initDictMap();
		Node root = analyzer.get_root();
		Map<Character, Node> map = root.get_subNodes();
		Set<Entry<Character, Node>> entity = map.entrySet();
		Iterator<Entry<Character, Node>> it = entity.iterator();
		while(it.hasNext()) {
			Entry<Character, Node> en = it.next();
			setBaseK(en.getValue());
		}

		String t = "中国情一丈长有中央人民银行中国心一不压众百不随一一不小心一不扭众一不注意一不留神一专多能一世一世之雄一世纪一世英名一世龙门一丘一壑一丘之貉一丙一业一丝一丝一毫一丝不挂";
		long b = System.currentTimeMillis();
		List<String> rs = new ArrayList<String>(0);
		int index = 0;
		int len = t.length();
		boolean isMax = false;
		while(index < len) {
			int code = t.codePointAt(index);
			int bc = base[code];
			String _temp = String.valueOf(t.charAt(index))+"["+code+"]";
			System.out.println(_temp + "bc:" +bc);
			if(bc != 0){
				int loop = index + 1;
				while(loop < len) {
					code = t.codePointAt(loop);
					bc = Math.abs(bc);
					_temp += String.valueOf(t.charAt(loop))+"["+code+"]";
					int chIndex = bc + code;
					bc = check[chIndex];
					System.out.println("\t"+_temp + "-checkIndex: "+chIndex+",bc="+bc);
					if(bc == 0){
						break;
					}else if(bc == -1){
						rs.add(_temp);
						break;
					}else if(bc < 0) {
						if(!isMax){
							rs.add(_temp);
						}
						bc = bc * -1;
					}
					loop ++;
				}
			}

			index ++;
		}
		System.out.println();
		System.out.println(System.currentTimeMillis() - b);
		
		for(String r : rs) {
			System.out.println(r);
		}
	}
}
