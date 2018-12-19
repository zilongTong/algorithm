package chaintree.userinfo;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-5-30 上午11:06:04 
 */
public class StaticValue {

	public static final String USER_DATE_SRC = "D:/同事文档/sql_data/查询结果.csv";
	
	public static final String USER_DATE_AFTER_HANDLE = "D:/快盘/Java Design Model/Arithmetics/src/chaintree/userinfo/user.dat";
	
	public static final String[] HANDLED_USER_FIELD = new String[]{"Mobile", "IsActive", "Age", "Star", "Sex",
		"Email", "userType"};
	
	public static final String[] STAR = new String[]{"无", 
		"水瓶座", "双鱼座", "白羊座", "金牛座",
		"双子座", "巨蟹座", "狮子座", "处女座",
		"天枰座", "天蝎座", "射手座", "摩羯座"
	};
	private static int returnInt(int d, int min, int last, int thisd) {
		if(d <= min) {
			return last;
		}
		return thisd;
	}
	public static int getStarIndex(int m, int d) {
		switch (m) {
		case 1://12--19
			return returnInt(d, 19, 12, m);
		case 2://1--18
			return returnInt(d, 18, 1, m);
		case 3://2--20
			return returnInt(d, 20, 2, m);
		case 4://3--19
			return returnInt(d, 19, 3, m);
		case 5://4--20
			return returnInt(d, 20, 4, m);
		case 6://5--21
			return returnInt(d, 21, 5, m);
		case 7://6--22
			return returnInt(d, 22, 6, m);
		case 8://7--22
			return returnInt(d, 22, 7, m);
		case 9://8--22
			return returnInt(d, 22, 8, m);
		case 10://9--23
			return returnInt(d, 23, 9, m);
		case 11://10--23
			return returnInt(d, 23, 10, m);
		case 12://11--21
			return returnInt(d, 21, 11, m);
		default:
			return 0;
		}
	}
	
	public static final String[] COMMON_EMAIL_ENDER = new String[]{
		"qq.com", "126.com", "163.com", "gmail.com"
	};
	
	public static void main(String[] args) {
		
		int t = getStarIndex(2, 19);
		System.out.println(t);
		System.out.println(StaticValue.STAR[t]);
	}
}
