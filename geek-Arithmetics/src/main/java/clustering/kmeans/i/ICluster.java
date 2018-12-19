package clustering.kmeans.i;

import clustering.kmeans.surface.Point;

public interface ICluster {

	public void push(Point tar);
	
	public double distance(Point tar);

	public Point newCenter(Point tar);
}
