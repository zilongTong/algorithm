package ansj.sun.bloomFilter;
import java.io.File;

import util.resource.ResourceReader;
import ansj.sun.bloomFilter.filter.ELFFilter;
import ansj.sun.bloomFilter.filter.FNVFilter;
import ansj.sun.bloomFilter.filter.HfFilter;
import ansj.sun.bloomFilter.filter.HfIpFilter;
import ansj.sun.bloomFilter.filter.JSFilter;
import ansj.sun.bloomFilter.filter.JavaFilter;
import ansj.sun.bloomFilter.filter.PHPFilter;
import ansj.sun.bloomFilter.filter.PJWFilter;
import ansj.sun.bloomFilter.filter.RSFilter;
import ansj.sun.bloomFilter.filter.SDBMFilter;
import ansj.sun.bloomFilter.iface.BitMap;
import ansj.sun.bloomFilter.iface.Filter;

/**
 * BlommFilter ʵ�� 1.����hash�㷨 2.ɢ��hashӳ�䵽�����bitλ�� 3.��֤
 * 
 * @author Ansj
 */
public class BloomFilter {
	
	private static int length = 10 ;
	
	Filter[] filters = new Filter[length] ;
	
	public BloomFilter(int m, int machine) throws Exception{
		float mNum = m / 5 ;
		long size = (long) (1L * mNum * 1024 * 1024 * 8) ;
		filters[0] = new JavaFilter(size, machine) ;
		filters[1] = new PHPFilter(size, machine) ;
		filters[2] = new JSFilter(size, machine) ;
		filters[3] = new PJWFilter(size, machine) ;
		filters[4] = new SDBMFilter(size, machine) ;
		filters[5] = new ELFFilter(size, machine) ;
		filters[6] = new FNVFilter(size, machine) ;
		filters[7] = new HfIpFilter(size, machine) ;
		filters[8] = new RSFilter(size, machine) ;
		filters[9] = new HfFilter(size, machine) ;
	}
	
	public void add(String str){
		for (int i = 0; i < length; i++) {
			filters[i].add(str) ;
		}
	}
	
	/**
	 * ȫ��1����ʾ���ڣ�ʵ�����к�С����Ҳ�ǲ�����
	 * ��һ����Ϊ1����ʾ�����ڣ�ʵ���Ͼ��ǲ�����
	 * 
	 * false:������
	 * true:���ڣ���С�Ŀ����ǲ����ڣ����©url
	 * @param str
	 * @return
	 */
	public boolean contains(String str){
		for (int i = 0; i < length; i++) {
			if(!filters[i].contains(str)){
				//��һ��bitλ����1���򷵻�false����ʾ������
				return false ;
			}
		}
		return true;
	}
	
	public boolean containsAndAdd(String str){
		boolean flag = true ;
		for (int i = 0; i < length; i++) {
			//�����ڣ�����false�������
			boolean temp = filters[i].containsAndAdd(str);
			if(flag) {	//���flag��false����������������һ��bit�ǲ�Ϊ1���϶��ǲ����ڣ�����Ҫ������flag��ֵ
				flag = temp;
			}
//			flag = flag && filters[i].containsAndAdd(str) ;
		}
		return flag ;
	}

	public static void main(String[] args) throws Exception {
		//Test
		String path = "F:/��������/url/urls.txt";
		ResourceReader r = new ResourceReader(new File(path));
		r.load();
		String url = null;
		
		BloomFilter filter = new BloomFilter(64, BitMap.MACHINE64);
		
		while((url = r.readLine()) != null) {
			if(!filter.containsAndAdd(url)) {
				System.out.println(url);
			}
		}
		
//		long b = System.nanoTime();
//		System.out.println(filter.contains("http://www.iteye.com/news/30611"));
//		System.out.println("cost : " + (System.nanoTime() - b) / 1000000f);
//		System.out.println(filter.containsAndAdd("http://www.iteye.com/news/30611"));
		
		r.close();
	}
}
