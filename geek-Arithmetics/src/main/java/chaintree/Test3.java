package chaintree;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import clustering.kmeans.surface.Point;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2013-1-14 下午4:42:50 
 */
public class Test3 {
	public static Point[] createPoints() {
		int length = 400;
		Point[] ps = new Point[length];
		
		Map<Integer, Point> centers = new HashMap<Integer, Point>();
		centers.put(0, new Point(15, 15));
		centers.put(1, new Point(-15, 15));
		centers.put(2, new Point(15, -15));
		centers.put(3, new Point(-15, -15));
		
		for(int i = 0; i <length; i++) {
			Point p = centers.get(i % 4);
			ps[i] = createPoint(i, p.get_x(), p.get_y());
		}
		
		return ps;
	}
	
	public static Point createPoint(int i, double x, double y) {
		double x1 = new Random(i).nextInt(6) - 3 + x;
		double y1 = new Random(i + (long) x1).nextInt(6) - 3 + y;
		return new Point(x1, y1);
	}
	
	public static double[][] createMatrix(Point[] points) {
		int n = points.length;
		double[][] rs = new double[n][n];
		
		for(int i = 0; i < n; i ++) {
			Point a = points[i];
			for(int j = i + 1; j < n; j ++) {
				Point b = points[j];
				rs[i][j] = distance(a, b);
				rs[j][i] = rs[i][j];
			}
		}
		
		return rs;
	}

	public static double distance(Point a, Point b) {
		
		return Math.sqrt(Math.pow(a.get_x() - b.get_x(), 2) + Math.pow(a.get_y() - b.get_y(), 2));
	}
	
	public static void main(String[] args) {
		Point[] points = createPoints();
		double[][] matrix = createMatrix(points);
		
//		Matrix matrix2 = new Matrix(matrix);
//		matrix2.display();
		
		SingleLinkAlgorithm singleLinkAlgorithm = new SingleLinkAlgorithm(points, matrix, 10);
		
		Dendrogram dendrogram = singleLinkAlgorithm.cluster();
		
		dendrogram.print(7);
	}
}
