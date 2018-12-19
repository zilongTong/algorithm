package clustering.kmeans.surface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class KMeans {

	protected int _clusterNum;
	protected List<Point> _srcList;
	protected Map<Integer, Cluster> _clusters;
	public KMeans(List<Point> list, int num) {
		_srcList = list;
		_clusterNum = num;
		_clusters = new HashMap<Integer, Cluster>(_clusterNum, 0.95f);
	}
	
	public List<Cluster> execute() {
		init();
		List<Cluster> result = new ArrayList<Cluster>(0);
		while(_srcList.size() > 0) {
			Point tar = _srcList.remove(0);
			int minKey = 0;
			double minDist = -1;
			outDebug("当前:" + tar);
			for(int key = 1; key <= _clusterNum; key ++) {
				double cDist = distance(key, tar);
				if(minDist == -1 || minDist > cDist) {
					minDist = cDist;
					minKey = key;
				}
				outDebug(_clusters.get(key) + "; 距离: " + cDist);
			}
			
			outDebug("加入到：" + _clusters.get(minKey));
			_clusters.get(minKey).push(tar);
			outDebug("********************************************************");
		}
		
		Iterator<Integer> it = _clusters.keySet().iterator();
		while(it.hasNext()) {
			result.add(_clusters.get(it.next()));
		}
		return result;
	}
	
	protected double distance(Integer key, Point tar) {
		return _clusters.get(key).distance(tar);
	}
	
	private void init() {
		for(int i = 1; i <= _clusterNum; i ++) {
			Cluster cluster = new Cluster(pick());
			_clusters.put(i, cluster);
		}
	}
	
	private Point pick() {
		Random random = new Random(System.currentTimeMillis());
		int size = _srcList.size();
		if(size < 1) {
			return new Point(0, 0);
		}
		return _srcList.remove(random.nextInt(size));
	}
	
	private void outDebug(String msg) {
		if(_isDebug)
			System.out.println(msg);
	}
	
	public int get_clusterNum() {
		return _clusterNum;
	}
	public List<Point> get_srcList() {
		return _srcList;
	}
	
	private boolean _isDebug = false;
	public void setDebug(boolean debug) {
		_isDebug = debug;
	}
}
