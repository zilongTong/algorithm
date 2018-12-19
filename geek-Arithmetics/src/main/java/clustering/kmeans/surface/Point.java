package clustering.kmeans.surface;


public class Point {

	private double _x;
	private double _y;
	private static int counter = 0;
	private int id;
	
	public Point(double x, double y) {
		_x = x;
		_y = y;
		id = counter ++;
	}
	
	public int getID() {
		return id;
	}
	
	public double get_x() {
		return _x;
	}
	public double get_y() {
		return _y;
	}
	
	@Override
	public String toString() {
		return "(" + _x + "," + _y + ")";
	}
	public double distance(Point tar) {
		return Math.sqrt(
				Math.pow(_x - tar.get_x(), 2) + 
				Math.pow(_y - tar.get_y(), 2));
	}
}
