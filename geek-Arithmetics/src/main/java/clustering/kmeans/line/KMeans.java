package clustering.kmeans.line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class KMeans {

	private int _clusterNum;
	private List<Integer> _srcList;
	private Map<Integer, Cluster> _clusters;
	public KMeans(List<Integer> list, int clusterNum) {
		_clusterNum = clusterNum;
		_srcList = list;
	}
	
	public List<Cluster> execute() {
		initCluster();

		while(_srcList.size() > 0){
			int tar = _srcList.remove(0);
			int tarKey = -1;
			double minDist = -1;
			for(int key = 1; key <= _clusterNum; key ++) {
				double cDist = _clusters.get(key).distance(tar);
				if(minDist == -1 || minDist > cDist) {
					minDist = cDist;
					tarKey = key;
				}
			}
			_clusters.get(tarKey).push(tar);
		}
		
		List<Cluster> clusterList = new ArrayList<Cluster>();
		Iterator<Integer> it = _clusters.keySet().iterator();
		while(it.hasNext()) {
			clusterList.add(_clusters.get(it.next()));
		}
		return clusterList;
	}
	
	public void initCluster() {
		_clusters = new HashMap<Integer, Cluster>(_clusterNum, 0.95f);
		for(int i = 1; i <= _clusterNum; i ++) {
			Cluster cluster = new Cluster(pick(i));
			_clusters.put(i, cluster);
		}
	}
	
	public Integer pick(int idnex) {
		Random random = new Random(System.currentTimeMillis());
		int size = _srcList.size();
		if(size < 1) {
			return -1;
		}
		return _srcList.remove(random.nextInt(size));
	}
	
	public int get_clusterNum() {
		return _clusterNum;
	}
	public List<Integer> get_srcList() {
		return _srcList;
	}
}
