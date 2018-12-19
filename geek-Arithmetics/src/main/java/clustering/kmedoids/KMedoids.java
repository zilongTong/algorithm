package clustering.kmedoids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import clustering.kmeans.surface.Point;

public class KMedoids {

	protected int _clusterNum;
	protected List<Point> _srcList;
	protected Map<Integer, KmCluster> _clusters;
	public KMedoids(List<Point> list, int num) {
		_srcList = list;
		_clusterNum = num;
		_clusters = new HashMap<Integer, KmCluster>(_clusterNum, 0.95f);
	}
	
	public List<KmCluster> execute() {
		init();
		List<KmCluster> result = new ArrayList<KmCluster>(0);
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
				outDebug("聚类#" + key + ": " + _clusters.get(key) + " 距离: " + cDist);
			}
			
			outDebug("加入到 聚类#" + minKey + "：" + _clusters.get(minKey));
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
	
	/**
	 * 初始化聚类中心
	 */
	private void init() {
		for(int i = 1; i <= _clusterNum; i ++) {
			/*
			 * 随机选择聚类中心，效果不太好。
			 * 好的聚类中心需要差异性
			 */
			KmCluster cluster = new KmCluster(pick());
			_clusters.put(i, cluster);
		}
	}
	
	/**
	 * 随机选择点，作为聚类的初始中心点
	 * @return
	 */
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
