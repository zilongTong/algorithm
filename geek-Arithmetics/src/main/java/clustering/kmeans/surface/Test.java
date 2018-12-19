package clustering.kmeans.surface;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Point> points = new ArrayList<Point>(0);
		points.add(new Point(1,1));
		points.add(new Point(1.5,1.5));
		points.add(new Point(2,2));
		points.add(new Point(2.1,2.1));
		points.add(new Point(8,8));
		points.add(new Point(33,33));
		points.add(new Point(32,17));
		points.add(new Point(7,6));
		points.add(new Point(4,2.01));
		points.add(new Point(3,1));
		points.add(new Point(4,11));
		points.add(new Point(8,17));
		points.add(new Point(7,3.3));
		points.add(new Point(7,2));
		points.add(new Point(5,33));
		points.add(new Point(1,5));
		points.add(new Point(2,1));
		points.add(new Point(3,11));
		points.add(new Point(9.5,3));
		points.add(new Point(5.5,1.5));
		points.add(new Point(4,5));
		points.add(new Point(5,4));
		points.add(new Point(31,10));
		points.add(new Point(311,101));
		
		KMeans means = new KMeans(points, 4);
		means.setDebug(false);
		List<Cluster> rs = means.execute();
		for(Cluster c : rs) {
			System.out.println(c);
		}
	}
}
