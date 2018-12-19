package analyze.assemble;
import java.util.ArrayList;
import java.util.List;

/**
 * 关键字组合类
 * 排列组合概念中的组合
 * @author HQ01U8435
 *
 */
public class Assemble {

	public static <T> List<List<T>> get(List<T> src, List<List<T>> n) {
		List<List<T>> rs = new ArrayList<List<T>>();
		if(n == null || n.size() < 1){
			for(T s : src) {
				List<T> k = new ArrayList<T>();
				k.add(s);
				rs.add(k);
			}
		}else{
			for(List<T> o : n) {
				int index = src.indexOf(o.get(o.size() - 1));
				if(index >= src.size() - 1) {
					continue;
				}
				for(int i = index + 1; i < src.size(); i ++) {
					List<T> newList = new ArrayList<T>();
					newList.addAll(o);
					newList.add(src.get(i));
					rs.add(newList);
				}
			}
		}
		return rs;
	}
	public static <T> List<List<T>> get(List<T> src) {
		if(src == null || src.size() < 1){
			return new ArrayList<List<T>>(0);
		}
		List<List<T>> rs = new ArrayList<List<T>>();
		List<List<T>> temp = null;
		int len = src.size();
		do {
			temp = get(src, temp);
			rs.addAll(temp);
		} while(temp.get(0).size() <= len - 1);
		return rs;
	}
	
	
	public static void main(String[] args) {
		List<String> src = new ArrayList<String>();
		src.add("休闲");
		src.add("男装");
		src.add("外套");
		src.add("修身");
		src.add("花格子");
		
		List<List<String>> rs = get(src);
		for(List<String> r : rs) {
			System.out.println(r);
		}
	}
}
