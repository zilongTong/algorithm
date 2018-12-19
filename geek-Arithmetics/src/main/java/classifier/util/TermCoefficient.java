package classifier.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 计算字符串数组的相似性
 * @author 吴健 (HQ01U8435)
 *
 */
public class TermCoefficient implements SimilarityMeasure {
	private static final long serialVersionUID = 4223687407927691763L;

	public TermCoefficient() {
		
	}
	
	public double similarity(String[] x, String[] y) {
		double sim = 0.0;
		if( (x != null && y != null) && (x.length > 0 || y.length > 0)) {
			sim = similarity(Arrays.asList(x), Arrays.asList(y));
		} else {
			throw new IllegalArgumentException("The arguments x and y must be not NULL and either x or y must be non-empty.");
		}
		return sim;
	}
	
	private double similarity(List<String> x, List<String> y) {
		int xS = x.size();
		int yS = y.size();
		if(xS == 0 || yS == 0) {
			return 0.0;
		}
		Set<String> intersectionXY = new HashSet<String>(x);
		
		intersectionXY.retainAll(y);
		double xySize = (double)intersectionXY.size();
		return xySize / (xS + yS - xySize);
	}
	
	public static void main(String[] args) {
		String[] s1 = new String[]{"A", "B", "C", "D", "E"};
		String[] s2 = new String[]{"B", "D", "T", "E", "H"};
		
		TermCoefficient tc = new TermCoefficient();
		long b = System.currentTimeMillis();
		System.out.println(tc.similarity(s1, s2));
		System.out.println(System.currentTimeMillis() - b);
	}
}
