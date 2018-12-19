package chaintree.userinfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-5-30 上午11:04:59 
 */
public class Util {
	public static String getFieldTitle() {
		String[] fs = StaticValue.HANDLED_USER_FIELD;
		StringBuilder sb = new StringBuilder("");
		for(String f : fs) {
			sb.append(f).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static String handleLine(String line) {
		String[] ss = line.split(",");
		String temp = "";
		int len = ss.length;
		for(int j = 0; j < len; j ++) {
			String s = ss[j];
			if(j == 2) {//日期处理
				temp += getAgeAndStar(s).toString();
			} else if(j == 4) {
				temp += s != null && s.length() > 3 ? 1 : 0;
			} else {
				temp += s;
			}
			if(j < len - 1) {
				temp += ",";
			}
		}
		
		return temp;
	}
	
	public static AgeAndStar getAgeAndStar(String date) {
		AgeAndStar star = new AgeAndStar();
		int nowYear = Calendar.getInstance().get(Calendar.YEAR);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = null;
		try {
			sdf.parse(date);
			calendar = sdf.getCalendar();
		} catch (ParseException e) {
			calendar = Calendar.getInstance();
		}
		int y = calendar.get(Calendar.YEAR);
		star.setAge(nowYear + 1 - y);
		
		int m = calendar.get(Calendar.MONTH) + 1;
		int d = calendar.get(Calendar.DAY_OF_MONTH);

		int starIndex = StaticValue.getStarIndex(m, d);
		String satrStr = StaticValue.STAR[starIndex];
		star.setStar(starIndex);
		star.setStarName(satrStr);
		
		return star;
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(handleLine("+6598220605,1,1989-04-29 00:00:00,2,SEOWLINR89@HOTNAIL.COM,1"));
	}
	
}
