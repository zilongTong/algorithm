package clustering.kmedoids;

import clustering.kmeans.surface.Cluster;
import clustering.kmeans.surface.Point;

public class KmCluster extends Cluster {

	public KmCluster(Point point) {
		super(point);
	}

	public Point newCenter(Point tar) {
		Point current = null;
		double minTotal = -1;
		for(Point p : _list) {
			double total = 0;
			for(Point p1 : _list) {
				total += p.distance(p1);
			}
			System.out.println(p+":"+total);
			if(minTotal == -1 || minTotal > total){
				minTotal = total;
				current = p;
			}
		}
		return current;
	}
	
}
