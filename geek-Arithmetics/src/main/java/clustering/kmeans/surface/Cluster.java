package clustering.kmeans.surface;

import java.util.ArrayList;
import java.util.List;

import clustering.kmeans.i.ICluster;

public class Cluster implements ICluster {
	protected Point _centerPoint;
	protected List<Point> _list;
	private static int counter;
	private String label = "";
	public Cluster(Point point) {
		this();
		_centerPoint = point;
		if(point != null) {
			_list.add(point);
		}
	}

	public Cluster() {
		_centerPoint = null;
		_list = new ArrayList<Point>(0);
		label = (counter ++) + "";
	}
	
	public Cluster(List<Point> ps) {
		this();
		_centerPoint = null;
		_list = ps;
	}
	
	
	public double distance(Point tar) {
		return _centerPoint.distance(tar);
	}
	public void push(Point tar) {
		_list.add(tar);
		_centerPoint = newCenter(tar);
	}
	public Point newCenter(Point tar) {
		double totalX = 0;
		double totalY = 0;
		for(Point p : _list) {
			totalX += p.get_x();
			totalY += p.get_y();
		}
		double size = _list.size();
		return new Point(totalX / size, totalY / size);
	}
	public Point get_centerPoint() {
		return _centerPoint;
	}
	public List<Point> get_list() {
		return _list;
	}
	
	@Override
	public String toString() {
		return label;
	}

	public String getElementString() {
		StringBuilder sb = new StringBuilder("[");
		for(Point p : _list) {
			sb.append(p).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("] center:" + _centerPoint + " ");
		return sb.toString();
	}
	
	public boolean contain(Point p) {
		for(Point pt : _list) {
			if(pt.getID() == p.getID()) {
				return true;
			}
		}
		return false;
	}
	public Cluster copy() {
		Cluster c = new Cluster();
		for(Point p : this._list) {
			c.get_list().add(p);
		}
		return c;
	}
}
