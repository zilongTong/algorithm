package clustering.kmedoids;

import java.util.ArrayList;
import java.util.List;
import clustering.kmeans.surface.Point;

public class Test {

	/**
	 * @param args
	 */
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
		
		KMedoids medoids = new KMedoids(points, 4);
		medoids.setDebug(true);
		List<KmCluster> rs = medoids.execute();
		for(KmCluster c : rs) {
			System.out.println(c);
		}

	}

}
