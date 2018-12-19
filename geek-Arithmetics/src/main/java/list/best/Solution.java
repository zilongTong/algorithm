package list.best;


/**
 *
 * @author Smile.Wu
 * @version 2015-9-14
 */
public class Solution {
	public int caculate(String s) {
		int rs = 0;
		
		if(s.indexOf('(') < 0) {
			String current = "";
			int op = 1;
			for(int i = 0, len = s.length(); i < len; i ++) {
				char c = s.charAt(i);
				if(c == ' ') {
					continue;
				}
				if(c == '+' || c == '-') {
					if(current.length() > 0) {
						rs += (Integer.parseInt(current) * op);
					}
					if(c == '+') {
						op = 1;
					} else {
						op = -1;
					}
					current = "";
				} else {
					current += c;
				}
			}
			rs += (Integer.parseInt(current) * op);
			return rs;
		} else {
			int openCount = 0;
			for(int i = 0, len = s.length(); i < len; i ++) {
				char c = s.charAt(i);
				if(c == '(') {
					openCount ++;
				} 
			}
			
			int opens = 0;
			String[] openSubs = new String[openCount];
			int index = -1;
			for(int i = 0, len = s.length(); i < len; i ++) {
				char c = s.charAt(i);
				if(c == '(') {
					index ++;
					openSubs[index] = "";
					opens ++;
				} else if(c == ')') {
					opens --;
					String temp1 = openSubs[index];
					index --;
					if(index < 0) {
						index = 0;
						openSubs[index] = caculate(temp1)+"";
					} else {
						openSubs[index] += caculate(temp1);
					}
				} else {
					openSubs[index] += c;
				}
			}
			
			if(opens == 0) {
				return caculate(openSubs[0]);
			}
			
		}
		return rs;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().caculate("0"));
		System.out.println(new Solution().caculate("1 + 1"));
		System.out.println(new Solution().caculate("2-1+2"));
		System.out.println(new Solution().caculate("(1+(4+5+2)-3)+(6+8)"));
	}
}
